package controller;

import model.Ground;
import model.Status;
import model.TypeOffice;
import service.GroundServiceImpl;
import service.IGroundService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "GroundServlet", urlPatterns = "/ground")
public class GroundServlet extends HttpServlet {
    IGroundService groundService = new GroundServiceImpl();

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
                deleteGround(request, response);
                break;
            case "search":
                searchGround(request, response);
                break;
            default:
                listGround(request, response);
                break;
        }
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TypeOffice> typeOfficeList = groundService.selectAllTypeOffice();
        List<Status> statusList = groundService.selectAllStatus();
        List<Integer> listFloors = groundService.listFloors();
        request.setAttribute("typeOfficeList", typeOfficeList);
        request.setAttribute("statusList", statusList);
        request.setAttribute("listFloors", listFloors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ground/create.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Ground ground = groundService.selectGround(id);
        List<TypeOffice> typeOfficeList = groundService.selectAllTypeOffice();
        List<Status> statusList = groundService.selectAllStatus();
        List<Integer> listFloors = groundService.listFloors();
        request.setAttribute("ground", ground);
        request.setAttribute("listFloors", listFloors);
        request.setAttribute("typeOfficeList", typeOfficeList);
        request.setAttribute("statusList", statusList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ground/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void deleteGround(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        boolean check = groundService.deleteGround(id);
        if(check) {
            request.setAttribute("message", "Xoá thành công");
        } else {
            request.setAttribute("message", "Xóa thất bại");
        }
        List<Ground> groundList = groundService.selectAllGround();
        List<TypeOffice> typeOfficeList = groundService.selectAllTypeOffice();
        List<Status> statusList = groundService.selectAllStatus();
        List<Integer> listFloors = groundService.listFloors();
        request.setAttribute("groundList", groundList);
        request.setAttribute("typeOfficeList", typeOfficeList);
        request.setAttribute("statusList", statusList);
        request.setAttribute("listFloors", listFloors);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ground/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchGround(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String typeOfficeSearch = request.getParameter("typeOfficeSearch");
        String floorsSearch = request.getParameter("floorsSearch");
        String priceSearch = request.getParameter("priceSearch");
        List<Ground> groundList = groundService.search(typeOfficeSearch, floorsSearch, priceSearch);
        List<TypeOffice> typeOfficeList = groundService.selectAllTypeOffice();
        List<Status> statusList = groundService.selectAllStatus();
        List<Integer> listFloors = groundService.listFloors();
        request.setAttribute("groundList", groundList);
        request.setAttribute("listFloors", listFloors);
        request.setAttribute("typeOfficeList", typeOfficeList);
        request.setAttribute("statusList", statusList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ground/list.jsp");
        dispatcher.forward(request, response);
    }

    private void listGround(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Ground> groundList = groundService.selectAllGround();
        List<Integer> listFloors = groundService.listFloors();
        List<TypeOffice> typeOfficeList = groundService.selectAllTypeOffice();
        List<Status> statusList = groundService.selectAllStatus();
        request.setAttribute("groundList", groundList);
        request.setAttribute("listFloors", listFloors);
        request.setAttribute("typeOfficeList", typeOfficeList);
        request.setAttribute("statusList", statusList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ground/list.jsp");
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
                createGround(request, response);
                break;
            case "edit":
                updateGround(request, response);
                break;
        }
    }

    private void createGround(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        double area = Double.parseDouble(request.getParameter("area"));
        int statusId = Integer.parseInt(request.getParameter("status"));
        int floors = Integer.parseInt(request.getParameter("floors"));
        int typeOfficeId = Integer.parseInt(request.getParameter("typeOffice"));
        String description = request.getParameter("description");
        double rentalPrice = Double.parseDouble(request.getParameter("rentalPrice"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Ground ground = new Ground(id, area, statusId, floors, typeOfficeId, description, rentalPrice, startDate, endDate);
        Map<String, String> error = groundService.insertGround(ground);
        List<Ground> groundList = groundService.selectAllGround();
        List<TypeOffice> typeOfficeList = groundService.selectAllTypeOffice();
        List<Status> statusList = groundService.selectAllStatus();
        List<Integer> listFloors = groundService.listFloors();
        RequestDispatcher dispatcher = null;
        if (error.isEmpty()) {
            request.setAttribute("message", "Thêm mới thành công");
            request.setAttribute("groundList", groundList);
            request.setAttribute("typeOfficeList", typeOfficeList);
            request.setAttribute("statusList", statusList);
            dispatcher = request.getRequestDispatcher("ground/list.jsp");
        } else {
            request.setAttribute("message", "Thêm mới không thành công");
            request.setAttribute("listFloors", listFloors);
            request.setAttribute("groundList", groundList);
            request.setAttribute("typeOfficeList", typeOfficeList);
            request.setAttribute("statusList", statusList);
            request.setAttribute("ground", ground);
            request.setAttribute("error", error);
            dispatcher = request.getRequestDispatcher("ground/create.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void updateGround(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        double area = Double.parseDouble(request.getParameter("area"));
        int statusId = Integer.parseInt(request.getParameter("status"));
        int floors = Integer.parseInt(request.getParameter("floors"));
        int typeOfficeId = Integer.parseInt(request.getParameter("typeOffice"));
        String description = request.getParameter("description");
        double rentalPrice = Double.parseDouble(request.getParameter("rentalPrice"));
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        Ground ground = new Ground(id, area, statusId, floors, typeOfficeId, description, rentalPrice, startDate, endDate);
        List<TypeOffice> typeOfficeList = groundService.selectAllTypeOffice();
        List<Status> statusList = groundService.selectAllStatus();
        Map<String, String> error = groundService.updateGround(ground);
        if (error.isEmpty()) {
            request.setAttribute("message", "Chỉnh sửa thành công");
            List<Ground> groundList = groundService.selectAllGround();
            request.setAttribute("groundList", groundList);
            request.setAttribute("typeOfficeList", typeOfficeList);
            request.setAttribute("statusList", statusList);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ground/list.jsp");
            dispatcher.forward(request, response);
        } else {
            request.setAttribute("message", "Chỉnh sửa không thành công");
            request.setAttribute("typeOfficeList", typeOfficeList);
            request.setAttribute("statusList", statusList);
            request.setAttribute("error", error);
            request.setAttribute("ground", ground);
            RequestDispatcher dispatcher = request.getRequestDispatcher("ground/edit.jsp");
            dispatcher.forward(request, response);
        }
    }
}
