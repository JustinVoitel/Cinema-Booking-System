package cinema;

import java.util.ArrayList;

public class Row {
	private int rowNum;
	private ArrayList<Seat> seats;
	
	public Row(int rowNum, int seatSize) {
		super();
		this.seats = new ArrayList<>();
		this.rowNum=rowNum;
		this.addSeats(seatSize);
	}
	
	public void addSeats(int number) {
		for(int i=0;i<number;i++) {
			this.seats.add(new Seat(i,false));			
		}
	}
	
	public int getRow() {
		return this.rowNum;
	}
	
	public ArrayList<Seat> getSeats(){
		return this.seats;
	}
	
	public boolean checkValidSeat(int column) {
		return this.seats.get(column).isReserved();
	}
	
	public boolean bookSeat(int column) {
		return this.seats.get(column).setReserved();
	}
}
