package model.repository.impl.customer;

import model.bean.CustomerType;
import model.repository.BaseRepository;
import model.repository.icustomer.ICustomerTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
    private static final String SELECT_ALL_CUSTOMER_TYPE = "select * from customer_type;";

    @Override
    public List<CustomerType> selectAllCustomerType() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_type_id");
                String customerTypeName = resultSet.getString("customer_type_name");
                customerTypeList.add(new CustomerType(id, customerTypeName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customerTypeList;
    }
}
