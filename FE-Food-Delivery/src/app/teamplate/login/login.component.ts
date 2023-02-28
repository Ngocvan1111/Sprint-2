import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {TokenService} from "../../service/token.service";
import {SecurityService} from "../../service/security.service";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  signInForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder,
              private tokenService: TokenService,
              private securityService: SecurityService) { }

  ngOnInit(): void {
    this.getFormLogin();
  }

  login() {
    const signInForm = this.signInForm?.value;
    this.securityService.signIn(signInForm).subscribe(data=>{
      this.tokenService.setName(data.name);
      this.tokenService.setToken(data.token);
      this.tokenService.setEmail(data.email);
      this.tokenService.setId(data.id)
      alert("Dang nhap thanh cong")
      location.href='http://localhost:4200/'
    }, error => {})

  }
  getFormLogin(): void {
    this.signInForm = this.formBuilder.group({
      email: [''],
      password: [''],
    })
  }
}
