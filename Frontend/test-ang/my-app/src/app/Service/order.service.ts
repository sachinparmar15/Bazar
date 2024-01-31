// orderservice.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Order } from '../models/Order';

@Injectable({
  providedIn: 'root',
})
export class OrderService {
  private apiUrl = 'http://localhost:8080/order';

  constructor(private http: HttpClient) {}

  getOrderHistory(userId: number): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.apiUrl}/${userId}/getOrders`);
  }

  createOrder(userId: number): Observable<number> {
    return this.http.get<number>(`${this.apiUrl}/${userId}/createOrder`);
  }

  getAllOrders(): Observable<Order[]> {
    return this.http.get<Order[]>(`${this.apiUrl}/allOrders`);
  }

}
