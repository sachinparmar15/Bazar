import { Component, OnInit } from '@angular/core';
import { ProductService } from '../Service/product.service';
import { CartService } from '../Service/cart.service'; 
import { Product } from '../models/Product';
import { Filter } from '../models/Filter';
import { Observable } from 'rxjs';


@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  products: Product[] = [];
  category: string = ''; 
  filter: Filter = { maxValue: 0, minValue: 0, orderBy: '' };


  constructor(private productService: ProductService, private cartService: CartService) { }

  ngOnInit(): void {
    
    this.productService.getAllProducts().subscribe((data: Product[]) => {
      this.products = data;
    });
  }

  

  addToCart(product: Product): void {
      const productId = product.productid;

    const userId = Number(localStorage.getItem('userId'));
    


    this.cartService.addToCart(userId, productId,1).subscribe(
      (response) => {
        console.log('Product added to cart successfully');
      
        
      },
      (error) => {
        console.error('Error adding product to cart', error);
        
      }
    );
  }

  loadFilteredProducts() {
    this.productService.getFilteredProducts(this.category, this.filter)
      .subscribe(products => this.products = products);
  }

  applyFilter(filter: Filter) {
    this.filter = filter;
    this.loadFilteredProducts();
  }
}
