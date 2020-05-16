package CarCosCanLivreisan.sef_project;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CustomerPage_Controller {
	
	 public void LogOutButtonClicked(ActionEvent event) throws IOException {
       Parent LogOutView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
       Scene LogOutScene = new Scene(LogOutView);

       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
  
       window.close();
   }

}
