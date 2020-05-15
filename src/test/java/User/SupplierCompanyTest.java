package User;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Order.Product;
import Order.ProductEnum;
import Timetable.TimeSlotException;

public class SupplierCompanyTest {
	@Test
	public void testCreate() throws TimeSlotException {
		SupplierCompany test = new SupplierCompany("Dedeman", 10, 20, "0730497867", "Str. Mihai Eminescu, no. 10",
				"dedeman@yahoo.com");
		String output = test.toString();
		String expected = "Company : Dedeman" + ", Phone number : " + "0730497867" + ", Address: "
				+ "Str. Mihai Eminescu, no. 10" + ",email : " + "dedeman@yahoo.com" + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testShowTimetable() throws TimeSlotException {
		SupplierCompany test = new SupplierCompany("Dedeman", 10, 20, "0730497867", "Str. Mihai Eminescu, no. 10",
				"dedeman@yahoo.com");
		String output = test.getTimetable().toString();

		String expected = "MONDAY : " + "10:00 - 20:00" + "\n" + "TUESDAY : " + "10:00 - 20:00" + "\n" + "WEDNESDAY : "
				+ "10:00 - 20:00" + "\n" + "THURSDAY : " + "10:00 - 20:00" + "\n" + "FRIDAY : " + "10:00 - 20:00" + "\n"
				+ "SATURDAY : " + "10:00 - 20:00" + "\n" + "SUNDAY : " + "10:00 - 20:00" + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testAddProduct() throws TimeSlotException {
		SupplierCompany test = new SupplierCompany("Dedeman", 10, 20, "0730497867", "Str. Mihai Eminescu, no. 10",
				"dedeman@yahoo.com");
		Product product = new Product("Autofiletanta", test, ProductEnum.CLOTHING, 600);
		test.addProduct(product);
		test.addProduct(new Product("Bormasina", test, ProductEnum.DRUGS, 300));
		String output = test.showProducts();
		String expected = "Products of Company " + "Dedeman:"
				+ " Autofiletanta, Pret :600.0, Bormasina, Pret :300.0, \n";
		assertEquals(expected, output);

	}

	@Test
	public void testDeleteProduct() throws TimeSlotException {
		SupplierCompany test = new SupplierCompany("Dedeman", 10, 20, "0730497867", "Str. Mihai Eminescu, no. 10",
				"dedeman@yahoo.com");
		Product product = new Product("Autofiletanta", test, ProductEnum.CLOTHING, 600);
		test.addProduct(product);
		test.addProduct(new Product("Bormasina", test, ProductEnum.DRUGS, 300));
		test.deleteProduct("Autofiletanta");
		String output = test.showProducts();
		String expected = "Products of Company " + "Dedeman:" + " Bormasina, Pret :300.0, \n";
		assertEquals(expected, output);

	}
}
