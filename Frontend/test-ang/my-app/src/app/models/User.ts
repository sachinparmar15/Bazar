import { Address } from './Address';

export class User {
    name: string;
    email: string;
    phone: string;
    password: string;
    address: Address; 
    id: any;
  

    constructor() {
        this.name = '';
        this.email = '';
        this.phone = '';
        this.password = '';
        this.address= new Address();
        
      }
  }
 