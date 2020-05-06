package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model_entities.Reservation;
import model_exceptions.DomainException;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			System.out.print("Room Number: ");
			int roomNumber = sc.nextInt();
			System.out.print("CheckIn date: ");
			Date checkIn = sdf.parse(sc.next());
			System.out.print("CheckOut date: ");
			Date checkOut = sdf.parse(sc.next());
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println();
			System.out.println(reservation);
			System.out.println();
			
			System.out.println("Enter data to update the reservation: ");
			System.out.print("CheckIn date: ");
			Date checkIn2 = sdf.parse(sc.next());
			System.out.print("CheckOut date: ");
			Date checkOut2 = sdf.parse(sc.next());
			reservation.updateDates(checkIn2, checkOut2);
			System.out.println();
			System.out.println(reservation);
		}
		catch (ParseException e) {
			System.out.println("Invalid date format! Try again!");			
		}
		catch (DomainException e) {
			System.out.println("Error in reservation "+ e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error, try again!");
		}
		
		sc.close();

	}

}
