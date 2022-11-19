package model.service.impl.service;

import model.bean.Service;
import model.repository.impl.service.ServiceRepository;
import model.repository.iservice.IServiceRepository;
import model.service.iservice.IServiceService;

import java.util.List;

public class ServiceService implements IServiceService {
    IServiceRepository serviceRepository = new ServiceRepository();

    @Override
    public List<Service> selectAllService() {
        return serviceRepository.selectAllService();
    }

    @Override
    public boolean insertService(Service service) {
        return serviceRepository.insertService(service);
    }

    @Override
    public Service selectService(int id) {
        return serviceRepository.selectService(id);
    }

    @Override
    public boolean updateService(Service service) {
        return serviceRepository.updateService(service);
    }

    @Override
    public boolean deleteService(int id) {
        return serviceRepository.deleteService(id);
    }

    @Override
    public List<Service> searchService(String nameSearch, String rentTypeSearch, String serviceTypeSearch) {
        return serviceRepository.searchService(nameSearch, rentTypeSearch, serviceTypeSearch);
    }
}
