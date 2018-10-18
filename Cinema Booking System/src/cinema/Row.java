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
	
	/**
	 * adds a Seat to this row
	 * @param number of seats
	 */
	public void addSeats(int number) {
		for(int i=0;i<number;i++) {
			this.seats.add(new Seat(i,false));			
		}
	}
	
	/**
	 * checking a seat if it is free or taken
	 * @param column
	 * @return boolean 
	 */
	public boolean checkValidSeat(int column) {
		return this.seats.get(column).isReserved();
	}
	
	/**
	 * book a certain seat in that row
	 * @param column
	 * @return
	 */
	public boolean bookSeat(int column) {
		return this.seats.get(column).setReserved();
	}
	
	/**
	 * GETTERS
	 */
	public int getRow() {
		return this.rowNum;
	}
	
	public ArrayList<Seat> getSeats(){
		return this.seats;
	}
}
