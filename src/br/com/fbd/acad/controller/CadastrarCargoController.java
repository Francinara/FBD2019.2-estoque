package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.business.BusinessCargo;
import br.com.fbd.acad.business.IBusinessCargo;
import br.com.fbd.acad.entidade.Cargo;
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

public class CadastrarCargoController implements Initializable{
	
	private static Stage stage;
	
	IBusinessCargo businessCargo = new BusinessCargo();

    @FXML private TextField nomeField;
    @FXML private JFXButton cancelarButton;
    @FXML private JFXButton salvarButton;
    @FXML private Label alertLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancelarButton.setOnAction((ActionEvent event)->{
	    	getStage().close();
		});
		salvarButton.setOnAction((ActionEvent event)->{
			if(nomeField.getText().equalsIgnoreCase("")) {
				alertLabel.setText("Preencha o campo");
				alertLabel.setVisible(true);
			}else if(businessCargo.cadastrar(new Cargo(nomeField.getText()))) {
				alertLabel.setText("Cargo Cadastrado com sucesso");
				alertLabel.setVisible(true);
			}else {
				alertLabel.setText("Cargo já cadastrado");
				alertLabel.setVisible(true);
			}
			
		});
	}
	
	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/CadastrarCargo.fxml"));
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
		CadastrarCargoController.stage = stage;
	}

}
