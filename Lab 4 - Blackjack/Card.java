class Card{
	private char symbol;
	private String faceValue;
	private int realValue;

	public Card(char symbol, String faceValue){
		this.symbol = symbol;
		this.faceValue = faceValue;
	}

	@Override
	public String toString(){
		String card = faceValue + "-" + symbol;
		return card;
	}

	void setSymbol(char symbol){
		this.symbol = symbol;
	}

	char getSymbol(){
		return symbol;
	}

	void setFaceValue(String faceValue){
		this.faceValue = faceValue;
	}

	String getFaceValue(){
		return faceValue;
	}

	int getRealValue(){
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
}
