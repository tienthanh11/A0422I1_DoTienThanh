import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SumServlet", value = "/sum")
public class SumServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int n1 = Integer.parseInt(request.getParameter("num1"));
        int n2 = Integer.parseInt(request.getParameter("num2"));
        int s = n1+n2;
        // cách này không dùng vì nó chuối
//        PrintWriter printWriter = response.getWriter();
//        printWriter.write("<h1> doGet chay</h1");
//        printWriter.write("<h1> Ket Qua : " + s + "</h1");
        // cách hay hơn
        request.setAttribute("sum",s);
        request.getRequestDispatcher("result.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        printWriter.write("<h1> doPost chay</h1");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("servlet duoc khoi tao");
    }

    @Override
    public void destroy() {
        System.out.println("servlet bi pha huy");
    }
}
