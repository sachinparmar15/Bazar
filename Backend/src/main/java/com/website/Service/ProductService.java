package com.website.Service;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.website.Repository.ProductRepository;
import com.website.model.Product;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductService {

	//connecting productrepository with this service
	@Autowired
	private ProductRepository productRepository;

	
	//addproduct function
	public Product addProduct(Product product) { // taking product as a input
		System.out.println("product creating");
		return productRepository.save(product); //saving updated product
	}

	//updateProduct function
	public Product updateProduct(Product updatedProduct) { //taking updated product as a input

		return productRepository.save(updatedProduct); //saving updated product
	}

	//getproductbyid function
	public Product getProductById(int productId) {//taking productId as a input
		return productRepository.findById(productId).orElse(null); //finding product by productid
	}

	//getproductsbycategory function to find product by category
	public List<Product> getProductsByCategory(String category) { //taking category as a input
		return productRepository.findByCategory(category); //searching products with this category	
	}

	//function fo gettinf all prodyuct
	public List<Product> getAllProducts() {
		
		return productRepository.findAll(); //it will dsplay all product in frontend
	}

	//function for geting product by seaching 
	public List<Product> getProductsBySearchString(String searchString) { //taking searched value as a input
		return productRepository.findByNameContainingOrDetailsContainingOrCategoryContaining(searchString, searchString,
				searchString); //find searched value in name, details and category of a product 
	}
	
	//function for getting filtered product
	//taking input as  a min value, max value and orderby 
	 public List<Product> getFilteredProducts(String category, int maxValue, int minValue, String orderBy) { 
	        
		    List<Product> products;

	        // Filter by category
	        if (category != null) {
	            products = productRepository.findByCategory(category);
	        } else {
	            // If category is not provided, get all products
	            products = productRepository.findAll();
	        }

	        // Filter by price range
	        if (maxValue > 0 && minValue >= 0) {
	            products = products.stream() // It creates a stream from the products list
	            		//This is a lambda expression defining the condition. It checks if the product's price is within the specified range 
	                    .filter(product -> product.getPrice() >= minValue && product.getPrice() <= maxValue)
	                    .collect(Collectors.toList());//collect the filtered stream back into the list
	        }

	        // Apply ordering
	        if (orderBy != null) {
	            switch (orderBy.toLowerCase()) {
	                case "name":
	                	//sorting product according t name 
	                    products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
	                    break;	                    
	                case "namedesc":
	                    // Sorting product according to name in descending order
	                    products.sort((p1, p2) -> p2.getName().compareToIgnoreCase(p1.getName()));
	                    break;
	                    
	                case "price":
	                	//Sorting products by price
	                    products.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())); 
	                    break;
	                case "pricedesc":
	                    // Sorting products by price in descending order
	                    products.sort((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()));
	                    break;
	                // Add more cases for other fields if needed
	                default:
	                    // Default sorting if the provided field is not recognized
	                    products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
	                    break;
	            }
	        }

	        return products;
	    }

}
