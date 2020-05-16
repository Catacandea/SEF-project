package CarCosCanLivreisan.sef_project;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Register_Controller {

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

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(CustomerHomePageScene);
        window.show();
    }

    public void HomePageSupply(ActionEvent event) throws IOException
    {
        Parent SupplyHomePageView = FXMLLoader.load(getClass().getResource("SupplyCompanyHomePage.fxml"));
        Scene SupplyHomePageScene = new Scene(SupplyHomePageView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(SupplyHomePageScene);
        window.show();
    }

    public void HomePageDelivery(ActionEvent event) throws IOException
    {
        Parent DeliveryHomePageView = FXMLLoader.load(getClass().getResource("DeliveryCompanyHomePage.fxml"));
        Scene DeliveryHomePageScene = new Scene(DeliveryHomePageView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(DeliveryHomePageScene);
        window.show();
    }
    
   
    public void LogOutButtonClicked(ActionEvent event) throws IOException {
        Parent LogOutView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        Scene LogOutScene = new Scene(LogOutView);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        //window.setScene(LogOutScene);
        //window.show();
        window.close();
    }

}
