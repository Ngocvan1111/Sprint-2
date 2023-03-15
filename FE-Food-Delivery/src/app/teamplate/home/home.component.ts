import { Component, OnInit } from '@angular/core';
import {FoodPage} from "../../dto/food-page";
import {FoodService} from "../../service/food.service";
import {ToastrService} from "ngx-toastr";
import {CartService} from "../../service/cart.service";
import {DataBindingService} from "../../service/data-binding.service";
import {Cart} from "../../dto/cart";
import {CartCreate} from "../../dto/cart-create";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  foodList!: FoodPage;
  name: string = '';
  constructor(private foodService: FoodService,
              private toastrService: ToastrService,
              private cartService: CartService,
              private dataBindingService: DataBindingService) {

  }

  ngOnInit(): void {

    this.dataBindingService.currentData.subscribe(data => {

      this.name = data;
      console.log("tesst namess"+this.name)
      this.getAllFood(this.name,0);

    })

  }
  getAllFood(name: string,pageNumber: any):void {
    this.foodService.getAllFood(pageNumber,name).subscribe(data => {
      this.foodList = data;
    }, error => {}, () =>{})
  }
  gotoPage(pageNumber: number): void {
    this.getAllFood(this.name, pageNumber);

  }






}
