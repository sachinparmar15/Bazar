

import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../models/Product';
import { Filter } from '../models/Filter';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private apiUrl = 'http://localhost:8080/products';

  constructor(private http: HttpClient) {}

  getAllProducts(): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/allproducts`);
  }

  addProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${this.apiUrl}/addProduct`, product);
  }

  updateProduct(updatedProduct: Product): Observable<Product> {
    const url = `${this.apiUrl}/update`;
    return this.http.post<Product>(url, updatedProduct);
  }

  getProductById(productId: number): Observable<Product> {
    return this.http.get<Product>(`${this.apiUrl}/getById/${productId}`);
    
  }


  getFilteredProducts(category: string, filter: Filter): Observable<Product[]> {

    const url = `${this.apiUrl}/${category}/getFilteredProducts`;
    return this.http.post<Product[]>(url, filter);
  }
  
  
  
  getProductsByCategory(category: string): Observable<Product[]> {
    console.log(category);
    return this.http.get<Product[]>(`${this.apiUrl}/${category}`);
  }

  getProductsBySearchString(searchString: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.apiUrl}/search/${searchString}`);
  }
 
}








  



