import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './teamplate/home/home.component';
import { HeaderComponent } from './teamplate/header/header.component';
import { FooterComponent } from './teamplate/footer/footer.component';
import { LoginComponent } from './teamplate/login/login.component';
import { CartComponent } from './teamplate/cart/cart.component';
import { DetailComponent } from './teamplate/detail/detail.component';
import { ProductComponent } from './teamplate/product/product.component';
import {HttpClientModule} from "@angular/common/http";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    LoginComponent,
    CartComponent,
    DetailComponent,
    ProductComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
