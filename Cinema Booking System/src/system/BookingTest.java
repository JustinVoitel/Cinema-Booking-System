package system;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import cinema.Show;
import cinema.Theatre;

class BookingTest {
	int price = 30;
	ArrayList<String> seats = new ArrayList<>();
	Theatre theatre = new Theatre("theater1","Venom",10);
	Show show = new Show("Show1",theatre,price);
	Customer user = new Customer("Justin","123");
	Booking booking1 = new Booking(show,seats,user);

	@Test
	void calcTotal() {
		seats.add("1/1");
		seats.add("1/2");
		double total = seats.size()*show.getPrice();
		assertEquals(60.00,total);
	}

}
