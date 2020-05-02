package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private int mailboxCapacity = 500;
	private int defaultpasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "abccompany.com";

	// Constructor to recieve the first name and last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;

		// Call a method asking for the department - return the department
		this.department = setDepartment();

		// Call a method that returns a random password
		this.password = randomPassword(defaultpasswordLength);

		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}

	// Ask for the department
	private String setDepartment() {
		System.out.println("Enter the department" + "\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\n"
				+ "---------------------\n" + firstName + " Enter department code: ");
		Scanner sc = new Scanner(System.in);
		int depChoice = sc.nextInt();
		if (depChoice == 1) {
			return "sales";
		} else if (depChoice == 2) {
			return "dev";
		} else if (depChoice == 3) {
			return "acc";
		} else {
			return "";
		}
	}

	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}

	// Set the mailbox capacity
	public void setMailBoxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}

	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}

	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}

	// Get mail Box Capacity
	public int getMailBoxCapacity() {
		return mailboxCapacity;
	}

	// Get alternate email
	public String getAlternateEmail() {
		return alternateEmail;
	}

	// Get password
	public String getPassword() {
		return password;
	}

	public String showInfo() {
		return "Display Name: " + firstName + " " + lastName + "\nCompany Email: " + email + "\nPassword: " + password
				+ "\nMailBox Capacity: " + mailboxCapacity + "MB";
	}
}
