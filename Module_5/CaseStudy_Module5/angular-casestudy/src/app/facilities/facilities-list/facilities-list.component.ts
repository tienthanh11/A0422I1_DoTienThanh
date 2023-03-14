import { Component, OnInit } from '@angular/core';
import {IFacility} from "../../model/ifacility";
import {FacilityService} from "../../service/facility.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-facilities-list',
  templateUrl: './facilities-list.component.html',
  styleUrls: ['./facilities-list.component.css']
})
export class FacilitiesListComponent implements OnInit {

  page: number = 1;
  facilities: IFacility[] = [];
  facilityDelete: IFacility = {};

  constructor(private facilityService: FacilityService,
              private router: Router) { }

  ngOnInit(): void {
    this.facilityService.getAllFacility().subscribe((data) => {
      this.facilities = data;
    })
  }

  showInfo(facility: IFacility) {
    this.facilityDelete = facility;
  }

  delete(id: number) {
    this.facilityService.deleteFacility(id).subscribe(
      () => {},
      () => {},
      () => {
        alert('Xoá dịch vụ thành công');
        this.ngOnInit();
      }
    );
  }
}
