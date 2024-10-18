package application;


import java.util.*;

public class Manager {
	private ArrayList<Family> families = new ArrayList<>();

	// getter and setter
	public ArrayList<Family> getFamilies() {
		return families;
	}

	public void setFamilies(ArrayList<Family> families) {
		this.families = families;
	}

	// this method to add family to the system
	public boolean addFamily(Family family) {
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName().equalsIgnoreCase(family.getFamilyName())) {
				return false;
			}

		}

		families.add(family);
		return true;

	}

	// this method to update family in the system
	public boolean updateFamily(String familyName, Family updatedFamily) throws FamilyNotFoundException {
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				families.set(i, updatedFamily);
				return true;

					
				
			}

		}
		throw new FamilyNotFoundException(" family was not found") ;

	}

	// to find family by name
	public Family searchByName(String familyName)  {
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName().equalsIgnoreCase(familyName)) {
				return families.get(i);

			}
			}
		
		return null;

	}

	// to delete family from the system
	public boolean deletFamily(String familyName)  throws FamilyNotFoundException{
		for (int i = 0; i < families.size(); i++) {
			if (families.get(i).getFamilyName() .equalsIgnoreCase(familyName)) {
				families.remove(i);

				return true;
			}
				
			}
		
		throw  new FamilyNotFoundException("family was not found");
	}

	// to find person in the system by the ID
	public Person searchPersonByID(String personID) {
		for (Family family : families) {
			for (Person person : family.getMembers()) {
				if (person.getID().equalsIgnoreCase(personID) ) {
					return person;
				}
			}
		}
		return null;
	}

	// method for display the number of martyr in the system
	public int calaulateTotalMartyrs() {
		int martyrcounter = 0;

		for (Family family : families) {
			for (Person person : family.getMembers()) {
				if (person instanceof Martyr) {
					martyrcounter++;
				}
			}

		}
		return martyrcounter;

	}

	// method for display the number of orphans in the system
	public int calaulateTotalOrphans() {
		int orphansCounter = 0;
		for (Family family : families) {
			boolean mum = true;
			boolean dad = true;
			for (Person person : family.getMembers()) {
				if (person.getRoleInFamily().equalsIgnoreCase("mum")) {
					if (person instanceof Martyr) 
						mum = false;
				}
				if (person.getRoleInFamily().equalsIgnoreCase("dad")) {
					if (person instanceof Martyr) 
							dad = false;
				}
				if (mum == false && dad == false) 
					if(person.getRoleInFamily().equalsIgnoreCase("son") || person.getRoleInFamily().equalsIgnoreCase("daughter")) 
						if(person instanceof LivePerson) 
							orphansCounter++;	
			}
		}
		return orphansCounter;

	}
	// method to display the number of live people in the system
	public int calculateLivePersons() {
		int livePersonsCounter = 0;
		for (Family family : families) {
			for (Person person : family.getMembers()) {
				if (person instanceof LivePerson) {
					livePersonsCounter++;
				}

			}
		}
		return livePersonsCounter;

	}

	// this method to display the statistics ( martyrs , orphans , live person
	// numbers ) for a family in the system
	public ArrayList<Integer> calculateFamilyStatistics(String familyName)  {
		ArrayList<Integer> statistics = new ArrayList<>();
		int familyMartyrs = 0;
		int familyOrphans = 0;
		int familyLivePersons = 0;
		for (Family family : families) {
			if(family.getFamilyName().equalsIgnoreCase(familyName)) {
				boolean mum = true;
				boolean dad = true;
				for (Person person : family.getMembers()) {
					if (person instanceof LivePerson) 
						familyLivePersons++;

					if (person instanceof Martyr) 
						familyMartyrs++;
					
					if (person.getRoleInFamily().equalsIgnoreCase("mum")) 
						if (person instanceof Martyr) 
							mum = false;

					if (person.getRoleInFamily().equalsIgnoreCase("dad") ) 
						if (person instanceof Martyr) 
							dad = false;
						
					
					if(person.getRoleInFamily().equalsIgnoreCase("son") || person.getRoleInFamily().equalsIgnoreCase("daughter")) 
						if (mum == false && dad == false) 
							if(person instanceof LivePerson) 
								familyOrphans++;
				}
			}
		}
		statistics.add(familyMartyrs);
		statistics.add(familyOrphans);
		statistics.add(familyLivePersons);
		return statistics;
	}
		
	
	// this method to display the statistics ( martyrs , orphans , live person
	// numbers ) in all the system

	public ArrayList<Integer> calculateGlobalStatistics() {
		ArrayList<Integer> GlobalStatistics = new ArrayList<>();
		int AllMartyrNumber = 0;
		int AllOrphansNumber = 0;
		int AllLivePersonNumber = 0;
		for (Family family : families) {
			boolean mum = true;
			boolean dad = true;
			for (Person person : family.getMembers()) {
				if (person instanceof Martyr) 
					AllMartyrNumber++;
				
				if (person.getRoleInFamily().equalsIgnoreCase("mum")) 
					if (person instanceof Martyr) 
						mum = false;

				if (person.getRoleInFamily().equalsIgnoreCase("dad")) 
					if (person instanceof Martyr) 
						dad = false;

				if (mum == false && dad == false) 
					if(person.getRoleInFamily().equalsIgnoreCase( "son") || person.getRoleInFamily().equalsIgnoreCase( "daughter")) 
						if(person instanceof LivePerson) 
							AllOrphansNumber++;

				if (person instanceof LivePerson) 
					AllLivePersonNumber++;
			
			}
		}
		GlobalStatistics.add(AllMartyrNumber);
		GlobalStatistics.add(AllOrphansNumber);
		GlobalStatistics.add(AllLivePersonNumber);
		
		return GlobalStatistics;
	}
	// toString method to representation the Manager object

	@Override
	public String toString() {
		return "Manager [families=" + families + ", getFamilies()=" + getFamilies() + ", calaulateTotalMartyrs()="
				+ calaulateTotalMartyrs() + ", calaulateTotalOrphans()=" + calaulateTotalOrphans()
				+ ", calculateLivePersons()=" + calculateLivePersons() + ", calculateGlobalStatistics()="
				+ calculateGlobalStatistics() + "]";
	}
	
}