package application;


import java.util.*;

public class Family implements Sortable, Cloneable {
	

	// attributes of a family class

	private String familyName;
	private ArrayList<Person> members = new ArrayList<>();
	private ArrayList<Person> parents = new ArrayList<>();
	// constructor to set initial values

	public Family(String familyName) {

		this.familyName = familyName;

	}
	// getter and setter for the attributes

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		try {
			this.familyName = familyName;
		} catch (InputMismatchException e) {
			System.out.println(" your input is invalid please try again ");
		}
	}

	public ArrayList<Person> getMembers() {
		return members;
	}

	public void setMembers(ArrayList<Person> members) {
		this.members = members;
	}

	public ArrayList<Person> getParents() {
		return parents;
	}

	public void setParents(ArrayList<Person> parents) {
		this.parents = parents;
	}

	// this method to add member to the system
	public boolean removeMember(Person member) {

		if (member.getRoleInFamily().equalsIgnoreCase("mum") || member.getRoleInFamily().equalsIgnoreCase("dad")) {
			parents.remove(member);
			members.remove(member);
			return true;
		}

		if (member.getRoleInFamily().equalsIgnoreCase("son") || member.getRoleInFamily().equalsIgnoreCase("daughter")) {
			members.remove(member);
			return true;
		}
		return false;

	}

	// this method to remove member to the system
	public boolean addMember(Person member, String roleinfamily) throws ParentsNotFoundException {
		//System.out.println(parents.size());

		if (parents.size() < 2) {
			if (member.getRoleInFamily().equalsIgnoreCase("mum")) {
				for (Person person : parents) {
					if (person.getRoleInFamily().equalsIgnoreCase("mum")) {
						return false;
					}
				}

				{
					parents.add(member);
					members.add(member);

					return true;
				}
			}
			if (member.getRoleInFamily().equalsIgnoreCase("dad")) {
				for (Person person1 : parents) {
					if (person1.getRoleInFamily().equalsIgnoreCase("dad")) {
						return false;
					}
				}

				parents.add(member);
				members.add(member);

				return true;
			}
		}

		if (member.getRoleInFamily().equalsIgnoreCase("son") || member.getRoleInFamily().equalsIgnoreCase("daughter")) {
			if (parents.size() == 2) {

				members.add(member);
				return true;
			} else {
				throw new ParentsNotFoundException("parents not found");

			}
		}

		return false;

	}

	// this method to add parent to the system

	public void addParent(Person parent) {
		if (parents.size() < 2) {
			parents.add(parent);
		} else {
			System.out.println("There are already two parents in this family");
		}
	}

	// this method to remove parent to the system

	public boolean removeParent(Person parent) {
		for (int i = 0; i < parents.size(); i++) {
			if (parents.get(i).getName().equalsIgnoreCase(parent.getName())) {
				parents.remove(parent);
				members.remove(parent);
				return true;
			}
		}
		return false;
	}

	// toString method to representatiom=n the family object
	@Override
	public String toString() {
		return "Family [familyName=" + familyName + ", members=" + members + ", parents=" + parents
				+ ", getFamilyName()=" + getFamilyName() + ", getMembers()=" + getMembers() + ", getParents()="
				+ getParents() + "]";
	}

	// the equals method to compairing between 2 family martyrs number
	@Override
	public boolean equals(Object obj) {
		int counter1 = 0;
		int counter2 = 0;
		for (int i = 0; i < members.size(); i++) {
			if (members.get(i) instanceof Martyr) {
				counter1++;
			}
			}
		for(int i = 0 ; i < ((Family) obj).getMembers().size() ; i ++) {
			if (((Family) obj).members.get(i) instanceof Martyr) {
				counter2++;
			}
		}
		return counter1 == counter2;

	}
// i do this method to get the number of the martyrs in the family
	public int familyMartyrsNumber(Family family) {
		int counter = 0;
		for (Person person : family.getMembers()) {
			if (person instanceof Martyr) {
				counter++;
			}

		}
		return counter;
	}
// i do this method to get the number of the orphans in the family
	public int familyOrphansNumber(Family family) {
		int counter = 0;
		boolean dad = true;
		boolean mum = true;
		for (Person person : family.getMembers()) {
			if (person.getRoleInFamily().equalsIgnoreCase("mum")) 
				if (person instanceof Martyr) 
					mum = false;

			if (person.getRoleInFamily().equalsIgnoreCase("dad") ) 
				if (person instanceof Martyr) 
					dad = false;
				
			
			if(person.getRoleInFamily().equalsIgnoreCase("son") || person.getRoleInFamily().equalsIgnoreCase("daughter")) 
				if (mum == false && dad == false) 
					if(person instanceof LivePerson) 
						counter++;
		}
			return counter;
	}
// the method will return a arraylist of families sorted based on martyrs number
	public ArrayList<Family> sortByMartyrs(ArrayList<Family> families) {
		ArrayList<Family> CoppyArray = new ArrayList<Family>();
		for (int i = 0; i < families.size(); i++) {
			CoppyArray.add(families.get(i));
		}
		for (int i = 0; i < CoppyArray.size() - 1; i++) {
			for (int j = 0; j < CoppyArray.size() - i; j++) {
				if (j == CoppyArray.size() - 1) {
					break;
				}

				if (familyMartyrsNumber(CoppyArray.get(j)) < familyMartyrsNumber(CoppyArray.get(j + 1))) {
					Family temp = CoppyArray.get(j);
					CoppyArray.set(j, CoppyArray.get(j + 1));
					CoppyArray.set(j + 1, temp);
				}
			}

		}

		return CoppyArray;

	}
	// the method will return a arraylist of families sorted based on orphans number

	public ArrayList<Family> sortByOrphans(ArrayList<Family> families) {
		ArrayList<Family> CoppyArray = new ArrayList<Family>();
		for (int i = 0; i < families.size(); i++) {
			CoppyArray.add(families.get(i));
		}
		for (int i = 0; i < CoppyArray.size() - 1; i++) {
			for (int j = 0; j < CoppyArray.size() - i; j++) {
				if (j == CoppyArray.size() - 1) {
					break;
				}

				if (familyOrphansNumber(CoppyArray.get(j)) < familyOrphansNumber(CoppyArray.get(j + 1))) {
					Family temp = CoppyArray.get(j);
					CoppyArray.set(j, CoppyArray.get(j + 1));
					CoppyArray.set(j + 1, temp);
				}
			}

		}
		return CoppyArray;

	}

	@Override
	// the clone method
	public Object clone() throws CloneNotSupportedException {

		Family clonedFamily = (Family) super.clone();

		clonedFamily.members = new ArrayList<>();
		clonedFamily.parents = new ArrayList<>();

		for (int i = 0; i < members.size(); i++) {
			clonedFamily.members.add((Person) members.get(i).clone());
		}

		for (Person person : parents) {
			clonedFamily.parents.add((Person) person.clone());
		}

		return clonedFamily;
	}

}
