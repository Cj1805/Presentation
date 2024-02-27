package com.example.database.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Employee;

@Repository
public class EmployeeRepository {

	private final DataSource dataSource;

	@Autowired
	public EmployeeRepository(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void addUser(Employee user) throws SQLException {
		String query = "INSERT INTO employee (first_name, last_name, email, city) VALUES (?, ?, ?, ?)";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getCity());
			statement.executeUpdate();
		}
	}

	public List<Employee> getAllUsers() throws SQLException {
		List<Employee> users = new ArrayList<>();
		String query = "SELECT * FROM employee";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query);
				ResultSet resultSet = statement.executeQuery()) {
			while (resultSet.next()) {
				Employee user = new Employee();
				user.setId(resultSet.getInt("id"));
				user.setFirstName(resultSet.getString("first_name"));
				user.setLastName(resultSet.getString("last_name"));
				user.setEmail(resultSet.getString("email"));
				user.setCity(resultSet.getString("city"));
				users.add(user);
			}
		}
		return users;
	}

	 public List<Employee> findByName(String firstName) throws SQLException {
	        List<Employee> employees = new ArrayList<>();
	        String query = "SELECT * FROM employee WHERE first_name = ?";
	        try (Connection connection = dataSource.getConnection();
	             PreparedStatement statement = connection.prepareStatement(query)) {
	            statement.setString(1, firstName);
	            try (ResultSet resultSet = statement.executeQuery()) {
	                while(resultSet.next()) {
	                 Employee employee = new Employee();
	                    employee.setId(resultSet.getInt("id"));
	                    employee.setFirstName(resultSet.getString("first_name"));
	                    employee.setLastName(resultSet.getString("last_name"));
	                    employee.setEmail(resultSet.getString("email"));
	                    employee.setCity(resultSet.getString("city"));
	                    employees.add(employee);
	                }
	            }
	        }
	        return employees;
	    }
	
	public void deleteUser(int userId) throws SQLException {
		String query = "DELETE FROM employee WHERE id = ?";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setInt(1, userId);
			statement.executeUpdate();
		}
	}

}
