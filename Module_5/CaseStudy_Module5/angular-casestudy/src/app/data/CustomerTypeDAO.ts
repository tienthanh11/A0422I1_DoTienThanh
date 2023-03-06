import {ICustomerType} from "../model/icustomer-type";

export class CustomerTypeDAO {
  static customerTypes: ICustomerType[] = [
    {
      id: 1,
      name: 'Diamond'
    },
    {
      id: 2,
      name: 'Platinium'
    },
    {
      id: 3,
      name: 'Gold'
    },
    {
      id: 4,
      name: 'Silver'
    },
    {
      id: 5,
      name: 'Member'
    }
  ];
}
