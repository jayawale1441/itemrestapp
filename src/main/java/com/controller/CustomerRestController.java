package com.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dao.CustomerDAO;
import com.model.Customer;
import com.model.Item;



@RestController
public class CustomerRestController {
	@Autowired
	CustomerDAO dao;
		
	
	
	@PostMapping("/addcustomer")
	public ResponseEntity addCustomer(@RequestBody Customer customer) {
		
		dao.save(customer);
		
		return new ResponseEntity<String>("Customer added successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getallCustomer")
	public List<Customer> getAllCustomer(){
		return dao.findAll();
	}
	
	@PatchMapping("/updatecustomer")
	public ResponseEntity updateItem(@RequestBody Customer customer) {
		dao.save(customer);
		return new ResponseEntity<String>("Entity updated",HttpStatus.OK);
	}

	@DeleteMapping("/deletecustomer")
	public ResponseEntity deleteCustomer(@RequestBody Customer customer) {
		dao.delete(customer);
		return new ResponseEntity<String>("Customer deleted",HttpStatus.OK);
	}
	
	@GetMapping("/findbycustomerid/{id}")
	public Optional<Customer> getCustomer(@PathVariable int id) {
		Optional<Customer> customer=dao.findById(id);
		//OR Item item=dao.findById(id).get;
		return customer;
		
	}
	
}
	
