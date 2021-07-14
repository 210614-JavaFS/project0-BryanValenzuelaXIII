package com.revature.models;

public class Employee extends User{

	public Employee() {
		super();
		this.setType(Type.EMPLOYEE);
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String username, String password) {
		super(name, username, password);
		this.setType(Type.EMPLOYEE);
		// TODO Auto-generated constructor stub
	}
	
	//public void 
}