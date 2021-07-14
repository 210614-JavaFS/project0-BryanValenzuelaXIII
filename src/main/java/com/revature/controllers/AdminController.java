package com.revature.controllers;

import java.util.Scanner;

import com.revature.models.Admin;
import com.revature.services.AdminService;



public class AdminController {
	
private static AdminService admService = new AdminService();
	
	public void menu(Admin usuario) {
		System.out.println("Welcome back " + usuario.getName());
		Scanner cin = new Scanner(System.in);
		int respuesta = 0;
		
		while (respuesta != 6) {
			System.out.println("Please choose an option\n"
					+ "1. View customer/employee info\n"
					+ "2. Edit customer info\n"
					+ "3. Edit employee info\\n"
					+ "4. Delete accout\n"
					+ "5. Approve/Deny applications\n"
					+ "6. Loggout");
			respuesta = cin.nextInt();
			switch(respuesta) {
			case 1:
				admService.viewInfo();
				break;
			case 2:
				admService.editCustomerAccount();
				break;
			case 3:
				admService.editEmployeeAccount();
				break;
			case 4:
				admService.cancelAccount();
				break;
			case 5:
				admService.aprooveApplication();
				break;
			default:
				System.out.println("Not an option, please try again\n");
			}
		}
	}

}
