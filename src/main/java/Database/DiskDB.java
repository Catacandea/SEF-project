package Database;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Timetable.TimeSlotException;
import User.Customer;
import User.DeliveryCompany;
import User.SupplierCompany;

public class DiskDB {
	// public ArrayList<Product> products = getProductsfromDisk();
	// public ArrayList<Order> orders = getOrdersfromDisk();
	// private static ObjectMapper mapper = new ObjectMapper();

	/*
	 * public ArrayList<Product> getProductsfromDisk() { ArrayList<Product> product
	 * = null; try { InputStream inputStream = new FileInputStream( new
	 * File("/sef-project/src/main/resources/Database/products.json"));
	 * TypeReference<ArrayList<Product>> typeReference = new
	 * TypeReference<ArrayList<Product>>() { }; products =
	 * mapper.readValue(inputStream, typeReference); } catch (FileNotFoundException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (JsonParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } ;
	 * 
	 * return products; }
	 * 
	 * public ArrayList<Order> getOrdersfromDisk() { ArrayList<Order> orders = null;
	 * try { InputStream inputStream = new FileInputStream( new
	 * File("/sef-project/src/main/resources/Database/orders.json"));
	 * TypeReference<ArrayList<Product>> typeReference = new
	 * TypeReference<ArrayList<Product>>() { }; products =
	 * mapper.readValue(inputStream, typeReference); } catch (FileNotFoundException
	 * e) { // TODO Auto-generated catch block e.printStackTrace(); } catch
	 * (JsonParseException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } catch (JsonMappingException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch (IOException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } ;
	 * 
	 * return orders; }
	 * 
	 * public void writeOrdersToDisk(ArrayList<Order> orders) { try { File file =
	 * new File("/sef-project/src/main/resources/Database/orders.json");
	 * file.delete(); file.createNewFile(); mapper.writeValue(new
	 * File("/sef-project/src/main/resources/Database/products.json"), orders); }
	 * catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */
	private Map<Customer, String> CustomerToPassword = new HashMap<Customer, String>();
	private Map<SupplierCompany, String> SupplierToPassword = new HashMap<SupplierCompany, String>();
	private Map<DeliveryCompany, String> DeliveryToPassword = new HashMap<DeliveryCompany, String>();

