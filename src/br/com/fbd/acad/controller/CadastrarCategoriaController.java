package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.business.BusinessCategoria;
import br.com.fbd.acad.business.IBusinessCategoria;
import br.com.fbd.acad.entidade.Categoria;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CadastrarCategoriaController implements Initializable{
	
	private static Stage stage;
	
	IBusinessCategoria businessCategoria = new BusinessCategoria();

    @FXML private TextField nomeField;
    @FXML private JFXButton cancelarButton;
    @FXML private JFXButton salvarButton;
    @FXML private Label alertLabel;
    
    @FXML 
    void buttonHandler(ActionEvent event) {

    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancelarButton.setOnAction((ActionEvent event)->{
	    	getStage().close();
		});
		salvarButton.setOnAction((ActionEvent event)->{
			if(nomeField.getText().equalsIgnoreCase("")) {
				alertLabel.setText("Preencha o campo");
				alertLabel.setVisible(true);
			}else if(businessCategoria.cadastrar(new Categoria(nomeField.getText()))) {
				alertLabel.setText("Categoria Cadastrado com sucesso");
				alertLabel.setVisible(true);
			}else {
				alertLabel.setText("Categoria já cadastrado");
				alertLabel.setVisible(true);
			}
			
		});
		
	}
	
	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/CadastrarCategoria.fxml"));
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
		CadastrarCategoriaController.stage = stage;
	}


}