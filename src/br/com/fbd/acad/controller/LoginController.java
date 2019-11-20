package br.com.fbd.acad.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.app.App;
import br.com.fbd.acad.dao.DaoFuncionario;
import br.com.fbd.acad.dao.IDaoFuncionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class LoginController implements Initializable{
	
	private final String INDEX = "index";
	private IDaoFuncionario daoFuncionario;
	
	@FXML private JFXButton closeButton;
	@FXML private TextField emailField;
	@FXML private PasswordField senhaField;
	@FXML private Label confimLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		App.addOnChangeScreenListener(new App.OnChangeScreen() {
			
			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				// TODO Auto-generated method stub
				
			}
		});
		
		daoFuncionario = new DaoFuncionario();

		emailField.setOnKeyPressed((KeyEvent event)->{
			if(event.getCode() == KeyCode.ENTER) {
				logar();
			}
		});
		senhaField.setOnKeyPressed((KeyEvent event)->{
			if(event.getCode() == KeyCode.ENTER) {
				logar();
			}
		});
		
		closeButton.setOnAction((ActionEvent event)->{
			System.exit(0);
		});
		
	}
	public void buttonHandler(ActionEvent event) {
		logar();
	}
	
	public void logar() {
		if(emailField.getText().equalsIgnoreCase("") || senhaField.getText().equalsIgnoreCase("")) {
			confimLabel.setText("Preencha todos os campos");
			confimLabel.setVisible(true);
		}else if(daoFuncionario.validarLogin(emailField.getText(), senhaField.getText())) {
			App.changeScreen(INDEX, daoFuncionario.selecionarFuncionario(emailField.getText()));
			emailField.setText("");
			senhaField.setText("");
		}else {
			confimLabel.setText("Informações incorretas");
			confimLabel.setVisible(true);
		}
	}

}
