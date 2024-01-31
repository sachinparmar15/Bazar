
package com.website.Controller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.website.Service.CartService;
import com.website.model.Cart;
//import com.website.model.Cartitem;

@CrossOrigin("*") //Allows cross-origin resource sharing from any origin
@RestController   // Indicates that this class is a REST controller
@RequestMapping("/cart")
public class CartController {

	//connecting carservice with cartcontroller 
    @Autowired
    private CartService cartService;

    //getcart api
    @GetMapping("/{userId}/getCart")
    public ResponseEntity<Cart> getCart(@PathVariable int userId) {
        Cart cart = cartService.getCart(userId);
        if (cart != null) {//if cartitem exist
            return ResponseEntity.ok(cart);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    //api for creating cart
    @PostMapping("{userid}/createCart")
    public void createCart(@PathVariable int userid) {
    	cartService.createCart(userid);
    }


    //addTocart api
    @GetMapping("/{userId}/add/{productId}/qty/{quantity}")
    public ResponseEntity<String> addToCart(@PathVariable int userId, @PathVariable int productId, @PathVariable int quantity) {
        cartService.addToCart(userId, productId,quantity);
        return ResponseEntity.ok("Success");
    }
    
    //removefromcart api
    @GetMapping("/{userId}/remove/{productId}")
    public ResponseEntity<String> removeFromCart(@PathVariable int userId, @PathVariable int productId) { //taking userid and productid as a input
        try {
            String result = cartService.removeFromCart(userId, productId);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            
            return ResponseEntity.status(500).body("Error removing product from cart");//returning error
        }
    }
 
    

    //api for changing quantity
    @PostMapping("/{userId}/changeQuantity/{productId}")
    public ResponseEntity<String> changeQuantity(@PathVariable int userId, @PathVariable int productId, @RequestBody int quantity) { //taking userid,quantity and productid as a input
      
    	cartService.changeQuantity(userId, productId, quantity);
        return ResponseEntity.ok("quantity has been changed");
    }
}
