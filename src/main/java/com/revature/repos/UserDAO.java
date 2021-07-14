package com.revature.repos;

import java.util.List;

import com.revature.models.*;

public interface UserDAO {
	
	public List<Employee> finaAllEmployees();
	public Employee findByUsernameEmployee(String name);
	
	public List<Customer> finaAllCustomers();
	public Customer findByUsernameCustomer(String name);
	
	public List<Admin> finaAllAdmins();
	public Admin findByUsernameAdmins(String name);
	
	public List<NewUser> finaAllNewUser();
	public NewUser findByUsernameNew(String name);

	public boolean updateMoney(Customer cus);
	public boolean updateInfor(Customer cus);
	public boolean updateInfor(Employee cus);
	
	public boolean deleteEmployee(Employee cus);
	public boolean deleteCustomer(Customer cus);
	public boolean deleteNewUser(NewUser cus);
	
	public boolean applyUser(NewUser cus);
	public boolean aprooveUser(NewUser cus);
}
