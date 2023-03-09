import { Injectable } from '@angular/core';
import {FacilityDAO} from "../data/FacilityDAO";
import {IFacility} from "../model/ifacility";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  constructor() { }

  getAllFacility() {
    return FacilityDAO.facilities;
  }

  findByIdFacility(id: number) {
    return FacilityDAO.facilities.find(facility => facility.id === id);
  }

  createFacility(facility) {
    return FacilityDAO.facilities.push(facility);
  }

  updateFacility(id: number, facility: IFacility) {
    for(let i = 0; i < FacilityDAO.facilities.length; i++) {
      if (FacilityDAO.facilities[i].id === id) {
        FacilityDAO.facilities[i] = facility;
      }
    }
  }
}
