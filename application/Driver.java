package application;


import java.io.*;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		Manager manager = new Manager();
		Scanner input = new Scanner(System.in);
		int choice = 0;
		boolean boolean1 = true;
		boolean boolean2 = true;
		// the file
		File file = new File("file.txt");
		try {
			// the user choose if file or console
			System.out.print("Please Choose the input source : 1.Console , 2.Text File :");
			choice = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("please enter invaild choice");
		}
		if (choice == 1) {
			int option = 0;
			do {
				// display the menu for the user
				System.out.println();
				System.out.println(
						"------------------------------------------------------------------------------------------------------------");
				System.out.println("1.To add a new family");
				System.out.println("2.Add parents to a family");
				System.out.println("3.Add a family members");
				System.out.println("4.To remove Member ");
				System.out.println("5.To search for a person by ID");
				System.out.println("6.To delet family");
				System.out.println("7.To update a family");
				System.out.println("8.To compare the number of Martyrs between two families");
				System.out.println("9.To calaulateTotalMartyrs");
				System.out.println("10.TocalaulateTotalOrphans");
				System.out.println("11.To calculateLivePersons");
				System.out.println("12.To calculate family statistics");
				System.out.println("13.To calculate global statistics");
				System.out.println(
						"14.To Print to the file all families with their members in sorted order based in Martyr number");
				System.out.println(
						"15.To Print to the file all families with their members in sorted order based in Orphans number");
				System.out.println("16.To Copy an object of type Martyr");
				System.out.println("17.To Copy an object of type Family");
				System.out.println("18.To  Copy an object of type LivePerson ");
				System.out.println("19.Exit");
				try {
					System.out.print(" please enter your option :");
					option = input.nextInt();
				} catch (InputMismatchException e) {
					System.out.println(" please enter vaild option");
				}
				switch (option) {
				// this case to creat new family
				case 1:
					System.out.print("please enter the family name :");
					String familyName = input.next();
					Family family = new Family(familyName);
					manager.addFamily(family);
					System.out.println("you  have created new family named :" + familyName);
					break;
				// to add member to the family
				case 2:
					try {
						System.out.print("please enter the family name : ");
						String familyName1 = input.next();
						if ((manager.searchByName(familyName1) == null)) {
							System.out.println("the family was not found");
						} else {
							// System.out.println(" the parents is Martyr or LivePerson");
							System.out.print("please enter the parent  ID :");
							String id = input.next();
							System.out.print("please enter the parent  Name :");
							String name = input.next();
							System.out.print("please enter the parent Age :");
							int age = input.nextInt();
							System.out.print("please enter the parent Gender : ");
							String gender = input.next();
							System.out.print("please enter the parent  Address :");
							String address = input.next();
							System.out.print("please enter the parent  ContactInfo :");
							String contactInfo = input.next();
							System.out.print("please enter the parent  RoleInFamily :");
							String roleInFamily = input.next();
							LivePerson parent = new LivePerson(id, name, age, gender, address, contactInfo,
									roleInFamily);
							manager.searchByName(familyName1).addMember(parent, roleInFamily);
						}
					} catch (ParentsNotFoundException e) {
						System.out.println("parent is not found1");
					}
					break;
				// add parents to the family
				case 3:
					int n = 0;
					System.out.print("please enter the family name :");
					String familyName2 = input.next();

					if ((manager.searchByName(familyName2) == null)) {
						System.out.println("the family was not found");
					} else {
						try {
							System.out.print("select 1 if the member is Marter  , 2 if The member is LivePerson :");
							n = input.nextInt();
						} catch (InputMismatchException e) {
							System.out.println(" please enter 1 or 2");
						}
						if (n == 2) {
							try {
								System.out.print("please enter the member  ID :");
								String id1 = input.next();
								System.out.print("please enter the member  Name :");
								String name1 = input.next();
								System.out.print("please enter the member Age :");
								int age1 = input.nextInt();
								System.out.print("please enter the member Gender :");
								String gender1 = input.next();
								System.out.print("please enter the member  Address :");
								String address1 = input.next();
								System.out.print("please enter the member  ContactInfo :");
								String contactInfo1 = input.next();
								System.out.print("please enter the member  RoleInFamily :");
								String roleInFamily1 = input.next();
								LivePerson member = new LivePerson(id1, name1, age1, gender1, address1, contactInfo1,
										roleInFamily1);
								System.out.println(manager.searchByName(familyName2).addMember(member, roleInFamily1));
							} catch (ParentsNotFoundException e) {
								System.out.println(" parents is not found ");
							}
						}

						if (n == 1) {
							try {
								System.out.print("please enter the member  ID :");
								String id1 = input.next();
								System.out.print("please enter the member  Name :");
								String name1 = input.next();
								System.out.print("please enter the member Age :");
								int age1 = input.nextInt();
								System.out.print("please enter the member Gender :");
								String gender1 = input.next();
								System.out.print("please enter the member  Address :");
								String address1 = input.next();
								System.out.print("please enter the member  ContactInfo :");
								String contactInfo1 = input.next();
								System.out.print("please enter the member  RoleInFamily :");
								String roleInFamily1 = input.next();
								Martyr member = new Martyr(id1, name1, age1, gender1, address1, contactInfo1,
										roleInFamily1);
								System.out.println(manager.searchByName(familyName2).addMember(member, roleInFamily1));
							} catch (ParentsNotFoundException e) {
								System.out.println(" the parents is not found ");
							}
						}
					}
					break;
				case 4:// remove member
					System.out.print("please enter the member family name :");
					String familyname4 = input.next();
					if (manager.searchByName(familyname4) == null) {
						System.out.println(" the family was not found");
					} else {
						System.out.print("please enter the member  ID :");
						String id1 = input.next();
						System.out.print("please enter the member  Name :");
						String name1 = input.next();
						System.out.print("please enter the member Age :");
						int age1 = input.nextInt();
						System.out.print("please enter the member Gender :");
						String gender1 = input.next();
						System.out.print("please enter the member  Address :");
						String address1 = input.next();
						System.out.print("please enter the member  ContactInfo :");
						String contactInfo1 = input.next();
						System.out.print("please enter the member  RoleInFamily :");
						String roleInFamily1 = input.next();
						LivePerson person = new LivePerson(id1, name1, age1, gender1, address1, contactInfo1,
								roleInFamily1);
						System.out.println(manager.searchByName(familyname4).removeMember(person));
					}
					break;
				case 5:// fine member by id
					System.out.print("please enter the person ID :");
					String Id = input.next();
					if (manager.searchPersonByID(Id) == null) {
						System.out.println(" this person is not found in the system");
					} else {
						System.out.println(manager.searchPersonByID(Id));
					}
					break;
				case 6:
					// delet family
					try {
						System.out.print("please enter the family name :");
						String familyname5 = input.next();
						if (manager.searchByName(familyname5) == null) {
							System.out.println(" this family is not in the system");
						} else {
							System.out.println(manager.deletFamily(familyname5));
						}
					} catch (FamilyNotFoundException e) {
						System.out.println("family was not found ");
					}
					break;
				case 7:// update family
					try {
						System.out.print("please enter the family name that you want to update it :");
						String q = input.next();
						if (manager.searchByName(q) == null) {
							System.out.println(" this family is not found ");
						} else {
							manager.deletFamily(q);
							System.out.println("please enter the new name for the family");
							String moon = input.next();
							Family family2004 = new Family(moon);
							manager.addFamily(family2004);
							System.out.print("please enter the number of the member in the family to add them :");
							int v = input.nextInt();
							for (int i = 0; i < v; i++) {
								System.out.print("please enter the member  ID :");
								String id1 = input.next();
								System.out.print("please enter the member  Name :");
								String name1 = input.next();
								System.out.print("please enter the member Age :");
								int age1 = input.nextInt();
								System.out.print("please enter the member Gender :");
								String gender1 = input.next();
								System.out.print("please enter the member  Address :");
								String address1 = input.next();
								System.out.print("please enter the member  ContactInfo :");
								String contactInfo1 = input.next();
								System.out.print("please enter the member  RoleInFamily :");
								String roleinfamily = input.next();
								try {
									System.out.print("the member is livePerson or martyr :");
									{
										String h = input.next();
										if (h.equalsIgnoreCase("livePerson")) {
											LivePerson person = new LivePerson(id1, name1, age1, gender1, address1,
													contactInfo1, roleinfamily);
											family2004.addMember(person, roleinfamily);

										} else if (h.equalsIgnoreCase("martyr")) {
											Martyr person = new Martyr(id1, name1, age1, gender1, address1,
													contactInfo1, roleinfamily);
											family2004.addMember(person, roleinfamily);

										} else {
											System.out.println(" enter liveperson or martyr");
										}

									}
								} catch (InputMismatchException e) {
									System.out.println(" the inout is invaild please enter vaild input");
								}

							}
						}
					} catch (FamilyNotFoundException e) {
						System.out.println(" family was not found");
					} catch (ParentsNotFoundException e) {
						System.out.println(" the parents is not found");
					}
					break;
				case 8:// compare the number of Martyrs between two families
					System.out.print("please enter the the first family name :");
					String first = input.next();
					System.out.print("please enter the second family name :");
					String second = input.next();
					if (manager.searchByName(first) == null || manager.searchByName(second) == null) {
						System.out.println(" one of the two families is not found of both");
					}
					System.out.println(manager.searchByName(first).equals(manager.searchByName(second)));
					break;

				case 9:// the number of the maretyrs in the system
					System.out.println(manager.calaulateTotalMartyrs());
					break;
				case 10:// the number of the orphans in the system
					System.out.println(manager.calaulateTotalOrphans());
					break;
				case 11:// the number of the livepersson
					System.out.println(manager.calculateLivePersons());
					break;
				case 12:
					// to get a family statistics
					System.out.print("please enter the family name :");
					String familyname7 = input.next();
					if (manager.searchByName(familyname7) == null) {
						System.out.println(" this family is not found ");
					}
					System.out.println(manager.calculateFamilyStatistics(familyname7));

					break;
				case 13:
					// to get the global statistics
					System.out.println(manager.calculateGlobalStatistics());
					break;
				// print the families in the file oreder be martyrs number
				case 14:
					try (PrintWriter printWriter = new PrintWriter(file)) {
						Family family8 = new Family("family");
						ArrayList<Family> arraylist = family8.sortByMartyrs(manager.getFamilies());
						for (Family family99 : arraylist) {
							printWriter.println(family99.getFamilyName() + ": number of martyrs ("
									+ family8.familyMartyrsNumber(family99) + ")");
							printWriter.println("...............................");
							for (Person person99 : family99.getMembers()) {
								if (person99.getRoleInFamily().equalsIgnoreCase("dad")) {
									printWriter.println("ParentDad: " + person99.getName());
								} else if (person99.getRoleInFamily().equalsIgnoreCase("mum")) {
									printWriter.println("ParentMum: " + person99.getName());
								} else if (person99.getRoleInFamily().equalsIgnoreCase("son")
										|| person99.getRoleInFamily().equalsIgnoreCase("daughter")) {
									printWriter.println("Members: " + person99.getName());
								}
							}
							printWriter.println();
						}
					} catch (FileNotFoundException e) {
						System.out.println("The file is not found.");
					}
					break;
				case 15:
					// print the families in the file oreder be orphans number

					try (PrintWriter printWriter = new PrintWriter(file)) {
						Family family8 = new Family("family");
						ArrayList<Family> arraylist = family8.sortByMartyrs(manager.getFamilies());
						for (Family family99 : arraylist) {
							printWriter.println(family99.getFamilyName() + ": number of Orphans ("
									+ family8.familyOrphansNumber(family99) + ")");
							printWriter.println("...............................");
							for (Person person99 : family99.getMembers()) {
								if (person99.getRoleInFamily().equalsIgnoreCase("dad")) {
									printWriter.println("ParentDad: " + person99.getName());
								} else if (person99.getRoleInFamily().equalsIgnoreCase("mum")) {
									printWriter.println("ParentMum: " + person99.getName());
								} else if (person99.getRoleInFamily().equalsIgnoreCase("son")
										|| person99.getRoleInFamily().equalsIgnoreCase("daughter")) {
									printWriter.println("Members: " + person99.getName());
								}
							}

							printWriter.println();
						}
					} catch (FileNotFoundException e) {
						System.out.println("The file is not found.");
					}
					break;
				case 16:
					// to get clone of Martyr
					try {
						System.out.print(" please enter the Martyr ID :");
						String martyrID = input.next();
						if (manager.searchPersonByID(martyrID) == null) {
							System.out.println("the person is not found");
						} else {

							manager.searchPersonByID(martyrID).clone();
							System.out.println("done");
						}
					} catch (CloneNotSupportedException e) {
						System.out.println("CloneNotSupportedException");
					}
					break;
				// to get clone of family

				case 17:
					try {
						System.out.print("please enter the family name :");
						String familyname0 = input.next();
						if (manager.searchByName(familyname0) == null) {
							System.out.println(" the family in not foun in the system");
						}
						manager.searchByName(familyname0).clone();
						System.out.println("done");
					} catch (CloneNotSupportedException e) {
						System.out.println("CloneNotSupportedException");
					}
					break;
				case 18:
					// to get clone of LivePerson

					try {
						System.out.print("please enter the LivePerson ID :");
						String ID5 = input.next();
						if (manager.searchPersonByID(ID5) == null) {
							System.out.println(" the person is not found ");
						} else {
							manager.searchPersonByID(ID5).clone();
							System.out.println("done");
						}
					} catch (CloneNotSupportedException e) {
						System.out.println("CloneNotSupportedException");

					}
					break;
				case 19:
					// exit the program
					String x = null;
					try (PrintWriter printWriter1 = new PrintWriter(file)) {
						try {
							System.out.print("do you want to save the data in the file :");
							x = input.next();
						} catch (InputMismatchException e) {
							System.out.println("please enter yes or no ");
						}
						if (x.equalsIgnoreCase("no")) {

							boolean1 = false;
						} else if (x.equalsIgnoreCase("yes")) {
							for (Family family7 : manager.getFamilies()) {
								printWriter1.println(family7.getFamilyName() + "," + family7.getMembers().size());
								for (Person person5 : family7.getMembers()) {
									if (person5 instanceof Martyr) {
										printWriter1.println(person5.getID() + "," + person5.getName() + ","
												+ person5.getAge() + "," + person5.getGender() + ","
												+ person5.getAddress() + "," + person5.getContactInfo() + ","
												+ person5.getRoleInFamily() + ",Martyr");
									}
									if (person5 instanceof LivePerson) {
										printWriter1.println(person5.getID() + "," + person5.getName() + ","
												+ person5.getAge() + "," + person5.getGender() + ","
												+ person5.getAddress() + "," + person5.getContactInfo() + ","
												+ person5.getRoleInFamily() + ",LivePerson");
									}
								}
							}
							System.out.println(" the data is in the file");

						} else {
							System.out.println("invalid inut the input should be yes or no ");
						}
					} catch (FileNotFoundException e) {
						System.out.println("the file is not found ");
					}
					boolean1 = false;
					break;
				default:
					System.out.println("  Invalid input. Please enter a valid  Option");

				}
			} while (boolean1 == true);
		} else {
			// code that read the data from the file and added it to the system
			try (Scanner scanner = new Scanner(file)) {
				while (scanner.hasNext()) {
					String line = scanner.nextLine();
					String[] familyData = line.trim().split(",");
					Family family = new Family(familyData[0]);
					for (int i = 0; i < Integer.parseInt(familyData[1]); i++) {
						line = scanner.nextLine();
						String[] data = line.trim().split(",");
						String Id = data[0];
						String name = data[1];
						int age = Integer.parseInt(data[2]);
						String gender = data[3];
						String address = data[4];
						String contactInfo = data[5];
						String roleInFamily = data[6];
						if (data[7].equalsIgnoreCase("LivePerson")) {
							LivePerson person = new LivePerson(Id, name, age, gender, address, contactInfo,
									roleInFamily);
							if (roleInFamily.equalsIgnoreCase("mum") || roleInFamily.equalsIgnoreCase("dad")) {
								System.out.println(family.addMember(person, roleInFamily));
							}
							if (roleInFamily.equalsIgnoreCase("son") || roleInFamily.equalsIgnoreCase("daughter")) {
								System.out.println(family.addMember(person, roleInFamily));
							}
						} else if (data[7].equalsIgnoreCase("Martyr")) {
							Martyr person = new Martyr(Id, name, age, gender, address, contactInfo, roleInFamily);
							if (roleInFamily.equalsIgnoreCase("mum") || roleInFamily.equalsIgnoreCase("dad")) {
								System.out.println(family.addMember(person, roleInFamily));
							}
							if (roleInFamily.equalsIgnoreCase("son") || roleInFamily.equalsIgnoreCase("daughter")) {
								System.out.println(family.addMember(person, roleInFamily));

							}
						}

					}

					manager.addFamily(family);
				}
				int option = 0;
				// display the menu for the user
				do {
					System.out.println();
					System.out.println(
							"------------------------------------------------------------------------------------------------------------");
					System.out.println("1.To add a new family");
					System.out.println("2.Add parents to a family");
					System.out.println("3.Add a family members");
					System.out.println("4.To remove Member ");
					System.out.println("5.To search for a person by ID");
					System.out.println("6.To delet family");
					System.out.println("7.To update a family");
					System.out.println("8.To compare the number of Martyrs between two families");
					System.out.println("9.To calaulateTotalMartyrs");
					System.out.println("10.TocalaulateTotalOrphans");
					System.out.println("11.To calculateLivePersons");
					System.out.println("12.To calculate family statistics");
					System.out.println("13.To calculate global statistics");
					System.out.println(
							"14.To Print to the file all families with their members in sorted order based in Martyr number");
					System.out.println(
							"15.To Print to the file all families with their members in sorted order based in Orphans number");
					System.out.println("16.To Copy an object of type Martyr");
					System.out.println("17.To Copy an object of type Family");
					System.out.println("18.To  Copy an object of type LivePerson ");
					System.out.println("19.Exit");
					try {
						System.out.print(" please enter your option :");
						option = input.nextInt();
					} catch (InputMismatchException e) {
						System.out.println(" please enter vaild option");
					}
					switch (option) {
					case 1:
						// add new family
						System.out.print("please enter the family name :");
						String familyName = input.next();
						Family family = new Family(familyName);
						manager.addFamily(family);
						System.out.println("you  have created new family named :" + familyName);
						break;
					case 2:
						// to add member to the family

						try {
							System.out.print("please enter the family name : ");
							String familyName1 = input.next();
							if ((manager.searchByName(familyName1) == null)) {
								System.out.println("the family was not found");
							} else {
								// System.out.println(" the parents is Martyr or LivePerson");
								System.out.print("please enter the parent  ID :");
								String id = input.next();
								System.out.print("please enter the parent  Name :");
								String name = input.next();
								System.out.print("please enter the parent Age :");
								int age = input.nextInt();
								System.out.print("please enter the parent Gender : ");
								String gender = input.next();
								System.out.print("please enter the parent  Address :");
								String address = input.next();
								System.out.print("please enter the parent  ContactInfo :");
								String contactInfo = input.next();
								System.out.print("please enter the parent  RoleInFamily :");
								String roleInFamily = input.next();
								LivePerson parent = new LivePerson(id, name, age, gender, address, contactInfo,
										roleInFamily);
								manager.searchByName(familyName1).addMember(parent, roleInFamily);
							}
						} catch (ParentsNotFoundException e) {
							System.out.println("parent is not found1");
						}
						break;
					case 3:
						// to add member to the family

						int n = 0;
						System.out.print("please enter the family name :");
						String familyName2 = input.next();

						if ((manager.searchByName(familyName2) == null)) {
							System.out.println("the family was not found");
						} else {
							try {
								System.out.print("select 1 if the member is Marter  , 2 if The member is LivePerson :");
								n = input.nextInt();
							} catch (InputMismatchException e) {
								System.out.println(" please enter 1 or 2");
							}
							if (n == 2) {
								try {
									System.out.print("please enter the member  ID :");
									String id1 = input.next();
									System.out.print("please enter the member  Name :");
									String name1 = input.next();
									System.out.print("please enter the member Age :");
									int age1 = input.nextInt();
									System.out.print("please enter the member Gender :");
									String gender1 = input.next();
									System.out.print("please enter the member  Address :");
									String address1 = input.next();
									System.out.print("please enter the member  ContactInfo :");
									String contactInfo1 = input.next();
									System.out.print("please enter the member  RoleInFamily :");
									String roleInFamily1 = input.next();
									LivePerson member = new LivePerson(id1, name1, age1, gender1, address1,
											contactInfo1, roleInFamily1);
									System.out.println(
											manager.searchByName(familyName2).addMember(member, roleInFamily1));
								} catch (ParentsNotFoundException e) {
									System.out.println(" parents is not found ");
								}
							}
							if (n == 1) {
								try {
									System.out.print("please enter the member  ID :");
									String id1 = input.next();
									System.out.print("please enter the member  Name :");
									String name1 = input.next();
									System.out.print("please enter the member Age :");
									int age1 = input.nextInt();
									System.out.print("please enter the member Gender :");
									String gender1 = input.next();
									System.out.print("please enter the member  Address :");
									String address1 = input.next();
									System.out.print("please enter the member  ContactInfo :");
									String contactInfo1 = input.next();
									System.out.print("please enter the member  RoleInFamily :");
									String roleInFamily1 = input.next();
									Martyr member = new Martyr(id1, name1, age1, gender1, address1, contactInfo1,
											roleInFamily1);
									System.out.println(
											manager.searchByName(familyName2).addMember(member, roleInFamily1));
								} catch (ParentsNotFoundException e) {
									System.out.println(" the parents is not found ");
								}
							}
						}
						break;
					case 4:
						// delete member from a family
						System.out.print("please enter the member family name :");
						String familyname4 = input.next();
						if (manager.searchByName(familyname4) == null) {
							System.out.println(" the family was not found");
						} else {
							System.out.print("please enter the member  ID :");
							String id1 = input.next();
							System.out.print("please enter the member  Name :");
							String name1 = input.next();
							System.out.print("please enter the member Age :");
							int age1 = input.nextInt();
							System.out.print("please enter the member Gender :");
							String gender1 = input.next();
							System.out.print("please enter the member  Address :");
							String address1 = input.next();
							System.out.print("please enter the member  ContactInfo :");
							String contactInfo1 = input.next();
							System.out.print("please enter the member  RoleInFamily :");
							String roleInFamily1 = input.next();
							LivePerson person = new LivePerson(id1, name1, age1, gender1, address1, contactInfo1,
									roleInFamily1);
							System.out.println(manager.searchByName(familyname4).removeMember(person));
						}
						break;
					case 5:
						// find member by id
						System.out.print("please enter the person ID :");
						String Id = input.next();
						if (manager.searchPersonByID(Id) == null) {
							System.out.println(" this person is not found in the system");
						} else {
							System.out.println(manager.searchPersonByID(Id));
						}
						break;
					case 6:
						// remove family from the system
						try {
							System.out.print("please enter the family name :");
							String familyname5 = input.next();
							if (manager.searchByName(familyname5) == null) {
								System.out.println(" this family is not in the system");
							} else {
								System.out.println(manager.deletFamily(familyname5));
							}
						} catch (FamilyNotFoundException e) {
							System.out.println("family was not found ");
						}
						break;
					case 7:
						// update family
						try {
							System.out.print("please enter the family name that you want to update it :");
							String q = input.next();
							if (manager.searchByName(q) == null) {
								System.out.println(" this family is not found ");
							} else {
								manager.deletFamily(q);
								System.out.println("please enter the new name for the family");
								String moon = input.next();
								Family family2004 = new Family(moon);
								manager.addFamily(family2004);
								System.out.print("please enter the number of the member in the family to add them :");
								int v = input.nextInt();
								for (int i = 0; i < v; i++) {
									System.out.print("please enter the member  ID :");
									String id1 = input.next();
									System.out.print("please enter the member  Name :");
									String name1 = input.next();
									System.out.print("please enter the member Age :");
									int age1 = input.nextInt();
									System.out.print("please enter the member Gender :");
									String gender1 = input.next();
									System.out.print("please enter the member  Address :");
									String address1 = input.next();
									System.out.print("please enter the member  ContactInfo :");
									String contactInfo1 = input.next();
									System.out.print("please enter the member  RoleInFamily :");
									String roleinfamily = input.next();
									try {
										System.out.print("the member is livePerson or martyr :");
										{
											String h = input.next();
											if (h.equalsIgnoreCase("livePerson")) {
												LivePerson person = new LivePerson(id1, name1, age1, gender1, address1,
														contactInfo1, roleinfamily);
												family2004.addMember(person, roleinfamily);

											} else if (h.equalsIgnoreCase("martyr")) {
												Martyr person = new Martyr(id1, name1, age1, gender1, address1,
														contactInfo1, roleinfamily);
												family2004.addMember(person, roleinfamily);

											} else {
												System.out.println(" enter liveperson or martyr");
											}

										}
									} catch (InputMismatchException e) {
										System.out.println(" the inout is invaild please enter vaild input");
									}

								}
							}
						} catch (FamilyNotFoundException e) {
							System.out.println(" family was not found");
						}
						break;

					case 8:
						// compare the number of Martyrs between two families
						System.out.print("please enter the the first family name :");
						String first = input.next();
						System.out.print("please enter the second family name :");
						String second = input.next();
						if (manager.searchByName(first) == null || manager.searchByName(second) == null) {
							System.out.println(" one of the two families is not found of both");
						}
						System.out.println(manager.searchByName(first).equals(manager.searchByName(second)));
						break;
					case 9:
						// to get the number of the martyrs
						System.out.println(manager.calaulateTotalMartyrs());
						break;
					case 10:
						// to get the number of the orphans
						System.out.println(manager.calaulateTotalOrphans());
						break;
					case 11:
						// to get the number of the live person
						System.out.println(manager.calculateLivePersons());
						break;
					case 12:
						// to get a family statistics
						System.out.print("please enter the family name :");
						String familyname7 = input.next();
						if (manager.searchByName(familyname7) == null) {
							System.out.println(" this family is not found ");
						} else {
							System.out.println(manager.calculateFamilyStatistics(familyname7));
						}

						break;
					case 13:
						// to get the global statistics
						System.out.println(manager.calculateGlobalStatistics());
						break;
					case 14:
						// print the families in the file ordered by martyrs number
						try (PrintWriter printWriter = new PrintWriter(file)) {
							Family family8 = new Family("family");
							ArrayList<Family> arraylist = family8.sortByMartyrs(manager.getFamilies());
							for (Family family99 : arraylist) {
								printWriter.println(family99.getFamilyName() + ": number of martyrs ("
										+ family8.familyMartyrsNumber(family99) + ")");
								printWriter.println("...............................");
								for (Person person99 : family99.getMembers()) {
									if (person99.getRoleInFamily().equalsIgnoreCase("dad")) {
										printWriter.println("ParentDad: " + person99.getName());
									} else if (person99.getRoleInFamily().equalsIgnoreCase("mum")) {
										printWriter.println("ParentMum: " + person99.getName());
									} else if (person99.getRoleInFamily().equalsIgnoreCase("son")
											|| person99.getRoleInFamily().equalsIgnoreCase("daughter")) {
										printWriter.println("Members: " + person99.getName());
									}
								}
								printWriter.println();
							}
						} catch (FileNotFoundException e) {
							System.out.println("The file is not found.");
						}
						break;
					case 15:
						// print the families in the file ordered by orphans number

						try (PrintWriter printWriter = new PrintWriter(file)) {
							Family family8 = new Family("family");
							ArrayList<Family> arraylist = family8.sortByMartyrs(manager.getFamilies());
							for (Family family99 : arraylist) {
								printWriter.println(family99.getFamilyName() + ": number of Orphans ("
										+ family8.familyOrphansNumber(family99) + ")");
								printWriter.println("...............................");
								for (Person person99 : family99.getMembers()) {
									if (person99.getRoleInFamily().equalsIgnoreCase("dad")) {
										printWriter.println("ParentDad: " + person99.getName());
									} else if (person99.getRoleInFamily().equalsIgnoreCase("mum")) {
										printWriter.println("ParentMum: " + person99.getName());
									} else if (person99.getRoleInFamily().equalsIgnoreCase("son")
											|| person99.getRoleInFamily().equalsIgnoreCase("daughter")) {
										printWriter.println("Members: " + person99.getName());
									}
								}
								printWriter.println();
							}
						} catch (FileNotFoundException e) {
							System.out.println("The file is not found.");
						}
						break;
					case 16:
						// to get clone of martyr
						try {
							System.out.print(" please enter the Martyr ID :");
							String martyrID = input.next();
							if (manager.searchPersonByID(martyrID) == null) {
								System.out.println("the person is not found");
							} else {

								manager.searchPersonByID(martyrID).clone();
								System.out.println("done");
							}
						} catch (CloneNotSupportedException e) {
							System.out.println("CloneNotSupportedException");
						}
						break;
					// to get clone of a family
					case 17:
						try {
							System.out.print("please enter the family name :");
							String familyname0 = input.next();
							if (manager.searchByName(familyname0) == null) {
								System.out.println(" the family in not foun in the system");
							}
							manager.searchByName(familyname0).clone();
							System.out.println("done");
						} catch (CloneNotSupportedException e) {
							System.out.println("CloneNotSupportedException");
						}
						break;
					// to get clone of the liveperson class
					case 18:
						try {
							System.out.print("please enter the LivePerson ID :");
							String ID5 = input.next();
							if (manager.searchPersonByID(ID5) == null) {
								System.out.println(" the person is not found ");
							} else {
								manager.searchPersonByID(ID5).clone();
								System.out.println("done");
							}
						} catch (CloneNotSupportedException e) {
							System.out.println("CloneNotSupportedException");
						}
						break;
					// close the program
					case 19:
						String x = null;
						try (PrintWriter printWriter1 = new PrintWriter(file)) {
							try {
								System.out.print("do you want to save the data in the file :");
								x = input.next();
							} catch (InputMismatchException e) {
								System.out.println("please enter yes or no ");
							}
							if (x.equalsIgnoreCase("no")) {

								boolean2 = false;
							} else if (x.equalsIgnoreCase("yes")) {
								for (Family family7 : manager.getFamilies()) {
									printWriter1.println(family7.getFamilyName() + "," + family7.getMembers().size());
									for (Person person5 : family7.getMembers()) {
										if (person5 instanceof Martyr) {
											printWriter1.println(person5.getID() + "," + person5.getName() + ","
													+ person5.getAge() + "," + person5.getGender() + ","
													+ person5.getAddress() + "," + person5.getContactInfo() + ","
													+ person5.getRoleInFamily() + ",Martyr");
										}
										if (person5 instanceof LivePerson) {
											printWriter1.println(person5.getID() + "," + person5.getName() + ","
													+ person5.getAge() + "," + person5.getGender() + ","
													+ person5.getAddress() + "," + person5.getContactInfo() + ","
													+ person5.getRoleInFamily() + ",LivePerson");
										}
									}
								}
								System.out.println(" the data is in the file");
							} else {
								System.out.println("invalid inut the input should be yes or no ");
							}
						} catch (FileNotFoundException e) {
							System.out.println("the file is not found ");
						}

						boolean2 = false;
						break;
					default:
						System.out.println("  Invalid input. Please enter a valid  Option");
					}
				} while (boolean2 == true);

			} catch (FileNotFoundException e) {
				System.out.println("the file is not found");
			} catch (ParentsNotFoundException e) {
				System.out.println("parents is not found");
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
