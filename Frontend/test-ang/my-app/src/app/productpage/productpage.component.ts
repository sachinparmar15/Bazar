
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from '../Service/product.service';
import { CartService } from '../Service/cart.service';
import { Product } from '../models/Product';
import { CartItem } from '../models/Cartitem';
import { CartComponent } from "../cart/cart.component";
import { faCaretDown, faCaretUp } from '@fortawesome/free-solid-svg-icons'; 


@Component({
  selector: 'app-productpage',
  templateUrl: './productpage.component.html',
  styleUrls: ['./productpage.component.css']
})

export class ProductPageComponent implements OnInit {
  productId: number = 0;
  caretDown = faCaretDown;
  caretUp = faCaretUp;
  

  quantity: number = 1;
  product: Product = {
    productid: 0,
    name: '',
    price: 0,
    details: '',
    category: '',
    img: ''
  };

  constructor(private route: ActivatedRoute, private productService: ProductService , private cartService: CartService ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
     
      this.productId = +params['productId'];
      this.loadProduct();
    });
  }
  

  loadProduct(): void {
    this.productService.getProductById(this.productId)
      .subscribe(product => this.product = product);
      console.log(this.product);
  }


  increaseQuantity(): void {
    this.quantity += 1;
   
  }

  decreaseQuantity(): void {
    if (this.quantity  > 1) {
      this.quantity  -= 1;
   
    }
  }

addToCart(product: Product): void {
  let userId = 1;   const productId = product.productid;

  const localStorageuserId = localStorage.getItem('userId');
  if (localStorageuserId) {
    userId = Number(localStorageuserId);
  }

  this.cartService.addToCart(userId, productId,this.quantity).subscribe(
    (response) => {
      console.log('Product added to cart successfully');
      
    },
    (error) => {
      console.error('Error adding product to cart', error);
      
    }
  );



}

}