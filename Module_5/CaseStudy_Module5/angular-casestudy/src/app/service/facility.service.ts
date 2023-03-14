import {Injectable} from '@angular/core';
import {IFacility} from "../model/ifacility";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICustomer} from "../model/icustomer";

@Injectable({
  providedIn: 'root'
})
export class FacilityService {

  readonly URI: string = 'http://localhost:3000/facilities'

  constructor(
    private httpClient: HttpClient
  ) {
  }

  getAllFacility(): Observable<IFacility[]> {
    return this.httpClient.get<IFacility[]>(this.URI)
  }

  createFacility(facility: IFacility): Observable<void> {
    return this.httpClient.post<void>(this.URI, facility);
  }

  findByIdFacility(id: number): Observable<IFacility> {
    return this.httpClient.get(this.URI + '/' + id);
  }

  updateFacility(id: number, facility: IFacility): Observable<IFacility> {
    this.httpClient.put<IFacility>(`${this.URI}/${id}`, facility).subscribe();
    return this.httpClient.put<IFacility>(`${this.URI}/${id}`, facility);
  }

  deleteFacility(id: number): Observable<void> {
    return this.httpClient.delete<void>(this.URI + '/' + id);
  }

  searchCustomer(name: string, email: string, typeId: string): Observable<ICustomer[]> {
    return this.httpClient.get<ICustomer[]>(this.URI + '?name_like=' + name + '&email_like=' + email + 'type.id_like=' + typeId);
  }
}
