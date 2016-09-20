/**
 * This program demonstrate the Validator Exception 
 * @author : Hafiz Jefri
 */

package apps.blackjack;

import exception.blackjack.ValidatorException;
import simplified.blackjack.Player;

public class DemoValidatorException {
	
	public static void main(String[] args) {
		
		Player player1 = new Player("Em1ma McK0ay0-Fi3kri");
		Player player2 = new Player("2N6ik Ahmad");
		Player player3 = new Player("Ahmad Emaliana");
		Player player4 = new Player("Fikri3 Isma9il");
		
		
		Player players[] = {player1, player2, player3, player4};
		
		
		for(int index = 0; index<4; index++) {
			
			try {
				
				players[index].validatename();
			} catch(ValidatorException e) {

				System.out.println(e.getMessage());
				System.out.println("Change from " + players[index].getName() 
						+ " -> " + e.rename());
				System.out.println();
			}
		}
	}
}
