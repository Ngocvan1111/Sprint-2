import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {FoodPage} from "../dto/food-page";

@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor(private httpClient: HttpClient) {
  }

  getAllFood(pageNumber: any): Observable<FoodPage> {
    return this.httpClient.get<FoodPage>('http://localhost:8080/food/list?page=' + pageNumber);
  }
}

