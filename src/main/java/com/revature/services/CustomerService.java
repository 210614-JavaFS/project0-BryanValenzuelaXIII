package com.revature.services;
// All the logic
import java.util.List;
import java.util.Scanner;

import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;

public class CustomerService {
	
	private static UserDAO userDAO = new UserDAOImpl();
	
	public List<Customer> getAllUsers(){
		
		return userDAO.finaAllCustomers();
		}
		
	public void deposit(Customer cus) {
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("How much are you depositing? ");
		   double ammount = sc.nextDouble();
		
		if (ammount < 0) 
			System.out.println("Sorry, you can not deposit negative or zero dollars!"
					+ "\n you can withdraw in the other option");
		else {
			System.out.println("Which account do you want to deposit to?\n"
					+ "1. Checkings");
			if (cus.getSavings() > 0)
				System.out.println("2. Savings");
			
			int decision = sc.nextInt();
			
			switch(decision) {
			case 1: cus.setChecking(ammount + cus.getChecking());
				if(userDAO.updateMoney(cus))
					System.out.println("Your checking account now have $"
							+ cus.getChecking());
					break;
					
			case 2: if (cus.getSavings() > 0) { 
				if(userDAO.updateMoney(cus))
					cus.setSavings(ammount + cus.getSavings());
					System.out.println("Your saving account now have $"
							+ cus.getSavings());
					}
					else
						System.out.println("Invalid option, returning to main menu");
					break;
			default:
				System.out.println("Invalid option, returning to main menu");
			}
				
		}
	}
	
   public void withdraw(Customer cus) {
	   
	   System.out.println("Your balance is: checkings $"
	   		+ cus.getChecking());
   		if (cus.getSavings() > 0) 
   			System.out.println("Your balance is: savings $" + cus.getSavings());
   			
	   Scanner sc = new Scanner(System.in);
	   
	   System.out.println("How much are you withdrawing? ");
	   double ammount = sc.nextDouble();
	   
	   
	   if (ammount < 0) 
			System.out.println("Sorry, you can not withdraw negative or zero dollars!"
					+ "\n you can deposit in the other option");
	   else {
		   System.out.println("Which account do you want to withdraw from?\n"
					+ "1. Checkings ");
			if (cus.getSavings() > 0)
				System.out.println("2. Savings ");
			
			int decision = sc.nextInt();
			
			switch(decision) {
			
			case 1: if(cus.getChecking() >= ammount) {
					cus.setChecking(cus.getChecking() - ammount);
					if(userDAO.updateMoney(cus))
					System.out.println("Your checking account now have $"
							+ cus.getChecking());
					}
					else
						System.out.println("You don'thave enough money to withdraw that ammount"
								+ "returning to main menu");
					break;
					
			case 2: if (cus.getSavings() > 0) { 
						if (cus.getSavings() > ammount){
					cus.setSavings(cus.getSavings() - ammount);
					if(userDAO.updateMoney(cus))
					System.out.println("Your savings account now have $"
							+ cus.getSavings());
						}
						else 
							System.out.println("You don'thave enough money to withdraw that ammount");
					}
					else
						System.out.println("Invalid option, returning to main menu"
								+ "returning to main menu");
					break;
			default:
				System.out.println("Invalid option, returning to main menu");
			}
	   }
   }
   
   public void transfer (Customer cus1) {
	   System.out.println("Your balance is: checkings $"
		   		+ cus1.getChecking());
	   		if (cus1.getSavings() > 0) 
	   			System.out.println("Your balance is: savings $" + cus1.getSavings());
	   boolean savings = false;
	   if (cus1.getSavings() > 0)
		   savings = true;
	   if (savings) {
		   System.out.println("Do you want to trasnfer money from: 1. Checkings to Savings\n"
		   		+ "2. Savings to Checkings");
		   Scanner sc = new Scanner(System.in);
		   
		   int decision = sc.nextInt();
		   
		   System.out.println("How much are you transfering?");
		   double ammount = sc.nextDouble();
		   
			switch(decision) {
			
			case 1: if(cus1.getChecking() >= ammount) {
				if(userDAO.updateMoney(cus1))
					cus1.setChecking(cus1.getChecking() - ammount);
					cus1.setSavings(ammount + cus1.getSavings());
					System.out.println("Your checking account now have $"
							+ cus1.getChecking());
					System.out.println("Your Saving account now have $"
							+ cus1.getSavings());
					}
					else
						System.out.println("You don'thave enough money to transfer that ammount"
								+ "returning to main menu");
					break;
					
			case 2: if (cus1.getSavings() > ammount){
					cus1.setSavings(cus1.getSavings() - ammount);
					cus1.setChecking(ammount + cus1.getChecking());
					if(userDAO.updateMoney(cus1))
					System.out.println("Your checking account now have $"
							+ cus1.getChecking());
					System.out.println("Your Saving account now have $"
							+ cus1.getSavings());
						}
						else 
							System.out.println("You don'thave enough money to transfer that ammount");
					
					break;
			default:
				System.out.println("Invalid option, returning to main menu");
			}
			}
	   else
		   System.out.println("You do not have a savings account, returning to main menu");
	   }
   
