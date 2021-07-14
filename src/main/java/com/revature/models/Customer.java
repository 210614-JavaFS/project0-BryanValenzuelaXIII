package com.revature.models;

public class Customer extends User{
	
	private double checking;
	private double savings = -1;
	private boolean joint = false;
	private String partner = "";
	
	public Customer(String name, String username, String password,  double checking, double savings) {
		super(password, password, password);
		this.checking = checking;
		this.savings = savings;
		this.setType(Type.CUSTOMER);
	}

	public Customer() {
		super();
		this.setType(Type.CUSTOMER);
		// TODO Auto-generated constructor stub
	}

	public double getChecking() {
		return checking;
	}

	public void setChecking(double checking) {
		this.checking = checking;
	}

	public double getSavings() {
		if (this.savings  < 0)
			System.out.println("Sorry, you don't have a savings accounts");
		return savings;
	}

	public void setSavings(double savings) {
		this.savings = savings;
	}
	
	
	public boolean getJoint() {
		return joint;
	}
	
	public void setJoint(boolean joint) {
		this.joint = joint;
	}
	
	public void setPartner(String partner) {
		if (this.getJoint())
			this.partner = partner;
		else
			System.out.println("This function is not permitted");
	}
	public String getPartner() {
		return partner;
	}
}
