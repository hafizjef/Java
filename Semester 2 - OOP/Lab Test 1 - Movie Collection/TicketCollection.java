public class TicketCollection{
	private String day;
	private double totalCollection;

	public TicketCollection(String day, double totalCollection){
		this.day = day;
		this.totalCollection = totalCollection;
	}

	public String getDay(){
		return this.day;
	}

	public double getTotalCollection(){
		return this.totalCollection;
	}

	public void displayCollection(){
		// Display ticket collection incl. day & total collection
		System.out.println(day + "\t" + totalCollection);
	}
}