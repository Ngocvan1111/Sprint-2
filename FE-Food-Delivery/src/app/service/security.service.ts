import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {environment} from "../../environments/environment";
import {SignInForm} from "../dto/SignInForm";
import {Observable} from "rxjs";
import {JwtReponse} from "../dto/JwtReponse";

@Injectable({
  providedIn: 'root'
})
export class SecurityService {
  private API_SIGNIN = environment.API_LOCAL+ '/signin';
  constructor(private httpClient:HttpClient) { }
  signIn(signInForm: SignInForm): Observable<any>{
    return this.httpClient.post<JwtReponse>(this.API_SIGNIN,signInForm);

  }

}
