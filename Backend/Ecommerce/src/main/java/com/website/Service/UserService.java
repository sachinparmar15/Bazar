package com.website.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.website.Repository.UserRepository;
import com.website.Repository.CartRepository;
import com.website.model.User;

@Service
public class UserService {

	//connect userrepository with userservice
	@Autowired
	private UserRepository userrepository;
	@Autowired
	private UserRepository cartrepository;
	
	
    //login function
	public int login(String email, String password) {
		User user = userrepository.findByEmail(email); //finding user by email
        
		//applying condition if user is not null
		if (user != null) {
			if (password.equals(user.getPassword())) {   //matching password after getting user
				return user.getUserid();     //returning userid of that user
			} else {
				return 0;  //if password does not match 
			}
		}

		return 0; //if user with this email not found
	}

	//signup function
	public User signup(User user) {
		return userrepository.save(user);   //saving user once he/she completed sinup process
		
	}

	//getprofile function
	public User getProfile(int userId) {//taking userid as a input

		User user = userrepository.findById(userId).orElse(null); //finding user with this userid 

		return user;
	}

	//logout function
	public String logout() {

		return "Logout successful";
	}

	//update function 
	public boolean updateProfile(User updatedUser) { //passing updated user as input
		User existingUser = userrepository.findById(updatedUser.getUserid()).orElse(null);//searching by id 

		if (existingUser != null) {   //if user with this id is found

			//saving changes 
			existingUser.setName(updatedUser.getName());  
			existingUser.setEmail(updatedUser.getEmail());
			existingUser.setPhone(updatedUser.getPhone());
			existingUser.setAddress(updatedUser.getAddress());

			userrepository.save(existingUser);  //saving updated fields
			return true;   
			
		} else {  //if user not found or null
			return false;
		}
	}

}
