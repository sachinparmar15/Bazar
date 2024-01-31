
import { Component, OnInit } from '@angular/core';
import { OrderService } from '../Service/order.service';
import { Order } from '../models/Order';

@Component({
  selector: 'app-allorder',
  templateUrl: './allorder.component.html',
  styleUrl: './allorder.component.css'
})



export class AllorderComponent implements OnInit {
  allOrders: Order[] = [];

  constructor(private orderService: OrderService) {}

  ngOnInit(): void {
    this.orderService.getAllOrders().subscribe({

        next: (orders) => {
              this.allOrders = orders;
      },
      error: (error) =>{
        console.error('Error fetching orders:', error);
      }
  });
  }
}
