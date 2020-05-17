package User;

import java.util.ArrayList;

import Order.Order;
import Order.OrderStatusEnum;

public class DeliveryCompany extends User {
	private String phoneNumber;
	private Order order;

	/**
	 * 
	 * @param username
	 * @param email
	 * @param phoneNumber
	 */
	public DeliveryCompany(String username, String email, String phoneNumber) {
		super(username, phoneNumber, email);
	}

	public void assignOrder(Order wanted) {
		order = wanted.getOrder(this);
	}

	public Order getOrder() {
		return this.order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String viewOrders(ArrayList<Order> orders) {
		String returnValue = "";
		for (Order auxOrder : orders) {
			returnValue += auxOrder.toString();
		}
		return returnValue;
	}

	public void finishOrder(int mark) {
		order.getCustomer().getReview(mark);
		OrderStatusEnum status = OrderStatusEnum.FINISH;
		order.setStatus(status);
		order = null;
	}

	public Order cancelOrder() {
		Order aux = order;
		aux.cancelOrder();
		order = null;
		return aux;
	}

	@Override
	public String getPhoneNumber() {
		return phoneNumber;
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		} else if (!(o instanceof DeliveryCompany)) {
			return false;
		} else {
			DeliveryCompany c = (DeliveryCompany) o;
			if (c.getUsername() == this.getUsername()) {
				return true;
			} else {
				return false;
			}
		}
	}

}
