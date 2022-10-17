package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.dao.ItemDAO;
import com.model.Item;

@RestController
public class ItemRestController {
	@Autowired
	ItemDAO dao;
	
	
	@GetMapping("/homeinfo")
	public String gethomeinfo(){
		return "Home for Itemrestcontroller api is workin fine";
	}
		
	
	
	@PostMapping("/additem")
	public ResponseEntity addItem(@RequestBody Item item) {
		
		dao.save(item);
		
		return new ResponseEntity<String>("item added successfully",HttpStatus.OK);
	}
	
	@GetMapping("/getallItems")
	public List<Item> getAllItems(){
		return dao.findAll();
	}
	
	@PatchMapping("/updateitem")
	public ResponseEntity updateItem(@RequestBody Item item) {
		dao.save(item);
		return new ResponseEntity<String>("Entity updated",HttpStatus.OK);
	}

	@DeleteMapping("/deleteitem")
	public ResponseEntity deleteItem(@RequestBody Item item) {
		dao.delete(item);
		return new ResponseEntity<String>("Item deleted",HttpStatus.OK);
	}
	
	@GetMapping("/findbyid/{id}")
	public Optional<Item> getItem(@PathVariable int id) {
		Optional<Item> item=dao.findById(id);
		//OR Item item=dao.findById(id).get;
		return item;
		
	}
}
