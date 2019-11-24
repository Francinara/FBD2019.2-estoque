package br.com.fbd.acad.controller;

import java.net.URL;
import java.sql.Date;
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
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.MouseEvent;

public class FazerVendaController implements Initializable{
	
	IBusinessVenda businessVenda = new BusinessVenda();
	
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
    
    private double valor;
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarFornecedor();
		carregarProduto();
		
		App.addOnChangeScreenListener(new App.OnChangeScreen() {

			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				funcionario =  (Funcionario)userData;
				if(newScreen.equals("index")) {
					funcionarioLabel.setText(funcionario.getNome());
					if(funcionario.getId_cargo() == 0) {

						//						}
					}
				}

			}
		});
		closeButton.setOnMouseClicked((MouseEvent event)->{
			App.changeScreen("index", funcionario);
		});
		
		cancelarButton.setOnMouseClicked((MouseEvent event)->{
			App.changeScreen("index", funcionario);
		});
		
		
	}
    
    @FXML
    void handleButtonAction(ActionEvent event) {
    	if(event.getSource() == salvarButton) {
    		Date date = Date.valueOf(dataField.getValue());
    		businessVenda.cadastrar(new Venda(valor, date, funcionario.getId(), 
    				clienteField.getSelectionModel().getSelectedItem().getId()));
    	}
    }
    
    @FXML
    void handleButtonAdicionar(ActionEvent event) {
    	valor += produtoField.getSelectionModel().getSelectedItem().getPreco() * quantidadeField.getValue();
    	valorLabel.setText("R$"+valor);
    }
    
    @FXML
    void comboBoxHandler(ActionEvent event) {
    	SpinnerValueFactory<Integer> spinnerValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1,
    			produtoField.getSelectionModel().getSelectedItem().getQuantidade(),1);
    	this.quantidadeField.setValueFactory(spinnerValueFactory);
    	
    	quantidadeLabel.setVisible(true);
    	quantidadeField.setVisible(true);
    	adicionarButton.setVisible(true);
    }
    
    public void carregarFornecedor(){
		IBusinessCliente businessCliente = new BusinessCliente();
		clienteField.setItems(FXCollections.observableArrayList(businessCliente.getList()));

	}
    public void carregarProduto(){
		IBusinessProduto businessProduto = new BusinessProduto();
		produtoField.setItems(FXCollections.observableArrayList(businessProduto.getList()));

	}

}