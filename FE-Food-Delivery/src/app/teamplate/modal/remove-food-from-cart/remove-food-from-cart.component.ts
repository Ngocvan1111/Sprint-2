import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Food} from "../../../dto/food";
import {Cart} from "../../../dto/cart";
import {CartFoodService} from "../../../service/cart-food.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-remove-food-from-cart',
  templateUrl: './remove-food-from-cart.component.html',
  styleUrls: ['./remove-food-from-cart.component.css']
})
export class RemoveFoodFromCartComponent implements OnInit {
  @Input()
  food: Cart = {idFood:0,foodName:"",quantity:0,price:0,url:''};
  @Input()
  idCustomer: number = 0;
 @Output()
  emiter = new EventEmitter();
  constructor(private cartFoodService: CartFoodService,
              private toastrService: ToastrService) { }

  ngOnInit(): void {
    console.log(this.food.foodName + "aaaa")
  }
  onSubmit(){
    this.cartFoodService.deleteFoodInCart(this.food.idFood, this.idCustomer).subscribe(data => {
        this.emiter.emit('');
        this.toastrService.success('Xóa thành công.', 'Thông báo', {
          timeOut: 2000,
          progressBar: true,
          positionClass: 'toast-top-right',
          easing: 'ease-in'
        });
      }
      , (error: any) => {
        this.toastrService.error('Không tìm thấy sản phẩm cần xóa', 'Lỗi', {
          timeOut: 2000,
          progressBar: true,
          positionClass: 'toast-top-right',
          easing: 'ease-in'
        });
      }, () => {
      });
  }

}
