package br.com.fbd.acad.controller;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.app.App;
import br.com.fbd.acad.business.BusinessCliente;
import br.com.fbd.acad.business.BusinessProduto;
import br.com.fbd.acad.business.BusinessVenda;
import br.com.fbd.acad.business.IBusinessCliente;
import br.com.fbd.acad.business.IBusinessProduto;
import br.com.fbd.acad.business.IBusinessVenda;
import br.com.fbd.acad.entidade.Cliente;
import br.com.fbd.acad.entidade.Funcionario;
import br.com.fbd.acad.entidade.Produto;
import br.com.fbd.acad.entidade.Venda;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class FazerVendaController implements Initializable{

	IBusinessVenda businessVenda = new BusinessVenda();

	IBusinessProduto businessProduto = new BusinessProduto();
	List<Produto> businessListProduto = businessProduto.getListEstoque();

	List<Produto> produtos = new ArrayList<Produto>();

	private Funcionario funcionario;

	@FXML private JFXButton closeButton;
	@FXML private JFXButton salvarButton;
	@FXML private JFXButton cancelarButton;
	@FXML private ComboBox<Cliente> clienteField;
	@FXML private Label funcionarioLabel;
	@FXML private Label valorLabel;
	@FXML private DatePicker dataField;
	@FXML private ComboBox<Produto> produtoField;
	@FXML private Label quantidadeLabel;
	@FXML private Spinner<Integer> quantidadeField;
	@FXML private JFXButton adicionarButton;
	@FXML private Label alertLabel;
	@FXML private Label vendaLabel;

	@FXML private TableView<Produto> produtoTable;
	@FXML private TableColumn<Produto, Integer> idProdutoClm;
	@FXML private TableColumn<Produto, String> fornecedorProdutoClm;
	@FXML private TableColumn<Produto, String> descricaoProdutoClm;
	@FXML private TableColumn<Produto, Integer> quantidadeProdutoClm;
	@FXML private TableColumn<Produto, Double> valorProdutoClm;

	private double valor;
	
	private Produto produtoSelecionado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarFornecedor();
		carregarProduto();
		initTableProduto();

		App.addOnChangeScreenListener(new App.OnChangeScreen() {

			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				funcionario =  (Funcionario)userData;
				funcionarioLabel.setText(funcionario.getNome());
				vendaLabel.setText("nº"+(businessVenda.maxId()+1));

			}
		});
		closeButton.setOnMouseClicked((MouseEvent event)->{
			clearScream();
			App.changeScreen("index", funcionario);
		});

		cancelarButton.setOnMouseClicked((MouseEvent event)->{
			clearScream();
			App.changeScreen("index", funcionario);
		});
		
		produtoTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				produtoSelecionado = (Produto)newValue;
			}
		});
		
		produtoTable.setOnKeyPressed((KeyEvent event)->{
			System.out.println("entrei Viado");
			if(event.getCode() == KeyCode.DELETE) {
				if(produtoSelecionado != null) {
		    		produtos.remove(produtoSelecionado);
		    		produtoTable.setItems(updateTableProduto());
		    	}
			}
		});

	}

	@FXML
	void handleButtonAction(ActionEvent event) {
		if(event.getSource() == salvarButton) {
			if(clienteField.getSelectionModel().getSelectedItem() == null) {
				alertLabel.setVisible(true);
				alertLabel.setText("Adicione um cliente");
			}else if(dataField.getValue() == null) {
				alertLabel.setVisible(true);
				alertLabel.setText("Adicione uma data");
			}
			else if(valor == 0){
				alertLabel.setVisible(true);
				alertLabel.setText("Valor invalido");

			}
			else {
				Date date = Date.valueOf(dataField.getValue());
				if(businessVenda.cadastrar(new Venda(businessVenda.maxId()+1, valor, date, funcionario.getId(), 
						clienteField.getSelectionModel().getSelectedItem().getId()), produtos)) {
					clearScream();
					App.changeScreen("index", funcionario);
				}
			}
		}
	}

	@FXML
	void handleButtonAdicionar(ActionEvent event) {
		if(produtoField.getSelectionModel().getSelectedItem() == null) {
			alertLabel.setVisible(true);
			alertLabel.setText("Selecione um produto");
		}else if(quantidadeField.getValue() == 0) {
			alertLabel.setVisible(true);
			alertLabel.setText("Valor invalido");
		}

		else {
			valor += produtoField.getSelectionModel().getSelectedItem().getPreco() * quantidadeField.getValue();
			valorLabel.setText("R$"+valor);

			Produto produto =  new Produto(produtoField.getSelectionModel().getSelectedItem().getId(), 
					produtoField.getSelectionModel().getSelectedItem().getDescricao(), 
					produtoField.getSelectionModel().getSelectedItem().getPreco(), 
					produtoField.getSelectionModel().getSelectedItem().getFornecedor(), quantidadeField.getValue());
			produtos.add(produto);
			produtoTable.setItems(updateTableProduto());

			for(Produto produto1: businessListProduto) {
				if(produto1 == produtoField.getSelectionModel().getSelectedItem()) {
					produto1.setQuantidade(produto1.getQuantidade()-quantidadeField.getValue());
					if(produto1.getQuantidade() == 0) {
						businessListProduto.remove(produto1);
					}break;
				}
			}

			produtoField.setItems(FXCollections.observableArrayList(businessListProduto));
			
			produtoField.getSelectionModel().clearSelection();
			quantidadeField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0));
		}
	}

	@FXML
	void comboBoxHandler(ActionEvent event) {
		if(produtoField.getSelectionModel().getSelectedItem() != null) {
			SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0,
					produtoField.getSelectionModel().getSelectedItem().getQuantidade(),0);
			this.quantidadeField.setValueFactory(spinnerValueFactory);
		}	
	}
	
	public void carregarFornecedor(){
		IBusinessCliente businessCliente = new BusinessCliente();
		clienteField.setItems(FXCollections.observableArrayList(businessCliente.getList()));

	}

	public void carregarProduto(){
		produtoField.setItems(FXCollections.observableArrayList(businessListProduto));

	}

	public void initTableProduto() {
		idProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
		fornecedorProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, String>("fornecedor"));
		descricaoProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
		quantidadeProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));
		valorProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));
		produtoTable.setItems(updateTableProduto());
	}

	public ObservableList<Produto> updateTableProduto(){
		return FXCollections.observableArrayList(produtos);
	}
	
	public void clearScream() {
		clienteField.getSelectionModel().clearSelection();
		produtoField.getSelectionModel().clearSelection();
		dataField.setValue(null);
		quantidadeField.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 0));
		produtos.clear();
		businessListProduto = businessProduto.getListEstoque();
		valorLabel.setText("R$0.0");
		produtoTable.setItems(updateTableProduto());
		carregarProduto();
		valor = 0;
	}

}