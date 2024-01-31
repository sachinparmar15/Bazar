import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { User } from '../models/User';
import { Console } from 'console';

@Injectable({
  providedIn: 'root',
})
export class UserService {

  private apiUrl = 'http://localhost:8080/user';
  private isLoggedInKey = 'isLoggedIn';
  public isAdmin = false 

  constructor(private http: HttpClient) {}
  

  signupUser(user: any): Observable<any> {
    console.log(user);

   
    const userWithAddress = {
      ...user,
      address: {
        houseNo: user.houseNo,
        area: user.area,
        landmark: user.landmark,
        village: user.village,
        city: user.city,
        state: user.state,
        pincode: user.pincode,
      },
    };

   
    return this.http.post(`${this.apiUrl}/signup`, userWithAddress);
  }

  loginUser(user: any): Observable<any> {

    
    console.log(this.isLoggedInKey)
    return this.http.post(`${this.apiUrl}/login`, user, {
      responseType: 'text',
    });
  }

  

  logoutUser(): void {
    localStorage.setItem("isLoggedIn", "false");
    localStorage.setItem("userId", "");
    localStorage.setItem("isAdmin", "false");
    console.log(this.isLoggedIn)
  }

  private isLocalStorageAvailable(): boolean {
    try {
      const testKey = 'test';
      localStorage.setItem(testKey, 'test');
      localStorage.removeItem(testKey);
      return true;
    } catch (error) {
      return false;
    }
  }
  private isItemInLocalStorage(itemKey: string): boolean {
    if (this.isLocalStorageAvailable()) {
      return localStorage.getItem(itemKey) !== null;
    }
    return false;
  }

  

  isLoggedIn(): boolean {
    return this.isItemInLocalStorage(this.isLoggedInKey);
  }



  getUserProfile(userId: number): Observable<any> {

    return this.http.get<any>(`${this.apiUrl}/getprofile/${userId}`);
  }

  updateProfile(updatedUser: any): Observable<any> {
    const url = `${this.apiUrl}/updateprofile`;
    return this.http.put(url, updatedUser, { responseType: 'text' });
  }
}
