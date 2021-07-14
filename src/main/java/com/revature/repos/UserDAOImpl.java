package com.revature.repos;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.Connection.ConnectionUtil;
import com.revature.models.Admin;
import com.revature.models.Customer;
import com.revature.models.Employee;
import com.revature.models.NewUser;
import com.revature.models.User;

public class UserDAOImpl implements UserDAO {

	@Override
	public List<Employee> finaAllEmployees() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employee";
					
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Employee> list = new ArrayList<>();
			
			while(result.next()) {
				Employee user = new Employee();
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("pass"));
				list.add(user);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Employee findByUsernameEmployee(String name) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM employee WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//This is where SQL injection is checked for.
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			Employee user = new Employee();
			
			while(result.next()) {
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("pass"));
			}
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Customer> finaAllCustomers() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customer";
					
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Customer> list = new ArrayList<>();
			
			while(result.next()) {
				Customer user = new Customer();
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("pass"));
				user.setChecking(result.getDouble("checkings"));
				user.setSavings(result.getDouble("savings"));
				list.add(user);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Customer findByUsernameCustomer(String name) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customer WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//This is where SQL injection is checked for.
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			Customer user = new Customer();
			
			while(result.next()) {
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("pass"));
				user.setChecking(result.getDouble("checkings"));
				user.setSavings(result.getDouble("savings"));
			}
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Admin> finaAllAdmins() {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM customer";
					
			Statement statement = conn.createStatement();
			
			ResultSet result = statement.executeQuery(sql);
			
			List<Admin> list = new ArrayList<>();
			
			while(result.next()) {
				Admin user = new Admin();
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("pass"));
				list.add(user);
			}
			
			return list;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}

	@Override
	public Admin findByUsernameAdmins(String name) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM admins WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//This is where SQL injection is checked for.
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			Admin user = new Admin();
			
			while(result.next()) {
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("pass"));
			}
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public boolean updateMoney(Customer cus) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE customer SET checkings = ? WHERE username = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setFloat(++index,(float) cus.getChecking());
			statement.setString(++index, cus.getUsername());
			
			statement.execute();
			
			sql = "UPDATE customer SET savings = ? WHERE username = ?;";
			
			statement = conn.prepareStatement(sql);
			
			index = 0;
			statement.setFloat(++index,(float) cus.getSavings());
			statement.setString(++index, cus.getUsername());
			
			statement.execute();
			return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
	}
	
	public boolean deleteCustomer(Customer cus) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM customer WHERE username = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, cus.getUsername());
			
			statement.execute();
			
			return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
	}
	
	public boolean deleteEmployee(Employee cus) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM employee WHERE username = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, cus.getUsername());
			
			statement.execute();
			
			return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public boolean updateInfor(Customer cus) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE customer SET name = ? WHERE username = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, cus.getName());
			statement.setString(++index, cus.getUsername());
			
			statement.execute();
			
			sql = "UPDATE customer SET username = ? WHERE name = ?;";
			
			statement = conn.prepareStatement(sql);
			
			index = 0;
			statement.setString(++index, cus.getUsername());
			statement.setString(++index, cus.getName());
			
			statement.execute();
			
			sql = "UPDATE customer SET pass = ? WHERE username = ?;";
			
			statement = conn.prepareStatement(sql);
			
			index = 0;
			statement.setString(++index, cus.getPassword());
			statement.setString(++index, cus.getUsername());
			
			statement.execute();
			return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
		
	}

	@Override
	public boolean updateInfor(Employee cus) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "UPDATE employee SET name = ? WHERE username = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, cus.getName());
			statement.setString(++index, cus.getUsername());
			
			statement.execute();
			
			sql = "UPDATE employee SET username = ? WHERE name = ?;";
			
			statement = conn.prepareStatement(sql);
			
			index = 0;
			statement.setString(++index, cus.getUsername());
			statement.setString(++index, cus.getName());
			
			statement.execute();
			
			sql = "UPDATE employee SET pass = ? WHERE username = ?;";
			
			statement = conn.prepareStatement(sql);
			
			index = 0;
			statement.setString(++index, cus.getPassword());
			statement.setString(++index, cus.getUsername());
			
			statement.execute();
			return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public boolean applyUser(NewUser cus) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO newUser (name, username, pass, income, startingAmmount)"
					+ " VALUES (?,?,?,?,?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, cus.getName());
			statement.setString(++index, cus.getUsername());
			statement.setString(++index, cus.getPassword());
			statement.setFloat(++index, (float)cus.getIncome());
			statement.setFloat(++index, (float)cus.getStartingAmmount());
			
			statement.execute();
			
			return true;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<NewUser> finaAllNewUser() {
			try(Connection conn = ConnectionUtil.getConnection()){
				String sql = "SELECT * FROM newuser";
						
				Statement statement = conn.createStatement();
				
				ResultSet result = statement.executeQuery(sql);
				
				List<NewUser> list = new ArrayList<>();
				
				while(result.next()) {
					NewUser user = new NewUser();
					user.setName(result.getString("name"));
					user.setUsername(result.getString("username"));
					user.setPassword(result.getString("pass"));
					user.setIncome(result.getDouble("income"));
					user.setStartingAmmount(result.getDouble("startingAmmount"));
					list.add(user);
				}
				
				return list;
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return null;
	}

	@Override
	public NewUser findByUsernameNew(String name) {
		try(Connection conn = ConnectionUtil.getConnection()){
			String sql = "SELECT * FROM newuser WHERE username = ?;";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			//This is where SQL injection is checked for.
			statement.setString(1, name);
			
			ResultSet result = statement.executeQuery();
			
			NewUser user = new NewUser();
			
			while(result.next()) {
				user.setName(result.getString("name"));
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("pass"));
				user.setIncome(result.getDouble("income"));
				user.setStartingAmmount(result.getDouble("income"));
			}
			return user;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean deleteNewUser(NewUser cus) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "DELETE FROM newuser WHERE username = ?;";
		
			PreparedStatement statement = conn.prepareStatement(sql);
			
			statement.setString(1, cus.getUsername());
			
			statement.execute();
			
			return true;
	}catch(SQLException e) {
		e.printStackTrace();
	}
	return false;
	}

	@Override
	public boolean aprooveUser(NewUser cus) {
		try (Connection conn = ConnectionUtil.getConnection()){
			String sql = "INSERT INTO customer (name, username, pass, checkings)"
					+ "	VALUES(?, ?, ?, ?);";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			
			int index = 0;
			statement.setString(++index, cus.getName());
			statement.setString(++index, cus.getUsername());
			statement.setString(++index, cus.getPassword());
			statement.setFloat(++index, (float)cus.getStartingAmmount());
			
			statement.execute();
			
			return true;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
