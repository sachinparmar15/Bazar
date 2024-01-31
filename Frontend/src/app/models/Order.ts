
import { OrderItem } from './Orderitem';
import { User } from './User';

export interface Order {
  orderid: number;
  orderItems: OrderItem[] ;
  userid :User;

}
