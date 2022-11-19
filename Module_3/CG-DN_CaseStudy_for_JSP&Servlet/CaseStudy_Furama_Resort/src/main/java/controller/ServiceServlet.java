package controller;

import model.bean.RentType;
import model.bean.Service;
import model.bean.ServiceType;
import model.service.impl.service.RentTypeService;
import model.service.impl.service.ServiceService;
import model.service.impl.service.ServiceTypeService;
import model.service.iservice.IRentTypeService;
import model.service.iservice.IServiceService;
import model.service.iservice.IServiceTypeService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    private IServiceService serviceService = new ServiceService();
    private IServiceTypeService serviceTypeService = new ServiceTypeService();
    private IRentTypeService rentTypeService = new RentTypeService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null) {
            action = "";
        }
        switch (action) {
            case "create":

                break;
            case "edit":
                break;
            case "delete":
                break;
            case "search":
                break;
            default:
                listService(request, response);
                break;
        }
    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = serviceService.selectAllService();
        List<ServiceType> serviceTypeList = serviceTypeService.selectAllServiceType();
        List<RentType> rentTypeList = rentTypeService.selectAllRentType();
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("serviceTypeList", serviceTypeList);
        request.setAttribute("rentTypeList", rentTypeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/service/list.jsp");
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
                break;
            case "edit":
                break;
        }
    }
}
