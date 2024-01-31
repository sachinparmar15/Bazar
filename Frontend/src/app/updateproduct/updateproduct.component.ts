import { Component } from '@angular/core';
import { ProductService } from '../Service/product.service';
import { Product } from '../models/Product';
import {ActivatedRoute, Router} from "@angular/router"


@Component({
  selector: 'app-updateproduct',
  templateUrl: './updateproduct.component.html',
  styleUrl: './updateproduct.component.css'
})
export class UpdateproductComponent {



productId: number = 0;
  product: Product = {
    productid: 0,
    name: '',
    price: 0,
    details: '',
    category: '',
    img: ''
  };

  constructor(private productService: ProductService,private router: Router, private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.productId = +params['productId'];
      this.loadProduct();
    });
  }
  

  loadProduct(): void {
    this.productService.getProductById(this.productId)
      .subscribe(product => this.product = product);
      console.log(this.product);
  }


  updateProduct() {
    console.log("sacsdd")
    this.productService.updateProduct(this.product)
      .subscribe(response => {
        console.log('Product Updated successfully:', response);
        this.router.navigate(['/productlist']);
      }
       
      );
  }


}



