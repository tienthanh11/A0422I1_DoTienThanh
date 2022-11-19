package model.repository.impl.employee;

import model.bean.Employee;
import model.repository.BaseRepository;
import model.repository.iemployee.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String SELECT_ALL_EMPLOYEE = "select * from employee;";
    private static final String INSERT_EMPLOYEE_SQL = "insert into employee (employee_name, employee_birthday, " +
            "employee_id_card, employee_salary, employee_phone, employee_email, employee_address, position_id, " +
            "education_degree_id, division_id, username) " +
            "values (?,?,?,?,?,?,?,?,?,?,?);";
    private static final String SELECT_EMPLOYEE_BY_ID = "select * from employee where employee_id = ?;";
    private static final String UPDATE_EMPLOYEE_SQL = "update employee set employee_name = ?, employee_birthday = ?, " +
            "employee_id_card = ?, employee_salary = ?, employee_phone = ?, employee_email = ?, employee_address = ?, " +
            "position_id = ?,education_degree_id = ?,division_id = ?,username = ? where employee_id = ?;";
    private static final String DELETE_EMPLOYEE = "delete from employee where employee_id = ?;";
    private static final String SEARCH_EMPLOYEE_SQL = "select * from employee where employee_name like ? " +
            "and position_id like ? and division_id like ?;";

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                        educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
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
    public Employee selectEmployee(int id) {
        Employee employee = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_BY_ID)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("employee_id");
                String name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employee = new Employee(id, name, birthday, idCard, salary, phone, email, address,
                        positionId, educationDegreeId, divisionId, username);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee;
    }

    @Override
    public boolean updateEmployee(Employee employee) {
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, employee.getEmployeeName());
            preparedStatement.setString(2, employee.getEmployeeBirthday());
            preparedStatement.setString(3, employee.getEmployeeIdCard());
            preparedStatement.setDouble(4, employee.getEmployeeSalary());
            preparedStatement.setString(5, employee.getEmployeePhone());
            preparedStatement.setString(6, employee.getEmployeeEmail());
            preparedStatement.setString(7, employee.getEmployeeAddress());
            preparedStatement.setInt(8, employee.getPositionId());
            preparedStatement.setInt(9, employee.getEducationDegreeId());
            preparedStatement.setInt(10, employee.getDivisionId());
            preparedStatement.setString(11, employee.getUsername());
            preparedStatement.setInt(12, employee.getEmployeeId());
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
    public boolean deleteEmployee(int id) {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_EMPLOYEE)) {
            preparedStatement.setInt(1, id);
            rowDeleted = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rowDeleted;
    }

    @Override
    public List<Employee> search(String name, String position, String division) {
        List<Employee> employeeList = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_EMPLOYEE_SQL)) {
            preparedStatement.setString(1, "%" + name + "%");
            preparedStatement.setString(2, "%" + position + "%");
            preparedStatement.setString(3, "%" + division + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("employee_id");
                name = resultSet.getString("employee_name");
                String birthday = resultSet.getString("employee_birthday");
                String idCard = resultSet.getString("employee_id_card");
                double salary = resultSet.getDouble("employee_salary");
                String phone = resultSet.getString("employee_phone");
                String email = resultSet.getString("employee_email");
                String address = resultSet.getString("employee_address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("division_id");
                String username = resultSet.getString("username");
                employeeList.add(new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                        educationDegreeId, divisionId, username));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeList;
    }
}
