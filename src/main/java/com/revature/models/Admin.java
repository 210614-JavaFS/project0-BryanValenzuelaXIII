package com.revature.models;

public class Admin extends User {

	public Admin() {
		super();
		this.setType(Type.ADMIN);
		// TODO Auto-generated constructor stub
	}

	public Admin(String name, String username, String password) {
		super(name, username, password);
		this.setType(Type.ADMIN);
		// TODO Auto-generated constructor stub
	}
	
	
	
}
