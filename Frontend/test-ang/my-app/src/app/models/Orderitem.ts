// orderitem.ts
import { Product } from './Product';
export interface OrderItem {
  product: Product;
  img: string;
  orderPrice: number;
  quantity: number;
  productId: number;
}
