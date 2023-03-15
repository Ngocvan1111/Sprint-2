import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FoodPage} from "../dto/food-page";
import {FoodDetail} from "../dto/food-detail";
import {Food} from "../dto/food";

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private httpClient: HttpClient) {
  }

  getAllFood(pageNumber: any, name: string): Observable<FoodPage> {
    return this.httpClient.get<FoodPage>('http://localhost:8080/api/public/list?page=' + pageNumber+ '&name='+ name);
  }
  getFoodByIdFood(idFood: number): Observable<FoodDetail>{
    return  this.httpClient.get<FoodDetail>('http://localhost:8080/api/public/food/'+ idFood);
  }
  getFoodByCategory(idCategory: number): Observable<Food[]>{
    return  this.httpClient.get<Food[]>('http://localhost:8080/api/public/list/food/category/' + idCategory)
  }
}

