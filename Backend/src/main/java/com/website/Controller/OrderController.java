
package com.website.Controller;

import com.website.model.Order;

//import com.website.model.OrderItem;
import com.website.Service.OrderService;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin("*") //Allows cross-origin resource sharing from any origin
@RestController   // Indicates that this class is a REST controller
@RequestMapping("/order")
public class OrderController {

	//connecting orderservice with ordercontroller
	@Autowired
	private OrderService service;

	//get orders api
	@GetMapping("/{userid}/getOrders")
	public List<Order> getOrderHistory(@PathVariable int userid) {//taking userid as a input
		
		List<Order> orders = service.getOrderByUserId(userid);
		Collections.reverse(orders);

		return orders;
	}
	

	//api for creating order
	@GetMapping("/{userid}/createOrder")
	public ResponseEntity<Integer> createOrder(@PathVariable int userid) { //taking userid as a input

		int orderid = service.createOrder(userid);
		return ResponseEntity.ok(orderid);
	}
	
	
	//api for getting all order. It is for admin use only
	@GetMapping("/allOrders")
	public ResponseEntity<List<Order>> getAllOrders(){
		List<Order> allOrders = service.getAllOrders();
		return ResponseEntity.ok(allOrders);		
	}	
	

}