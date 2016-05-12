/**
 * This class demonstrate player objects
 * This class act as player properties.
 * @author: Hafiz Jefri
 **/

package simplified.blackjack;

import java.util.Calendar;
import being.Person;

public class Player extends Person{
	
	
	/* Class properties definition */
	private String name;
	private Card[] cardInHand = new Card[3];
	private int totalPoint = 0;
	private Calendar playDate = Calendar.getInstance();

	private int cardNum = 0;
	
	private static int noOfPlayers = 0;

	private int noOfVowel = 0;
	private int noOfSpace = 0;
	private int noOfNonVowel = 0;
	private int lengthOfName = 0;

	/**
	* Default Player constructor
	* @param name
	*/
	public Player(String name){
		this.name = name;
		
		noOfPlayers++;
	}

	/**
	* Overloaded constructor
	* @param name, height, weight
	*/
	public Player(String name, double height, double weight){
		super(height, weight);
		this.name = name;
		
		noOfPlayers++;
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
	 * Get Number of players
	 */
	public static int getNoOfPlayers() {	
		return noOfPlayers;
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
	
	
public void calculateAlphabet() {
		
		String playerName = getName();
		lengthOfName = playerName.length();
		
		for (int index = 0; index < playerName.length(); index++) {
			if ((playerName.charAt(index)) == 'a') {
					noOfVowel++;
					
				}	else if ((playerName.charAt(index)) == 'A') { 

					noOfVowel++;
					
				}	else if ((playerName.charAt(index)) == 'e') { 
					
					noOfVowel++;
					
				}	else if ((playerName.charAt(index)) == 'E') { 
					
					noOfVowel++;
				
				}	else if ((playerName.charAt(index)) == 'i') { 
					
					noOfVowel++;
				
				}	else if ((playerName.charAt(index)) == 'I') { 
					
					noOfVowel++;
				
				}	else if ((playerName.charAt(index)) == 'o') { 
					
					noOfVowel++;
					
				}	else if ((playerName.charAt(index)) == 'O') { 
					
					noOfVowel++;
				
				}	else if ((playerName.charAt(index)) == 'u') { 
					
					noOfVowel++;
				
				}	else if ((playerName.charAt(index)) == 'U') { 
					
					noOfVowel++;
				
				}	else if ((playerName.charAt(index)) == ' ') { 
					
					noOfSpace++;
				
				}	else {
					
					noOfNonVowel++;
			
				}
		}
	}

	public int getNoOfVowel() {
		return noOfVowel;
	}

	public int getNoOfNonVowel() {
		return noOfNonVowel;
	}

	public int getNoOfSpace() {
		return noOfSpace;
	}

	public int lengthOfName() {
		return lengthOfName;
	}

	public void displayAlphabetCounts() {
		System.out.println("\tAlphabets Count : # Vowels - " + getNoOfVowel() + ", # Non-vowels - " + getNoOfNonVowel() + ", # Spaces - " + getNoOfSpace() + " and Length : " +lengthOfName());
	}
}