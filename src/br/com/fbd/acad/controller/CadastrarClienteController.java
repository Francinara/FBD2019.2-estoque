package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.business.BusinessCliente;
import br.com.fbd.acad.business.IBusinessCliente;
import br.com.fbd.acad.entidade.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CadastrarClienteController implements Initializable{

	private IBusinessCliente businessCliente = new BusinessCliente();

	private static Stage stage;

	@FXML private TextField nomeField;
	@FXML private TextField emailField;
	@FXML private TextField telefoneField;
	@FXML private TextField cpfField;
	@FXML private TextField ruaField;
	@FXML private TextField cidadeField;
	@FXML private TextField estadoField;
	@FXML private TextField cepField;
	@FXML private TextField paisField;
	@FXML private JFXButton cancelarButton;
	@FXML private JFXButton salvarButton;
	@FXML private DatePicker dataField;
	@FXML private TextArea observacoesField;
	@FXML private Label alertLabel;

	@FXML
	void buttonHandler(ActionEvent event) {
		if(event.getSource() == cancelarButton) {
			CadastrarClienteController.stage.close();
		}if(event.getSource() == salvarButton) {
			if(nomeField.getText().equalsIgnoreCase("") || emailField.getText().equalsIgnoreCase("") || telefoneField.getText().equalsIgnoreCase("")){
				alertLabel.setVisible(true);
				alertLabel.setText("Preencha todos os campos");
			}else {
				String temp = businessCliente.cadastrar(new Cliente(nomeField.getText(), emailField.getText(), telefoneField.getText()));
				if(temp == "0") {
					Alert a = new Alert(AlertType.CONFIRMATION);
					a.setHeaderText("Cliente Adicionado com sucesso");
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

	}
	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/CadastrarCliente.fxml"));
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
		CadastrarClienteController.stage = stage;
	}

}