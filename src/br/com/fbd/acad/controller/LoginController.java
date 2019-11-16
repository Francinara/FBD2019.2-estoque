package br.com.fbd.acad.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.com.fbd.acad.app.App;
import br.com.fbd.acad.dao.DaoFuncionario;
import br.com.fbd.acad.dao.IDaoFuncionario;
import br.com.fbd.acad.entidade.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable{

	private IDaoFuncionario daoFuncionario;
	@FXML private TextField emailField;
	@FXML private PasswordField senhaField;
	@FXML private Label confimLabel;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
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
	}
	public void buttonHandler(ActionEvent event) {
		logar();
	}
	public void fecha() {
		App.getStage().close();
	}

	public void logar() {
		if(emailField.getText().equalsIgnoreCase("") || senhaField.getText().equalsIgnoreCase("")) {
			confimLabel.setText("Preencha todos os campos");
			confimLabel.setVisible(true);
		}else if(daoFuncionario.validarLogin(emailField.getText(), senhaField.getText())) {
			IndexController indexController = new IndexController();
			try {
				indexController.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			fecha();
		}else {
			confimLabel.setText("Informações incorretas");
			confimLabel.setVisible(true);
		}
	}
	
	public Funcionario verificarAcessor() {
		
		return null;
		
	}

}
