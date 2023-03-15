import { Component, OnInit } from '@angular/core';
import {CartService} from "../../service/cart.service";
import {Cart} from "../../dto/cart";
import {DataBindingService} from "../../service/data-binding.service";
import {TokenService} from "../../service/token.service";
import {CartFoodService} from "../../service/cart-food.service";
import {element} from "protractor";
import {Food} from "../../dto/food";

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  foodList: Cart[] = [{idFood: 0, url:'',foodName:'',price:0,quantity:0}];
  idCustomer: number = 0;
  idFood: number = 0;
  totalPay: number =0;
  quantity: number = 0;
  temp: Cart = {idFood:0,foodName:"",quantity:0,price:0,url:''};
  constructor(private cartService: CartService,
              private tokenService: TokenService,
              private cartFoodService: CartFoodService,
              private dataBindingService: DataBindingService) {
  }

  ngOnInit(): void {
    this.getIdCustomer()
    this.getAllFoodInCart(this.idCustomer);
  }
  getIdCustomer(){
    this.dataBindingService.currentData.subscribe(data=>{
        // @ts-ignore
        this.idCustomer = +this.tokenService.getIdCustomer();
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
      // @ts-ignore
      this.totalPay += this.foodList[i].price*this.foodList[i].quantity;
    }
  }

  changeQuantity(operator: string, id: number){
    let temp = this.foodList.filter(element => (element.idFood == id))
    if(operator === "+"){
      this.quantity = temp[0].quantity+1;
      // @ts-ignore
      this.cartFoodService.updateQuantity(this.quantity, id, this.idCustomer).subscribe(data =>{
        this.getAllFoodInCart(this.idCustomer);
        this.dataBindingService.changeData("ok");

      })
    }
    if(operator === "-"){
      this.quantity = temp[0].quantity - 1;
      // @ts-ignore
      this.cartFoodService.updateQuantity(this.quantity, id, this.idCustomer).subscribe(data =>{
        this.getAllFoodInCart(this.idCustomer);
        this.dataBindingService.changeData("ok");
      })
     }

  }
  goToPaymentPage(){
    location.href = 'http://localhost:4200/payment';
  }
}

