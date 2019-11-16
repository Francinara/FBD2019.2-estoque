package br.com.fbd.acad.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.business.BusinessCargo;
import br.com.fbd.acad.business.IBusinessCargo;
import br.com.fbd.acad.entidade.Cargo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CadastrarCargoController implements Initializable{
	
	IBusinessCargo businessCargo = new BusinessCargo();

    @FXML private TextField nomeField;
    @FXML private JFXButton cancelarButton;
    @FXML private JFXButton salvarButton;
    @FXML private Label alertLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cancelarButton.setOnAction((ActionEvent event)->{
			System.exit(0);
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

}
