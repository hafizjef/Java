/**
 * This class demonstrate card object for blackjack game. 
 * This class act as the card properties
 * @author: Hafiz Jefri
 **/

public class Card extends Rectangle{

	/* Class properties definition */
	private char symbol;
	private String faceValue;
	private int realValue;

	/**
	* Default Card constructor
	* @param symbol, faceValue
	*/
	public Card(char symbol, String faceValue){
		this.symbol = symbol;
		this.faceValue = faceValue;
	}

	/**
	* Overloaded Card constructor
	* @param symbol, faceValue, width, length
	*/
	public Card(char symbol, String faceValue, int width, int length){
		super(width, length);
		this.symbol = symbol;
		this.faceValue = faceValue;
	}

	/**
	* To set Card symbol
	* @param symbol
	*/
	public void setSymbol(char symbol){
		this.symbol = symbol;
	}
	
	/**
	* To get Card symbol
	* @return symbol
	*/
	public char getSymbol(){
		return symbol;
	}

	/**
	* To set Card face value
	* @param faceValue
	*/
	public void setFaceValue(String faceValue){
		this.faceValue = faceValue;
	}
	
	/**
	* To get Card face value
	* @return faceValue
	*/
	public String getFaceValue(){
		return faceValue;
	}
	
	/**
	* To get Card real value
	* @return the card real value
	*/
	public int getRealValue(){
		if (faceValue.equalsIgnoreCase("ace")) {
			return 1;
		} else if (faceValue.equalsIgnoreCase("jack")) {
		 	return 10;
		} else if (faceValue.equalsIgnoreCase("queen")) {
		 	return 10; 
		} else if (faceValue.equalsIgnoreCase("king")) {
		 	return 10;
		} else if (faceValue.equalsIgnoreCase("joker")) {
			return 10; 
		} else if (faceValue.equals("2")) {
			return 2;
		} else if (faceValue.equals("3")) {
			return 3;
		} else if (faceValue.equals("4")) {
			return 4;
		} else if (faceValue.equals("5")) {
			return 5;
		} else if (faceValue.equals("6")) {
			return 6;
		} else if (faceValue.equals("7")) {
			return 7;
		} else if (faceValue.equals("8")) {
			return 8;
		} else if (faceValue.equals("9")) {
			return 9;
		} else if (faceValue.equals("10")) {
			return 10;
		} else {
			return 0;
		}	
	}

	/**
	* To draw cards
	* 
	*/
	public void draw(){
		
		System.out.print("\n+");
		
		for (int index = 0; index < getWidth(); index++){
			System.out.print("-");
		}
			
		System.out.println("+");
		System.out.print("|");
		System.out.print(getSymbol());
		
		for (int index = 0; index < (getWidth() - 1); index++){
			System.out.print(" ");
		}
			
		System.out.print("|");
		System.out.println();

		for (int index = 0; index < (getLength() - 2); index++) {
			
			System.out.print("|");
			for (int index2 = 0; index2 < getWidth(); index2++){
				System.out.print(" ");
			}
			System.out.println("|");
		}

		System.out.print("|");
		for (int index = 0; index < (getWidth() - 1); index++){
			System.out.print(" ");
		}
			
		if (faceValue.equalsIgnoreCase("King")){
			System.out.print("K");
		}else if (faceValue.equalsIgnoreCase("Queen")){
			System.out.print("Q");
		}else {
			System.out.print(getFaceValue());
		}
			
		
		System.out.print("|");
		System.out.println();
		System.out.print("+");
		
		for (int index = 0; index < getWidth(); index++){
			System.out.print("-");
		}
		
		System.out.println("+");
	}

	public int calculateArea(){
		return (getLength() * getWidth());
	}
}
