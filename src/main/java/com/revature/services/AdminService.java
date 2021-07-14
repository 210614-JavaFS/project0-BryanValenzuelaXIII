package com.revature.services;

import java.util.List;
import java.util.Scanner;

import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.NewUser;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

public class AdminService {
	
	private static UserDAO userDAO = new UserDAOImpl();
	List <Customer> customer = userDAO.finaAllCustomers();
	List <Employee> employee = userDAO.finaAllEmployees();
	List <Admin> admin = userDAO.finaAllAdmins();
	Scanner sc = new Scanner(System.in);
	
	public void viewInfo() {
		for(Customer i: customer) {
			System.out.println("Name: " + i.getName()
			+ "\nUsername: " + i.getUsername() 
			+ "\nType: " + i.getType()
			+ "\nCheckings balance: " + i.getChecking());
		if(i.getSavings() > 0)
			System.out.println("Savings balance: " + i.getSavings());
		if(i.getJoint())
			System.out.println("Shared account with: " + i.getPartner());
		}
		
		for(Employee i: employee) {
			System.out.println("Name: " + i.getName()
			+ "\nUsername: " + i.getUsername() 
			+ "\nType: " + i.getType());
		}
		
		for(Admin i: admin) {
			System.out.println("Name: " + i.getName()
			+ "\nUsername: " + i.getUsername() 
			+ "\nType: " + i.getType());
		}
		/*System.out.println("Please choose a user to see their info");
		String uname = sc.nextLine();
		Customer info = userDAO.findByUsernameCustomer(uname);*/
	}
	
	public void editEmployeeAccount() {
		System.out.println("Please type a user to edit their info");
		String uname = sc.nextLine();
		Employee info = userDAO.findByUsernameEmployee(uname);
		
		System.out.println("What do you want to edir from this account?");
		int respuesta;
		System.out.println("1. Change name\n"
				+ "2. Change username\n"
				+ "3. Change Password"
				+ "4. Cancel");
		respuesta = sc.nextInt();
		switch(respuesta) {
		case 1: System.out.println("What is the new name?");
		sc.nextLine();
			uname = sc.nextLine();
			info.setName(uname);
			userDAO.updateInfor(info);
			break;
		case 2: System.out.println("What is the new usernamename?");
		sc.nextInt();
			uname = sc.nextLine();
			info.setUsername(uname);
			userDAO.updateInfor(info);
			break;
		case 3: System.out.println("What is the new password?");
		sc.nextLine();
			uname = sc.nextLine();
			info.setPassword(uname);
			userDAO.updateInfor(info);
			break;
		default:
			System.out.println("Returning to menu");
		}
	}
	
	public void editCustomerAccount() {
		System.out.println("Please type a user to edit their info");
		String uname = sc.nextLine();
		Customer info = userDAO.findByUsernameCustomer(uname);
		System.out.println("What do you want to edit from this account?");
		int respuesta;
		CustomerService cusService = new CustomerService();
		System.out.println("1. Change name\n"
				+ "2. Change username\n"
				+ "3. Change Password\n"
				+ "4. withdrawing\n"
				+ "5. depositing\n"
				+ "6. Transfer\n"
				+ "7. Cancel");
		respuesta = sc.nextInt();
		switch(respuesta) {
		case 1: System.out.println("What is the new name?");
		sc.nextLine();
			uname = sc.nextLine();
			info.setName(uname);
			userDAO.updateInfor(info);
			break;
		case 2: System.out.println("What is the new usernamename?");
		sc.nextLine();
			uname = sc.nextLine();
			info.setUsername(uname);
			userDAO.updateInfor(info);
			break;
		case 3: System.out.println("What is the new password?");
		sc.nextInt();
			uname = sc.nextLine();
			info.setPassword(uname);
			userDAO.updateInfor(info);
			break;
		case 4: cusService.withdraw(info);
			break;
		case 5: cusService.deposit(info);
			break;
		case 6: cusService.transferToOther(info);
			break;
		default:
			System.out.println("Returning to menu");
		}
	}
	
	public void cancelAccount() {
		System.out.println("Are you canceling a: 1. Customer account\n"
				         + "                     2. Employee account\n"
				         + "                     3. Cancel");
		int respuesta = sc.nextInt();
		switch(respuesta) {
		case 1:
			System.out.println("Please type a user to cancel their account");
			sc.nextLine();
			String uname = sc.nextLine();
			Customer info = userDAO.findByUsernameCustomer(uname);
			userDAO.deleteCustomer(info);
			break;
		case 2:
			System.out.println("Please type a user to cancel their account");
			sc.nextLine();
			String fire = sc.nextLine();
			Employee empl = userDAO.findByUsernameEmployee(fire);
			userDAO.deleteEmployee(empl);
			break;
			
		default:
			System.out.println("Wrong option");
		}
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
		System.out.println("Do you aprove this person to become a customer? 1. yes\n"
				+ "2. no");
		int res = sc.nextInt();
		switch (res) {
		case 1:if( userDAO.aprooveUser(info));
			System.out.println("User added");
			userDAO.deleteNewUser(info);
			break;
		case 2:
		if(userDAO.deleteNewUser(info))
			System.out.println("User deleted");
		break;
		default:
			System.out.println("Not an option");
		
		}
	}
}
