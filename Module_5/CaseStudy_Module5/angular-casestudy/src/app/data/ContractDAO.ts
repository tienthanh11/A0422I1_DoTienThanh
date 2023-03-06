import {IContract} from "../model/icontract";

export class ContractDAO {
  static contacts: IContract[] = [
    {
      id: 1,
      startDate: '2020-12-08',
      endDate: '2020-12-08',
      deposit: 0,
      totalMoney: 500000,
      customer: {
        id: 1,
        type: {
          id: 5,
          name: 'Member'
        },
        name: 'Nguyễn Thị Hào',
        birthday: '1970-11-07',
        gender: 0,
        idCard: '643431213',
        phone: '0945423362',
        email: 'thihao07@gmail.com',
        address: '23 Nguyễn Hoàng, Đà Nẵng'
      },
      facility: {
        id: 3,
        name: 'Room Twin 01',
        area: 5000,
        cost: 1000000,
        maxPeople: 2,
        rentType: 'Room',
        serviceType: 'Day',
        standardRoom: 'Normal',
        description: 'Có tivi',
        poolArea: 500,
        numberOfFloor: 3,
        image: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Lagoon-Superior-twin-bed-F-370x239.jpg'
      }
    },
    {
      id: 2,
      startDate: '2020-07-14',
      endDate: '2020-07-21',
      deposit: 200000,
      totalMoney: 1000000,
      customer: {
        id: 3,
        type: {
          id: 1,
          name: 'Diamond'
        },
        name: 'Trương Đình Nghệ',
        birthday: '1990-02-27',
        gender: 1,
        idCard: '488645199',
        phone: '0373213122',
        email: 'nghenhan2702@gmail.com',
        address: 'K323/12 Ông Ích Khiêm, Vinh'
      },
      facility: {
        id: 1,
        name: 'Villa Beach Front',
        area: 25000,
        cost: 10000000,
        maxPeople: 10,
        rentType: 'Room',
        serviceType: 'Year',
        standardRoom: 'Vip',
        description: 'Có hồ bơi',
        poolArea: 500,
        numberOfFloor: 4,
        image: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Suite-Feature-370x239.jpg'
      }
    },
    {
      id: 3,
      startDate: '2021-03-15',
      endDate: '2021-03-17',
      deposit: 50000,
      totalMoney: 700000,
      customer: {
        id: 4,
        type: {
          id: 1,
          name: 'Diamond'
        },
        name: 'Dương Văn Quan',
        birthday: '1981-07-08',
        gender: 1,
        idCard: '543432111',
        phone: '0490039241',
        email: 'duongquan@gmail.com',
        address: 'K453/12 Lê Lợi, Đà Nẵng'
      },
      facility: {
        id: 2,
        name: 'House Princess 01',
        area: 14000,
        cost: 5000000,
        maxPeople: 7,
        rentType: 'House',
        serviceType: 'Month',
        standardRoom: 'Vip',
        description: 'Có thêm bếp nướng',
        poolArea: 500,
        numberOfFloor: 3,
        image: 'https://furamavietnam.com/wp-content/uploads/2018/03/Vietnam_Danang_Furama_Ocean-Studio-Suite-F-370x239.jpg'
      }
    },
    {
      id: 4,
      startDate: '2021-01-14',
      endDate: '2021-01-18',
      deposit: 100000,
      totalMoney: 5000000,
      customer: {
        id: 5,
        type: {
          id: 4,
          name: 'Silver'
        },
        name: 'Hoàng Trần Nhi Nhi',
        birthday: '1995-12-09',
        gender: 0,
        idCard: '795453345',
        phone: '0312345678',
        email: 'nhinhi123@gmail.com',
        address: '224 Lý Thái Tổ, Gia Lai'
      },
      facility: {
        id: 5,
        name: 'House Princess 02',
        area: 10000,
        cost: 4000000,
        maxPeople: 5,
        rentType: 'House',
        serviceType: 'Month',
        standardRoom: 'Normal',
        description: 'Có thêm bếp nướng',
        poolArea: 300,
        numberOfFloor: 2,
        image: 'https://furamavietnam.com/wp-content/uploads/2018/08/Vietnam_Danang_Furama_Garden-Deluxe-twin-bed-F-370x239.jpg'
      }
    },
    {
      id: 5,
      startDate: '2021-07-14',
      endDate: '2021-07-15',
      deposit: 0,
      totalMoney: 500000,
      customer: {
        id: 2,
        type: {
          id: 3,
          name: 'Gold'
        },
        name: 'Phạm Xuân Diệu',
        birthday: '1992-08-08',
        gender: 1,
        idCard: '865342123',
        phone: '0954333333',
        email: 'xuandieu92@gmail.com',
        address: 'K77/22 Thái Phiên, Quảng Trị'
      },
      facility: {
        id: 6,
        name: 'Room Twin 02',
        area: 3000,
        cost: 900000,
        maxPeople: 2,
        rentType: 'Room',
        serviceType: 'Day',
        standardRoom: 'Normal',
        description: 'Có tivi',
        poolArea: 300,
        numberOfFloor: 2,
        image: 'https://furamavietnam.com/wp-content/uploads/2018/03/Presidential-Suite-F-370x239.jpg'
      }
    }
  ];
}
