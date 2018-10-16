package system;

import java.util.ArrayList;
import java.util.Random;

public class Customer {
	private String name;
	private String phone;
	private boolean isLogged = true;
	private int id;
	private ArrayList<Booking> bookings;
	
	public Customer(String name,String phone) {
		super();
		Random rng = new Random();
		this.id = rng.nextInt(999);
		this.bookings = new ArrayList<>();
		this.name=name;
		this.phone=phone;
	}
	
	public Boolean isLogged() {
		return this.isLogged;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void addBooking(Booking booking) {
		this.bookings.add(booking);
	}
	
	public void deleteBooking(int bookingIndex) {
		this.bookings.remove(bookingIndex);
	}
	
	public ArrayList<Booking> getBookings() {
		return this.bookings;
	}
}
