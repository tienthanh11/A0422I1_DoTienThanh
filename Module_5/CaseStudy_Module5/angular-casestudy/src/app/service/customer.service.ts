import { Injectable } from '@angular/core';
import {CustomerDAO} from "../data/CustomerDAO";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor() { }

  getAllCustomer() {
    return CustomerDAO.customers;
  }
}
