package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CadastrarFornecedorController implements Initializable{
	
	public static Stage stage;

	@FXML private TextField empresaField;
    @FXML private TextField nomeField;
    @FXML private TextField emailField;
    @FXML private TextField telefoneField;
    @FXML private TextField cnpjField;
    @FXML private TextField ruaField;
    @FXML private TextField cidadeField;
    @FXML private TextField estadoField;
    @FXML private TextField cepField;
    @FXML private TextField paisField;
    @FXML private JFXButton cancelarButton;
    @FXML private JFXButton salvarButton;
    @FXML private TextArea observacoesField;
    @FXML private Label alertLabel;

    @FXML
    void buttonHandler(ActionEvent event) {
    	if(event.getSource() == cancelarButton) {
    		CadastrarFornecedorController.stage.close();
    	}if(event.getSource() == salvarButton) {
    		if(empresaField.getText().equalsIgnoreCase("") || nomeField.getText().equalsIgnoreCase("") || 
    				emailField.getText().equalsIgnoreCase("") || telefoneField.getText().equalsIgnoreCase("") || 
    				cnpjField.getText().equalsIgnoreCase("")) {
    			alertLabel.setVisible(true);
    			alertLabel.setText("Os campos * são obrigatorios");
    		}
    	}
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/CadastrarFornecedor.fxml"));
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
		CadastrarFornecedorController.stage = stage;
	}
	
	

}
