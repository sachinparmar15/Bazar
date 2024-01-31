
package com.website.Repository;

import com.website.model.Order;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;




@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
	

	//custom query to get order by userid
	@Query("SELECT o FROM Order o WHERE o.userid.userid = :userid")
	List<Order> getOrderByUserid(@Param("userid") int userid);
	
	
}