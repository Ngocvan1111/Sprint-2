import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cart} from "../dto/cart";
import {CartCreate} from "../dto/cart-create";
import {CartPayment} from "../dto/cart-payment";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient: HttpClient) { }
  getAllFoodInCart(idCustomer: number): Observable<Cart[]>{
    return this.httpClient.get<Cart[]>('http://localhost:8080/api/cart/list/'+ idCustomer);
  }
  createCart(cart: CartCreate){
    return  this.httpClient.post('http://localhost:8080/api/cart/update/quantity', cart);
  }
  getTotalPay(idCart: number): Observable<CartPayment>{
    return this.httpClient.get<CartPayment>('http://localhost:8080/api/cart/get/total-pay/'+ idCart);
  }
  updateCartAfterPay(idCustomer: number): any{
    return this.httpClient.patch('http://localhost:8080/api/cart/update-cart-after-pay/'+idCustomer, {});
  }
}
