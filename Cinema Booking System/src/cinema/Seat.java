package cinema;

public class Seat {
	private int seatNum;
	private Boolean isReserved;
	
	public Seat(int seatNum, Boolean isReserved) {
		super();
		this.seatNum=seatNum;
		this.isReserved=isReserved;
	}
	
	/**
	 * sets the seat to the status reserved
	 * @return
	 */
	public boolean setReserved() {
		if(this.isReserved.equals(false)) {
			this.isReserved=true;
			return this.isReserved;
		}
		return false;
	}
	
	/**
	 * checks if the seat is already taken 
	 */
	public Boolean isReserved() {
		return this.isReserved;
	}
	
	/**
	 * GETTER
	 */
	public int getSeat() {
		return this.seatNum;
	}
}
