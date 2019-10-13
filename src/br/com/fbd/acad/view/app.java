package br.com.fbd.acad.view;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class app extends Application {

	@Override
	public void start(Stage primaryStage) {

		
		try {
			Pane root;
			root = FXMLLoader.load(getClass().getResource("fornecedor.fxml"));
			Scene scene = new Scene(root, 1180, 680);
			scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setTitle("Estoque");
			Image anotherIcon = new Image(getClass().getResourceAsStream("images/venda.png"));
            primaryStage.getIcons().add(anotherIcon);
			primaryStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}