package model.repository.impl.customer;

import model.bean.Customer;
import model.repository.BaseRepository;
import model.repository.icustomer.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static final String SELECT_ALL_CUSTOMER = "select * from customer;";
    private static final String INSERT_CUSTOMER_SQL = "insert into customer(customer_type_id,customer_name," +
            "customer_birthday,customer_gender,customer_id_card,customer_phone,customer_email,customer_address) " +
            "values (?,?,?,?,?,?,?,?);";
    private static final String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id = ?;";
    private static final String UPDATE_CUSTOMER_SQL = "update customer set customer_type_id = ?, customer_name  = ?, " +
            "customer_birthday = ?, customer_gender = ?, customer_id_card = ?,customer_phone = ?, customer_email = ?, " +
            "customer_address = ? where customer_id = ?;";
    private static final String DELETE_CUSTOMER = "delete from customer where customer_id = ?;";
    private static final String SEARCH_CUSTOMER_SQL = "select * from customer where customer_name like ? " +
            "and customer_address like ? and customer_type_id like ?;";


    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customerList.add(new Customer(id, customerTypeId, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }

    @Override
    public boolean insertCustomer(Customer customer) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            int check = preparedStatement.executeUpdate();
            if (check != 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public Customer selectCustomer(int id) {
        Customer customer = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CUSTOMER_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customer = new Customer(id, customerTypeId, customerName, customerBirthday, customerGender, customerIdCard,
                        customerPhone, customerEmail, customerAddress);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getCustomerTypeId());
            preparedStatement.setString(2, customer.getCustomerName());
            preparedStatement.setString(3, customer.getCustomerBirthday());
            preparedStatement.setInt(4, customer.getCustomerGender());
            preparedStatement.setString(5, customer.getCustomerIdCard());
            preparedStatement.setString(6, customer.getCustomerPhone());
            preparedStatement.setString(7, customer.getCustomerEmail());
            preparedStatement.setString(8, customer.getCustomerAddress());
            preparedStatement.setInt(9, customer.getCustomerId());
            System.out.println(preparedStatement);
            int check = preparedStatement.executeUpdate();
            if (check != 0) {
                return true;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean deleteCustomer(int id) {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public List<Customer> search(String name, String type, String address) {
        List<Customer> customerList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_CUSTOMER_SQL)) {
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + address + "%");
            preparedStatement.setString(3, "%" + type + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                int customerTypeId = resultSet.getInt("customer_type_id");
                String customerName = resultSet.getString("customer_name");
                String customerBirthday = resultSet.getString("customer_birthday");
                int customerGender = resultSet.getInt("customer_gender");
                String customerIdCard = resultSet.getString("customer_id_card");
                String customerPhone = resultSet.getString("customer_phone");
                String customerEmail = resultSet.getString("customer_email");
                String customerAddress = resultSet.getString("customer_address");
                customerList.add(new Customer(id, customerTypeId, customerName, customerBirthday, customerGender,
                        customerIdCard, customerPhone, customerEmail, customerAddress));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerList;
    }
}
