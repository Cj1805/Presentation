package com.example.database.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.database.entity.Employee;
import com.example.database.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
    private EmployeeService empService;

    @PostMapping("/save")
    public ResponseEntity<Void> addUser(@RequestBody Employee emp) {
        try {
        	empService.addUser(emp);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllUsers() {
        try {
            List<Employee> users = empService.getAllUsers();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{fname}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String fname ) {
        try {
            List<Employee> emp = empService.findByName(fname);
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/last/{lname}")
    public ResponseEntity<List<Employee>> findByLastName(@PathVariable String lname ) {
        try {
            List<Employee> emp = empService.findByLastName(lname);
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/greater/{id}")
    public ResponseEntity<List<Employee>> findByGreaterId(@PathVariable int id ) {
        try {
            List<Employee> emp = empService.findByIdGreater(id);
            return new ResponseEntity<>(emp, HttpStatus.OK);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable int userId) {
        try {
        	empService.deleteUser(userId);
            return new ResponseEntity<>(HttpStatus.GONE);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

