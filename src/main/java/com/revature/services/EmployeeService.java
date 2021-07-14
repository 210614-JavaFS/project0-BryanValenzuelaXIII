package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.NewUser;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

public class EmployeeService {
	
	private static UserDAO userDAO = new UserDAOImpl();
	
	public void customerInfo() {
		List <Customer> users = userDAO.finaAllCustomers();
		Scanner sc = new Scanner(System.in);
		for(Customer i: users) {
			System.out.println("Username: " + i.getUsername() + ", Name: " +  i.getName());
		}
		System.out.println("Please choose a customer to see their info");
		String uname = sc.nextLine();
		Customer info = userDAO.findByUsernameCustomer(uname);
		System.out.println("Name: " + info.getName()
				+ "\nUsername: " + info.getUsername() 
				+ "\nCheckings balance: " + info.getChecking());
		if(info.getSavings() > 0)
			System.out.println("Savings balance: " + info.getSavings());
		if(info.getJoint())
			System.out.println("Shared account with: " + info.getPartner());
	}
	
	public void aprooveApplication() {
		List <NewUser> users = userDAO.finaAllNewUser();
		for(NewUser i: users) {
			System.out.println(i.toString());
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Please choose a customer to see their info");
		String uname = sc.nextLine();
		NewUser info = userDAO.findByUsernameNew(uname);
		System.out.println(info.getName());
		System.out.println("Do you aprove this person to become a customer? 1. yes"
				+ "2. no");
		int res = sc.nextInt();
		switch (res) {
		case 1:if( userDAO.aprooveUser(info));
			System.out.println("User added");
			userDAO.deleteNewUser(info);
			break;
		case 2:
		userDAO.deleteNewUser(info);
			System.out.println("User deleted");
		break;
		default:
			System.out.println("Not an option");
		
		}
	}
}
