// order.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OrderService } from '../Service/order.service';
import { Order } from '../models/Order';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css'],
})
export class OrderComponent implements OnInit {
  userId: number = 1; // Replace with your logic to get the user ID
  orders: Order[] = [];

  constructor(
    private route: ActivatedRoute,
    private OrderService: OrderService
  ) {}

  ngOnInit(): void {
    
    this.route.paramMap.subscribe((params) => {
      const userId = Number(params.get('userId'));
      this.loadOrderHistory(userId);
    });
  }

  loadOrderHistory(userId: number): void {
    this.OrderService.getOrderHistory(userId).subscribe(
      (orders) => {
        this.orders = orders;
        console.log(orders)
      },
      (error) => {
        console.error('Error fetching order history:', error);
      }
    );
  }

  getTotalPrice(order: Order): number {
    if (order && order.orderItems) {
      return order.orderItems.reduce((total, item) => {
        return total + (item.orderPrice * item.quantity);
      }, 0);
    }
    return 0;
  }
}
