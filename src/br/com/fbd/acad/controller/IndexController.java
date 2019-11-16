package br.com.fbd.acad.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class IndexController implements Initializable{

	private static Stage stage;
	
	
	@FXML private Pane pane_funcionarios;
    @FXML private AnchorPane vazio_funcionarios_pane;
    @FXML private JFXButton funcionario_cadastrar_btn;
    @FXML private JFXButton btn_painel;
    @FXML private JFXButton btn_vendas;
    @FXML private JFXButton btn_gastos;
    @FXML private JFXButton btn_funcionarios;
    @FXML private JFXButton btn_relatorios;
    @FXML private ImageView plusButton;
    @FXML private ImageView enableButton;
    @FXML private Label atualLabel;

	public void initialize(URL location, ResourceBundle resources) {
		System.out.println("initialize");
	}
	
	public void start(Stage stage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/Index.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Estoque");
		stage.getIcons().add(new Image("/br/com/fbd/acad/view/images/icone.png"));
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		setStage(stage);
		

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		IndexController.stage = stage;
	}

	public void handleButtonAction(ActionEvent event) {
		if(event.getSource() == btn_painel) {
		}
		else if(event.getSource() == btn_vendas) {
		}
		else if(event.getSource() == btn_gastos) {
		}
		else if(event.getSource() == btn_funcionarios) {
				
		}else if(event.getSource() == btn_relatorios) {
		}
	}

	public void cadastrar_funcionarios(ActionEvent event) {
		CadastrarFuncionarioController cadastrarFuncionario = new CadastrarFuncionarioController();
		try {
			cadastrarFuncionario.start(new Stage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
