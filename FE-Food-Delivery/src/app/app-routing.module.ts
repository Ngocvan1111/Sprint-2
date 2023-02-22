import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {CartComponent} from "./cart/cart.component";
import {DetailComponent} from "./detail/detail.component";
import {ProductComponent} from "./product/product.component";

const routes: Routes = [
  {
    path: '', component: HomeComponent,
  },
  {
    path: 'login',  component: LoginComponent,
  },
  {
    path: 'cart', component: CartComponent,
  },
  {
    path: 'detail', component: DetailComponent,
  },
  {
    path: 'product', component: ProductComponent,
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
