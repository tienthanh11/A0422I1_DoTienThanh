package model.service.impl.service;

import model.bean.ServiceType;
import model.repository.impl.service.ServiceTypeRepository;
import model.repository.iservice.IServiceTypeRepository;
import model.service.iservice.IServiceTypeService;

import java.util.List;

public class ServiceTypeService implements IServiceTypeService {
    IServiceTypeRepository serviceTypeRepository = new ServiceTypeRepository();

    @Override
    public List<ServiceType> selectAllServiceType() {
        return serviceTypeRepository.selectAllServiceType();
    }
}
