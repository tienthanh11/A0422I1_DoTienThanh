package controller;

import model.bean.Customer;
import model.bean.CustomerType;
import model.service.icustomer.ICustomerService;
import model.service.icustomer.ICustomerTypeService;
import model.service.impl.customer.CustomerService;
import model.service.impl.customer.CustomerTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    private ICustomerService customerService = new CustomerService();
    private ICustomerTypeService customerTypeService = new CustomerTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
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
                deleteCustomer(request, response);
                break;
            case "search":
                searchCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();

        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer = customerService.selectCustomer(id);
        request.setAttribute("customer", customer);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.selectAllCustomer();
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();

        int id = Integer.parseInt(request.getParameter("idDelete"));
        boolean flag = customerService.deleteCustomer(id);
        if(flag) {
            request.setAttribute("mess", "Customer was deleted");
        } else {
            request.setAttribute("mess", "Unsuccessful");
        }
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameSearch = request.getParameter("nameSearch");
        String typeSearch = request.getParameter("typeSearch");
        String addressSearch = request.getParameter("addressSearch");
        List<Customer> customerList = customerService.search(nameSearch, typeSearch, addressSearch);
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = customerService.selectAllCustomer();
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        request.setAttribute("customerList", customerList);
        request.setAttribute("customerTypeList", customerTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                insertCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
        }
    }

    private void insertCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        int type = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(type, name, birthday, gender, idCard, phone, email, address);
        customerService.insertCustomer(customer);
        request.setAttribute("customerTypeList", customerTypeList);
        request.setAttribute("mess", "Customer was added");
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/create.jsp");
        dispatcher.forward(request, response);
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerTypeList = customerTypeService.selectAllCustomerType();
        int id = Integer.parseInt(request.getParameter("id"));
        int type = Integer.parseInt(request.getParameter("type"));
        String name = request.getParameter("name");
        String birthday = request.getParameter("birthday");
        int gender = Integer.parseInt(request.getParameter("gender"));
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        Customer customer = new Customer(id, type, name, birthday, gender, idCard, phone, email, address);
        boolean flag = customerService.updateCustomer(customer);
        if(flag) {
            request.setAttribute("mess", "Customer was updated");
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypeList", customerTypeList);
        } else {
            request.setAttribute("mess", "Unsuccessful");
            request.setAttribute("customer", customer);
            request.setAttribute("customerTypeList", customerTypeList);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }
}
