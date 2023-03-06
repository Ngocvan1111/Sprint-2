import { Injectable } from '@angular/core';
import {BehaviorSubject} from "rxjs";
import {DataBinding} from "../dto/data-binding";

@Injectable({
  providedIn: 'root'
})
export class DataBindingService {
  private dataSource = new BehaviorSubject<DataBinding>({id: 0, name: ''})
  currentData = this.dataSource.asObservable()
  constructor() { }
  changeData(data: DataBinding){
    this.dataSource.next(data);
  }
}
