package model.repository.impl.service;

import model.bean.RentType;
import model.repository.BaseRepository;
import model.repository.iservice.IRentTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepository implements IRentTypeRepository {
    private static final String SELECT_ALL_RENT_TYPE = "select * from rent_type;";

    @Override
    public List<RentType> selectAllRentType() {
        List<RentType> rentTypeList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_RENT_TYPE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int rentTypeId = resultSet.getInt("rent_type_id");
                String rentTypeName = resultSet.getString("rent_type_name");
                double rentTypeCost = resultSet.getDouble("rent_type_cost");
                rentTypeList.add(new RentType(rentTypeId, rentTypeName, rentTypeCost));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rentTypeList;
    }
}
