public class MovieApps{


	public static void main(String[] args){


		Movie movie1 = new Movie(1001, "Dead Poets Society");

		TicketCollection movie1Sat = new TicketCollection("Sat", 13501.00);
		TicketCollection movie1Sun = new TicketCollection("Sun", 24956.00);
		TicketCollection movie1Mon = new TicketCollection("Mon", 4612.00);
		TicketCollection movie1Tue = new TicketCollection("Tue", 3601.00);
		TicketCollection movie1Wed = new TicketCollection("Wed", 10478.00);
		
		movie1.addCollection(movie1Sat);
		movie1.addCollection(movie1Sun);
		movie1.addCollection(movie1Mon);
		movie1.addCollection(movie1Tue);
		movie1.addCollection(movie1Wed);


		
		Movie movie2 = new Movie(1002, "The Last Of Mohicans");

		TicketCollection movie2Sat = new TicketCollection("Sat", 41574.00);
		TicketCollection movie2Sun = new TicketCollection("Sun", 175633.00);
		TicketCollection movie2Mon = new TicketCollection("Mon", 8900.00);
		TicketCollection movie2Tue = new TicketCollection("Tue", 6514.00);
		TicketCollection movie2Wed = new TicketCollection("Wed", 6588.00);

		movie2.addCollection(movie2Sat);
		movie2.addCollection(movie2Sun);
		movie2.addCollection(movie2Mon);
		movie2.addCollection(movie2Tue);
		movie2.addCollection(movie2Wed);



		Movie movie3 = new Movie(1003,"Good Will Hunting");

		TicketCollection movie3Sat = new TicketCollection("Sat", 89456.00);
		TicketCollection movie3Sun = new TicketCollection("Sun", 1755896.00);
		TicketCollection movie3Mon = new TicketCollection("Mon", 54122.00);
		TicketCollection movie3Tue = new TicketCollection("Tue", 12336.00);
		TicketCollection movie3Wed = new TicketCollection("Wed", 7844.00);

		movie3.addCollection(movie3Sat);
		movie3.addCollection(movie3Sun);
		movie3.addCollection(movie3Mon);
		movie3.addCollection(movie3Tue);
		movie3.addCollection(movie3Wed);



		// Display Info
		movie1.displayMovieDetails();
		movie2.displayMovieDetails();
		movie3.displayMovieDetails();
		
		System.out.println("\nSummary Collection of 3 movies for 5 days");
		System.out.println("-------------------------------------------");
		double totalCollection = 0;

		totalCollection = movie1.getTotalCollection() + movie2.getTotalCollection() + 
		movie3.getTotalCollection();
 
		System.out.println("Total collections : RM" + totalCollection);
		System.out.println("Total collections : RM" + totalCollection/3);
		
		
		System.out.println("\nDeveloped by Hafiz Naqiuddin Bin Jefri B031510393");
	}
}