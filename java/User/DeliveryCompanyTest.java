package User;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Order.Order;
import Order.Product;
import Order.ProductEnum;

public class DeliveryCompanyTest {

	@Test
	public void testTakeOrder() {
		DeliveryCompany test = new DeliveryCompany("Dorel", "0792694202", "Dorel@yahoo.com");
		Order order = new Order(test, null);
		Product product = new Product("Autofiletanta", test, ProductEnum.CLOTHING, 600);
		order.addProduct(product);
		test.assignOrder(order);
		Order output = test.getOrder();
		assertEquals(order, output);
	}

	@Test
	public void testCancelOrder() {
		DeliveryCompany test = new DeliveryCompany("Dorel", "0792694202", "Dorel@yahoo.com");
		Order order = new Order(test, null);
		Product product = new Product("Autofiletanta", test, ProductEnum.CLOTHING, 600);
		order.addProduct(product);
		test.assignOrder(order);
		test.cancelOrder();
		Order output = test.getOrder();
		assertEquals(null, output);
	}

	@Test
	public void testViewOrders() {
		DeliveryCompany test = new DeliveryCompany("Dorel", "0792694202", "Dorel@yahoo.com");
		ArrayList<Order> allOrders = new ArrayList<Order>();
		Order order = new Order(null, null);
		Order order2 = new Order(null, null);
		Product product = new Product("Autofiletanta", test, ProductEnum.CLOTHING, 600);
		Product product2 = new Product("Canapea", test, ProductEnum.CLOTHING, 600);
		order.addProduct(product);
		order2.addProduct(product2);
		allOrders.add(order);
		allOrders.add(order2);
		String output = test.viewOrders(allOrders);
		String expected = "The Order with the ID 2 products list: Autofiletanta\n"
				+ "The Order with the ID 3 products list: Canapea\n";
		assertEquals(expected, output);
	}

	@Test
	public void testFinishOrder() {
		DeliveryCompany test = new DeliveryCompany("Dorel", "0792694202", "Dorel@yahoo.com");
		Customer customer = new Customer("Eu", "random", "random", "random");
		Order order = new Order(test, customer);
		Product product = new Product("Autofiletanta", test, ProductEnum.CLOTHING, 600);
		order.addProduct(product);
		test.assignOrder(order);
		test.finishOrder(5);
		Order result = test.getOrder();
		assertEquals(null, result);
	}

}
