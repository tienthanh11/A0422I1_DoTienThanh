package model.repository.iemployee;

import model.bean.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAllEmployee();

    boolean insertEmployee(Employee employee);

    Employee selectEmployee(int id);

    boolean updateEmployee(Employee employee);

    boolean deleteEmployee(int id);

    List<Employee> search(String name, String position, String division);
}
