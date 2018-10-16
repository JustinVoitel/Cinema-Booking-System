package cinema;

import java.util.ArrayList;

public class Cinema {
	private String name;
	private int theatreNum;
	private ArrayList<String> movies = new ArrayList<>();
	private ArrayList<Theatre> theatres;
	public Cinema(String name, int theatres) {
		super();
		this.theatres=new ArrayList<>();
		this.name = name;
		this.addMovies();
		this.theatreNum = theatres;
		this.createTheatres();
	}
	
	public void createTheatres() {
		for(int i=0;i<this.theatreNum;i++) {
			this.theatres.add(new Theatre("Theatre "+i,this.movies.get(i),5));
		}
	}
	
	public void addMovies() {
		this.movies.add("Venom");
		this.movies.add("Jonny English");
		this.movies.add("Small Foot");
		this.movies.add("Abgeschnitten");
		this.movies.add("Die Unglaublichen 2");
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
