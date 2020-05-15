package Review;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing the Review class and the output of it
 * 
 * @author catalin.candea
 *
 */
public class ReviewTest {

	@Test
	public void testCreate() {
		Review test = new Review();
		String output = test.toString();
		String expected = "Review = : " + "0.0" + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testAddOne() {
		Review test = new Review();
		test.getReview(10);
		String output = test.toString();
		String expected = "Review = : " + "5.0" + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testAddNegative() {
		Review test = new Review();
		test.getReview(-5);
		String output = test.toString();
		String expected = "Review = : " + "0.0" + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testAddTwo() {
		Review test = new Review();
		test.getReview(10);
		test.getReview(1);
		String output = test.toString();
		String expected = "Review = : " + "3.0" + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testAddZero() {
		Review test = new Review();
		test.getReview(0);
		String output = test.toString();
		String expected = "Review = : " + "0.0" + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testAddOver5() {
		Review test = new Review();
		test.getReview(10);
		String output = test.toString();
		String expected = "Review = : " + "5.0" + "\n";
		assertEquals(expected, output);
	}
}
