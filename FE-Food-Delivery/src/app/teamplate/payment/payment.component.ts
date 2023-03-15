import { Component, OnInit } from '@angular/core';
import { render} from "creditcardpayments/creditCardPayments";
import {TokenService} from "../../service/token.service";
import {CartService} from "../../service/cart.service";
import {Cart} from "../../dto/cart";
import {UserService} from "../../service/user.service";
import {User} from "../../dto/user";

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {
  quantityFoodInCart: number = 0;
  foodList: Cart[] = [{idFood: 0, url:'',foodName:'',price:0,quantity:0}];
  idCustomer: number;
  totalPayUSD: string = "0";
  totalPayVND: number = 0;
  customer: User = {name: "",email: "", phoneNumber: 0, address: ""};
  flag = false;
  constructor(private tokenService: TokenService,
              private userService:UserService,
              private cartService: CartService) {
      // @ts-ignore
    this.idCustomer = +this.tokenService.getIdCustomer();
    this.cartService.getTotalPay(this.idCustomer).subscribe(data =>{
      if(data.totalPayUSD != undefined){
        this.totalPayVND = data.totalPayVND;
        this.totalPayUSD =  (data.totalPayUSD).toFixed(2);
        console.log("thanh toan" + this.totalPayUSD)

        render(
          {
            id: "#myPaypalButtons",
            currency: "USD",
            value: this.totalPayUSD,
            onApprove: details => {
              alert("Transaction Successfull");
              this.updateCartAfterPay(this.idCustomer)

            }
          }
        )
      }


    })
    this.userService.getCustomer(this.idCustomer).subscribe(data =>{
      this.customer = data;
    })



  }

  ngOnInit(): void {
    this.getAllFoodInCart(this.idCustomer)
  }
  getAllFoodInCart(idCustomer: number){
    this.cartService.getAllFoodInCart(idCustomer).subscribe(data =>{
      this.foodList = data
      console.log(data)
      this.getQuantityFoodInCart()
    })
  }
  getQuantityFoodInCart(){
    this.quantityFoodInCart = 0;
    for(let i = 0; i<this.foodList.length; i++){
      // @ts-ignore
      this.quantityFoodInCart += this.foodList[i].quantity;
    }
    console.log("test"+this.quantityFoodInCart)
  }
  updateCartAfterPay(idCustomer: number){
    this.cartService.updateCartAfterPay(idCustomer).subscribe((data:any) => {
      alert("thanh toán ô kê")
      location.href = 'http://localhost:4200/payment';
    })
  }


}
