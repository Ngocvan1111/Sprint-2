import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {DataBinding} from "../dto/data-binding";

@Injectable({
  providedIn: 'root'
})
export class DataBindingService {
  private dataSource = new BehaviorSubject<string>("")
  currentData = this.dataSource.asObservable()
  constructor() { }
  changeData(data: string){
    this.dataSource.next(data);
  }
}
