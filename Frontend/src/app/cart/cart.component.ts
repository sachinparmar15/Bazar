// cart.ts

import { Component, OnInit } from '@angular/core';
import { CartService } from '../Service/cart.service';
import { CartItem } from '../models/Cartitem';
import { Product } from '../models/Product';
import { OrderService } from '../Service/order.service';
import { Router } from '@angular/router';

import { faCaretDown, faCaretUp } from '@fortawesome/free-solid-svg-icons';
import { ActivatedRoute, Route } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css'],
})
export class CartComponent implements OnInit {
  caretDown = faCaretDown;
  caretUp = faCaretUp;


  cartItems: CartItem[] = [];
  productid: number = 1;
  quantity: number = 1;
  userId = Number(localStorage.getItem('userId'));

  constructor(
    private cartService: CartService,
    private orderService: OrderService,
    private router: Router
  ) {}

  ngOnInit(): void {

   
    setTimeout(() => {
      this.getCart();
    }, 500);


  }

  getCart(): void {
   
    console.log(this.userId)
    this.cartService.getCart(this.userId).subscribe((response: any) => {
      
      this.cartItems = response?.cartitems || [];
    });
  }

  increaseQuantity(item: CartItem): void {
    item.quantity++;
    this.productid = item.product.productid;
    this.quantity = item.quantity;
    this.getTotal();

    this.cartService
      .changeQuantity(this.userId, this.productid, this.quantity)
      .subscribe((response: any) => {});
  }

  decreaseQuantity(item: CartItem): void {
    if (item.quantity > 1) {
      item.quantity--;
      this.productid = item.product.productid;

      this.quantity = item.quantity;
      this.getTotal();

      this.cartService
        .changeQuantity(this.userId, this.productid, this.quantity)
        .subscribe((response: any) => {});
    }
  }

  getTotal(): number {
    let totalAmount = 0;

    for (const item of this.cartItems) {
      totalAmount += item.product.price * item.quantity;
    }

    return totalAmount;
  }

  removeFromCart(item: CartItem): void {
    let userId;
    if(localStorage.getItem("userId") != ""){
      userId = localStorage.getItem('userId');
    }
    console.log(userId)
    this.cartService.removeFromCart(this.userId, item.product.productid).subscribe({
            next: () =>{
          this.cartItems = this.cartItems.filter(
            (cartItem) => cartItem !== item
          );
          this.getTotal();
        },
        error: (error) => {
          console.error('Error removing item from cart:', error);
        }
  });
  }

  checkout(): void {
    const userId = Number(localStorage.getItem('userId'));
    // Assuming this.cartService.createOrder returns an Observable
    this.orderService.createOrder(this.userId).subscribe(
      (orderId) => {
        alert("Are you sure you want to proceed with this order??");
        // Navigate to the order page with the created orderId
        this.router.navigate(['/order', this.userId]);
      },
      (error) => {
        console.error('Error creating order:', error);
        alert('No item in cart!');
      }
    );
  }
}
