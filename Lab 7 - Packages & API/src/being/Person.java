/**
 * This class acts as Person superclass for
 * the BlackJack game
 */

package being;
import citizen.Citizenship;

public abstract class Person implements Citizenship {
	/* Class properties definition */
	private double height;
	private double weight;
	protected String location;
	private int yearOfBirth;
	
	public Person() {
		
		height = 1.55;
		weight = 60;
		location = "Melaka";
		yearOfBirth = 1992;
	}
	
	public Person(double height, double weight) {
	
		this.height = height;
		this.weight = weight;
		location = "Melaka";
		yearOfBirth = 1991;
	}
	
	public double getHeight() {
	
		return height;
	}
	
	public void setHeight(double height) {
	
		this.height = height;
	}
	
	public double getWeight() {
	
		return weight;
	}
	
	public void setWeight(double weight) {
	
		this.weight = weight;
	}
	
	public String getLocation() {
	
		return location;
	}
	
	public void setLocation(String location) {
	
		this.location = location;
	}
	
	public int getYearOfBirth() {
	
		return yearOfBirth;
	}
	
	public void setYearOfBirth (int yearOfBirth) {
	
		this.yearOfBirth = yearOfBirth;
	}

	public boolean eligibility(){
		if (location.equalsIgnoreCase("denmark")){
			return true;
		} else if (location.equalsIgnoreCase("algeria")) {
			return true;
		} else if (location.equalsIgnoreCase("france")) {
			return true;
		}
		else {
			return false;
		}
	}

}