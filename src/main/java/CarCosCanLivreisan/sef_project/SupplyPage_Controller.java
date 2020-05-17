package CarCosCanLivreisan.sef_project;
import java.io.IOException;

import Order.Product;
import User.SupplierCompany;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SupplyPage_Controller {
	
	@FXML
	private TextField nameProduct;
	@FXML
	private TextField priceProduct;
	@FXML
	private CheckBox drugsType;
	@FXML
	private CheckBox foodType;
	@FXML
	private CheckBox clothingType;
	
	
	public void LogOutButtonClicked(ActionEvent event) throws IOException {
	       Parent LogOutView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
	       Scene LogOutScene = new Scene(LogOutView);

	       boolean result = ConfirmBox.display("Sign Out", "Are you sure you want to sign out?");
	       System.out.println(result) ;
	       Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	      
	       if(result == false)
	    	   window.show();
	       else if(result == true)
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
	 
	 public void AddProductButtonClicked(ActionEvent event) throws IOException 
	 {
	    Parent AddProductView = FXMLLoader.load(getClass().getResource("SupplyCompany_AddProduct.fxml"));
	    Scene AddProductScene = new Scene(AddProductView);
	    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    
	    window.setScene(AddProductScene);       
	    window.show();
	 }
	 public void AddedProduct (ActionEvent event) throws IOException
	 {
		 Parent AddedProductView = FXMLLoader.load(getClass().getResource("SupplyCompanyHomePage.fxml"));
		 Scene AddedProductScene = new Scene(AddedProductView);
		 Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		 
		 if(nameProduct.getText().equals("") || priceProduct.getText().equals(""))
			 AlertBox.display("Add product", "Please insert data in every field!");
		 else 
			 {
			// sp.addProduct(new Product(nameProduct.getText(), priceProduct.getText()),ProductEnum.typeEnum());
			 AlertBox.display("Add product", "The product was added.");
			 window.setScene(AddedProductScene);       
			 window.show();
			 }
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
