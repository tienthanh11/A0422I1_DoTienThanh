package model.repository.impl.service;

import model.bean.Service;
import model.repository.BaseRepository;
import model.repository.iservice.IServiceRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepository implements IServiceRepository {
    private static final String SELECT_ALL_SERVICE = "select * from service;";

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String serviceName = resultSet.getString("service_name");
                int serviceArea = resultSet.getInt("service_area");
                double serviceCost = resultSet.getDouble("service_cost");
                int serviceMaxPeople = resultSet.getInt("service_max_people");
                int rentTypeId = resultSet.getInt("rent_type_id");
                int serviceTypeId = resultSet.getInt("service_type_id");
                String standardRoom = resultSet.getString("standard_room");
                String descriptionOtherConvenience = resultSet.getString("description_other_convenience");
                double poolArea = resultSet.getDouble("pool_area");
                int numberOfFloor = resultSet.getInt("number_of_floors");
                serviceList.add(new Service(id, serviceName, serviceArea, serviceCost, serviceMaxPeople, rentTypeId,
                        serviceTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloor));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceList;
    }

    @Override
    public boolean insertService(Service service) {
        return false;
    }

    @Override
    public Service selectService(int id) {
        return null;
    }

    @Override
    public boolean updateService(Service service) {
        return false;
    }

    @Override
    public boolean deleteService(int id) {
        return false;
    }

    @Override
    public List<Service> searchService(String nameSearch, String rentTypeSearch, String serviceTypeSearch) {
        return null;
    }

}
