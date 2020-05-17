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
	private TextField nameCustomer;

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

	public void BackHomeViewButoonClicked(ActionEvent event) throws IOException {
		Parent HomePageView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Scene HomePageScene = new Scene(HomePageView);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(HomePageScene);
		window.show();
	}

	public void RegisterSupplyButoonClicked(ActionEvent event) throws IOException {
		Parent RegisterSupplyView = FXMLLoader.load(getClass().getResource("RegisterSupply.fxml"));
		Scene RegisterSupplyScene = new Scene(RegisterSupplyView);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(RegisterSupplyScene);
		window.show();
	}

	public void RegisterDeliveryButoonClicked(ActionEvent event) throws IOException {
		Parent RegisterDeliveryView = FXMLLoader.load(getClass().getResource("RegisterDelivery.fxml"));
		Scene RegisterDeliveryScene = new Scene(RegisterDeliveryView);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(RegisterDeliveryScene);
		window.show();
	}

	public void RegisterCustomerButoonClicked(ActionEvent event) throws IOException {
		Parent RegisterCustomerView = FXMLLoader.load(getClass().getResource("RegisterCustomer.fxml"));
		Scene RegisterCustomerScene = new Scene(RegisterCustomerView);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(RegisterCustomerScene);
		window.show();
	}

	public void BackRegisterViewButoonClicked(ActionEvent event) throws IOException {
		Parent RegisterView = FXMLLoader.load(getClass().getResource("Register.fxml"));
		Scene RegisterScene = new Scene(RegisterView);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(RegisterScene);
		window.show();
	}

	public void HomePageCustomer(ActionEvent event) throws IOException {
		Parent CustomerHomePageView = FXMLLoader.load(getClass().getResource("CustomerHomePage.fxml"));
		Scene CustomerHomePageScene = new Scene(CustomerHomePageView);

		if (userCustomer.getText().equals("") || nameCustomer.getText().equals("")
				|| passwordCustomer.getText().equals("") || phoneCustomer.getText().equals("")
				|| emailCustomer.getText().equals("") || addressCustomer.getText().equals(""))
			AlertBox.display("Register", "Please insert the data in every field");

		else {
			DiskDB db = new DiskDB();
			Customer customer = db.registerCustomer(userCustomer.getText(), passwordCustomer.getText(),
					nameCustomer.getText(), phoneCustomer.getText(), emailCustomer.getText(),
					addressCustomer.getText());

			// daca nu ii in baza de date si toate campurile is completate merge mai jos
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(CustomerHomePageScene);
			window.show();
		}

	}

	public void HomePageSupply(ActionEvent event) throws IOException, TimeSlotException {
		Parent SupplyHomePageView = FXMLLoader.load(getClass().getResource("SupplyCompanyHomePage.fxml"));
		Scene SupplyHomePageScene = new Scene(SupplyHomePageView);

		if (userSupply.getText().equals("") || passwordSupply.getText().equals("") || phoneSupply.getText().equals("")
				|| emailSupply.getText().equals("") || addressSupply.getText().equals("")
				|| fromHour.getText().equals("") || toHour.getText().equals(""))
			AlertBox.display("Register", "Please insert the data in every field");

		else {
			DiskDB db = new DiskDB();
			// sp == null
			SupplierCompany sp = db.registerSupplierCompany(userSupply.getText(), passwordSupply.getText(),
					Integer.parseInt(fromHour.getText()), Integer.parseInt(toHour.getText()), phoneSupply.getText(),
					addressSupply.getText(), emailSupply.getText());
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(SupplyHomePageScene);
			window.show();
		}
	}

	public void HomePageDelivery(ActionEvent event) throws IOException, TimeSlotException {
		Parent DeliveryHomePageView = FXMLLoader.load(getClass().getResource("DeliveryCompanyHomePage.fxml"));
		Scene DeliveryHomePageScene = new Scene(DeliveryHomePageView);

		if (userDelivery.getText().equals("") || passwordDelivery.getText().equals("")
				|| phoneDelivery.getText().equals("") || emailDelivery.getText().equals(""))
			AlertBox.display("Register", "Please insert the data in every field");

		else {
			DiskDB db = new DiskDB();
			DeliveryCompany dc = db.registerDeliveryCompany(userDelivery.getText(), passwordDelivery.getText(),
					emailDelivery.getText(), phoneDelivery.getText());

			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(DeliveryHomePageScene);
			window.show();
		}
	}

	public void LogOutButtonClicked(ActionEvent event) throws IOException {
		Parent LogOutView = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
		Scene LogOutScene = new Scene(LogOutView);

		AlertBox.display("Sign out", "Are you sure you want to sign out?");
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

		window.show();
		// window.close();
	}

}