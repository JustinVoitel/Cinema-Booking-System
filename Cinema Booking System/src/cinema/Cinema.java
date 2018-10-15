package cinema;

import java.util.ArrayList;

public class Cinema {
	private String name;
	private int theatreNum;
	private ArrayList<Theatre> theatres;
	public Cinema(String name, int theatres) {
		super();
		this.theatres=new ArrayList<>();
		this.name = name;
		this.theatreNum = theatres;
		this.createTheatres();
	}
	
	public void createTheatres() {
		for(int i=0;i<this.theatreNum;i++) {
			this.theatres.add(new Theatre("Theatre "+i,"Movie "+i,5));
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Show> getAllShows() {
		ArrayList<Show> allShows = new ArrayList<>();
		for(Theatre theatre:theatres) {
			allShows.addAll(theatre.getShows());
		}
		return allShows;
	}
	
	public Show getShow(String input) {
		String showName = input.toLowerCase().trim().replaceAll("\\s","");
		for(Theatre theatre:theatres) {
			for(Show show:theatre.getShows()) {
				if(show.getName().toLowerCase().trim().replaceAll("\\s","").equals(showName)) {
					System.out.println("input: "+showName);

					System.out.println("getShow: "+show.getName().toLowerCase().trim());
					return show;
				}
			}
		}
		return null;
	}
}
