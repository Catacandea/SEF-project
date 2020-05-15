package Order;

import java.util.ArrayList;

import User.Customer;
import User.DeliveryCompany;

/**
 * The Order class is used to manage a set of products. Also is used to store
 * cusomer and delivery company for each order
 * 
 * @author catalin.candea
 *
 */
public class Order {
	private Customer customer;
	private DeliveryCompany delivery;
	private OrderStatusEnum status;
	private ArrayList<Product> productList;
	private double price;
	private int ID;
	private static int IDcounter = 0;

	/**
	 * Constructor for the order, created before any other product to be added to
	 * the list
	 * 
	 * @param client
	 * @param delivery
	 * @param customer
	 */
	public Order(DeliveryCompany delivery, Customer customer) {
		this.customer = customer;
		this.delivery = delivery;
		this.status = OrderStatusEnum.PENDING;
		this.ID = IDcounter;
		this.price = 0;
		IDcounter++;
		productList = new ArrayList<Product>();

	}

	public void addProduct(Product newProduct) {
		productList.add(newProduct);
		price = price + newProduct.getPrice();
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public DeliveryCompany getDelivery() {
		return delivery;
	}

	public void setDelivery(DeliveryCompany delivery) {
		this.delivery = delivery;
	}

	public OrderStatusEnum getStatus() {
		return status;
	}

	public void setStatus(OrderStatusEnum status) {
		this.status = status;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Order getOrder(DeliveryCompany delivery) {
		this.setDelivery(delivery);
		this.setStatus(OrderStatusEnum.IN_PROGRESS);
		return this;
	}

	public void cancelOrder() {
		this.setStatus(OrderStatusEnum.PENDING);
		this.delivery = null;
	}

	public void deleteProduct(String productName) {
		for (Product product : productList) {
			if (product.equals(productName)) {
				productList.remove(product);
			}
		}
	}

	@Override
	public String toString() {
		String returnValue = "The Order with the ID " + this.ID + " products list: ";
		for (Product products : productList) {
			returnValue += products.getName();
		}
		returnValue += "\n";
		return returnValue;
	}
}
