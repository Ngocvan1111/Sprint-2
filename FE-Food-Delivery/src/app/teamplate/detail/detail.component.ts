import { Component, OnInit } from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {Image} from "../../dto/image";
import {ImageService} from "../../service/image.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CartCreate} from "../../dto/cart-create";
import {CartService} from "../../service/cart.service";
import {FormControl, FormGroup} from "@angular/forms";
import {DataBindingService} from "../../service/data-binding.service";
import {Customer} from "../../dto/customer";
import {DataBinding} from "../../dto/data-binding";
import {TokenService} from "../../service/token.service";
import {FoodDetail} from "../../dto/food-detail";
import {FoodService} from "../../service/food.service";
import {Food} from "../../dto/food";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  foodList!: Food[];
  foodDetail: FoodDetail = {idFood: 0, code: '', description: '', name: '', price: 0, comparePrice: 0, quantity:0,origin:'',idCategory:0};
  quantity: number = 1;
  imageList?: Image[];
  status = "Hàng không đổi trả";
  idFood!: number;
  name = "";
  idCustomer!: number | null;
  customer: Customer = {idCustomer:0};
  cart: CartCreate = { quantity: 122, status: "Hàng không đổi trả",idFood: 2,customer:{idCustomer:1}}
  constructor(private toastrService: ToastrService,
              private imageService: ImageService,
              private activatedRoute: ActivatedRoute,
              private dataBindingService: DataBindingService,
              private tokenService: TokenService,
              private foodService: FoodService,
              private router: Router,
              private cartService: CartService) { }

  ngOnInit(): void {
    this.getFoodId()
    this.dataBindingService.currentData.subscribe(data => {
      if (data != ""){
        // @ts-ignore
        this.name = this.tokenService.getName()
      }
    })


  }
  changeQuatity(operator: string){
    if(operator === "+"){
      this.quantity++;
    }
    if(operator === "-"){
    this.quantity--}
  }
  getFoodId(){
    this.activatedRoute.paramMap.subscribe(data => {
      const id = data.get('id');
      if(id != null){
        this.idFood = +id;
        this.getIdCustomer();
        this.imageService.getImageByFoodId(parseInt(id)).subscribe(data =>{
          this.imageList = data;
        }, error => {
          alert("Lỗi")
        }, ()=>{})
      }
      this.getFoodDetail(this.idFood);
    })
  }

  addToCart(){
    this.setCart(this.quantity, this.status, this.idFood, this.customer);
    this.cartService.createCart(this.cart).subscribe(data =>{
      this.toastrService.success('Đã thêm mới .'+ this.foodDetail.name + ' vào giỏ hàng', 'Thông báo', {
        timeOut: 2000,
        progressBar: true,
        positionClass: 'toast-top-right',
        easing: 'ease-in'
      });
      this.dataBindingService.changeData("ok");
    })
  }
  getIdCustomer(){
    this.dataBindingService.currentData.subscribe(data=>{
        // @ts-ignore
      this.idCustomer = this.tokenService.getIdCustomer();
        // @ts-ignore
        this.customer.idCustomer = this.idCustomer;
        console.log("ok")

    })
  }
  setCart(quantity:number, status: string, idFood:number, customer:Customer){
    this.cart.quantity = quantity;
    this.cart.status = status;
    this.cart.idFood = idFood;
    this.cart.customer = customer;
    console.log(quantity)
    console.log(status)
    console.log(idFood)
    console.log(customer)
  }
  getFoodDetail(idFood: number){
    this.foodService.getFoodByIdFood(idFood).subscribe(data => {
      this.foodDetail = data;
      this.getFoodByCategory(data.idCategory);
    })
  }
  getFoodByCategory(idCategory: number){
    this.foodService.getFoodByCategory(idCategory).subscribe(data =>{
      this.foodList = data;
    }, error => {
    }, () => {
    })
  }
}
