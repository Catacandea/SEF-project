package User;

import java.util.ArrayList;

import Order.Product;
import Timetable.DaysEnum;
import Timetable.TimeSlot;
import Timetable.TimeSlotException;
import Timetable.Timetable;

public class SupplierCompany extends User {
	private Timetable timetable;
	private String address;
	private ArrayList<Product> products;

	/**
	 * 
	 * @param username
	 * @param toHour
	 * @param fromHour
	 * @param phoneNumber
	 * @param address
	 * @param email
	 * @throws TimeSlotException
	 */
	public SupplierCompany(String username, int to, int from, String phoneNumber, String address, String email)
			throws TimeSlotException {
		super(username, phoneNumber, email);
		timetable = new Timetable(new TimeSlot(to, from));
		this.address = address;
		products = new ArrayList<Product>();
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void addProduct(Product newProduct) {
		products.add(newProduct);
		newProduct.setProvider(this);
	}

	public String showProducts() {
		String returnValue = "Products of Company " + this.getUsername() + ": ";
		for (Product product : products) {
			returnValue = returnValue + product.toString() + ", ";
		}
		returnValue = returnValue + "\n";
		return returnValue;
	}

	public void deleteProduct(String productName) {
		for (Product product : products) {
			if (product.equals(productName)) {
				products.remove(product);
			}
		}
	}

	public void modifyTimetable(TimeSlot timeslot, DaysEnum day) {
		timetable.modifyTimetable(timeslot, day);

	}

	@Override
	public String toString() {
		String returnValue = "Company : ";
		returnValue = returnValue + this.getUsername() + ", Phone number : " + this.getPhoneNumber() + ", Address: "
				+ this.getAddress() + ",email : " + this.getEmail() + "\n";
		return returnValue;
	}
}
