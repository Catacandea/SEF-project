package CarCosCanLivreisan.sef_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		primaryStage.setTitle("CarCosCân Livreișăn");
		primaryStage.setScene(new Scene(root, 700, 500));
		primaryStage.show();
	}

	static void main(String[] args) {
		launch();
	}

}