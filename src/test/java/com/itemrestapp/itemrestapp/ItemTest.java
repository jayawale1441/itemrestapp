package com.itemrestapp.itemrestapp;


import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import com.dao.ItemDAO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.model.Item;


@SpringBootTest
class ItemTest {
	
	@Autowired
	ItemDAO dao;
	
	
	@BeforeEach
	void setUp() {
		
		
	}
	/*
	@Test
	void test() {
		Item item=new Item();
		item.setItemName("Coffee");
		item.setPrice(20);
		item.setQuantity(5);
		dao.save(item);
		
		Item item1=dao.findById(item.getItemId()).get();
		
		Assertions.assertEquals(item.getItemName(), item1.getItemName());	
		
	}
	
	@Test
	void testbByPrice() {
		Item item=new Item();
		item.setItemName("Manchow");
		item.setPrice(55);
		item.setQuantity(12);
		dao.save(item);
		
		Item item1=dao.findByPrice(55);
		
		Assertions.assertEquals(item.getPrice(), item1.getPrice());	
		
	}
	
	@Test
    void test1() throws URISyntaxException, JsonProcessingException {
      
       
 
      
      
      RestTemplate template=new RestTemplate();
      final String url="http://localhost:8080/findbyid/1";
      URI uri=new URI(url);
      
      ResponseEntity<String> res=template.getForEntity(uri,String.class);
      Assertions.assertEquals(HttpStatus.OK,res.getStatusCode());
      
  }
  */
	
	@GetMapping(path="/item",produces="application/json")
	public List<Item> getItems() {
		return dao.findAll();
	}
	
	@Test
	public void testgetItems() throws URISyntaxException{
		RestTemplate template=new RestTemplate();
		
		Item i=new Item();
		i.setItemName("Notebook");
		i.setPrice(20);
		i.setQuantity(50);
		dao.save(i);
		
		final String url="http://localhost:8081/getallItems";
		URI uri=new URI(url);
		
		ResponseEntity<List> res=template.getForEntity(uri, List.class);
		Assertions.assertEquals(HttpStatus.OK, res.getStatusCode());
		System.out.println(res.getBody());
		System.out.println(i.toString());
		Assertions.assertEquals(200,res.getStatusCodeValue());
		//Assertions.assertEquals(true,res.getBody().equals(i.toString()));
		
	}
	
	
	
	
	
	

}
