package br.com.fbd.acad.app;

import java.io.IOException;
import java.util.ArrayList;

import br.com.fbd.acad.dao.DaoProduto;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class App extends Application {

	private static Stage stage;
	
	private static Scene loginScene;
	private static Scene indexScene;
	private static Scene vendaScene;
	
	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		App.stage = stage;
	}


	@Override
	public void start(Stage stage) throws IOException {
		
		DaoProduto daoProduto = new DaoProduto();
		
		daoProduto.getList();
		
		App.stage = stage;
		
		stage.setTitle("Estoque");
		stage.getIcons().add(new Image("/br/com/fbd/acad/view/images/icone.png"));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);

		Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/Login.fxml"));
		loginScene = new Scene(fxmlLogin);
		Parent fxmlIndex = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/Index.fxml"));
		indexScene = new Scene(fxmlIndex);
		Parent fxmlVenda = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/FazerVenda.fxml"));
		vendaScene = new Scene(fxmlVenda);

		stage.setScene(loginScene);
		stage.show();

	}

	public static void changeScreen(String scr, Object userData) {
		switch (scr) {
		case "login":
			stage.setScene(loginScene);
			notifyAllListeners("main", userData);
			break;
		case "index":
			stage.setScene(indexScene);
			notifyAllListeners("index", userData);
			break;
		case "venda":
			stage.setScene(vendaScene);
			notifyAllListeners("venda", userData);
			break;
		}
	}
	
	public static void changeScreen(String scr) {
		changeScreen(scr, null);
		
	}
	

	public static void main(String[] args) {
		launch(args);
	}
	
	
	private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();
	
	public static interface OnChangeScreen{
		void onScreenChanged(String newScreen, Object userData);
	}
	
	public static void addOnChangeScreenListener(OnChangeScreen newListener) {
		listeners.add(newListener);
	}
	
	private static void notifyAllListeners(String newScreen, Object userData) {
		for(OnChangeScreen l : listeners)
			l.onScreenChanged(newScreen, userData);
	}
	
	

}
