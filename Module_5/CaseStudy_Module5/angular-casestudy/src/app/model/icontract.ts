import {ICustomer} from "./icustomer";
import {IFacility} from "./ifacility";

export interface IContract {
  id?: number;
  startDate?: string;
  endDate?: string;
  deposit?: number;
  totalMoney?: number;
  customer?: ICustomer;
  facility?: IFacility;
}
