import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../service/token.service";
import {DataBindingService} from "../../service/data-binding.service";
import {Cart} from "../../dto/cart";
import {ToastrService} from "ngx-toastr";
import {CartService} from "../../service/cart.service";
import {FormControl, FormGroup} from "@angular/forms";
import {FoodService} from "../../service/food.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  name: string | null = '';
  quantityFoodInCart: number = 0;
  id: number | null =0;
  foodListInCart: Cart[] = [{idFood: 0, url:'',foodName:'',price:0,quantity:0}];
  searchForm!: FormGroup;
  constructor(private tokenService: TokenService,
              private dataBindingService: DataBindingService,
              private toastrService: ToastrService,
              private foodService: FoodService,
              private cartService: CartService) {
    this.searchForm = new FormGroup({
      name: new FormControl('')
    })


  }

  ngOnInit(): void {
    this.dataBindingService.currentData.subscribe(data => {

        this.name = this.tokenService.getName();
      console.log("tesst name"+this.name)
        // @ts-ignore
        this.id = this.tokenService.getIdCustomer()
        // @ts-ignore
        this.getAllFoodInCart(this.id);
    })
  }

  getAllFoodInCart(id: number){
    this.cartService.getAllFoodInCart(id).subscribe(data =>{
      this.foodListInCart = data
      this.getQuantityFoodInCart()
    })
  }
  getQuantityFoodInCart(){
    this.quantityFoodInCart = 0;
    for(let i = 0; i<this.foodListInCart.length; i++){
      // @ts-ignore
      this.quantityFoodInCart += this.foodListInCart[i].quantity;
    }
    console.log("test"+this.quantityFoodInCart)
  }

  /**
   * Logout
   */
  logout(){
    window.localStorage.clear();
    location.href = 'http://localhost:4200/home';

}
  onSubmit(){
    this.dataBindingService.changeData(this.searchForm.value.name);

  }


}
