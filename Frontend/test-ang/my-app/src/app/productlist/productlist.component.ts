






import { Component, OnInit } from '@angular/core';
import { ProductService } from '../Service/product.service';
import { CartService } from '../Service/cart.service'; 
import { Product } from '../models/Product';


@Component({
  selector: 'app-productlist',
  templateUrl: './productlist.component.html',
  styleUrl: './productlist.component.css'
})
export class ProductlistComponent implements OnInit {
  products: Product[] = [];

  constructor(private productService: ProductService, private cartService: CartService) { }

  ngOnInit(): void {
    this.productService.getAllProducts().subscribe((data: Product[]) => {
      this.products = data;
    });
  }

  



  addToCart(product: Product): void {
    let userId = 1;   const productId = product.productid;

    const localStorageuserId = localStorage.getItem('userId');
    if (localStorageuserId) {
      userId = Number(localStorageuserId);
    }

    this.cartService.addToCart(userId, productId, 1
      ).subscribe(
      (response) => {
        console.log('Product added to cart successfully');
        
      },
      (error) => {
        console.error('Error adding product to cart', error);
        
      }
    );
  }

}







