package application;

//the LivePerson class is inherited from the Person class

public class LivePerson extends Person implements Cloneable {
	// constructor to set initial values

	public LivePerson(String ID, String Name, int Age, String Gender, String Address, String ContactInfo,
			String RoleInFamily) {
		super(ID, Name, Age, Gender, Address, ContactInfo, RoleInFamily);
	}
	@Override
  public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
//toString method to representation the LivePerson object

	@Override
	public String toString() {
		return "LivePerson [getID()=" + getID() + ", getName()=" + getName() + ", getAge()=" + getAge()
				+ ", getGender()=" + getGender() + ", getAddress()=" + getAddress() + ", getContactInfo()="
				+ getContactInfo() + ", getRoleInFamily()=" + getRoleInFamily() + ", toString()=" + super.toString();

	}

}
