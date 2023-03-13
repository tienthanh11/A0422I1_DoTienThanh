import { Injectable } from '@angular/core';
import {CustomerDAO} from "../data/CustomerDAO";
import {FacilityDAO} from "../data/FacilityDAO";
import {ICustomer} from "../model/icustomer";
import {IFacility} from "../model/ifacility";

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

  findByIdCustomer(id: number) {
    return CustomerDAO.customers.find(customer => customer.id === id);
  }

  updateCustomer(id: number, customer: ICustomer) {
    for (let i = 0; i < CustomerDAO.customers.length; i++) {
      if (CustomerDAO.customers[i].id === id) {
        CustomerDAO.customers[i] = customer;
      }
    }
  }
}
