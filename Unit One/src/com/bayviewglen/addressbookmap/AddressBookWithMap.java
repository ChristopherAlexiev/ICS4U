package com.bayviewglen.addressbookmap;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AddressBookWithMap {

	private static Scanner scanner = new Scanner(System.in);
	private Map<String, String[]> map = new HashMap<String, String[]>();

	public AddressBookWithMap() {

	}

	// adds a contact with inputted information to the arraylist
	public void addContact() {
		System.out.println("Please enter first name.");
		String first = scanner.nextLine();
		System.out.println("Please enter last name.");
		String last = scanner.nextLine();
		System.out.println("Please enter phone number.");
		String phone = scanner.nextLine();
		// find the occurrence of this particular phone number so that it can be
		// labeled to make it a unique key
		int occurrence = 1;
		for (String key : map.keySet()) {
			if (key.split("~")[0].equals(phone) && Integer.parseInt(key.split("~")[1]) >= occurrence){
				occurrence = Integer.parseInt(key.split("~")[1])+1;
			}
		}
		String[] names = { first, last };
		map.put(phone + "~" + occurrence, names);
		System.out.println("Congratulations!!!! You just added a contact.");
	}

	// adds a contact with the info as parameters (used when reading from file)
	public void addContactDirect(String fname, String lname, String phone) {
		String[] names = { fname, lname };
		map.put(phone, names);
	}

	// deletes a contact given an ArrayList of the indices of the address book
	// that the user can delete
	private void deleteContact(ArrayList<String> indices) {
		System.out.println("Would you like to delete one of the above contacts? (Y or N)");
		while (true) {
			String input = scanner.nextLine();
			if (input.equals("Y") || input.equals("y")) {
				System.out.println(
						"Delete which one? Please enter the contact's number (they are in order). If you no longer want to delete, enter 0.");
				int deleteIndicesIndex = inputer(indices.size()) - 1;
				if (deleteIndicesIndex == -1) {
					System.out.println("No problem, have a nice day.");
					break;
				}
				map.remove(indices.get(deleteIndicesIndex));
				System.out.println("Ok, you have deleted that contact.");
				break;
			} else if (input.equals("N") || input.equals("n")) {
				System.out.println("No problem, have a nice day.");
				break;
			} else {
				System.out.println("Please enter a valid response (Y or N)");
			}
		}
	}

	// This returns the value typed into the console
	private static int inputer(int numberOfStuff) {
		boolean bad = true;
		int choice = -1;
		while (bad) {
			System.out.println("Please enter a valid choice:");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
			}
			if (choice >= 0 && choice <= numberOfStuff) {
				bad = false;
			}
		}
		return choice;
	}

	// shows all the contacts containing a given name, and then run the
	// deleteContact function
	public void showContactName(String checkName) {
		System.out.println("Here is a list of contacts containing \"" + checkName + "\"");
		ArrayList<String> indices = new ArrayList<String>();
		int counter = 1;
		for (String phone : map.keySet()) {
			if (nameMatcher(phone, checkName)) {
				System.out.println("Contact " + counter++);
				printContact(phone);
				indices.add(phone);
			}

		}
		deleteContact(indices);

	}

	// prints a contact
	private void printContact(String phone) {
		System.out.println("First Name: " + map.get(phone)[0] + "\n Last Name: " + map.get(phone)[1]
				+ "\nPhone Number: " + phone.split("~")[0] + "\n");
	}

	// checks if a name (checkName) is found within a contact's name
	private boolean nameMatcher(String phone, String checkName) {
		String lowerName = map.get(phone)[0].toLowerCase() + " " + map.get(phone)[1].toLowerCase();
		if (lowerName.indexOf(checkName.toLowerCase()) != -1) {
			return true;
		} else {
			return false;
		}
	}

	// shows a contact given a phone
	public void showContactPhone(String checkPhone) {
		System.out.println("Here is a list of contacts containing \"" + checkPhone + "\"");
		ArrayList<String> indices = new ArrayList<String>();
		int counter = 1;
		for (String phone : map.keySet()) {
			if (phoneMatcher(phone, checkPhone)) {
				System.out.println("Contact " + counter++);
				printContact(phone);
				indices.add(phone);
			}

		}
		deleteContact(indices);
	}

	// checks if a phone number (checkPhone) is found within another phone
	// number (phone)
	private boolean phoneMatcher(String phone, String checkPhone) {
		if (removeDash(phone.split("~")[0]).indexOf(removeDash(checkPhone)) != -1) {
			return true;
		} else {
			return false;
		}
	}

	// this method removes dashes from a phone number
	private String removeDash(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '-') {
				str = str.substring(0, i) + str.substring(i + 1);
			}
		}
		return str;
	}

	// show all contacts
	public void showAll() {
		for (String phone : map.keySet()) {
			printContact(phone);
		}
	}

	// save the contacts to the file
	public void writeContacts() {
		try {
			FileWriter writer = new FileWriter("input/contactsMap.dat");
			for (String phone : map.keySet()) {
				writer.write(map.get(phone)[0] + "\n");
				writer.write(map.get(phone)[1] + "\n");
				writer.write(phone + "\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
