package model.service.impl.employee;

import model.bean.Employee;
import model.repository.iemployee.IEmployeeRepository;
import model.repository.impl.employee.EmployeeRepository;
import model.service.iemployee.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeRepository.insertEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int id) {
        return employeeRepository.selectEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        return employeeRepository.updateEmployee(employee);
    }

    @Override
    public boolean deleteEmployee(int id) {
        return employeeRepository.deleteEmployee(id);
    }

    @Override
    public List<Employee> search(String name, String position, String division) {
        return employeeRepository.search(name, position, division);
    }
}
