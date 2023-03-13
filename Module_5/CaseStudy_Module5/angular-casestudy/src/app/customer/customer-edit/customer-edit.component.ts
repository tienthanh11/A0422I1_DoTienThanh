import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ICustomerType} from "../../model/icustomer-type";
import {CustomerService} from "../../service/customer.service";
import {CustomerTypeService} from "../../service/customer-type.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {

  customerFormEdit: FormGroup;
  id: number;
  customerTypes: ICustomerType[] = [];

  constructor(private customerService: CustomerService,
              private customerTypeService: CustomerTypeService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.customerTypes = this.customerTypeService.getAllCustomerType();

    this.activatedRoute.paramMap.subscribe((param) => {
      this.id = +(param.get('id'));
      const customerEdit = this.getCustomer(this.id);
      this.customerFormEdit = new FormGroup({
        id: new FormControl(customerEdit.id, [Validators.required]),
        type: new FormControl(customerEdit.type.id, [Validators.required]),
        name: new FormControl(customerEdit.name, [Validators.required]),
        birthday: new FormControl(customerEdit.birthday, Validators.required),
        gender: new FormControl(customerEdit.gender, [Validators.required]),
        idCard: new FormControl(customerEdit.idCard, [Validators.required, Validators.pattern('(^\\d{9}$)|(^\\d{12}$)')]),
        phone: new FormControl(customerEdit.phone, [Validators.required, Validators.pattern('^090(\\d{7})|091(\\d{7})|\\(84\\)\\+90(\\d{7})|\\(84\\)\\+91(\\d{7})$')]),
        email: new FormControl(customerEdit.email, [Validators.required, Validators.email]),
        address: new FormControl(customerEdit.address, [Validators.required])
      });
    });
  }

  private getCustomer(id: number) {
    return this.customerService.findByIdCustomer(id);
  }

  editCustomer(id: number) {
    const customer = this.customerFormEdit.value;
    this.customerService.updateCustomer(id, customer);
    alert('Cập nhật thành công');
    this.router.navigateByUrl('customer/list');
  }
}
