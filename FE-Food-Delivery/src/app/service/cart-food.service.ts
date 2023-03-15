import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CartFoodService {

  constructor(private httpClient: HttpClient) { }
  updateQuantity(newQuantity: number, idFood:number, idCustomer:number): any{
   // @ts-ignore
    return this.httpClient.patch('http://localhost:8080/api/cart-food/update-quantity?newQuantity='+ newQuantity + '&idFood='+idFood + '&idCustomer=' + idCustomer, {})
  }
  deleteFoodInCart(idFood:number, idCustomer: number){
    return this.httpClient.delete('http://localhost:8080/api/cart-food/delete?idFood='+idFood+'&idCustomer=' + idCustomer)
  }
}
