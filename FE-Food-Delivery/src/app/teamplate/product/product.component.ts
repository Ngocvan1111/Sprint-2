import {Component, OnInit} from '@angular/core';
import {FoodService} from "../../service/food.service";
import {FoodPage} from "../../dto/food-page";
import {ToastrService} from "ngx-toastr";
import {Food} from "../../dto/food";

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {
  foodList!: Food[];


  constructor(private foodService: FoodService,
              private toastrService: ToastrService) {
  }

  ngOnInit(): void {
    this.getFoodByCategory(1)
  }

  getFoodByCategory(idCategory: number){
    this.foodService.getFoodByCategory(idCategory).subscribe(data =>{
      this.foodList = data;
    }, error => {
    }, () => {
    })
  }

}
