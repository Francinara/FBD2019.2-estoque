package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.app.App;
import br.com.fbd.acad.business.BusinessCliente;
import br.com.fbd.acad.business.BusinessFornecedor;
import br.com.fbd.acad.business.BusinessFuncionario;
import br.com.fbd.acad.business.BusinessProduto;
import br.com.fbd.acad.business.IBusinessCliente;
import br.com.fbd.acad.business.IBusinessFornecedor;
import br.com.fbd.acad.business.IBusinessFuncionario;
import br.com.fbd.acad.business.IBusinessProduto;
import br.com.fbd.acad.dao.DaoCliente;
import br.com.fbd.acad.dao.DaoFornecedor;
import br.com.fbd.acad.dao.DaoFuncionario;
import br.com.fbd.acad.dao.DaoProduto;
import br.com.fbd.acad.dao.DaoVenda;
import br.com.fbd.acad.dao.IDaoVenda;
import br.com.fbd.acad.entidade.Cliente;
import br.com.fbd.acad.entidade.Fornecedor;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class IndexController implements Initializable{

	private Funcionario funcionario;
	private IBusinessFuncionario businessFuncionario = new BusinessFuncionario();
	private IBusinessCliente businessCliente = new BusinessCliente();
	private IBusinessFornecedor businessFornecedor = new BusinessFornecedor();
	private IBusinessProduto businessProduto = new BusinessProduto();

	@FXML private Pane relatorioPane;
	@FXML private Pane funcionarioPane;
	@FXML private Pane vendasPane;
	@FXML private Pane gastosPane;
	@FXML private Pane painelPane;
	@FXML private Label atualLabel;
	@FXML private JFXButton painelButton;
	@FXML private JFXButton vendasButton;
	@FXML private JFXButton gastosButton;
	@FXML private JFXButton funcionariosButton;
	@FXML private JFXButton relatoriosButton;
	@FXML private JFXButton entradaButton;
	@FXML private JFXButton enableButton;
	@FXML private JFXButton closeButton;
	@FXML private JFXButton saidaButton;

	@FXML private TableView<Venda> vendaTable;
	@FXML private TableColumn<Venda, Integer> idVendaClm;
	@FXML private TableColumn<Venda, Date> dataVendaClm;
	@FXML private TableColumn<Venda, String> clienteVendaClm;
	@FXML private TableColumn<Venda, Double> precoVendaClm;
	@FXML private TableColumn<Venda, String> funcionarioVendaClm;

	@FXML private TableView<Cliente> clienteTable;
	@FXML private TableColumn<Cliente, Integer> idClienteClm;
	@FXML private TableColumn<Cliente, String> nomeClienteClm;
	@FXML private TableColumn<Cliente, String> emailClienteClm;
	@FXML private TableColumn<Cliente, String> telefoneClienteClm;
	
	@FXML private JFXButton editarClienteButton;
    @FXML private JFXButton excluirClienteButton;

	@FXML private TableView<Produto> produtoTable;
	@FXML private TableColumn<Produto, Integer> idProdutoClm;
	@FXML private TableColumn<Produto, String> nomeProdutoClm;
	@FXML private TableColumn<Produto, String> fornecedorProdutoClm;
	@FXML private TableColumn<Produto, String> categoriaProdutoClm;
	@FXML private TableColumn<Produto, Double> precoProdutoClm;
	@FXML private TableColumn<Produto, Double> custoProdutoClm;
	@FXML private TableColumn<Produto, Integer> qtdProdutoClm;
	
	@FXML private JFXButton editarProdutoButton;
    @FXML private JFXButton excluirProdutoButton;

	@FXML private TableView<Fornecedor> fornecedorTable; 
	@FXML private TableColumn<Fornecedor, Integer> idFornecdorClm;
	@FXML private TableColumn<Fornecedor, String> empresaFornecdorClm;
	@FXML private TableColumn<Fornecedor, String> representanteFornecdorClm;
	@FXML private TableColumn<Fornecedor, String> emailFornecdorClm;
	@FXML private TableColumn<Fornecedor, String> telefoneFornecdorClm;
	
	@FXML private JFXButton editarFornecedorButton;
	@FXML private JFXButton excluirFornecedorButton;

	@FXML private TableView<Funcionario> funcionarioTable;
	@FXML private TableColumn<Funcionario, Integer> idFuncionarioClm;
	@FXML private TableColumn<Funcionario, String> nomeFuncionarioClm;
	@FXML private TableColumn<Funcionario, String> emailFuncionarioClm;
	@FXML private TableColumn<Funcionario, String> telefoneFuncionarioClm;
	
	@FXML private JFXButton editarFuncionarioButton;
    @FXML private JFXButton excluirFuncionarioButton;
	
	private Funcionario funcionarioSelecionado;
	private Cliente clienteSelecionado;
	private Fornecedor fornecedorSelecionado;
	private Produto produtoSelecionado;

	public void initialize(URL location, ResourceBundle resources) {
		
		App.addOnChangeScreenListener(new App.OnChangeScreen() {
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				funcionario =  (Funcionario)userData;
				if(newScreen.equals("index")) {
					atualLabel.setText(funcionario.getNome());
					verificarAcesso(funcionario.getId_cargo());
				}
			}
		});

		closeButton.setOnAction((ActionEvent event)->{
			System.exit(0);
		});
		enableButton.setOnMouseClicked((MouseEvent event)->{
			App.getStage().close();
			try {
				new App().start(new Stage());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		});
		
		initTableClientes();
		initTableFuncionarios();
		initTableFornecedores();
		initTableProduto();
		initTableVenda();
		
		funcionarioTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				excluirFuncionarioButton.setVisible(true);
				editarFuncionarioButton.setVisible(true);
				funcionarioSelecionado = (Funcionario)newValue;
			}
		});
		
		clienteTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				excluirClienteButton.setVisible(true);
				editarClienteButton.setVisible(true);
				clienteSelecionado = (Cliente)newValue;
			}
		});
		fornecedorTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				excluirFornecedorButton.setVisible(true);
				editarFornecedorButton.setVisible(true);
				fornecedorSelecionado = (Fornecedor)newValue;
			}
		});
		produtoTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Object>() {

			@Override
			public void changed(ObservableValue<?> observable, Object oldValue, Object newValue) {
				excluirProdutoButton.setVisible(true);
				editarProdutoButton.setVisible(true);
				produtoSelecionado = (Produto)newValue;
			}
		});

	}

	public void handleButtonAction(ActionEvent event) {
		if(event.getSource() == painelButton) {
			painelPane.toFront();
		}
		else if(event.getSource() == vendasButton) {
			vendasPane.toFront();
		}
		else if(event.getSource() == gastosButton) {
			gastosPane.toFront();
		}
		else if(event.getSource() == funcionariosButton) {
			funcionarioPane.toFront();

		}else if(event.getSource() == relatoriosButton) {
			relatorioPane.toFront();
		}
	}
	@FXML
	public void cadastrarFuncionarios(ActionEvent event) {
		try {
			new CadastrarFuncionarioController().start(new Stage());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@FXML
    void editarFuncionario(ActionEvent event) {

    }

    @FXML
    void excluirFuncionario(ActionEvent event) {
    	if(funcionarioSelecionado != null) {
    		businessFuncionario.excluir(funcionarioSelecionado.getId());
    		funcionarioTable.setItems(updateTableFuncionario());
    		excluirFuncionarioButton.setVisible(false);
			editarFuncionarioButton.setVisible(false);
    	}
    }

	@FXML
	void cadastrarCliente(ActionEvent event) {
		try {
			new CadastrarClienteController().start(new Stage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void editarCliente(ActionEvent event) {
    }

    @FXML
    void excluirCliente(ActionEvent event) {
    	if(clienteSelecionado != null) {
    		businessCliente.excluir(clienteSelecionado.getId());
    		clienteTable.setItems(updateTableCliente());
    		excluirClienteButton.setVisible(false);
			editarClienteButton.setVisible(false);
    	}
    }

	@FXML
	void cadastrarProduto(ActionEvent event) {
		try {
			new CadastrarProdutoController().start(new Stage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void editarProduto(ActionEvent event) {

    }

    @FXML
    void excluirProduto(ActionEvent event) {
    	if(produtoSelecionado != null) {
    		businessProduto.excluir(produtoSelecionado.getId());
    		produtoTable.setItems(updateTableProduto());
    		excluirProdutoButton.setVisible(false);
			editarProdutoButton.setVisible(false);
    	}
    }

	@FXML
	void cadastrarVenda(ActionEvent event) {
		App.changeScreen("venda", funcionario);
	}
	@FXML
	void cadastrarFornecedores(ActionEvent event) {
		try {
			new CadastrarFornecedorController().start(new Stage());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
    void editarFornecedor(ActionEvent event) {
		
    }

    @FXML
    void excluirFornecedor(ActionEvent event) {
    	if(fornecedorSelecionado != null) {
    		businessFornecedor.excluir(fornecedorSelecionado.getId());
    		fornecedorTable.setItems(updateTableFornecedor());
    		excluirFornecedorButton.setVisible(false);
			editarFornecedorButton.setVisible(false);
    	}
    }

	private void verificarAcesso(int Cargo) {
		if(businessFuncionario.verificarAcesso(funcionario.getId_cargo())) {
			funcionariosButton.setVisible(true);
			relatoriosButton.setVisible(true);
			//						}
		}else {
			funcionariosButton.setVisible(false);
			relatoriosButton.setVisible(false);
		}
	}
	
	public void initTableVenda() {
		idVendaClm.setCellValueFactory(new PropertyValueFactory<Venda, Integer>("id"));
		dataVendaClm.setCellValueFactory(new PropertyValueFactory<Venda, Date>("data_venda"));
		clienteVendaClm.setCellValueFactory(new PropertyValueFactory<Venda, String>("cliente"));
		funcionarioVendaClm.setCellValueFactory(new PropertyValueFactory<Venda, String>("funcionario"));
		precoVendaClm.setCellValueFactory(new PropertyValueFactory<Venda, Double>("valor"));
		vendaTable.setItems(updateTableVenda());
	}

	public ObservableList<Venda> updateTableVenda(){
		IDaoVenda daoVenda = new DaoVenda();
		return FXCollections.observableArrayList(daoVenda.getList());
	}

	public void initTableClientes() {
		idClienteClm.setCellValueFactory(new PropertyValueFactory<Cliente, Integer>("id"));
		nomeClienteClm.setCellValueFactory(new PropertyValueFactory<Cliente, String>("nome"));
		emailClienteClm.setCellValueFactory(new PropertyValueFactory<Cliente, String>("email"));
		telefoneClienteClm.setCellValueFactory(new PropertyValueFactory<Cliente, String>("telefone"));
		clienteTable.setItems(updateTableCliente());
	}

	public ObservableList<Cliente> updateTableCliente(){
		DaoCliente daoCliente = new DaoCliente();
		return FXCollections.observableArrayList(daoCliente.getList());
	}
	
	
	public void initTableProduto() {
		idProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("id"));
		nomeProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, String>("descricao"));
		fornecedorProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, String>("fornecedor"));
		categoriaProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, String>("categoria"));
		precoProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, Double>("preco"));
		custoProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, Double>("custo"));
		qtdProdutoClm.setCellValueFactory(new PropertyValueFactory<Produto, Integer>("quantidade"));
		produtoTable.setItems(updateTableProduto());
	}

	public ObservableList<Produto> updateTableProduto(){
		DaoProduto daoProduto = new DaoProduto();
		return FXCollections.observableArrayList(daoProduto.getList());
	}

	public void initTableFuncionarios() {
		idFuncionarioClm.setCellValueFactory(new PropertyValueFactory<Funcionario, Integer>("id"));
		nomeFuncionarioClm.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("nome"));
		emailFuncionarioClm.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("email"));
		telefoneFuncionarioClm.setCellValueFactory(new PropertyValueFactory<Funcionario, String>("telefone"));
		funcionarioTable.setItems(updateTableFuncionario());
	}

	public ObservableList<Funcionario> updateTableFuncionario(){
		DaoFuncionario daoFuncionario = new DaoFuncionario();
		return FXCollections.observableArrayList(daoFuncionario.getList());
	}
	
	public void initTableFornecedores() {
		idFornecdorClm.setCellValueFactory(new PropertyValueFactory<Fornecedor, Integer>("id"));
		empresaFornecdorClm.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("empresa"));
		representanteFornecdorClm.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("nome"));
		emailFornecdorClm.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("email"));
		telefoneFornecdorClm.setCellValueFactory(new PropertyValueFactory<Fornecedor, String>("telefone"));
		fornecedorTable.setItems(updateTableFornecedor());
	}

	public ObservableList<Fornecedor> updateTableFornecedor(){
		DaoFornecedor daoFornecedor = new DaoFornecedor();
		return FXCollections.observableArrayList(daoFornecedor.getList());
	}

}
