package system;

import java.util.ArrayList;
import java.util.Random;

import cinema.Show;

public class Booking {
	private int id;
	private boolean isBooked;
	private double total;
	private Customer user;
	private Show show;
	private ArrayList<String> seats;
	public Booking(Show show, ArrayList<String> seats, Customer user) {
		super();
		this.isBooked=false;
		Random rng = new Random();
		this.id = rng.nextInt(999);
		this.user = user;
		this.show = show;
		this.seats = seats;
		this.calcTotal();
		this.bookSeats();
	}
	
	/**
	 * books the existing seats in the seats ArrayList
	 * 
	 */
	public void bookSeats() {
		//check if booking information is received
		if(seats.isEmpty() || user.equals(null) || show.equals(null)) {
			System.out.println("Payment failed!");
		}else {
			//book seats and get boolish response if successful
			Boolean valid = this.show.bookSeats(seats);
			if(valid) {
				this.user.addBooking(this);
				this.isBooked=true;
				System.out.println("Booking successful!");
			}else {
				System.out.println("booking failed!");
			}
		}
	}
	
	/**
	 * calculates the total price for this booking, 
	 * where it multiplies the number of seats with the price of the show
	 */
	public void calcTotal() {
		this.total = this.show.getPrice()*this.seats.size();
	}
	
	/**
	 * GETTERS & SETTERS
	 */
	public double getTotal() {
		return this.total;
	}
	
	public int getId() {
		return this.id;
	}
	
	public Show getShow() {
		return this.show;
	}
	
	public ArrayList<String> getSeats(){
		return this.seats;
	}
	
}
