package model.repository.icustomer;

import model.bean.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> selectAllCustomer();

    boolean insertCustomer(Customer customer);

    Customer selectCustomer(int id);

    boolean updateCustomer(Customer customer);

    boolean deleteCustomer(int id);

    List<Customer> search(String name, String type, String address);
}
