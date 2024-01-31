
import { Component, OnInit } from '@angular/core';
import { UserService } from '../Service/user.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  user: any;
  editMode: boolean = false;

  constructor(private userService: UserService) { }

  ngOnInit(): void {
    
    let userId = 1;
    const localStorageuserId = localStorage.getItem('userId');
    if (localStorageuserId) {
      userId = Number(localStorageuserId);
    }

    this.userService.getUserProfile(userId).subscribe(
      (data: any) => {
        this.user = data;
      }
    );
  }

  toggleEditMode(): void {
    this.editMode = !this.editMode;
  }

  updateProfile(): void {
    this.userService.updateProfile(this.user).subscribe(
      (response: any) => {
        console.log(response); 
        this.editMode = false;
      },
      (error: any) => {
        console.error(error); 
      }
    );
  }

  validatePhone() {
    const phonePattern = /^[0-9]{10}$/;
    if (!phonePattern.test(this.user.phone)) {
      alert("Incorrect Phone no. Format. Phone no. must be of 6 Digits ")
      // Clear the input or handle the error as needed
      this.user.phone = '';
    }
  }
  
  validatePincode() {
    const pincodePattern = /^[0-9]{6}$/;
    if (!pincodePattern.test(this.user.pincode)) {
      // Clear the input or handle the error as needed
      alert("Incorrect Pincode Format. Pincode must be of 6 Digits ")
      this.user.pincode = '';
    }
  
  }
  
}
