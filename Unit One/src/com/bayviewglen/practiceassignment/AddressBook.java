package com.bayviewglen.practiceassignment;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	private static Scanner scanner = new Scanner(System.in);
	private ArrayList<Contact> list;

	public AddressBook() {
		list = new ArrayList<Contact>();
	}

	// adds a contact with inputted information to the arraylist
	public void addContact() {
		System.out.println("Please enter first name.");
		String first = scanner.nextLine();
		System.out.println("Please enter last name.");
		String last = scanner.nextLine();
		System.out.println("Please enter phone number.");
		String phone = scanner.nextLine();
		Contact contact = new Contact(first, last, phone);
		list.add(contact);
		System.out.println("Congratulations!!!! You just added a contact.");
	}

	// adds a contact with the info as parameters
	public void addContactDirect(String fname, String lname, String phone) {
		Contact contact = new Contact(fname, lname, phone);
		list.add(contact);
	}

	// deletes a contact given an ArrayList of the indices of the address book
	// that the user can delete
	private void deleteContact(ArrayList<Integer> indices) {
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
				list.remove((int) indices.get(deleteIndicesIndex));
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
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int counter = 1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).checkContactName(checkName)) {
				System.out.println("Contact " + counter++);
				list.get(i).printContact();
				indices.add(i);
			}
		}
		deleteContact(indices);
	}

	// shows a contact given a phone
	public void showContactPhone(String checkPhone) {
		System.out.println("Here is a list of contacts containing \"" + checkPhone + "\"");
		ArrayList<Integer> indices = new ArrayList<Integer>();
		int counter = 1;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).checkContactPhone(checkPhone)) {
				System.out.println("Contact " + counter++);
				list.get(i).printContact();
				indices.add(i);
			}
		}
		deleteContact(indices);
	}

	// show all contacts
	public void showAll() {
		for (Contact c : list) {
			c.printContact();
		}
	}

	// save the contacts to the file
	public void writeContacts() {
		try {
			FileWriter writer = new FileWriter("input/contacts.dat");
			for (Contact c : list) {
				writer.write(c.fnameShow() + "\n");
				writer.write(c.lnameShow() + "\n");
				writer.write(c.phoneShow() + "\n");
			}

			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
