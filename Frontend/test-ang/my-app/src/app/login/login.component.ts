
// login.component.ts
import { Component, OnInit } from '@angular/core';
import { UserService } from '../Service/user.service';
import {Router} from "@angular/router"



@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit {
  user: any = {};
  isLoggedIn: boolean = false;
  isAdmin: boolean =false;

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
   
    this.isLoggedIn = this.userService.isLoggedIn();
    //this.login();
  }

  login(): void {
    console.log(this.user);
    this.userService.loginUser(this.user).subscribe({
      next: (result) => {
        if(result == 1){
          localStorage.setItem("isAdmin", "true");
          console.log(result);
          }
        // this.isLoggedIn = true;
        localStorage.setItem("isLoggedIn", "true");
        localStorage.setItem("userId", result);
        
        this.router.navigate(['/']);
        
      },
      error: (err) => {
        console.log(err);
        alert('Incorrect email or password!');
      },
    });
  }

  

  logout(): void {
    //console.log(localStorage.getItem("isAdmin"), "admin Local value");
    this.userService.logoutUser();
    // window.location.reload();
    window.location.reload;
  }
  
  
}

