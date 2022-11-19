package model.service.impl.customer;

import model.bean.CustomerType;
import model.repository.icustomer.ICustomerTypeRepository;
import model.repository.impl.customer.CustomerTypeRepository;
import model.service.icustomer.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    ICustomerTypeRepository customerTypeRepository = new CustomerTypeRepository();

    @Override
    public List<CustomerType> selectAllCustomerType() {
        return customerTypeRepository.selectAllCustomerType();
    }
}
