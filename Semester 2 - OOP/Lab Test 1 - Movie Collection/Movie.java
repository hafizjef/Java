public class Movie{
	private int movieId;
	private String title;
	private TicketCollection[] grossCollection = new TicketCollection[5];
	private double totalCollection;
	private double averageCollection;
	private int currentIndex = 0;


	public Movie(int movieId, String title){
		this.movieId = movieId;
		this.title = title;
	}

	public double getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(double totalCollection) {
		this.totalCollection = totalCollection;
	}

	public int getMovieId() {
		return movieId;
	}

	public String getTitle() {
		return title;
	}

	public TicketCollection[] getGrossCollections() {
		return grossCollection;
	}

	public double getAverageCollection() {
		return averageCollection;
	}

	public void setAverageCollection(double averageCollection) {
		this.averageCollection = averageCollection;
	}
	
	public boolean addCollection(TicketCollection inticketCollection){
		grossCollection[currentIndex] = inticketCollection;
		currentIndex++;
		return true;	
	}
	
	public void calculateTotalCollection(double incollection){
		totalCollection = totalCollection + incollection;
	}
	
	public void calculateAverageCollection(){
		averageCollection = totalCollection/5;
	}
	
	public void displayMovieDetails(){
		
		System.out.println("===========================================");
		System.out.println("Movie : " + movieId + " " + title);
		System.out.println("-------------------------------------------");
		System.out.println("Day\tCollection/Day (RM)");
		System.out.println("-------------------------------------------");

		for (int index = 0; index < grossCollection.length; index++) {
			grossCollection[index].displayCollection();
		}

		System.out.println("-------------------------------------------");

		for (int index = 0; index < grossCollection.length; index++) {
			calculateTotalCollection(grossCollection[index].getTotalCollection());
		}

		calculateAverageCollection();

		System.out.println("Total Collection : RM" + totalCollection);
		System.out.println("Average Collection : RM" + averageCollection);
		System.out.println("===========================================");
		
	}
}