package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import br.com.fbd.acad.business.BusinessFuncionario;
import br.com.fbd.acad.business.IBusinessFuncionario;
import br.com.fbd.acad.dao.DaoCargo;
import br.com.fbd.acad.dao.IDaoCargo;
import br.com.fbd.acad.entidade.Cargo;
import br.com.fbd.acad.entidade.Funcionario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
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
	
    @FXML private ComboBox<Cargo> cargoField;
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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarCargos();
		
		cargoField.setOnMouseClicked((MouseEvent event)->{
			carregarCargos();
		});
		
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
    
	@FXML
    void buttonHandler(ActionEvent event) {	
    	if(event.getSource() == cancelarButton) {
    		getStage().close();
    	}if(event.getSource() == salvarButton){
    		if(cargoField.getSelectionModel().getSelectedItem() == null || nomeField.getText().equalsIgnoreCase("") || 
    				emailField.getText().equalsIgnoreCase("") || telefoneField.getText().equalsIgnoreCase("") || 
    				cpfField.getText().equalsIgnoreCase("") || senhaField.getText().equalsIgnoreCase("")) {
    			alertLabel.setVisible(true);
    			alertLabel.setText("Os campos * são obrigatorios");
    		}else {
    			Date date = Date.valueOf(dataField.getValue());
    			String temp = businessFuncionario.cadastrar(new Funcionario(cargoField.getSelectionModel().getSelectedItem().getId(),
    					nomeField.getText(), emailField.getText(), telefoneField.getText(), date, cpfField.getText(), 
        				senhaField.getText()));
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
	
	@FXML
    void adicionarCargo(ActionEvent event) {
		try {
			new CadastrarCargoController().start(new Stage());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	public void carregarCargos(){
		IDaoCargo daoCargo = new DaoCargo();
		cargoField.setItems(FXCollections.observableArrayList(daoCargo.getList()));	
	}
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		CadastrarFuncionarioController.stage = stage;
	}

}