import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { HomeComponent } from './home/home.component';
import { ProfileComponent } from './profile/profile.component';
import { CartComponent } from './cart/cart.component';
import { AddProductComponent } from './add-product/add-product.component';
import { ProductPageComponent } from './productpage/productpage.component';

import { OrderComponent } from './order/order.component';
import { SearchComponent } from './search/search.component';
import { CategoryComponent } from './category/category.component';
import { ProductlistComponent } from './productlist/productlist.component';
import { UpdateproductComponent } from './updateproduct/updateproduct.component';
import { AllorderComponent } from './allorder/allorder.component';


const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  {path: 'cart', component: CartComponent},
  {path: 'profile', component: ProfileComponent},
  {path: 'profile', component: ProfileComponent},
  { path: '', component: HomeComponent },

  // { path: 'addProduct', component: AddProductComponent, canActivate: [AuthGuard] },
  // { path: 'updateProduct/:productId', component: UpdateproductComponent, canActivate: [AuthGuard] },
  // { path: 'productlist', component: ProductlistComponent, canActivate: [AuthGuard] },

  {path: "addProduct", component: AddProductComponent},
  {path: "updateProduct/:productId", component: UpdateproductComponent},
  {path: "productlist", component: ProductlistComponent},
  {path: "allorder", component: AllorderComponent},
  {path: "search/:searchString", component: SearchComponent},
  {path: ":category", component: CategoryComponent},
  {path: "order/:userId", component: OrderComponent},
  {path: 'Productpage/:productId', component: ProductPageComponent},
  

  // { path: 'customer', loadChildren: () => import('./customer/customer.module').then(m => m.CustomerModule) },
  // { path: 'admin', loadChildren: () => import('./admin/admin.module').then(m => m.AdminModule) },


  

];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
