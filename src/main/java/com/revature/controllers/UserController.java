package com.revature.controllers;

import java.util.List;
import java.util.Scanner;

// Menu
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.services.CustomerService;

public class UserController {
	
	private static CustomerService cusService = new CustomerService();
	
	public void showAllUsers() {///////
		List <Customer> users = cusService.getAllUsers();
		
		for (User i:users) {
			System.out.println(i.getName() + " " + i.getType());
		}
	}
	
	public void menu(Customer usuario) {
		System.out.println("Welcome back " + usuario.getName());
		Scanner cin = new Scanner(System.in);
		int respuesta = 0;
		
		while (respuesta != 7) {
			System.out.println("Please choose an option\n"
					+ "1. Withdraw money\n"
					+ "2. Deposit money\n"
					+ "3. Transfer money between account\n"
					+ "4. Transfer money to a another customer\n"
					+ "5. Open a saving account\n"
					+ "6. apply for a joint accounts\n"
					+ "7. Loggout");
			respuesta = cin.nextInt();
			switch(respuesta) {
			case 1: 
				cusService.withdraw(usuario);
				break;
			case 2:
				cusService.deposit(usuario);
				break;
			case 3:
				cusService.transfer(usuario);
				break;
			case 4:
				cusService.transferToOther(usuario);
				break;
			case 5:
				cusService.openSavings(usuario);
				break;
			case 6:
				cusService.jointAccounts(usuario);
				break;
			case 7:
				System.out.println("Logging out...");
				break;
			default:
				System.out.println("Not an option, please try again\n");
				break;
			}
		}
	}
}
