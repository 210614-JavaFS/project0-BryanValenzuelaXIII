package com.revature.models;

public class NewUser extends User{
	private double income;
	private double startingAmmount;
	
	public NewUser(String name, String username, String password, double income, double startingAmmount) {
		super(name, username, password);
		this.income = income;
		this.startingAmmount = startingAmmount;
	}
	public NewUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getStartingAmmount() {
		return startingAmmount;
	}
	public void setStartingAmmount(double startingAmmount) {
		this.startingAmmount = startingAmmount;
	}
	@Override
	public String toString() {
		return "NewUser [username=" + this.getUsername() + ", income=" + income + ", startingAmmount=" + startingAmmount + "]";
	}
	
	
	
}
