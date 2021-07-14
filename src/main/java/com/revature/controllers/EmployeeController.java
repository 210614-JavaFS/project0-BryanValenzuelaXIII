package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Employee;
import com.revature.services.EmployeeService;

public class EmployeeController {
	
	private static EmployeeService empService = new EmployeeService();
	
	public void menu(Employee usuario) {
		System.out.println("Welcome back " + usuario.getName());
		Scanner cin = new Scanner(System.in);
		int respuesta = 0;
		
		while (respuesta != 3) {
			System.out.println("Please choose an option\n"
					+ "1. View customer info\n"
					+ "2. Approve/Deny applications\n"
					+ "3. Loggout");
			respuesta = cin.nextInt();
			switch(respuesta) {
			case 1:
				empService.customerInfo();
				break;
			case 2:
				empService.aprooveApplication();
				break;
			case 3:
				System.out.println("Logging out...");
				break;
			default:
				System.out.println("Not an option, please try again\n");
			}
		}
	}
}
