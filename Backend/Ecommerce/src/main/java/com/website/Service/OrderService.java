
package com.website.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.model.Cart;
import com.website.model.Cartitem;
import com.website.model.Order;
import com.website.model.OrderItem;
import com.website.model.User;
import com.website.Repository.CartRepository;
import com.website.Repository.OrderRepository;
import com.website.Repository.UserRepository;

@Service
public class OrderService {

	//connecting orderrepository with orderservice
	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	public List<Order> getOrderByUserId(int userid) {
		return orderRepository.getOrderByUserid(userid);
	}
	
	

	//createorder function
	public int createOrder(int userid) {

		Order order = new Order(); //generating order

		User user = userRepository.findById(userid).orElseThrow(); //finding user by userid
		order.setUserid(user); //setting userid 

		Cart cart = cartRepository.findByUserId(userid); //getting cart from cartrepository
		
		 if (cart == null || cart.getCartitems().isEmpty()) { //if cart does not contain any item 
		      
		        throw new RuntimeException("Cart is empty. Cannot create an order."); //showing error
		    }

		List<Cartitem> cartItems = cart.getCartitems(); 
	
		for (Cartitem cartItem : cartItems) { //traversing cart
			
			OrderItem orderItem = new OrderItem();
			
			//setting parameters in orderitem using cartitem
			orderItem.setProduct(cartItem.getProduct());
			
			orderItem.setQuantity(cartItem.getQuantity());
			
			orderItem.setOrder(order);
			orderItem.setOrderPrice(cartItem.getProduct());
			
			order.getOrderItems().add(orderItem);
		
		}
		
		Order response = orderRepository.save(order);
		
		 cart.getCartitems().clear();
		    cartRepository.save(cart);

		    
		
		return response.getOrderid();

		

	}
	
	
	//getAllorders function  
	public List<Order> getAllOrders() {
		List<Order> allOrders =  orderRepository.findAll();
		return allOrders;
	}
	
	

}