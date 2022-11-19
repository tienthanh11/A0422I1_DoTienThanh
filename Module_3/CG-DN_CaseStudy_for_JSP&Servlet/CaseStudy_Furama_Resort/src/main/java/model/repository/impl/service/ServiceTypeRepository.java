package model.repository.impl.service;

import model.bean.ServiceType;
import model.repository.BaseRepository;
import model.repository.iservice.IServiceTypeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepository implements IServiceTypeRepository {
    private static final String SELECT_ALL_SERVICE_TYPE = "select * from service_type;";

    @Override
    public List<ServiceType> selectAllServiceType() {
        List<ServiceType> serviceTypeList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE_TYPE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int serviceTypeId = resultSet.getInt("service_type_id");
                String serviceTypeName = resultSet.getString("service_type_name");
                serviceTypeList.add(new ServiceType(serviceTypeId, serviceTypeName));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceTypeList;
    }
}
