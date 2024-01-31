package com.website.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.website.Service.ProductService;
import com.website.model.FilterRequest;
import com.website.model.Product;

import java.util.List;


@CrossOrigin("*")   //Allows cross-origin resource sharing from any origin
@RestController // Indicates that this class is a REST controller
@RequestMapping("/products") // Mapping of the controller to the "/products" url
public class ProductController {

	//connecting productservice with controller
	@Autowired
	private ProductService productService;

	//addproduct api
	@PostMapping("/addProduct")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) {
    	
		Product addedProduct = productService.addProduct(product);
		return ResponseEntity.ok(addedProduct);
	}
	

	//update api
	@PostMapping("/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product updatedProduct) {
		Product modifiedProduct = productService.updateProduct(updatedProduct);//saving  updated product as a modified product
		return ResponseEntity.ok(modifiedProduct);
	}

	//api to get product
	@GetMapping("/getById/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable int productId) {
		Product product = productService.getProductById(productId);

		if (product == null) {

			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok(product);
	}
	
	//api for getting all product
	@GetMapping("/allproducts")
	 public ResponseEntity<List<Product>> getAllProducts() { 
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

	//api to get product by category
	@GetMapping("/{category}")
	public ResponseEntity<List<Product>> getProductsByCategory(@PathVariable String category) {
		List<Product> products = productService.getProductsByCategory(category);

		return ResponseEntity.ok(products);
	}

	//searchstring api
	@GetMapping("/search/{searchString}")
	public ResponseEntity<List<Product>> getProductsBySearchString(@PathVariable String searchString) {
		List<Product> products = productService.getProductsBySearchString(searchString);

		return ResponseEntity.ok(products);
	}


	//endpoint for getfilteredproduct api
	@PostMapping("/{category}/getFilteredProducts")
	 public List<Product> getFilteredProducts(
	            @PathVariable String category,
	            @RequestBody FilterRequest filterRequest) { //taking category and parameters of filterequest
	        int maxValue = filterRequest.getMaxValue(); 
	        int minValue = filterRequest.getMinValue();
	        String orderBy = filterRequest.getOrderBy();

	        return productService.getFilteredProducts(category, maxValue, minValue, orderBy);
	    }

}
