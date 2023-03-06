import { Component, OnInit } from '@angular/core';
import {CartService} from "../../service/cart.service";
import {Cart} from "../../dto/cart";
import {DataBindingService} from "../../service/data-binding.service";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  foodList: Cart[] = [{url:'',foodName:'',price:0,quantity:0}];
  id: number = 0;
  totalPay: number =0;
  constructor(private cartService: CartService,
              private dataBindingService: DataBindingService) {
  }

  ngOnInit(): void {
    this.getIdCustomer()
    this.getAllFoodInCart(this.id);
  }
  getIdCustomer(){
    this.dataBindingService.currentData.subscribe(data=>{
      if(data != null){
        this.id = data.id;
      }
    })
  }
  getAllFoodInCart(id: number){
    this.cartService.getAllFoodInCart(id).subscribe(data =>{
      this.foodList = data
      this.calculateTotalPay()
    })
  }
  calculateTotalPay(){
    for(let i = 0; i<this.foodList.length; i++){
      this.totalPay += this.foodList[i].price*this.foodList[i].quantity;
    }

  }

}
