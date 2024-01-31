import { NgModule } from '@angular/core';
import {
  BrowserModule,
  provideClientHydration,
} from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { NavbarComponent } from './navbar/navbar.component';
// import { SliderComponent } from './slider/slider.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { ProfileComponent } from './profile/profile.component';
import { FontAwesomeModule } from '@fortawesome/angular-fontawesome';
import { CartComponent } from './cart/cart.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductComponent } from './product/product.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { OrderComponent } from './order/order.component';
import { ProductPageComponent } from './productpage/productpage.component';

import { SearchComponent } from './search/search.component';
import { CategoryComponent } from './category/category.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { AllorderComponent } from './allorder/allorder.component';
import { SliderComponent } from './slider/slider.component';


// import { ProductpageComponent } from './productpage/productpage.component';

// import { CommonModule } from '@angular/common';

@NgModule({
  declarations: [
    AppComponent,
 
    HomeComponent,
    LoginComponent,
    SignupComponent,
    NavbarComponent,
  
    FooterComponent,
    CartComponent,
    ProfileComponent,
    AddProductComponent,
    ProductComponent,

    ProductlistComponent,
    OrderComponent,
    ProductPageComponent,
    
    SearchComponent,
    CategoryComponent,
    UpdateproductComponent,
    AllorderComponent,
    SliderComponent
    
    
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    FormsModule,
    FontAwesomeModule,
    BrowserAnimationsModule

    
    // CommonModule
  ],
  providers: [provideClientHydration()],
  bootstrap: [AppComponent],
})
export class AppModule {}
