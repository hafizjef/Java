package exception.blackjack;

/**
 * Define PointExceedException class, subclass of Exception
 * to catch player point that are exceed to 21 and display the
 * exception message
 * @author : Hafiz Jefri
 */

@SuppressWarnings("serial")
public class PointExceedException extends Exception {

	public static String message = "Total points exceeds 21";
	
	public PointExceedException() {
		
		super(message);
	}
	
}
