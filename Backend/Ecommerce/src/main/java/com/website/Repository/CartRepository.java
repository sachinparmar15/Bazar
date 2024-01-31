
package com.website.Repository;

import com.website.model.Cart;


import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;



@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

	//custom query to find cart by userid 
	@Query("SELECT c FROM Cart c WHERE c.user.userid= :userid ")
	Cart findByUserId(int userid);
	

	
	@Transactional //It ensures that either all operations within the method succeed, or they all fail
	@Modifying //it is used to indicate that a method modifies the database state
	@Query("DELETE FROM Cartitem c WHERE c.id = :cartitemid") //query to remove cartitem from cart
	void removeFromCart(@Param("cartitemid") int cartitemid);

}
