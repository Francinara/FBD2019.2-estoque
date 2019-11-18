package br.com.fbd.acad.app;

import java.io.IOException;
import java.util.ArrayList;

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
	private static Scene compraScene;


	@Override
	public void start(Stage stage) throws IOException {
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
		Parent fxmlCompra = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/FazerCompra.fxml"));
		compraScene = new Scene(fxmlCompra);

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
		case "compra":
			stage.setScene(compraScene);
			notifyAllListeners("compra", userData);
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
