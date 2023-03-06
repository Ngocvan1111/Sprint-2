import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Cart} from "../dto/cart";

@Injectable({
  providedIn: 'root'
})
export class CartService {

  constructor(private httpClient: HttpClient) { }
  getAllFoodInCart(idCustomer: number): Observable<Cart[]>{
    return this.httpClient.get<Cart[]>('http://localhost:8080/api/cart/list/'+ idCustomer);
  }
}
