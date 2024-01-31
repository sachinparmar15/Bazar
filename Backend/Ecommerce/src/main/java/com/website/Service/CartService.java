
package com.website.Service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.Repository.CartRepository;
import com.website.Repository.ProductRepository;
import com.website.Repository.UserRepository;
import com.website.model.Cart;
import com.website.model.Cartitem;
import com.website.model.Product;
import com.website.model.User;

import jakarta.transaction.Transactional;

@Service
public class CartService {

	// connecting cartservice with cartcontroller
	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private UserRepository userRepository;

	// function for creating cart
	public Cart createCart(int userId) {

		User user = userRepository.findById(userId).orElse(null);

		Cart cart = new Cart(); // creating new cart
		cart.setUserId(user);
		return cartRepository.save(cart);// saving cart
	}

	// function to getCart
	public Cart getCart(int userId) {

		return cartRepository.findByUserId(userId); // finding cart by userid
	}

	@Transactional  //It ensures that either all operations within the method succeed, or they all fail
	public void addToCart(int userId, int productId, int quantity) { //addTocart function

		Cart cart = cartRepository.findByUserId(userId); //finding cart by userid

		Product product = productRepository.findById(productId).orElse(null); //finding product by productid

		List<Cartitem> cartItems = cart.getCartitems();

		boolean isPresent = false;

		for (Cartitem cartitem : cartItems) { //traversing cart through each cartitem
			if (cartitem.getProduct().getProductid() == productId) { //if product is already exist in cart
				cartitem.setQuantity(cartitem.getQuantity() + quantity); //then add quantity
				cartRepository.save(cart); //saving cart
				isPresent = true;
				break;
			}
		}

		if (!isPresent) { //if product is not present in cart

			Cartitem cartItem = new Cartitem(); //then add this item in cart
			//setting parameters
			cartItem.setProduct(product); 

			cartItem.setQuantity(quantity);
			cartItem.setCart(cart);
			cart.getCartitems().add(cartItem);

			cart = cartRepository.save(cart); //saving cart
		}
	}

	@Transactional //removefromcart function
	public String removeFromCart(int userId, int productId) {
		try {

			Cart cart = cartRepository.findByUserId(userId); //finding cart by userid

			if (cart != null) { //if there is items in cart item 

				List<Cartitem> cartItems = cart.getCartitems();

				for (Cartitem cartitem : cartItems) { //traversing cartitems
					if (cartitem.getProduct().getProductid() == productId) { //if product matches in cartitem
						cartRepository.removeFromCart(cartitem.getId()); //removing from cart
						return "removed";
					}
				}
			}
			return "not removed"; 
		} catch (Exception e) {
			throw new RuntimeException("Error removing product from cart", e); //error
		}
	}

	//changequantity api
	public void changeQuantity(int userId, int productId, int quantity) {
		Cart cart = cartRepository.findByUserId(userId); //finding cart by userid

		for (Cartitem cartItem : cart.getCartitems()) {
			if (cartItem.getProduct().getProductid() == productId) { //if product found in a cart
				cartItem.setQuantity(quantity); 

			
				cartRepository.save(cart); //saving cart

				break;
			}
		}
	}

}