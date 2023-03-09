import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {FacilityService} from "../../service/facility.service";
import {ActivatedRoute, Router} from "@angular/router";
import {jsGlobalObjectValue} from "@angular/compiler-cli/src/ngtsc/partial_evaluator/src/known_declaration";

@Component({
  selector: 'app-facilities-edit',
  templateUrl: './facilities-edit.component.html',
  styleUrls: ['./facilities-edit.component.css']
})
export class FacilitiesEditComponent implements OnInit {

  facilityFormEdit: FormGroup;
  id: number;

  constructor(private facilityService: FacilityService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((param) => {
      this.id = +(param.get('id'));
      const facilityEdit = this.getFacility(this.id);
      this.facilityFormEdit = new FormGroup({
        id: new FormControl(facilityEdit.id, [Validators.required]),
        name: new FormControl(facilityEdit.name, [Validators.required, Validators.pattern('^\\D*$')]),
        area: new FormControl(facilityEdit.area, [Validators.required, Validators.min(0)]),
        cost: new FormControl(facilityEdit.cost, [Validators.required, Validators.min(0)]),
        maxPeople: new FormControl(facilityEdit.maxPeople, [Validators.required, Validators.min(0)]),
        rentType: new FormControl(facilityEdit.rentType, [Validators.required]),
        serviceType: new FormControl(facilityEdit.serviceType, [Validators.required]),
        standardRoom: new FormControl(facilityEdit.standardRoom, [Validators.required]),
        description: new FormControl(facilityEdit.description, [Validators.required]),
        poolArea: new FormControl(facilityEdit.poolArea, [Validators.required, Validators.min(0)]),
        numberOfFloor: new FormControl(facilityEdit.numberOfFloor, [Validators.required, Validators.min(0)]),
        image: new FormControl(facilityEdit.image, [Validators.required])
      });
    })
  }

  private getFacility(id: number) {
    return this.facilityService.findByIdFacility(id);
  }


  editFacility(id: number) {
    const facility = this.facilityFormEdit.value;
    this.facilityService.updateFacility(id, facility);
    alert('Sửa dịch vụ thành công');
    this.router.navigateByUrl('facility/list');
  }
}
