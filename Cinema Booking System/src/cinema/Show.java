package cinema;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Show {
	private String name;
	private Theatre theatre;
	private double price;
	private ArrayList<Row> rows;
	private LocalDateTime date;
	
	public Show(String name, Theatre theatre, double price) {
		super();
		this.name=name;
		this.theatre=theatre;
		this.price=price;
		this.rows = this.theatre.getRowSchema();
		date = LocalDateTime.of(2018, Month.OCTOBER, 11, 20, 15);
	}
	
	/**
	 * checking if the seat is free or taken
	 * @param row
	 * @param column
	 * @return boolean that signals if the seat is free(true) or taken(false)
	 */
	public boolean checkValidSeat(int row,int column) {
		return this.rows.get(row).checkValidSeat(column);	 
	}
	
	/**
	 * booking the seats in the seats ArrayList
	 * @param seats
	 * @return boolean that signals if the booking was successful
	 */
	public boolean bookSeats(ArrayList<String> seats) {
		for(String seat:seats) {
			String[] seatNumbers = seat.split("/");
			int row = Integer.parseInt(seatNumbers[0]);
			int column = Integer.parseInt(seatNumbers[1]);
			boolean valid = this.rows.get(row).bookSeat(column);
			if(!valid) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * GETTERS & SETTERS
	 */
	public String getName() {
		return this.name;
	}
	
	public LocalDateTime getDate() {
		return this.date;
	}
	
	public double getPrice() {
		return this.price;
	}
	
	public Theatre getTheatre() {
		return this.theatre;
	}
	
	public ArrayList<Row> getRows(){
		return this.rows;
	}
}
