package User;

import Review.Review;

/**
 * User is an abstract class implemented so that all the users that have common
 * arguments and method will inherit
 * 
 * @author catalin.candea
 *
 */
abstract public class User {

	private String username;
	private Review review;
	private String email;

	private String phoneNumber;

	/**
	 * 
	 * @param username
	 * @param phoneNumber
	 * @param email2
	 */
	public User(String username, String phoneNumber, String email2) {
		this.username = username;
		this.email = email2;
		this.phoneNumber = phoneNumber;
		review = new Review();
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return username;
	}

	public String showReview() {
		String returnValue = null;
		returnValue = review.toString();
		return returnValue;
	}

	public void getReview(int mark) {
		review.getReview(mark);
	}

	public void setUsername(String newUsername) {
		this.username = newUsername;
	}
}
