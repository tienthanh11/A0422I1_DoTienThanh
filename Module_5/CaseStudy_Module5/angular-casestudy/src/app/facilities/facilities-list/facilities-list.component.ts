import { Component, OnInit } from '@angular/core';
import {IFacility} from "../../model/ifacility";
import {FacilityService} from "../../service/facility.service";

@Component({
  selector: 'app-facilities-list',
  templateUrl: './facilities-list.component.html',
  styleUrls: ['./facilities-list.component.css']
})
export class FacilitiesListComponent implements OnInit {

  page: number = 1;
  facilities: IFacility[] = [];

  constructor(private facilityService: FacilityService) { }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.facilities = this.facilityService.getAllFacility();
  }
}
