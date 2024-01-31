package com.website.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.DTO.LoginValue;
import com.website.Service.CartService;
import com.website.Service.UserService;
import com.website.model.User;

@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {

	//connect userservice with usercontroller
	@Autowired
	private UserService service;
	
	@Autowired
	private CartService cartservice;

	//login api
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginValue loginValue) {
         
		//passing email and password in userid
		int userid = service.login(loginValue.getEmail(),loginValue.getPassword());
		
		
		if (userid != 0) { //returning userid if its not 0;
			return new ResponseEntity<>(userid, HttpStatus.OK);
			
		} else { //returning error if userid = 0
			return new ResponseEntity<>(0,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	//endpoint of signup
	@PostMapping("/signup")
	public ResponseEntity<Integer> signup(@RequestBody User user) {
        
		service.signup(user);//calling signup function in service
		cartservice.createCart(user.getUserid());//creating cart here itself once the user successfully registered in site

		return ResponseEntity.ok(user.getUserid());
		

	}
	
	//endpoint of logout
	@GetMapping("/logout")
    public ResponseEntity<?> logout() {
       service.logout();
        return ResponseEntity.ok("Success");
    }
	
	
	//endpoint of getprofile
	@GetMapping("/getprofile/{userid}")
	public ResponseEntity<User> getUserProfile(@PathVariable int userid) {
	 
		User userProfile = service.getProfile(userid);//calling getprofile dunction in service  
	  
		return ResponseEntity.ok(userProfile);
	}
	
	//endpoint of updateprofile
	@PutMapping("/updateprofile")
    public ResponseEntity<String> updateProfile(@RequestBody User updatedUser) {
        boolean updated = service.updateProfile(updatedUser);

        if (updated) {   //if changes occurs in profile 
            return ResponseEntity.ok("Profile updated successfully");
        } 
        else {
          	//Return internal server error if its not updated
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
	

}
