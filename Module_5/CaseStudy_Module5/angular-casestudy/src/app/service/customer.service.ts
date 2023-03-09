import { Injectable } from '@angular/core';
import {CustomerDAO} from "../data/CustomerDAO";
import {FacilityDAO} from "../data/FacilityDAO";

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  constructor() { }

  getAllCustomer() {
    return CustomerDAO.customers;
  }

  createCustomer(customer) {
    return CustomerDAO.customers.push(customer);
  }
}
