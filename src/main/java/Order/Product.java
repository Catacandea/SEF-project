package Order;

import User.User;

/**
 * The Product class is the main Product class Stores name, provider, type of
 * product and the price
 * 
 * @author catalin.candea
 *
 */
public class Product {
	private String name;
	private User provider;
	private ProductEnum type;
	private double price;

	/**
	 * 
	 * @param name
	 * @param provider
	 * @param type
	 * @param price
	 */
	public Product(String name, User provider, ProductEnum type, double price) {
		this.name = name;
		this.provider = provider;
		this.type = type;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User getProvider() {
		return provider;
	}

	public void setProvider(User provider) {
		this.provider = provider;
	}

	public ProductEnum getType() {
		return type;
	}

	public void setType(ProductEnum type) {
		this.type = type;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		String returnValue = null;
		returnValue = this.getName() + ", Pret :" + this.price;
		return returnValue;
	}

	public boolean equals(String name) {
		boolean returnValue = false;
		if (this.name.contentEquals(name))
			returnValue = true;
		return returnValue;

	}

}
