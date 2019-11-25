package br.com.fbd.acad.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.app.App;
import br.com.fbd.acad.entidade.Funcionario;
import br.com.fbd.acad.entidade.Produto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EditarProdutoController implements Initializable{
	
	private Produto produto;

    @FXML
    private Label idLabel;

    @FXML
    private TextField nomeField;

    @FXML
    private TextField quatidadeField;

    @FXML
    private ComboBox<?> categoriaField;

    @FXML
    private TextField precoField;

    @FXML
    private TextField custoField;

    @FXML
    private TextArea observacoesField;

    @FXML
    private JFXButton cancelarButton;

    @FXML
    private JFXButton salvarButton;

    @FXML
    void adicionarCategoria(ActionEvent event) {

    }

    @FXML
    void buttonHandler(ActionEvent event) {
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		App.addOnChangeScreenListener(new App.OnChangeScreen() {

			@Override
			public void onScreenChanged(String newScreen, Object userData) {
				produto =  (Produto)userData;
				idLabel.setText(""+produto.getId());

			}
		});
		cancelarButton.setOnMouseClicked((MouseEvent event)->{
			App.changeScreen("index");
		});
		
	}

}
