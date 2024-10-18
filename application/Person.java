package application;

import java.util.*;

public  abstract class Person implements Cloneable {
	// attributes of a person class
	private String ID;
	private String Name;
	private int Age;
	private String Gender;
	private String Address;
	private String ContactInfo;
	private String RoleInFamily;
	// constructor to set initial values
	public Person() {
		
	}
	public Person(String ID, String Name, int Age, String Gender, String Address, String ContactInfo,
			String RoleInFamily) {

		setID(ID);
		setName(Name);
		setAge(Age);
		setGender(Gender);
		setAddress(Address);
		setContactInfo(ContactInfo);
		setRoleInFamily(RoleInFamily);
	}
	// getter and setter methods for ID

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		try {
		ID = iD;
		}catch(InputMismatchException e) {
			System.out.println(" Invaild input , please enter vaild ID");
		}
	}
	// getter and setter method for Name

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		try {
		Name = name;
		}catch(InputMismatchException e) {
			System.out.println("Invaild input , please entre valid name");
		}
	}

	// getter and setter method for Age
	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		if ( age > 0) {
			Age = age;

		}else {
			System.out.println(" your input is invaild the age should be  age > 0");
		}
	}

	// getter and setter methods for gender
	public String getGender() {
		return Gender;
	}

	// i do this in this method to get true input from the user
	public void setGender(String gender) {
		if (gender.equalsIgnoreCase("Male")  || gender.equalsIgnoreCase("Female")  ) {
			Gender = gender;
		} else {
			System.out.println(" your input is invaild the Gender should be Male of Female");
		}
	}

	// getter and setter for address
	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		try {
		Address = address;
		}catch(InputMismatchException e) {
			System.out.println("Invalid input , please enter valid address");
			
		}
	}

	// getter and setter for contactinfo
	public String getContactInfo() {
		
		return ContactInfo;
		
	}

	public void setContactInfo(String contactInfo) {
		try {
		ContactInfo = contactInfo;
		} catch(InputMismatchException e ) {
			System.out.println("Invalid input , please enter valid contactinfo");
		}
	}
	// getter and setter for roleinfamily

	public String getRoleInFamily() {
		return RoleInFamily;
	}

	// i do this in this method to get true input from the user
	public void setRoleInFamily(String roleInFamily) {
		if (roleInFamily.equalsIgnoreCase("dad")  || roleInFamily.equalsIgnoreCase("mum")   || roleInFamily.equalsIgnoreCase("son")   || roleInFamily.equalsIgnoreCase("daughter") ) {
			RoleInFamily = roleInFamily;
		} else {
			System.out.println("your input is invaild the RoleInFamily should be dad or mum or son or daughter ");
		}
	}
	  public Object clone() throws CloneNotSupportedException {
			return super.clone();
	  }

	// to String method to representation the person object
	@Override
	public String toString() {
		return "Person [ID=" + ID + ", Name=" + Name + ", Age=" + Age + ", Gender=" + Gender + ", Address=" + Address
				+ ", ContactInfo=" + ContactInfo + ", RoleInFamily=" + RoleInFamily + "]";
	}

}
