package model.repository.iservice;

import model.bean.Service;

import java.util.List;

public interface IServiceRepository {
    List<Service> selectAllService();

    boolean insertService(Service service);

    Service selectService(int id);

    boolean updateService(Service service);

    boolean deleteService(int id);

    List<Service> searchService(String nameSearch, String rentTypeSearch, String serviceTypeSearch);
}
