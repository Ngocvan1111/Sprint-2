import { Component, OnInit } from '@angular/core';
import {TokenService} from "../../service/token.service";
import {DataBindingService} from "../../service/data-binding.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  name: string = '';
  constructor(private tokenService: TokenService,
              private dataBindingService: DataBindingService) {

  }

  ngOnInit(): void {
    this.dataBindingService.currentData.subscribe(data => {
      if (data != null){
        // @ts-ignore
        this.name = data.name;
      }
      console.log("asd"+data.name)
      alert(this.name)

    })

  }

}
