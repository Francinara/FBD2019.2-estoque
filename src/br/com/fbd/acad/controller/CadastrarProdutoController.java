package br.com.fbd.acad.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastrarProdutoController implements Initializable{
	
    @FXML private ComboBox<?> categoriaField;
    @FXML private TextField nomeField;
    @FXML private TextField codigoField;
    @FXML private TextField quatidadeField;
    @FXML private TextField precoField;
    @FXML private TextField custoField;
    @FXML private JFXButton cancelarButton;
    @FXML private JFXButton salvarButton;
    @FXML private TextArea observacoesField;
    @FXML private Label alertLabel;
    @FXML private ComboBox<?> fornecedorField;

    @FXML
    void buttonHandler(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}

}
