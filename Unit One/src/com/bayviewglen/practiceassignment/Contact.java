package com.bayviewglen.practiceassignment;

public class Contact {
	private String lname;
	private String fname;
	private String phone;

	public Contact(String fname, String lname, String phone) {
		this.lname = lname;
		this.fname = fname;
		this.phone = phone;
	}

	// This method returns true if the contact contains a given name, and false
	// otherwise
	public boolean checkContactName(String checkName) {
		String lowerName = fname.toLowerCase() + " " + lname.toLowerCase();
		if (lowerName.indexOf(checkName.toLowerCase()) != -1) {
			return true;
		} else {
			return false;
		}
	}

	// This method returns true if the contact contains a given phone, and false
	// otherwise
	public boolean checkContactPhone(String checkPhone) {
		if (removeDash(phone).indexOf(removeDash(checkPhone)) != -1) {
			return true;
		} else {
			return false;
		}
	}

	// This method prints the contact for display
	public void printContact() {
		System.out.println("First Name: " + fname + "\n Last Name: " + lname + "\nPhone Number: " + phone + "\n");
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

	// return first name
	public String fnameShow() {
		return fname;
	}

	// return last name
	public String lnameShow() {
		return lname;
	}

	// return phone
	public String phoneShow() {
		return phone;
	}
}
