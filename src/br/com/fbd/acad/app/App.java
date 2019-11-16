package br.com.fbd.acad.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
//import javafx.stage.StageStyle;
import javafx.stage.StageStyle;

public class App extends Application {
	private static Stage stage;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws IOException {

		Parent root = FXMLLoader.load(getClass().getResource("/br/com/fbd/acad/view/CadastrarCargo.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Estoque");
		stage.getIcons().add(new Image("/br/com/fbd/acad/view/images/icone.png"));
		stage.initStyle(StageStyle.UNDECORATED);
		stage.setResizable(false);
		stage.setScene(scene);
		stage.show();
		setStage(stage);

	}

	public static Stage getStage() {
		return stage;
	}

	public static void setStage(Stage stage) {
		App.stage = stage;
	}

}
