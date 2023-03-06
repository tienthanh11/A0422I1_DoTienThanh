import {Component, OnInit} from '@angular/core';
import {ICustomer} from "../../model/icustomer";
import {ICustomerType} from "../../model/icustomer-type";
import {CustomerService} from "../../service/customer.service";
import {CustomerTypeService} from "../../service/customer-type.service";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  page: number = 1;
  customers: ICustomer[] = [];
  customerTypes: ICustomerType[] = [];
  customerSearch: FormGroup;

  constructor(private customerService: CustomerService, private customerTypeService: CustomerTypeService) {
  }

  ngOnInit(): void {
    this.customerSearch = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      typeId: new FormControl(''),
    });
    this.getAll();
  }

  getAll() {
     this.customers =  this.customerService.getAllCustomer();

     this.customerTypes = this.customerTypeService.getAllCustomerType();
  }
}
