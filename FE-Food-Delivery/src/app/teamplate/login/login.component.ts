import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {TokenService} from "../../service/token.service";
import {SecurityService} from "../../service/security.service";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  signInForm: FormGroup = new FormGroup({});

  constructor(private formBuilder: FormBuilder,
              private tokenService: TokenService,
              private securityService: SecurityService,
              private toastrService: ToastrService) { }

  ngOnInit(): void {
    this.getFormLogin();
  }

  login() {
    const signInForm = this.signInForm?.value;
    this.securityService.signIn(signInForm).subscribe(data=>{
      if(data.token !== undefined){
        this.tokenService.setName(data.name);
        this.tokenService.setToken(data.token);
        this.tokenService.setEmail(data.email);
        this.tokenService.setId(data.id)
        alert(data.status)
        location.href='http://localhost:4200/'
        this.toastrService.success('Đăng nhập thành công.', 'Thông báo', {
          timeOut: 2000,
          progressBar: true,
          positionClass: 'toast-top-right',
          easing: 'ease-in'})
      }
      if(data.status === 202){
        this.toastrService.error('Mật khẩu không đúng vui lòng nhập lại', 'Thông báo',{
          timeOut: 2000,
          progressBar: true,
          positionClass: 'toast-top-right',
          easing: 'ease-in'
        })
      }
    }
    , error => {
        if(error.status === 403){
          this.toastrService.error('Đăng nhập thất bại, vui lòng thử lại', 'Thông báo',{
            timeOut: 2000,
            progressBar: true,
            positionClass: 'toast-top-right',
            easing: 'ease-in'
          })
        }
      })

  }
  getFormLogin(): void {
    this.signInForm = this.formBuilder.group({
      email: [''],
      password: [''],
    })
  }
}
