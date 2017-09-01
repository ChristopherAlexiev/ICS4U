package com.bayviewglen.addressbookmap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class AddressBookInterfaceWithMap {

	private static AddressBookWithMap book = new AddressBookWithMap();
	private static Scanner scanner = new Scanner(System.in);

	// This is the address book interface structure
	public static void main(String[] args) {

		boolean inGame = true;

		contactsFromFile();

		System.out.println("Welcome to address book.");
		while (inGame) {
			System.out.println("Here is your menu, enter the number to choose an option.");
			System.out.println(
					" 1) Add a contact \n 2) Display all contacts \n 3) Search for or delete a contact by name \n 4) Search for or delete a contact by phone \n 5) Save address book");
			int input = inputer();
			if (input == 1) {
				book.addContact();
			} else if (input == 2) {
				System.out.println("Here are all contacts:");
				book.showAll();
			} else if (input == 3) {
				System.out.println("Please enter a name to search for contacts:");
				String checkName = scanner.nextLine();
				book.showContactName(checkName);
			} else if (input == 4) {
				System.out.println("Please enter a phone to search for contacts:");
				String checkPhone = scanner.nextLine();
				book.showContactPhone(checkPhone);
			} else {
				book.writeContacts();
				System.out.println("Address book saved.");
			}
			System.out.println("///////////////////////////////////////////////");
			System.out.println("Thank you for using address book.");
			System.out.println("///////////////////////////////////////////////");
		}
	}

	// This returns the value typed into the console
	private static int inputer() {
		boolean bad = true;
		int choice = 0;
		while (bad) {
			System.out.println("Please enter a valid choice:");
			try {
				choice = Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
			}
			if (choice >= 1 && choice <= 5) {
				bad = false;
			}
		}
		return choice;
	}

	// gets the contacts from the file
	static void contactsFromFile() {
		try {
			Scanner fileScan = new Scanner(new File("input/contactsMap.dat"));
			String fname;
			String phone;
			String lname;
			while (true) {
				try {
					fname = fileScan.nextLine();
					lname = fileScan.nextLine();
					phone = fileScan.nextLine();
				} catch (NoSuchElementException e) {
					break;
				}
				book.addContactDirect(fname, lname, phone);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
