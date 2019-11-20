package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.business.BusinessFuncionario;
import br.com.fbd.acad.business.IBusinessFuncionario;
import br.com.fbd.acad.dao.DaoFuncionario;
import br.com.fbd.acad.dao.IDaoFuncionario;
import br.com.fbd.acad.entidade.Funcionario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class CadastrarFuncionarioController implements Initializable {
	
	private static Stage stage;
	
    @FXML private ComboBox<String> cargoField;
    @FXML private TextField nomeField;
    @FXML private TextField emailField;
    @FXML private TextField telefoneField;
    @FXML private DatePicker dataField;
    @FXML private TextField cpfField;
    @FXML private PasswordField senhaField;
    @FXML private TextField ruaField;
    @FXML private TextField cidadeField;
    @FXML private TextField estadoField;
    @FXML private TextField cepField;
    @FXML private TextField paisField;
    @FXML private TextArea observacoesField;
    @FXML private Label alertLabel;
    @FXML private JFXButton cancelarButton;
    @FXML private JFXButton salvarButton;
    
    private IBusinessFuncionario businessFuncionario = new BusinessFuncionario();
    private IDaoFuncionario daoFuncionario = new DaoFuncionario();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		cargoField.getItems().addAll("adicionar novo cargo","Gerente", "Vendedor");
	}
	
	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/CadastrarFuncionarios.fxml"));
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
		CadastrarFuncionarioController.stage = stage;
	}
    
	@FXML
    void buttonHandler(ActionEvent event) {
    	if(event.getSource() == cancelarButton) {
    		CadastrarFuncionarioController.stage.close();
    	}if(event.getSource() == salvarButton){
    		if(nomeField.getText().equalsIgnoreCase("") || emailField.getText().equalsIgnoreCase("") 
    				|| telefoneField.getText().equalsIgnoreCase("") || cpfField.getText().equalsIgnoreCase("") 
    				|| senhaField.getText().equalsIgnoreCase("")) {
    			alertLabel.setVisible(true);
    			alertLabel.setText("Os campos * são obrigatorios");
    		}else if(!daoFuncionario.validarCpf(cpfField.getText())) {
    			alertLabel.setVisible(true);
    			alertLabel.setText("CPF já cadastrado");
    		}else if(!daoFuncionario.validarEmail(emailField.getText())) {
    			alertLabel.setVisible(true);
    			alertLabel.setText("Email já cadastrado");
    		}else {
    			Date date = Date.valueOf(dataField.getValue());
        		
        		businessFuncionario.cadastrar(new Funcionario(1, nomeField.getText(), 
        				emailField.getText(), telefoneField.getText(), date, cpfField.getText(), senhaField.getText()));
        		Alert a = new Alert(AlertType.CONFIRMATION);
        		a.setHeaderText("Funcionario Adicionado com sucesso");
        		a.show();
        		getStage().close();
    		}
    	}
    }

}