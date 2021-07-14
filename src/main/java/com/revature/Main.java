package com.revature;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.revature.Connection.ConnectionUtil;
import com.revature.controllers.AdminController;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.UserController;
import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.NewUser;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

public class Main {
	
	public static UserController controller = new UserController();
	public static EmployeeController controlle = new EmployeeController();
	public static AdminController control = new AdminController();
	private static UserDAO userDAO = new UserDAOImpl();
	
	public static void main(String[] args) {
		
		String un;
		
		while(true) {
			System.out.println("Hello user! Are you a: 1. Returning client\n"
					         + "                       2. Employee\n"
					         + "                       3. Admin\n"
					         + "                       4. New client");
			Scanner sc = new Scanner(System.in);
			int decision = sc.nextInt();
			switch(decision) {
			case 1: System.out.println("Please enter your username: ");
					sc.nextLine();
					un = sc.nextLine();
					Customer cus = userDAO.findByUsernameCustomer(un);
					System.out.println("Please enter your password: ");
					//1sc.nextLine();
					un = sc.nextLine();
					if (un.equals(cus.getPassword()))
						controller.menu(cus);
				break;
			case 2: System.out.println("Please enter your username: ");
			sc.nextLine();
					 un = sc.nextLine();
					Employee emp = userDAO.findByUsernameEmployee(un);
					System.out.println("Please enter your password: ");
					//sc.nextLine();
					un = sc.nextLine();
					if (un.equals(emp.getPassword()))
						controlle.menu(emp);
				break;
			case 3:System.out.println("Please enter your username: ");
			sc.nextLine();
			 	   un = sc.nextLine();
			 	   Admin adm = userDAO.findByUsernameAdmins(un);
			 	   System.out.println("Please enter your password: ");
			 	  //sc.nextLine();
			 	   un = sc.nextLine();
			 	   if (un.equals(adm.getPassword()))
			 		   control.menu(adm);
				break;
			case 4: 
				applyForAccount();
				break;
			default:
				System.out.println("Sorry that's not an option");
			}
			}
	}
	private static void applyForAccount() {
		System.out.println("To determine if you are able to get an account you must anwser this questions\n"
				+ "What's your name? ");
		Scanner sc = new Scanner(System.in);
		String respuesta1 = sc.nextLine();
		System.out.println("What would be your username?");
		String respuesta2 = sc.nextLine();
		System.out.println("What would be your password?");
		String respuesta3 = sc.nextLine();
		System.out.println("What is your income a year");
		double respuesta4 = sc.nextDouble();
		System.out.println("What would be your starting ammount?");
		double respuesta5 = sc.nextDouble();
		NewUser nuevo = new NewUser(respuesta1, respuesta2, respuesta3, respuesta4 ,respuesta5);
		
		userDAO.applyUser(nuevo);
	}

}
