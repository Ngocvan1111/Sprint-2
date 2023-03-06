import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Image} from "../dto/image";

@Injectable({
  providedIn: 'root'
})
export class ImageService {

  constructor(private httpClient: HttpClient) { }
  getImageByFoodId(foodId: number): Observable<Image[]>{
    return  this.httpClient.get<Image[]>('http://localhost:8080/api/image/food/'+ foodId);
  }
}
