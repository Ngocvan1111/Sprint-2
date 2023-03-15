import {Customer} from "./customer";

export interface CartCreate {
  quantity:number;
  status:string;
  idFood:number;
  customer:Customer;
}

