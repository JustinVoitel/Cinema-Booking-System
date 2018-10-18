package cinema;

import java.util.ArrayList;

public class Theatre {
	private String name;
	private ArrayList<Show> shows;
	private ArrayList<Row> rowSchema;
	
	public Theatre(String name,String firstMovie,int rowSize) {
		super();
		this.shows = new ArrayList<>();
		this.rowSchema = new ArrayList<>();
		this.name=name;
		this.addRows(rowSize);
		this.addShow(firstMovie);
		
	}
	
	/**
	 * adds a show to the theatre
	 * @param name
	 */
	public void addShow(String name) {
		this.shows.add(new Show(name, this, 14.5));
	}	
	
	public void addRows(int number) {
		for(int i=0;i<number;i++) {
			this.rowSchema.add(new Row(i,5));
		}
	}
	
	/**
	 * GETTERS & SETTERS
	 */
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Show> getShows() {
		return this.shows;
	}
	
	public ArrayList<Row> getRowSchema(){
		return this.rowSchema;
	}
	
}
