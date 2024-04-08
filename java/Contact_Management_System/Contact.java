package Contact_Management_System;

import java.util.Scanner;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Id;
import javax.persistence.Persistence;

@Entity
public class Contact {
	@Id
	private String name;
	private String mobileNo;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	static EntityManager em = emf.createEntityManager();
	static EntityTransaction et = em.getTransaction();
	static Scanner scn = new Scanner(System.in);

	public static void addContact() {
		Contact ct = new Contact();
		System.out.println("Enter Name");
		String name = scn.next();
		System.out.println("Enter MobileNumber");
		String mobileNo = scn.nextLine();
		System.out.println("Enter EmailAddress");
		String email = scn.next();

		ct.setName(name);
		ct.setMobileNo(mobileNo);
		ct.setEmail(email);

		et.begin();
		em.persist(ct);
		et.commit();
		System.out.println("Contact Added Sucessesfully.....");
	}

	public static void viewContact() {
		System.out.println("Enter name");
		String name = scn.next();

		Contact ct = em.find(Contact.class, name);
		if (ct != null) {
			System.out.println(ct.getName());
			System.out.println(Double.parseDouble(ct.getMobileNo()));
			System.out.println(ct.getEmail());
			System.out.println("Contact Fetched Sucessesfully...");
		} else
			System.out.println("Enter Valid name");
	}

	public static void editContact() {
		System.out.println("Enter name to edit");
		String name = scn.next();
		System.out.println("Enter edited MobileNumber");
		String mobileNo = scn.nextLine();

		Contact ct = em.find(Contact.class, mobileNo);
		ct.setMobileNo(mobileNo);
		et.begin();
		em.merge(ct);
		et.commit();
		System.out.println("Mobile Number is edited..");
	}

	public static void deleteContact() {
		System.out.println("Enter the name");
		String name = scn.next();
		Contact ct = em.find(Contact.class, name);
		et.begin();
		em.remove(ct);
		et.commit();
		System.out.println("Contact deleted Sucessesful..");
	}
}
