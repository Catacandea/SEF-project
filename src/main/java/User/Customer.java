package User;

import java.util.ArrayList;

import Order.Order;
import Order.OrderStatusEnum;
import Order.Product;

public class Customer extends User {
	private Order actualOrder;
	private ArrayList<Order> totalOrders = new ArrayList<Order>();
	private String address;
	private String fullName;

	public Customer(String username, String fullName, String phoneNumber, String email, String address) {
		super(username, username, email);
		this.setAddress(address);
		this.fullName = fullName;
	}

	public String viewProducts(ArrayList<Product> product) {
		String returnValue = "";
		for (Product auxOrder : product) {
			returnValue += auxOrder.toString();
		}
		return returnValue;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Order getActualOrder() {
		return actualOrder;
	}

	public void addProduct(Product product) {
		if (actualOrder == null) {
			actualOrder = new Order(null, this);
		}
		actualOrder.addProduct(product);
	}

	public void cancelOrder() {
		actualOrder.cancelOrder();
		actualOrder.getDelivery().setOrder(null);
	}

	public void finishOrder(int mark) {
		actualOrder.getDelivery().getReview(mark);
		OrderStatusEnum status = OrderStatusEnum.FINISH;
		actualOrder.setStatus(status);
		totalOrders.add(actualOrder);
		actualOrder = null;

	}

	public Order placeOrder() {
		return actualOrder;

	}

}
