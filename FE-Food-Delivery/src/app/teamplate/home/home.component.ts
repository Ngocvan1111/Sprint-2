import { Component, OnInit } from '@angular/core';
import {FoodPage} from "../../dto/food-page";
import {FoodService} from "../../service/food.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

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