	public DiskDB() {
		Customer c1 = new Customer("Customer1", "Customer1 fullname", "1111111111", "email1@yahoo.com", "First street");
		Customer c2 = new Customer("Customer2", "Customer2 fullname", "2222222222", "email2@yahoo.com", "2nd street");
		Customer c3 = new Customer("Customer3", "Customer3 fullname", "3333333333", "email3@yahoo.com", "3rd street");
		CustomerToPassword.put(c1, "password1");
		CustomerToPassword.put(c2, "password2");
		CustomerToPassword.put(c3, "password3");
		SupplierCompany s1;
		try {
			s1 = new SupplierCompany("Supplier1", 5, 10, "1111111111", "emailsupp1@yahoo.com", "First street");
			SupplierCompany s2 = new SupplierCompany("Supplier2", 2, 11, "2222222222", "emailsupp2@yahoo.com",
					"2nd street");
			SupplierCompany s3 = new SupplierCompany("Supplier3", 10, 20, "3333333333", "emailsupp3@yahoo.com",
					"3rd street");

			SupplierToPassword.put(s1, "password1");
			SupplierToPassword.put(s2, "password2");
			SupplierToPassword.put(s3, "password3");
		} catch (TimeSlotException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		DeliveryCompany d1 = new DeliveryCompany("Delivery1", "emailsupp1@yahoo.com", "1111111111");
		DeliveryCompany d2 = new DeliveryCompany("Delivery2", "emailsupp2@yahoo.com", "2222222222");
		DeliveryCompany d3 = new DeliveryCompany("Delivery3", "emailsupp3@yahoo.com", "3333333333");
		DeliveryToPassword.put(d1, "password1");
		DeliveryToPassword.put(d2, "password2");
		DeliveryToPassword.put(d3, "password3");

	}

	public SupplierCompany registerSupplierCompany(String username, String password, int to, int from,
			String phoneNumber, String address, String email) throws TimeSlotException {
		SupplierCompany createSupplier = null;
		if (!username.isEmpty() && !password.isEmpty()) {
			SupplierCompany searchSupplier = getSupplier(username);
			if (searchSupplier == null) {

				createSupplier = new SupplierCompany(username, to, from, phoneNumber, address, email);
				SupplierToPassword.put(createSupplier, password);
				createSupplier = loginSupplier(username, password);
			}

		} else {
			System.out.println("Creation unsuccessful! USERNAME is already taken!Please choose a different username!");
		}

		return createSupplier;

	}

	public DeliveryCompany registerDeliveryCompany(String username, String password, String email, String phoneNumber)
			throws TimeSlotException {
		DeliveryCompany createDelivery = null;
		if (!username.isEmpty() && !password.isEmpty()) {
			DeliveryCompany searchSupplier = getDelivery(username);
			if (searchSupplier == null) {

				createDelivery = new DeliveryCompany(username, email, phoneNumber);
				DeliveryToPassword.put(createDelivery, password);
				createDelivery = loginDelivery(username, password);
			}

		} else {
			System.out.println("Creation unsuccessful! USERNAME is already taken!Please choose a different username!");
		}

		return createDelivery;

	}

	public Customer registerCustomer(String username, String password, String fullName, String phoneNumber,
			String email, String address) {
		Customer createCustomer = null;

		if (!username.isEmpty() && !password.isEmpty()) {
			Customer searchCustomer = getCustomer(username);
			if (searchCustomer == null) {

				createCustomer = new Customer(username, fullName, phoneNumber, email, address);
				CustomerToPassword.put(createCustomer, password);
				createCustomer = loginCustomer(username, password);
			}

		} else {
			System.out.println("Creation unsuccessful! USERNAME is already taken!Please choose a different username!");
		}

		return createCustomer;
	}

	public Customer loginCustomer(String username, String password) {
		Customer searchedCustomer = getCustomer(username);
		Customer returnedCustomer = null;
		String pass;
		if (searchedCustomer == null) {
			System.out.println("Customer does not exist!");
		} else {
			pass = CustomerToPassword.get(searchedCustomer);
			if (password.equals(pass)) {
				returnedCustomer = searchedCustomer;
			} else {
				System.out.println("Password not matching");
			}
		}
		return returnedCustomer;
	}

	public SupplierCompany loginSupplier(String username, String password) {
		SupplierCompany searchedSupplier = getSupplier(username);
		SupplierCompany returnedSupplier = null;
		String pass;
		if (searchedSupplier == null) {
			System.out.println("Supplier Company does not exist!");
		} else {
			pass = SupplierToPassword.get(searchedSupplier);
			if (password.equals(pass)) {
				returnedSupplier = searchedSupplier;
			} else {
				System.out.println("Password not matching");
			}
		}
		return returnedSupplier;
	}

	public DeliveryCompany loginDelivery(String username, String password) {
		DeliveryCompany searchedDelivery = getDelivery(username);
		DeliveryCompany returnedDelivery = null;
		String pass;
		if (searchedDelivery == null) {
			System.out.println("Delivery Company does not exist!");
		} else {
			pass = DeliveryToPassword.get(searchedDelivery);
			if (password.equals(pass)) {
				returnedDelivery = searchedDelivery;
			} else {
				System.out.println("Password not matching");
			}
		}
		return returnedDelivery;
	}

	/**
	 * Finds the customer based on the username.
	 * 
	 * @param username
	 * @return
	 */
	private Customer getCustomer(String username) {
		Customer result = null;
		Set<Customer> customers = CustomerToPassword.keySet();
		for (Customer customer : customers) {
			String heroName = customer.getUsername();
			if (heroName.equals(username)) {
				result = customer;
				break;
			}
		}
		return result;
	}

	private SupplierCompany getSupplier(String username) {
		SupplierCompany result = null;
		Set<SupplierCompany> suppliers = SupplierToPassword.keySet();
		for (SupplierCompany supplier : suppliers) {
			String SupplierName = supplier.getUsername();
			if (SupplierName.equals(username)) {
				result = supplier;
				break;
			}
		}
		return result;
	}

	private DeliveryCompany getDelivery(String username) {
		DeliveryCompany result = null;
		Set<DeliveryCompany> deliveries = DeliveryToPassword.keySet();
		for (DeliveryCompany delivery : deliveries) {
			String deliveryName = delivery.getUsername();
			if (deliveryName.equals(username)) {
				result = delivery;
				break;
			}
		}
		return result;
	}

	/*
	 * public void writeProductsToDisk(ArrayList<Product> productlist) { try { File
	 * file = new File("products.json"); /* file.delete(); file.createNewFile();
	 * 
	 * String m = "Da frate"; mapper.writeValue(file, m); } catch (IOException e) {
	 * e.printStackTrace(); } }
	 */
}
