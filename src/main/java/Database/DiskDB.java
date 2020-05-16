package Database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import Order.Order;
import Order.Product;

public class DiskDB {
	public ArrayList<Product> products = getProductsfromDisk();
	public ArrayList<Order> orders = getOrdersfromDisk();
	private static ObjectMapper mapper = new ObjectMapper();

	public ArrayList<Product> getProductsfromDisk() {
		ArrayList<Product> products = null;
		try {
			InputStream inputStream = new FileInputStream(
					new File("/sef-project/src/main/resources/Database/products.json"));
			TypeReference<ArrayList<Product>> typeReference = new TypeReference<ArrayList<Product>>() {
			};
			products = mapper.readValue(inputStream, typeReference);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		return products;
	}

	public ArrayList<Order> getOrdersfromDisk() {
		ArrayList<Order> orders = null;
		try {
			InputStream inputStream = new FileInputStream(
					new File("/sef-project/src/main/resources/Database/orders.json"));
			TypeReference<ArrayList<Product>> typeReference = new TypeReference<ArrayList<Product>>() {
			};
			products = mapper.readValue(inputStream, typeReference);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		;

		return orders;
	}

	public void writeOrdersToDisk(ArrayList<Order> orders) {
		try {
			File file = new File("/sef-project/src/main/resources/Database/orders.json");
			file.delete();
			file.createNewFile();
			mapper.writeValue(new File("/sef-project/src/main/resources/Database/products.json"), orders);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void writeProductsToDisk(ArrayList<Product> products) {
		try {
			File file = new File("/sef-project/src/main/resources/Database/products.json");
			file.delete();
			file.createNewFile();
			mapper.writeValue(new File("/sef-project/src/main/resources/Database/products.json"), products);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
