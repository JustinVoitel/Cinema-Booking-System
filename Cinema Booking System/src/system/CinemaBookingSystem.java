package system;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import cinema.Cinema;
import cinema.Row;
import cinema.Seat;
import cinema.Show;

public class CinemaBookingSystem {
	//test user
	private static Customer user = new Customer("Justin","0949234799");
	//test cinema
	private static Cinema cinema = new Cinema("CineStar",5);
	//formatter for date
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm MM-dd");
	private static int state;
	private static boolean active =true;
	public static void main(String[] args) {
		Scanner stateSelect = new Scanner(System.in);
		Scanner showSelect = new Scanner(System.in);
		//check if user is logged in
		if(user.isLogged()) {
			//print helper at the beginning
			printHelp();
			do {
				//change state if number is written in input
				state = stateSelect.nextInt();
				if(state==0) {
					printHelp();
				}
				if(state==1) {
					printAllShows();
					String showName = showSelect.nextLine();
					printShow(cinema.getShow(showName));
				}
			}while(active);
		}else {
			System.out.println("Please Log In!");
		}
	}
	
	public static void printShow(Show show) {
		System.out.println("------------");
		System.out.println("Show Details");
		System.out.println("------------");
		System.out.println("Name: "+ show.getName());
		System.out.println("Date: "+ show.getDate().format(formatter));
		System.out.println("Theatre: "+ show.getTheatre().getName());
		System.out.println("Seats:");
		printSeats(show);
		selectSeats(show);
	}
	
	public static void selectSeats(Show show) {
		ArrayList <String> seats = new ArrayList<>();
		Scanner rowSelect = new Scanner(System.in);
		Scanner colSelect = new Scanner(System.in);
		Scanner quitSelect = new Scanner(System.in);
		boolean bookingActive = true;
		
		do {
			System.out.println("Enter number of Row:");
			int row = rowSelect.nextInt();
			System.out.println("Enter number of Column:");
			int column = colSelect.nextInt();
			if(show.checkValidSeat(row,column)) {
				System.out.println("Seat is already taken! please choose a free one!");
			}else {
				String seatNumber = row+("/")+column;
				if(seats.contains(seatNumber)) {
					System.out.println("You already added this seat! please choose a different one!");
				}else {
					System.out.println("Your seat is free!");
					seats.add(seatNumber);
				}
			}
			System.out.println("Continue Booking? Enter yes if so, or anything else to continue with checkout!");
			String quit = quitSelect.nextLine();
			if(!quit.toLowerCase().trim().equals("yes")) {
				bookingActive = false;
			}
			
		}while(bookingActive);
		checkout(show, seats, user);
	}
	
	public static void checkout(Show show, ArrayList<String> seats, Customer user) {
		Scanner paymentSelect = new Scanner(System.in);
		System.out.println("-------------------------");
		System.out.println("--------CHECKOUT---------");
		System.out.println("-------------------------");
		
		System.out.println("Name: "+ show.getName());
		System.out.println("Date: "+ show.getDate().format(formatter));
		System.out.println("Theatre: "+ show.getTheatre().getName());
		System.out.println("Seats:");
		for(String seat: seats) {
			System.out.println(seat);
		}
		System.out.println("Enter YES to pay with paypal, or anything else to quit!");
		String payment = paymentSelect.nextLine();
		if(!payment.equals("YES")) {
			active=false;
		}else {
			new Booking(show, seats, user);
			state=0;
		}
	}
	
	public static void printSeats(Show show) {
		int rowSize=show.getRows().size();
		int rowNum = 0;
		String colNum="";
		for(int i=0;i<rowSize;i++) {
			colNum += i+"\t";
		}
		System.out.println(colNum+"\n");
		for(Row row: show.getRows()) {
			String currentRow ="";
			for(Seat seat: row.getSeats()) {
				if(!seat.isReserved()) {
					currentRow += "+\t";
				}else {
					currentRow +="-\t";
				}
			}
			System.out.println(currentRow+rowNum);
			rowNum++;
		}
		
		System.out.println("\n________________SCREEN________________");
	}
	
	public static void printAllShows() {
		System.out.println("-------------------------");
		System.out.println("Option 1: Show Booking...");
		System.out.println("-------------------------");
		for(Show show: cinema.getAllShows()) {
			System.out.println("Enter "+show.getName()+": ->"+show.getDate().format(formatter));
		}
		System.out.println("Enter Option:");
		
	}
	
	public static void printHelp() {
		System.out.println("-------------------------");
		System.out.println("Welcome, "+user.getName()+ " to the Cinema Booking System!");
		System.out.println("Enter 1: to Book a Show!");
		System.out.println("Enter 2: to quit");
		System.out.println("-------------------------");
		System.out.println("Enter Option:");
	}
}
