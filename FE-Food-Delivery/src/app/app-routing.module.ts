import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./teamplate/home/home.component";
import {LoginComponent} from "./teamplate/login/login.component";
import {CartComponent} from "./teamplate/cart/cart.component";
import {DetailComponent} from "./teamplate/detail/detail.component";
import {ProductComponent} from "./teamplate/product/product.component";
import {HeaderComponent} from "./teamplate/header/header.component";
import {PaymentComponent} from "./teamplate/payment/payment.component";

const routes: Routes = [
  {
    path: 'home', component: HomeComponent,
  },
  {
    path: 'login',  component: LoginComponent,
  },
  {
    path: 'cart', component: CartComponent,
  },
  {
    path: 'detail/:id', component: DetailComponent,
  },
  {
    path: 'detail', component: DetailComponent,
  },
  {
    path: 'product', component: ProductComponent,
  },
  {
    path: 'payment', component: PaymentComponent,
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
