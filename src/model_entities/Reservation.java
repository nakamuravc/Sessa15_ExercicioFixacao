package model_entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model_exceptions.DomainException;

public class Reservation {

	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation() {
	}

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkIn.before(checkOut)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if (!checkIn.before(checkOut)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		if (!checkIn.after(now)) {
			throw new DomainException("Reservation dates for update must be future dates");
		}
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	public String toString() {
		return "Reservation: Room " + roomNumber
				+ ", checkIn: " + sdf.format(checkIn)
				+ ", checkOut: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}
	
}
