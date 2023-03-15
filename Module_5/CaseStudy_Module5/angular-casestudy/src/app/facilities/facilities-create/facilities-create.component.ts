import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {FacilityService} from "../../service/facility.service";
import {Router} from "@angular/router";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-facilities-create',
  templateUrl: './facilities-create.component.html',
  styleUrls: ['./facilities-create.component.css']
})
export class FacilitiesCreateComponent implements OnInit {

  facilityFormCreate: FormGroup;

  constructor(private facilityService: FacilityService,
              private router: Router,
              private toast: ToastrService) {
  }

  ngOnInit(): void {
    this.facilityFormCreate = new FormGroup({
      id: new FormControl('',),
      name: new FormControl('', [Validators.required, Validators.pattern('^\\D*$')]),
      area: new FormControl('', [Validators.required, Validators.min(0)]),
      cost: new FormControl('', [Validators.required, Validators.min(0)]),
      maxPeople: new FormControl('', [Validators.required, Validators.min(0)]),
      rentType: new FormControl('', [Validators.required]),
      serviceType: new FormControl('', [Validators.required]),
      standardRoom: new FormControl('', [Validators.required]),
      description: new FormControl('', [Validators.required]),
      poolArea: new FormControl('', [Validators.required, Validators.min(0)]),
      numberOfFloor: new FormControl('', [Validators.required, Validators.min(0)]),
      image: new FormControl('', [Validators.required])
    });
  }

  createFacility() {
    this.facilityService.createFacility(this.facilityFormCreate.value).subscribe(
      () => {
      },
      () => {
      },
      () => {
        this.toast.success("Thêm mới dịch vụ thành công");
        this.router.navigateByUrl('facility/list');
      }
    );
  }
}
