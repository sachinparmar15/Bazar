import { Component } from '@angular/core';
import { ProductService } from '../Service/product.service';
import { Product } from '../models/Product';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css'],
})
export class AddProductComponent {
  product: Product = {
    productid: 0,
    name: '',
    price: 0,
    details: '',
    category: '',
    img: '',
  };

  constructor(private productService: ProductService, private router: Router) {}

  

  addProduct() {
    this.productService.addProduct(this.product).subscribe((response) => {
      console.log('Product added successfully:', response);
      this.router.navigate(['/']);
    });
  }
}
