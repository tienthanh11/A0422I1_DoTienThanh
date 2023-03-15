import {Component, OnInit} from '@angular/core';
import {ICustomer} from "../../model/icustomer";
import {ICustomerType} from "../../model/icustomer-type";
import {CustomerService} from "../../service/customer.service";
import {CustomerTypeService} from "../../service/customer-type.service";
import {FormControl, FormGroup} from "@angular/forms";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: ICustomer[] = [];
  customerTypes: ICustomerType[] = [];
  customerDelete: ICustomer = {
    type: {}
  };
  page: number = 1;
  customerSearch: FormGroup;
  totalLength: number;

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.customerSearch = new FormGroup({
      name: new FormControl(''),
      email: new FormControl(''),
      typeId: new FormControl('')
    });
    this.getAll();
  }

  getAll() {
    this.customerService.getAllCustomer().subscribe((data) => {
      this.customers = data;
      this.totalLength = data.length;
    });

    this.customerTypeService.getAllCustomerType().subscribe((data) => {
      this.customerTypes = data;
    });
  }

  showInfo(customer: ICustomer) {
    console.log(customer);
    this.customerDelete = customer;
    console.log(this.customerDelete);
  }

  delete(id: number) {
    this.customerService.deleteCustomer(id).subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.toast.success("Xoá khách hàng thành công");
        this.getAll();
      }
    );
  }

  searchCustomer() {
    console.log(this.customerSearch.value);
    this.customerService.searchCustomer(
      this.customerSearch.get('name').value.trim(),
      this.customerSearch.get('email').value.trim(),
      this.customerSearch.get('typeId').value.trim()
    ).subscribe(
      (data) => {
        this.customers = data;
        this.totalLength = data.length;
        this.page = 1;
      }
    );
  }
}
