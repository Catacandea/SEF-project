package User;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Order.Order;
import Order.Product;
import Order.ProductEnum;

public class CustomerTest {

    @Test
    public void testAddProduct() {
        Product p1 = new Product("Tricou", null, ProductEnum.CLOTHING, 80);
        Customer test = new Customer("username", "Fullname", "000000000", "username@yahoo.com", "Street");
        Order order_before = test.getActualOrder();
        assertEquals(null, order_before);
        test.addProduct(p1);
        String expected = "The Order with the ID 1" + " products list: Tricou\n";
        Order order = test.getActualOrder();

        assertEquals(expected, order.toString());
    }

    @Test
    public void testFinishOrder() {
        Product p1 = new Product("Tricou", null, ProductEnum.CLOTHING, 80);
        Customer test = new Customer("username", "Fullname", "000000000", "username@yahoo.com", "Street");
        test.addProduct(p1);
        System.out.println(test.getActualOrder());
        DeliveryCompany someone = new DeliveryCompany(null, null, null);
        test.getActualOrder().setDelivery(someone);
        test.finishOrder(5);
        assertEquals(null, test.getActualOrder());

    }
}