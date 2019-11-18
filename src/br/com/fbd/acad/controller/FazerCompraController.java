package br.com.fbd.acad.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.app.App;
import br.com.fbd.acad.entidade.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class FazerCompraController implements Initializable{
	
	private Funcionario funcionario;

    @FXML
    private JFXButton closeButton;

    @FXML
    private JFXButton salvarButton;

    @FXML
    private JFXButton cancelarButton;

    @FXML
    private ComboBox<?> fornecedorField;

    @FXML
    private Label funcionarioLabel;

    @FXML
    private Label valorLabel;

    @FXML
    private DatePicker dataField;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		App.addOnChangeScreenListener(new App.OnChangeScreen() {

			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				//				if(Funcionario.class == userData.getClass()) {
				funcionario =  (Funcionario)userData;
				if(newScreen.equals("index")) {
					funcionarioLabel.setText(funcionario.getNome());
					if(funcionario.getId_cargo() == 0) {

						//						}
					}
				}

			}
		});
		closeButton.setOnAction((ActionEvent event)->{
			App.changeScreen("index", funcionario);
		});
		cancelarButton.setOnMouseClicked((MouseEvent event)->{
			App.changeScreen("index", funcionario);
		});
		
	}

}
