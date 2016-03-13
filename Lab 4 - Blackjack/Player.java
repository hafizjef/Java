import java.util.Date;

class Player{

	private String name;
	private Card[] cardInHand = new Card[3];
	private int totalPoint = 0;
	private Date playDate = new Date();

	private int cardNum = 0;
	private int playerPos = 0;

	static int playerCount = 0;
	


	public Player(String name){
		this.name = name;
		this.playerCount += 1;
		this.playerPos = playerCount;
	}

	void setName(String name){
		this.name = name;
	}

	int getPlayerPos(){
		return playerPos;
	}

	String getName(){
		return name;
	}

	void displayCardInHand(){
		System.out.print("Cards in hand: ");
		for(int count=0; count < 3; count++){
			System.out.print(cardInHand[count] + " ");
		}
	}

	void hit(Card card){
		this.cardInHand[cardNum] = card;
		totalPoint += card.getRealValue();
		cardNum += 1;
	}

	int getTotalPoint(){
		return totalPoint;
	}

	void getPlayDate(){
		Date playDate = new Date();
		System.out.println(playDate);
	}
}