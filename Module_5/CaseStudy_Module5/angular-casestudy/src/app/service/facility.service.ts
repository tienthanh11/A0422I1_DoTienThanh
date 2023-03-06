import { Injectable } from '@angular/core';
import {FacilityDAO} from "../data/FacilityDAO";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  constructor() { }

  getAllFacility() {
    return FacilityDAO.facilities;
  }
}
