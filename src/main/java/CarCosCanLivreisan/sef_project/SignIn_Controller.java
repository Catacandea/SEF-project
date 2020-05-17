package CarCosCanLivreisan.sef_project;

import java.io.IOException;

import Database.DiskDB;
import Timetable.TimeSlotException;
import User.Customer;
import User.DeliveryCompany;
import User.SupplierCompany;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignIn_Controller {
	@FXML
	private TextField userSignInCustomer;
	@FXML
	private TextField passwordSignInCustomer;
	@FXML
	private TextField userSignInDelivery;
	@FXML
	private TextField passwordSignInDelivery;
	@FXML
	private TextField userSignInSupply;
	@FXML
	private TextField passwordSignInSupply;
	
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
	    
	    public void HomePageCustomer(ActionEvent event) throws IOException 
	    {
			Parent CustomerHomePageView = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
			Scene CustomerHomePageScene = new Scene(CustomerHomePageView);

			if (userSignInCustomer.getText().equals("") || passwordSignInCustomer.getText().equals(""))
				AlertBox.display("SignIn", "Please insert the data in every field");

			else {
				DiskDB db = new DiskDB();
				Customer customer = db.loginCustomer(userSignInCustomer.getText(), passwordSignInCustomer.getText());
						
				if(customer == null)
					AlertBox.display("Login", "Incorrect username or password!");
				else
				{
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(CustomerHomePageScene);
				window.show();
				}
			}

		}
	    
	    public void HomePageSupply(ActionEvent event) throws IOException, TimeSlotException {
			Parent SupplyHomePageView = FXMLLoader.load(getClass().getResource("SupplyCompanyHomePage.fxml"));
			Scene SupplyHomePageScene = new Scene(SupplyHomePageView);

			if (userSignInSupply.getText().equals("") || passwordSignInSupply.getText().equals(""))
				AlertBox.display("SignIn", "Please insert the data in every field");
				
			else {
				DiskDB db = new DiskDB();
				 
				SupplierCompany sp = db.loginSupplier(userSignInSupply.getText(), passwordSignInSupply.getText());
				if(sp == null)
					AlertBox.display("Login", "Incorrect username or password!");
				else
				{
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(SupplyHomePageScene);
				window.show();
				}
			}
		}
	    
	    public void HomePageDelivery(ActionEvent event) throws IOException, TimeSlotException {
			Parent DeliveryHomePageView = FXMLLoader.load(getClass().getResource("DeliveryCompanyHomePage.fxml"));
			Scene DeliveryHomePageScene = new Scene(DeliveryHomePageView);

			if (userSignInDelivery.getText().equals("") || passwordSignInDelivery.getText().equals(""))
				AlertBox.display("Register", "Please insert the data in every field");

			else {
				DiskDB db = new DiskDB();
				
				DeliveryCompany dc = db.loginDelivery(userSignInDelivery.getText(), passwordSignInDelivery.getText());
				if(dc == null)
					AlertBox.display("Login", "Incorrect username or password!");
				else
				{
				Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
				window.setScene(DeliveryHomePageScene);
				window.show();
				}
			}
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
