package CarCosCanLivreisan.sef_project;

import java.io.IOException;

import Timetable.TimeSlotException;
import User.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Register_Controller {
	
	@FXML
	private TextField userCustomer;
	@FXML
	private PasswordField passwordCustomer;
	@FXML
	private TextField emailCustomer;
	@FXML
	private TextField phoneCustomer;
	@FXML
	private TextField addressCustomer;
	
	@FXML
	private TextField userDelivery;
	@FXML
	private PasswordField passwordDelivery;
	@FXML
	private TextField emailDelivery;
	@FXML
	private TextField phoneDelivery;
	
	@FXML
	private TextField userSupply;
	@FXML
	private PasswordField passwordSupply;
	@FXML
	private TextField emailSupply;
	@FXML
	private TextField phoneSupply;
	@FXML
	private TextField addressSupply;
	@FXML
	private TextField fromHour;
	@FXML
	private TextField toHour;
//	
	
	

    public void BackHomeViewButoonClicked(ActionEvent event) throws IOException
    {
        Parent HomePageView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene HomePageScene = new Scene(HomePageView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(HomePageScene);
        window.show();
    }

    public void RegisterSupplyButoonClicked(ActionEvent event) throws IOException
    {
        Parent RegisterSupplyView = FXMLLoader.load(getClass().getResource("RegisterSupply.fxml"));
        Scene RegisterSupplyScene = new Scene(RegisterSupplyView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(RegisterSupplyScene);
        window.show();
    }
    
    public void RegisterDeliveryButoonClicked(ActionEvent event) throws IOException
    {
        Parent RegisterDeliveryView = FXMLLoader.load(getClass().getResource("RegisterDelivery.fxml"));
        Scene RegisterDeliveryScene = new Scene(RegisterDeliveryView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(RegisterDeliveryScene);
        window.show();
    }
    
    public void RegisterCustomerButoonClicked(ActionEvent event) throws IOException
    {
        Parent RegisterCustomerView = FXMLLoader.load(getClass().getResource("RegisterCustomer.fxml"));
        Scene RegisterCustomerScene = new Scene(RegisterCustomerView);
        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(RegisterCustomerScene);
        window.show();
    }
    
    public void BackRegisterViewButoonClicked(ActionEvent event) throws IOException
    {
        Parent RegisterView = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Scene RegisterScene = new Scene(RegisterView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(RegisterScene);
        window.show();
    }
    

    public void HomePageCustomer(ActionEvent event) throws IOException
    {
        Parent CustomerHomePageView = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
        Scene CustomerHomePageScene = new Scene(CustomerHomePageView);
        
        //printeaza ce ia din field-uri
//        System.out.println(userCustomer.getText());
//        System.out.println(passwordCustomer.getText());
//        System.out.println(emailCustomer.getText());
//        System.out.println(phoneCustomer.getText());
//        System.out.println(addressCustomer.getText());
        
        Customer customer = new Customer(userCustomer.getText(), phoneCustomer.getText(), emailCustomer.getText(), addressCustomer.getText());
   
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(CustomerHomePageScene);
        window.show();
        
    }

    public void HomePageSupply(ActionEvent event) throws IOException, TimeSlotException
    {
        Parent SupplyHomePageView = FXMLLoader.load(getClass().getResource("SupplyCompanyHomePage.fxml"));
        Scene SupplyHomePageScene = new Scene(SupplyHomePageView);

        //printeaza ce ia din field-uri
//      System.out.println(userSupply.getText());
//      System.out.println(passwordSupply.getText());
//      System.out.println(emailSupply.getText());
//      System.out.println(phoneSupply.getText());
//      System.out.println(addressSupply.getText());
//      System.out.println(fromHour.getText());
//      System.out.println(toHour.getText());    
        
      SupplierCompany sp = new SupplierCompany (userSupply.getText(), Integer.parseInt(fromHour.getText()), Integer.parseInt(toHour.getText()),phoneSupply.getText(),addressSupply.getText(), emailSupply.getText());
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(SupplyHomePageScene);
        window.show();
    }

    public void HomePageDelivery(ActionEvent event) throws IOException
    {
        Parent DeliveryHomePageView = FXMLLoader.load(getClass().getResource("DeliveryCompanyHomePage.fxml"));
        Scene DeliveryHomePageScene = new Scene(DeliveryHomePageView);
	
//	    System.out.println(userDelivery.getText());
//	    System.out.println(passwordDelivery.getText());
//	    System.out.println(emailDelivery.getText());
//	    System.out.println(phoneDelivery.getText());
	     
	    DeliveryCompany dc = new DeliveryCompany(userDelivery.getText(),emailDelivery.getText(),phoneDelivery.getText());
	        
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeliveryHomePageScene);
        window.show();
    }
    
   
    public void LogOutButtonClicked(ActionEvent event) throws IOException {
        Parent LogOutView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene LogOutScene = new Scene(LogOutView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
       
        window.close();
    }

}
