package Database;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import Order.Product;
import Order.ProductEnum;

public class DiskDBTest {

	@Test
	public void testWrite() throws JsonGenerationException, JsonMappingException, IOException {
		ArrayList<Product> products = new ArrayList<Product>();
		Product p1 = new Product("Masina", null, ProductEnum.DRUGS, 300);
		Product p2 = new Product("Casa", null, ProductEnum.DRUGS, 300);
		Product p3 = new Product("Aur", null, ProductEnum.DRUGS, 300);
		DiskDB db = new DiskDB();
		products.add(p1);
		products.add(p2);
		products.add(p3);
		db.writeProductsToDisk(products);
	}

}
