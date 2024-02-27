package com.example.database.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.database.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {
	
	 List<Employee> findByFirstNameIgnoringCase(String firstName);
	 
	 @Query(value = "SELECT * FROM employee where last_name = :lastName ", nativeQuery = true)
	 List<Employee> findByLastName(String lastName);
	 
	 
	 @Query(value = "SELECT * FROM employee where id > :id ", nativeQuery = true)
	 List<Employee> findByIdGreater(int id);

}


	

