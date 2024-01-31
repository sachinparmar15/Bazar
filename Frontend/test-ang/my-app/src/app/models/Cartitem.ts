// cartitem.ts
import { Product } from './Product';

export interface CartItem {
  id: number;
  productId: number;
  quantity: number;
  totalPrice: number;
  product: Product;
  addedOn: Date; 
}import {Router} from "@angular/router"