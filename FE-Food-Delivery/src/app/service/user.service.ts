import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../dto/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private httpClient: HttpClient) { }
  getCustomer(idCustomer: number): Observable<User>{
    return this.httpClient.get<User>('http://localhost:8080/api/user/'+ idCustomer);
  }
}
