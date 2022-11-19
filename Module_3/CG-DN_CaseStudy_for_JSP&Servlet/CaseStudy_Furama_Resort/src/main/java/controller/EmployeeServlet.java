package controller;

import model.bean.Division;
import model.bean.EducationDegree;
import model.bean.Employee;
import model.bean.Position;
import model.service.iemployee.IDivisionService;
import model.service.iemployee.IEducationDegreeService;
import model.service.iemployee.IEmployeeService;
import model.service.iemployee.IPositionService;
import model.service.impl.employee.DivisionService;
import model.service.impl.employee.EducationDegreeService;
import model.service.impl.employee.EmployeeService;
import model.service.impl.employee.PositionService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IPositionService positionService = new PositionService();
    private IEducationDegreeService educationDegreeService = new EducationDegreeService();
    private IDivisionService divisionService = new DivisionService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;
            case "search":
                searchEmployee(request, response);
                break;
            default:
                listEmployee(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.selectEmployee(id);
        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("employee", employee);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        boolean flag = employeeService.deleteEmployee(id);
        if (flag) {
            request.setAttribute("mess", "Employee was deleted");
        } else {
            request.setAttribute("mess", "Unsuccessful");
        }
        List<Employee> employeeList = employeeService.selectAllEmployee();
        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        String positionSearch = request.getParameter("positionSearch");
        String divisionSearch = request.getParameter("divisionSearch");
        List<Employee> employeeList = employeeService.search(nameSearch, positionSearch, divisionSearch);
        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("nameSearch", nameSearch);
//        request.setAttribute("positionSearch", positionSearch);
//        request.setAttribute("divisionSearch", divisionSearch);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertEmployee(request, response);
                break;
            case "edit":
                updateEmployee(request, response);
                break;
        }
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Position> positionList = positionService.selectAllPosition();
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducationDegree();
        List<Division> divisionList = divisionService.selectAllDivision();

        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(name, birthday, idCard, salary, phone, email, address, positionId,
                educationDegreeId, divisionId, username);
        request.setAttribute("positionList", positionList);
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("divisionList", divisionList);
        employeeService.insertEmployee(employee);
        request.setAttribute("mess", "Employee was added");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionId"));
        int educationDegreeId = Integer.parseInt(request.getParameter("educationDegreeId"));
        int divisionId = Integer.parseInt(request.getParameter("divisionId"));
        String username = request.getParameter("username");
        Employee employee = new Employee(id, name, birthday, idCard, salary, phone, email, address, positionId,
                educationDegreeId, divisionId, username);
        boolean flag = employeeService.updateEmployee(employee);
        if (flag) {
            request.setAttribute("mess", "Employee was edited");
        } else {
            request.setAttribute("mess", "Unsuccessful");
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/edit.jsp");
        dispatcher.forward(request, response);
    }
}
