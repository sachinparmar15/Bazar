import { Component, OnInit } from '@angular/core';
import { ProductService } from '../Service/product.service';
import { CartService } from '../Service/cart.service';
import { Product } from '../models/Product';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  Product: Product[] = [];
  searchString: string ='';

  constructor(private route: ActivatedRoute, private productService: ProductService, private cartService: CartService) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {

      this.searchString = params['searchString'];
      this.productService.getProductsBySearchString(this.searchString).subscribe(products => {
        this.Product = products;
      });
    });

    // Assuming you want to retrieve all products on component initialization
   
  }

  addToCart(product: Product): void {
    let userId = 1;   const productId = product.productid;

    const localStorageuserId = localStorage.getItem('userId');
    if (localStorageuserId) {
      userId = Number(localStorageuserId);
    }

    this.cartService.addToCart(userId, productId,1).subscribe(
      (response) => {
        console.log('Product added to cart successfully');
      
        
      },
      (error) => {
        console.error('Error adding product to cart', error);
        
      }
    );
  }
}
