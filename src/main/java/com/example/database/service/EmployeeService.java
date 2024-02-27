package com.example.database.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.database.entity.Employee;
import com.example.database.repository.EmpRepository;
import com.example.database.repository.EmployeeHibernateRepository;
import com.example.database.repository.EmployeeRepository;

@Service
public class EmployeeService {

//	@Autowired
//    private EmployeeRepository empRepository;

//	@Autowired
//	private EmployeeHibernateRepository empRepository;
	
	@Autowired
	private EmpRepository empRepository;
	

//	public void addUser(Employee user) throws SQLException {
//		empRepository.addUser(user);
//	}
//
//	public List<Employee> getAllUsers() throws SQLException {
//		return empRepository.getAllUsers();
//	}
//
//	public void deleteUser(int userId) throws SQLException {
//		empRepository.deleteUser(userId);
//	}
//	
//	public List<Employee> findByName(String fname) throws SQLException{
//		return empRepository.findByName(fname);
//	}
	
	public void addUser(Employee user) throws SQLException {
		empRepository.save(user);
	}

	public List<Employee> getAllUsers() throws SQLException {
		return empRepository.findAll();
	}

	public void deleteUser(int userId) throws SQLException {
		empRepository.deleteById(userId);
	}

	public List<Employee> findByName(String fname) throws SQLException{
		return empRepository.findByFirstNameIgnoringCase(fname);
	}
	
	public List<Employee> findByLastName(String lname) throws SQLException{
		return empRepository.findByLastName(lname);
	}
	
	public List<Employee> findByIdGreater(int id) throws SQLException{
		return empRepository.findByIdGreater(id);
	}
	
}
