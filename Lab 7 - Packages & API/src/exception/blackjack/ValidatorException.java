package exception.blackjack;

/**
 * Class ValidatorException class, subclass of Exception
 * this is class is used to remove any int in player names
 * @author : Hafiz Jefri
 */

@SuppressWarnings("serial")
public class ValidatorException extends Exception {
	
	private String message = "Invalid name validation is thrown";
	private StringBuffer name;
	
	public ValidatorException(String name) {
		
		super(name);
		this.name=new StringBuffer(name);	
	}
	
	public StringBuffer rename() {
		
		StringBuffer remove = new StringBuffer(name);

		for(int index = 0; index<remove.length(); index++) {
			if(remove.charAt(index)== '1' ||remove.charAt(index)== '2' 
				|| remove.charAt(index)== '3' || remove.charAt(index)== '4' 
				|| remove.charAt(index)== '5' || remove.charAt(index)== '6' 
				|| remove.charAt(index)== '7' || remove.charAt(index)== '8' 
				|| remove.charAt(index)== '9' || remove.charAt(index)== '0') {
					
				remove = remove.deleteCharAt(index);
			}
		}
		
		return remove;
	}
	
	public String getMessage() {
		
		return message;
	}
	
}
