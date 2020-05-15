package Timetable;

/**
 * The TimeSlot is used to keep the Time interval for each day from the
 * Timetable
 * 
 * @author catalin.candea
 *
 */
public class TimeSlot {
	private int from;
	private int to;
	private boolean status;

	/**
	 * 
	 * @param from
	 * @param to
	 * @throws TimeSlotException
	 */
	public TimeSlot(int from, int to) throws TimeSlotException {
		if (from > 24 || to > 24) {
			throw new TimeSlotException("Hour must be between 0 and 24");
		}
		this.from = from;
		this.to = to;
		if (from == to)
			status = false;
		else
			status = true;
	}

	public int getFrom() {
		return from;
	}

	public void setFrom(int from) throws TimeSlotException {
		if (from > 24) {
			throw new TimeSlotException("Hour must be between 0 and 24");
		}
		this.from = from;
	}

	public int getTo() {
		return to;
	}

	public void setTo(int to) throws TimeSlotException {
		if (from > 24) {
			throw new TimeSlotException("Hour must be between 0 and 24");
		}
		this.to = to;
	}

	@Override
	public String toString() {
		String returnValue = "";
		if (status == true) {
			returnValue = returnValue + from + ":00 - " + to + ":00";
		} else {
			returnValue = "CLOSED";
		}
		return returnValue;
	}
}
