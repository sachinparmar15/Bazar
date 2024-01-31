import { Component, OnInit } from '@angular/core';
import { ProductService } from '../Service/product.service';
import { CartService } from '../Service/cart.service';
import { Product } from '../models/Product';
import { Filter } from '../models/Filter';
import { ActivatedRoute } from '@angular/router';
import { CartComponent } from '../cart/cart.component';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css'],
})
export class CategoryComponent implements OnInit {
  products: Product[] = [];
  category: string = '';
  userId = Number(localStorage.getItem('userId'));


  filter: Filter = { maxValue: 99999, minValue: 0, orderBy: 'name' };
 
  constructor(
    private productService: ProductService,
    private cartService: CartService,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {

    

    
    this.category = this.route.snapshot.params['category'];

    

    this.category && this.productService.getProductsByCategory(this.category)
        .subscribe((products) => {
          this.products = products;
        });
  }


  setOrderBy(orderBy: string): void {
    this.filter.orderBy = orderBy;
    this.getFilteredProduct();
    console.log("hello")
  }

  getFilteredProduct(): void{
    this.productService.getFilteredProducts(this.category, this.filter).subscribe((products) => {
      this.products = products;
    });
  }

  addToCart(product: Product): void {
  
    const productId = product.productid;

    console.log(this.userId)

    this.cartService.addToCart(this.userId, productId, 1).subscribe(
      (response) => {
        console.log('Product added to cart successfully');
        
      }
    );

    
  }
}
