package cinema;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class Show {
	private String name;
	private Theatre theatre;
	private int price;
	private ArrayList<Row> rows;
	private LocalDateTime date;
	
	public Show(String name, Theatre theatre) {
		super();
		this.name=name;
		this.theatre=theatre;
		this.rows = this.theatre.getRowSchema();
		date = LocalDateTime.of(2018, Month.OCTOBER, 11, 20, 15);
	}
	
	public String getName() {
		return this.name;
	}
	
	public LocalDateTime getDate() {
		return this.date;
	}
	
	public Theatre getTheatre() {
		return this.theatre;
	}
	
	public ArrayList<Row> getRows(){
		return this.rows;
	}
	
	public boolean checkValidSeat(int row,int column) {
		return this.rows.get(row).checkValidSeat(column);	 
	}
	
	public boolean bookSeats(ArrayList<String> seats) {
		for(String seat:seats) {
			String[] seatNumbers = seat.split("/");
			int row = Integer.parseInt(seatNumbers[0]);
			int column = Integer.parseInt(seatNumbers[1]);
			boolean valid = this.bookSeat(row,column);
			if(!valid) {
				return false;
			}
		}
		return true;
	}
	
	public boolean bookSeat(int row,int column) {
		return this.rows.get(row).bookSeat(column);
	}
}