   public void transferToOther(Customer cus) {
	   System.out.println("Your balance is: checkings $"
		   		+ cus.getChecking());
	   		if (cus.getSavings() > 0) 
	   			System.out.println("Your balance is: savings $" + cus.getSavings());
	   			
		   Scanner sc = new Scanner(System.in);
		   
		   System.out.println("How much are you Transfering? ");
		   double ammount = sc.nextDouble();
		   
		   if (ammount < 0) 
				System.out.println("Sorry, you can not withdraw negative or zero dollars!"
						+ "\n you can deposit in the other option");
		   else {
			   System.out.println("Which account do you want to withdraw from?\n"
						+ "1. Checkings ");
				if (cus.getSavings() > 0)
					System.out.println("2. Savings ");
				
				int decision = sc.nextInt();
				
				UserDAOImpl todos = new UserDAOImpl();
				//List <Customer> prros = todos.finaAllCustomers();
				String cuentaDos;
				
				switch(decision) {
				
				case 1: if(cus.getChecking() >= ammount) {
							System.out.println("Please enter the username you are transfering the money");
							sc.nextLine();
							cuentaDos = sc.nextLine();
							Customer cus2 = todos.findByUsernameCustomer(cuentaDos);;
							
							cus.setChecking(cus.getChecking() - ammount);
							cus2.setChecking(cus2.getChecking() + ammount);
							if(userDAO.updateMoney(cus))
								userDAO.updateMoney(cus2);
						}
						else
							System.out.println("You don'thave enough money to withdraw that ammount"
									+ "returning to main menu");
						break;
						
				case 2: if (cus.getSavings() > 0) { 
							if (cus.getSavings() > ammount){
								System.out.println("Please enter the username you are transfering the money");
								sc.nextLine();
								cuentaDos = sc.nextLine();
								Customer cus2 = todos.findByUsernameCustomer(cuentaDos);
								
								cus.setChecking(cus.getSavings() - ammount);
								cus2.setChecking(cus2.getChecking() + ammount);
								if(userDAO.updateMoney(cus))
									userDAO.updateMoney(cus2);
							}
							else 
								System.out.println("You don'thave enough money to withdraw that ammount");
						}
						else
							System.out.println("Invalid option, returning to main menu"
									+ "returning to main menu");
						break;
				default:
					System.out.println("Invalid option, returning to main menu");
				}
		   }
   }
   
   public void openSavings(Customer cus) {
	   if (cus.getSavings() > 0 ) { 
		   System.out.println("You already have a saving account or you do not have enough founds to open "
		   		+ "a saving account");
	   }
	   else {
	   	   System.out.println("You have to at least deposit $100 to open a saving account.\n"
	   	   		+ "Do you want to transfer $100 from your checking account?"
	   	   		+ "1. Yes \n 2.No");
	   	   
	   	Scanner sc = new Scanner(System.in);
	   	
	   	int respuesta = sc.nextInt();
	   	if(respuesta == 1) {
	   		if(cus.getChecking() >= 100) {
	   			cus.setChecking(cus.getChecking() - 100);
	   			cus.setSavings(100);	   	
	   			userDAO.updateMoney(cus);
	   		}
	   		else
	   			System.out.println("You don't have enough funds");
	   	}
	   	
	   }
   }
   
   public void jointAccounts(Customer cus) {
	   System.out.println("What is the username you want to join accounts with?");
	   Scanner sc = new Scanner(System.in);
	   UserDAOImpl todos = new UserDAOImpl();
	   String cuentaDos = sc.nextLine();
	   Customer cus2 = todos.findByUsernameCustomer(cuentaDos);
   }
   
   private static void updateUser(Customer cus) {
	   //update account
   }
	   
}
