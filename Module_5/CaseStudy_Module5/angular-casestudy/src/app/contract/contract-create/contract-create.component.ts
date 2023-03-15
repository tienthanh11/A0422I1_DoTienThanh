import {Component, OnInit} from '@angular/core';
import {ContractService} from "../../service/contract.service";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {ICustomer} from "../../model/icustomer";
import {IFacility} from "../../model/ifacility";
import {CustomerService} from "../../service/customer.service";
import {FacilityService} from "../../service/facility.service";
import {Router} from "@angular/router";
import {formatDate} from "@angular/common";
import {identityRevealedValidator} from "./custom-validate.validator";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-contract-create',
  templateUrl: './contract-create.component.html',
  styleUrls: ['./contract-create.component.css']
})
export class ContractCreateComponent implements OnInit {

  contractFormCreate: FormGroup;
  customers: ICustomer[] = [];
  facilities: IFacility[] = [];
  date1 = formatDate(new Date(), 'yyyy-MM-dd', 'en_US');

  constructor(private contractService: ContractService,
              private customerService: CustomerService,
              private facilityService: FacilityService,
              private router: Router,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    console.log(this.date1);

    this.customerService.getAllCustomer().subscribe((data) => {
      this.customers = data;
    });

    this.facilityService.getAllFacility().subscribe((data) => {
      this.facilities = data;
    });

    this.contractFormCreate = new FormGroup({
      startDate: new FormControl(this.date1, [Validators.required]),
      endDate: new FormControl(this.date1, [Validators.required]),
      deposit: new FormControl('', [Validators.required, Validators.min(0)]),
      totalMoney: new FormControl('', [Validators.required, Validators.min(0)]),
      customer: new FormControl('', [Validators.required]),
      facility: new FormControl('', [Validators.required]),
    }, identityRevealedValidator);
  }

  createContract() {
    this.contractService.createContract(this.contractFormCreate.value).subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.toast.success("Thêm mới hợp đồng thành công");
        this.router.navigateByUrl('contract/list');
      }
    );
  }
}
