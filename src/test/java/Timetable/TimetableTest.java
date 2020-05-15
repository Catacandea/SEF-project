package Timetable;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TimetableTest {

	@Test
	public void testCreate() throws TimeSlotException {
		TimeSlot ts = new TimeSlot(10, 20);
		Timetable test = new Timetable(ts);
		String output = test.toString();

		String expected = "MONDAY : " + ts.toString() + "\n" + "TUESDAY : " + ts.toString() + "\n" + "WEDNESDAY : "
				+ ts.toString() + "\n" + "THURSDAY : " + ts.toString() + "\n" + "FRIDAY : " + ts.toString() + "\n"
				+ "SATURDAY : " + ts.toString() + "\n" + "SUNDAY : " + ts.toString() + "\n";
		assertEquals(expected, output);
	}

	@Test
	public void testModifyTS() throws TimeSlotException {
		TimeSlot ts = new TimeSlot(1, 5);
		TimeSlot ts2 = new TimeSlot(10, 20);
		Timetable test = new Timetable(ts);
		test.modifyTimetable(ts2, DaysEnum.MONDAY);
		String output = test.toString();
		String expected = "MONDAY : " + ts2.toString() + "\n" + "TUESDAY : " + ts.toString() + "\n" + "WEDNESDAY : "
				+ ts.toString() + "\n" + "THURSDAY : " + ts.toString() + "\n" + "FRIDAY : " + ts.toString() + "\n"
				+ "SATURDAY : " + ts.toString() + "\n" + "SUNDAY : " + ts.toString() + "\n";
		assertEquals(expected, output);
	}

}
