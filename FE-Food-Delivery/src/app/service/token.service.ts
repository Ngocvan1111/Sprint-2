import { Injectable } from '@angular/core';
const NAME_KEY = 'Name_key';
const ROLE_KEY = 'Role_key';
const ID_KEY = "Id_key";
const EMAIL_KEY = "Email_key";
const TOKEN_KEY = 'Token_key';

@Injectable({
  providedIn: 'root'
})
export class TokenService {
  public roles = [];

  constructor() { }
  public setToken(token: string):void {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.setItem(TOKEN_KEY, token);
  }
  public getToken(): string | null {
    return localStorage.getItem(TOKEN_KEY);
  }
  public setEmail(email: string): void {
    localStorage.removeItem(EMAIL_KEY);
    localStorage.setItem(EMAIL_KEY, email);
  }
  public getEmail(): string | null {
    return localStorage.getItem(EMAIL_KEY);
  }
  public setId(id: string): void {
    localStorage.removeItem(ID_KEY);
    localStorage.setItem(ID_KEY, id);
  }
  public getId(): string | null {
    return localStorage.getItem(ID_KEY);
  }
  public setName(name: string): void {
    localStorage.removeItem(NAME_KEY);
    localStorage.setItem(NAME_KEY, name);
  }
  public getName(): string | null {
    return localStorage.getItem(NAME_KEY);
  }
  public setRole(roles: string[]): void {
    localStorage.removeItem(ROLE_KEY);
    localStorage.setItem(ROLE_KEY, JSON.stringify(roles));
  }

  public getRole(): string[] {
    this.roles = [];
    if(this.getToken()){
      // @ts-ignore
      JSON.parse(localStorage.getItem(ROLE_KEY)).forEach(role => {
        // @ts-ignore
        this.roles.push(role.authority)
      });
    }
    return this.roles;
  }
}
