package CarCosCanLivreisan.sef_project;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SupplyPage_Controller {
	
	public void LogOutButtonClicked(ActionEvent event) throws IOException {
	       Parent LogOutView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
	       Scene LogOutScene = new Scene(LogOutView);

	       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	       
	       window.close();
	   }
	
	 public void ViewProductsButtonClicked(ActionEvent event) throws IOException 
	 {
	    Parent ViewProductsView = FXMLLoader.load(getClass().getResource("SupplyCompany_Products.fxml"));
	    Scene ViewProductsScene = new Scene(ViewProductsView);

	    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    
	    window.setScene(ViewProductsScene);       
	    window.show();
	   }
	 
	 public void BackSupplyHomeViewButoonClicked(ActionEvent event) throws IOException
	    {
	        Parent HomePageView = FXMLLoader.load(getClass().getResource("SupplyCompanyHomePage.fxml"));
	        Scene HomePageScene = new Scene(HomePageView);

	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setScene(HomePageScene);
	        window.show();
	    }

}
