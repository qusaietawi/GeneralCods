package application;

import java.util.*;

// the Martyr class is inherited from the Person class
public class Martyr extends Person implements Cloneable {
	// attributes of a martyr class

	private String DateOfMartyrdom;
	private String CauseOfDeath;
	private String PlaceOfDeath;
	// constructor to set initial values
	public Martyr( String name , String DateOfMartyrdom) {
		this.setName(name);
		setDateOfMartyrdom(DateOfMartyrdom);

	}
	public Martyr( String ID, String Name, int Age,
			String Gender, String Address, String ContactInfo, String RoleInFamily) {
		super(ID, Name, Age, Gender, Address, ContactInfo, RoleInFamily);
		

	}

	// getter and setter for dateofmartyrdom
	public String getDateOfMartyrdom() {
		return DateOfMartyrdom;
	}

	public void setDateOfMartyrdom(String dateOfMartyrdom) throws InputMismatchException {
		 int x = Integer. parseInt(dateOfMartyrdom);
		
		if (x > 0) {
		DateOfMartyrdom = dateOfMartyrdom;
		}
		throw new InputMismatchException ("the date cant be negative");
	}

	// getter and setter for causeofdeath
	public String getCauseOfDeath() {
		return CauseOfDeath;
	}

	public void setCauseOfDeath(String causeOfDeath) {
		try {
		CauseOfDeath = causeOfDeath;
		}catch(InputMismatchException e ) {
			System.out.println("Invalid input , please enter valid causeOfDeath ");
		}
	}

	// getter and setter for placeofdeath
	public String getPlaceOfDeath() {
		return PlaceOfDeath;
	}

	public void setPlaceOfDeath(String placeOfDeath) {
		try {
		PlaceOfDeath = placeOfDeath;
		}catch(InputMismatchException e ) {
			System.out.println("Invalid input , please enter valid placeOfDeath");
		}
	}
	@Override
    public Object clone() throws CloneNotSupportedException {
		return super.clone();
		
	}

	// toString method to representation the martyr object
	@Override
	public String toString() {
		return "Martyr [DateOfMartyrdom=" + DateOfMartyrdom + ", CauseOfDeath=" + CauseOfDeath + ", PlaceOfDeath="
				+ PlaceOfDeath + ", getDateOfMartyrdom()=" + getDateOfMartyrdom() + ", getCauseOfDeath()="
				+ getCauseOfDeath() + ", getPlaceOfDeath()=" + getPlaceOfDeath() + ", getID()=" + getID()
				+ ", getName()=" + getName() + ", getAge()=" + getAge() + ", getGender()=" + getGender()
				+ ", getAddress()=" + getAddress() + ", getContactInfo()=" + getContactInfo() + ", getRoleInFamily()="
				+ getRoleInFamily() + ", toString()=" + super.toString();
	}

}