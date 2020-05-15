package Timetable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Testing the TimeSlot class if its behaviour is as expected
 * 
 * @author catalin.candea
 *
 */

public class TimeSlotTest {

	@Test
	public void testCreate() throws TimeSlotException {
		TimeSlot test = new TimeSlot(10, 11);
		String output = test.toString();
		String expected = "10:00 - 11:00";
		assertEquals(expected, output);
	}

	@Test
	public void testClose() throws TimeSlotException {
		TimeSlot test = new TimeSlot(10, 10);
		String output = test.toString();
		String expected = "CLOSED";
		assertEquals(expected, output);
	}
}
