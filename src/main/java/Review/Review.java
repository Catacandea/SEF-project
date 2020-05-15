package Review;

/**
 * The review system is used to keep track of the review a User gets from other
 * users
 * 
 * @author catalin.candea
 *
 */
public class Review {
	private double review;
	private int review_number;

	public Review() {
		review_number = 0;
		review = 0;
	}

	public void getReview(int review) {
		double reviewSum = this.review;
		if (review > 5)
			review = 5;
		if (review < 0)
			review = 0;
		reviewSum = reviewSum + review;
		review_number++;
		this.review = reviewSum / review_number;
	}

	@Override
	public String toString() {
		return "Review = : " + review + "\n";
	}
}
