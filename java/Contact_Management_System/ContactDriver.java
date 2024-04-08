package Contact_Management_System;

import java.util.Scanner;

public class ContactDriver {
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		while(true)
		{
			System.out.println("Perform operation in Contact table");
			System.out.println("1.AddContact\n2.ViewContact\n3.EditContact\n4.DeleteContact\n5.Exit");
			System.out.println("Enter your choice");
			int choice=scn.nextInt();
			switch(choice)
			{
			case 1:
				Contact.addContact();
				break;
			case 2:
				Contact.viewContact();
				break;
			case 3:
				Contact.editContact();
				break;
			case 4:
				Contact.deleteContact();
				break;
			case 5:
				System.out.println("Exiting Operation....");
	            System.exit(0);
	            break;
			default:
				System.out.println("Invalid Choice");
			}
		}
	}
}
