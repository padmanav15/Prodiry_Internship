package com.jsp.Task_03;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
	private String name;
	private String phoneNumber;
	private String email;

	public Contact(String name, String phoneNumber, String email) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Name: " + name + ", Phone: " + phoneNumber + ", Email: " + email;
	}
}

public class ContactManagement {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ContactManagement contactManager = new ContactManagement();

		while (true) {
			System.out.println("CONTACT MANAGEMENT SYSTEM \n");
			System.out.println("1. Add Contact");
			System.out.println("2. View Contacts");
			System.out.println("3. Edit Contact");
			System.out.println("4. Delete Contact");
			System.out.println("5. Exit\n");
			System.out.println("Enter your choice : ");
			int choice = scanner.nextInt();
			scanner.nextLine(); 

			switch (choice) {
			case 1:
				System.out.println("Enter name : ");
				String name = scanner.nextLine();
				System.out.print("Enter phone number: ");
				String phoneNumber = scanner.nextLine();
				System.out.print("Enter email address: ");
				String email = scanner.nextLine();
				Contact newContact = new Contact(name, phoneNumber, email);
				contactManager.addContact(newContact);
				System.out.println("Contact added successfully.");
				break;
			case 2:
				contactManager.viewContacts();
				break;
			case 3:
				System.out.print("Enter name of contact to edit: ");
				String editName = scanner.nextLine();
				System.out.print("Enter new phone number: ");
				String editPhoneNumber = scanner.nextLine();
				System.out.print("Enter new email address: ");
				String editEmail = scanner.nextLine();
				contactManager.editContact(editName, editPhoneNumber, editEmail);
				break;
			case 4:
				System.out.print("Enter name of contact to delete: ");
				String deleteName = scanner.nextLine();
				contactManager.deleteContact(deleteName);
				break;
			case 5:
				System.out.println("Exiting...");
				System.exit(0);

			default:
				System.out.println("Invalid choice. Please enter a number between 1 and 5.");

				break;
			}
		}
	}
	private ArrayList<Contact> contacts;

	public ContactManagement() {
		contacts = new ArrayList<>();
	}

	public void addContact(Contact contact) {
		contacts.add(contact);
	}

	public void viewContacts() {
		System.out.println("Contacts:");
		for (Contact contact : contacts) {
			System.out.println(contact);
		}
	}

	public void editContact(String name, String phoneNumber, String email) {
		for (Contact contact : contacts) {
			if (contact.getName().equals(name)) {
				contact.setPhoneNumber(phoneNumber);
				contact.setEmail(email);
				System.out.println("Contact updated successfully.");
				return;
			}
		}
		System.out.println("Contact not found.");
	}

	public void deleteContact(String name) {
		for (int i = 0; i < contacts.size(); i++) {
			if (contacts.get(i).getName().equals(name)) {
				contacts.remove(i);
				System.out.println("Contact deleted successfully.");
				return;
			}
		}
		System.out.println("Contact not found.");
	}
}
