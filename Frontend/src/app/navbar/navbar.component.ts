
import { Component,OnInit } from '@angular/core';
import { UserService } from '../Service/user.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  isLoggedIn: boolean = false;
  isAdmin: boolean = false;
  userId:number = 0;
  

  constructor(private userService: UserService, private router: Router) {
    
    //console.log(this.isLoggedIn)
    
    // this.isAdmin = Boolean(localStorage.getItem("isAdmin"));
       
  }
  

  ngOnInit(): void {
    console.log(localStorage);
    
    let isAdmin = localStorage.getItem('isAdmin'); 
    let isLoggedIn = localStorage.getItem('isLoggedIn');
    let userId = localStorage.getItem('userId');
    



    // console.log(isAdmin);

    if(isAdmin=="true"){
      //console.log(isAdmin)
      this.isAdmin = true;
    }

    if(isLoggedIn=="true"){
      this.isLoggedIn = true;
    }
    if (userId != null){
      this.userId=Number(userId);
    
    }

    console.log(this.isLoggedIn);
      

  }

  doSearch(value: string): void {
    this.router.navigateByUrl(`/search/${value}`);
  }

  logout(): void {
    this.userService.logoutUser();
  }
}
