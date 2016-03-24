import java.util.Calendar;

class Player{

	private String name;
	private Card[] cardInHand = new Card[3];
	private int totalPoint = 0;
	private Calendar playDate = Calendar.getInstance();

	private int cardNum = 0;
	


	public Player(String name){
		this.name = name;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void displayCardInHand(){
		System.out.print("Cards in hand: ");
		for(int count=0; count < 3; count++){
			System.out.print(cardInHand[count] + " ");
		}
		System.out.println("\n\n");
	}

	public void hit(Card card){
		this.cardInHand[cardNum] = card;
		cardNum += 1;
	}
	
	public void calculateTotalPoint(Card card){
		totalPoint += card.getRealValue();
	}

	public int getTotalPoint(){
		return totalPoint;
	}

	public Calendar getplayDate(){
		return playDate;
	}
}