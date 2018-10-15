package system;

import java.util.ArrayList;

import cinema.Show;

public class Booking {
	private boolean isBooked = false;
	private Customer user;
	private Show show;
	private ArrayList<String> seats;
	public Booking(Show show, ArrayList<String> seats, Customer user) {
		super();
		this.user = user;
		this.show = show;
		this.seats = seats;
		bookSeats();
	}
	
	public void bookSeats() {
		//check if booking information is received
		if(seats.isEmpty() || user.equals(null) || show.equals(null)) {
			System.out.println("Payment failed!");
		}else {
			//book seats and get boolish response if successful
			Boolean valid = this.show.bookSeats(seats);
			if(valid) {
				this.isBooked=true;
			}
		}
	}
	
}
