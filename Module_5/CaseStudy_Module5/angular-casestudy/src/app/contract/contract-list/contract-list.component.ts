import {Component, OnInit} from '@angular/core';
import {IContract} from "../../model/icontract";
import {ContractService} from "../../service/contract.service";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {

  page: number = 1;
  contracts: IContract[] = [];

  constructor(private contractService: ContractService) {
  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.contracts = this.contractService.getAllContract();
  }

}
