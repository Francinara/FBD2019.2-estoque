package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.business.BusinessCategoria;
import br.com.fbd.acad.business.BusinessFornecedor;
import br.com.fbd.acad.business.BusinessProduto;
import br.com.fbd.acad.business.IBusinessCategoria;
import br.com.fbd.acad.business.IBusinessFornecedor;
import br.com.fbd.acad.business.IBusinessProduto;
import br.com.fbd.acad.entidade.Categoria;
import br.com.fbd.acad.entidade.Fornecedor;
import br.com.fbd.acad.entidade.Produto;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CadastrarProdutoController implements Initializable{
	
	private IBusinessProduto businessProduto = new BusinessProduto();

	private static Stage stage;

	@FXML private ComboBox<Categoria> categoriaField;
	@FXML private TextField nomeField;
	@FXML private TextField codigoField;
	@FXML private TextField quatidadeField;
	@FXML private TextField precoField;
	@FXML private TextField custoField;
	@FXML private JFXButton cancelarButton;
	@FXML private JFXButton salvarButton;
	@FXML private TextArea observacoesField;
	@FXML private Label alertLabel;
	@FXML private ComboBox<Fornecedor> fornecedorField;

	@FXML
	void buttonHandler(ActionEvent event) {
		if(event.getSource() == cancelarButton) {
			CadastrarProdutoController.stage.close();
		}if(event.getSource() == salvarButton) {
			if(categoriaField.getSelectionModel().getSelectedItem() == null||nomeField.getText().equalsIgnoreCase("") || 
					codigoField.getText().equalsIgnoreCase("") || quatidadeField.getText().equalsIgnoreCase("") || 
					precoField.getText().equalsIgnoreCase("") || custoField.getText().equalsIgnoreCase("") || 
					fornecedorField.getSelectionModel().getSelectedItem() == null) {
				alertLabel.setVisible(true);
				alertLabel.setText("Os campos * são obrigatorios");
			}else {
				String temp = businessProduto.cadastrar(new Produto(nomeField.getText(), codigoField.getText(), 
						categoriaField.getSelectionModel().getSelectedItem().getId(), Double.parseDouble(precoField.getText()), 
						Double.parseDouble(custoField.getText()), fornecedorField.getSelectionModel().getSelectedItem().getId(), 
						Integer.parseInt(quatidadeField.getText())));
				if(temp == "0") {
					Alert a = new Alert(AlertType.CONFIRMATION);
					a.setHeaderText("Produto Adicionado com sucesso");
					a.show();
					getStage().close();
				}else{
					alertLabel.setVisible(true);
					alertLabel.setText(temp);
				}
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarCategorias();
		carregarFornecedor();

	}

	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/CadastrarProduto.fxml"));
		Scene scene = new Scene(root);
		stage.initStyle(StageStyle.UTILITY);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		setStage(stage);


	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		CadastrarProdutoController.stage = stage;
	}

	public void carregarCategorias(){
		IBusinessCategoria businessCategoria = new BusinessCategoria();
		categoriaField.setItems(FXCollections.observableArrayList(businessCategoria.getList()));

	}
	
	public void carregarFornecedor(){
		IBusinessFornecedor businessFornecedor = new BusinessFornecedor();
		fornecedorField.setItems(FXCollections.observableArrayList(businessFornecedor.getList()));

	}
}
