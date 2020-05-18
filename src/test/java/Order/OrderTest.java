package Order;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OrderTest {

	@Test
	public void testAddProduct() {
		Product p1 = new Product("tricou", null, null, 0);
		Order test1 = new Order(null, null);
		test1.addProduct(p1);
		String expected = "The Order with the ID " + "0" + " products list: tricou\n";
		String output = test1.toString();
		assertEquals(expected, output);
	}

	@Test
	public void testDeleteProduct() {
		Product p1 = new Product("tricou", null, null, 0);
		Order test = new Order(null, null);
		test.addProduct(p1);
		String expected = "The Order with the ID " + "1" + " products list: tricou\n";
		String output = test.toString();
		assertEquals(expected, output);
		// test.deleteProduct("tricou");
		expected = "The Order with the ID " + "0" + " products list: ";
		output = test.toString();
		// assertEquals(expected, output);

	}
}