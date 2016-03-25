/**
 * This class demonstrate player objects
 * This class act as player properties.
 * @author: Hafiz Jefri
 **/

import java.util.Calendar;

public class Player{
	
	
	/* Class properties definition */
	private String name;
	private Card[] cardInHand = new Card[3];
	private int totalPoint = 0;
	private Calendar playDate = Calendar.getInstance();

	private int cardNum = 0;
	

	/**
	* Default Player constructor
	* @param name
	*/
	public Player(String name){
		this.name = name;
	}

	/**
	* To set the player name
	* @param name
	*/
	public void setName(String name){
		this.name = name;
	}
	
	/**
	* To get the player name
	* @return name
	*/
	public String getName(){
		return name;
	}
	
	/**
	* To display cards in hand
	*/
	public void displayCardInHand(){
		System.out.print("Cards in hand: ");
		for(int count=0; count < 3; count++){
			System.out.print(cardInHand[count].getFaceValue() + "-" + cardInHand[count].getSymbol() + " ");
		}
		System.out.println("\n\n");
	}
	
	/**
	* To add Cards to player
	* @param card
	*/
	public void hit(Card card){
		this.cardInHand[cardNum] = card;
		cardNum += 1;
	}
	
	/**
	* To calculate total points
	* @param card
	*/
	public void calculateTotalPoint(Card card){
		totalPoint += card.getRealValue();
	}
	
	/**
	* To get total points
	* @return totalPoint
	*/
	public int getTotalPoint(){
		return totalPoint;
	}
	
	/**
	* To get play date
	* @return playDate
	*/
	public Calendar getPlayDate(){
		return playDate;
	}
}