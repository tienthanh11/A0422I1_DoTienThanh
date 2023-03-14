import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {ICustomerType} from "../model/icustomer-type";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {

  readonly URI: string = 'http://localhost:3000/customer-types'

  constructor(private httpClient: HttpClient) {
  }

  getAllCustomerType(): Observable<ICustomerType[]> {
    return this.httpClient.get<ICustomerType[]>(this.URI)
  }

  findByIdCustomerType(id: number): Observable<ICustomerType> {
    return this.httpClient.get<ICustomerType>(this.URI + '/' + id);
  }
}
