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

	    public void SignInSupplyButoonClicked(ActionEvent event) throws IOException
	    {
	        Parent SignInSupplyView = FXMLLoader.load(getClass().getResource("SignInSupply.fxml"));
	        Scene SignInSupplyScene = new Scene(SignInSupplyView);

	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setScene(SignInSupplyScene);
	        window.show();
	    }
	    
	    public void SignInDeliveryButoonClicked(ActionEvent event) throws IOException
	    {
	        Parent SignInDeliveryView = FXMLLoader.load(getClass().getResource("SignInDelivery.fxml"));
	        Scene SignInDeliveryScene = new Scene(SignInDeliveryView);

	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setScene(SignInDeliveryScene);
	        window.show();
	    }
	    
	    public void SignInCustomerButoonClicked(ActionEvent event) throws IOException
	    {
	        Parent SignInCustomerView = FXMLLoader.load(getClass().getResource("SignInCustomer.fxml"));
	        Scene SignInCustomerScene = new Scene(SignInCustomerView);
	        
	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setScene(SignInCustomerScene);
	        window.show();
	    }
	    
	    public void BackSignInViewButoonClicked(ActionEvent event) throws IOException
	    {
	        Parent SignInView = FXMLLoader.load(getClass().getResource("SignIn.fxml"));
	        Scene SignInScene = new Scene(SignInView);

	        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	        window.setScene(SignInScene);
	        window.show();
	    }
	    
}
