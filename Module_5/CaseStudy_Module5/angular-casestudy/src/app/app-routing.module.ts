import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {IntroComponent} from "./templates/intro/intro.component";
import {FacilitiesListComponent} from "./facilities/facilities-list/facilities-list.component";
import {CustomerListComponent} from "./customer/customer-list/customer-list.component";
import {ContractListComponent} from "./contract/contract-list/contract-list.component";
import {FacilitiesCreateComponent} from "./facilities/facilities-create/facilities-create.component";
import {FacilitiesEditComponent} from "./facilities/facilities-edit/facilities-edit.component";
import {CustomerCreateComponent} from "./customer/customer-create/customer-create.component";
import {CustomerEditComponent} from "./customer/customer-edit/customer-edit.component";
import {ContractCreateComponent} from "./contract/contract-create/contract-create.component";


// @ts-ignore
const routes: Routes = [
  {path: '', component: IntroComponent},
  {path: 'facility/list', component: FacilitiesListComponent},
  {path: 'facility/create', component: FacilitiesCreateComponent},
  {path: 'facility/edit/:id', component: FacilitiesEditComponent},
  {path: 'customer/list', component: CustomerListComponent},
  {path: 'customer/create', component: CustomerCreateComponent},
  {path: 'customer/edit/:id', component: CustomerEditComponent},
  {path: 'contract/list', component: ContractListComponent},
  {path: 'contract/create', component: ContractCreateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
