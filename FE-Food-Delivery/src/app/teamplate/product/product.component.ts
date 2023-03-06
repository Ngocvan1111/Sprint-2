import { Component, OnInit } from '@angular/core';
import {FoodService} from "../../service/food.service";
import {FoodPage} from "../../dto/food-page";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  foodList!: FoodPage;


  constructor(private foodService: FoodService,
              private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.getAllFood(0);
  }
  getAllFood(pageNumber: any):void {
this.foodService.getAllFood(pageNumber).subscribe(data => {
  this.foodList = data;
}, error => {}, () =>{})
  }

}
