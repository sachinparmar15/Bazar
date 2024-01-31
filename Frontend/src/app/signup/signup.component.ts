import { Component } from '@angular/core';
import { UserService } from '../Service/user.service';
import {Router} from "@angular/router"

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent {
  user: any = {}; 

  constructor(private userService: UserService, private router: Router) {}

  signup() {
    console.log(this.user);

   

    this.userService.signupUser(this.user).subscribe(
      (response) => {
        
        console.log('Signup successful', response);

        this.router.navigate(['/login']);

        
      },
      (error) => {
        
        console.error('Signup error', error);
        alert('Error in submitting your form');
      }
    );
  }

  validatePhone() {
    const phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(this.user.phone)) {
      alert("Incorrect Phone no. Format. Phone no. must be of 10 digits ")
      // Clear the input or handle the error as needed
      this.user.phone = '';
    }
  }
  
  validatePincode() {
    const pincodePattern = /^[0-9]{6}$/;
    if (!pincodePattern.test(this.user.pincode)) {
     
      alert("Incorrect Pincode Format.Pincode must be of 6 digits ")
      this.user.pincode = '';
    }
  
  }
}
