import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { BehaviorSubject, Observable } from 'rxjs';
import { CartItem } from '../models/Cartitem';

@Injectable({
  providedIn: 'root',
})
export class CartService {
  private baseUrl = 'http://localhost:8080/cart';

 
  constructor(private http: HttpClient) {}


  createCart(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${userId}/createCart`);
  }

  getCart(userId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${userId}/getCart`);
  }

  addToCart(userId: number, productId: number, quantity:number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${userId}/add/${productId}/qty/${quantity}`, {
      responseType: 'text',
    });
  }
 


  removeFromCart(userId: number, productId: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/${userId}/remove/${productId}`, {
      responseType: 'text',
    });
  }

  changeQuantity(userId: number,productId: number, quantity: number): Observable<any> {
   
    console.log(quantity)
    return this.http.post(`${this.baseUrl}/${userId}/changeQuantity/${productId}`, quantity,{
      responseType: 'text',});

  }
}
