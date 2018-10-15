package cinema;

public class Seat {
	private int seatNum;
	private Boolean isReserved;
	
	public Seat(int seatNum, Boolean isReserved) {
		super();
		this.seatNum=seatNum;
		this.isReserved=isReserved;
	}
	
	public int getSeat() {
		return this.seatNum;
	}
	
	public boolean setReserved() {
		if(this.isReserved.equals(false)) {
			this.isReserved=true;
			return this.isReserved;
		}
		return false;
	}
	
	public Boolean isReserved() {
		return this.isReserved;
	}
	
	
}
