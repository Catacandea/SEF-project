package CarCosCanLivreisan.sef_project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SignIn_Controller {

	 public void BackHomeViewButoonClicked(ActionEvent event) throws IOException
	    {
	        Parent HomePageView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
	        Scene HomePageScene = new Scene(HomePageView);

	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setScene(HomePageScene);
	        window.show();
	    }
}
