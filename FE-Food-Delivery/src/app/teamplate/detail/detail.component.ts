import { Component, OnInit } from '@angular/core';
import {ToastrService} from "ngx-toastr";
import {Image} from "../../dto/image";
import {ImageService} from "../../service/image.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  quantity: number = 1;
  imageList?: Image[];
  constructor(private toastrService: ToastrService,
              private imageService: ImageService,
              private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.getFoodId()


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
        this.imageService.getImageByFoodId(parseInt(id)).subscribe(data =>{
          this.imageList = data;
          console.log(this.imageList)
        }, error => {
          alert("Lỗi")
        }, ()=>{})
      }
    })
  }
  getImageByFoodId(foodId: number){

  }


  test() {
    this.toastrService.success('Thêm vào giỏ hàng thành công.', 'Thông báo', {
      timeOut: 2000,
      progressBar: true,
      positionClass: 'toast-top-right',
      easing: 'ease-in'})
  }
}
