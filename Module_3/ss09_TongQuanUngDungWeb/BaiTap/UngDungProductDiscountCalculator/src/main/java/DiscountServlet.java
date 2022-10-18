import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DiscountServlet", urlPatterns = "/display-discount")
public class DiscountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String description = request.getParameter("description");
        float price = Float.parseFloat(request.getParameter("price"));
        int discount_percent = Integer.parseInt(request.getParameter("discount"));
        float discount_amount = (float) (price * discount_percent * 0.01);
        float total = price - discount_amount;

        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Product Description: " + description + "</h1>");
        printWriter.println("<h1>List Price: " + price + "</h1>");
        printWriter.println("<h1>Discount Percent: " + discount_percent + "</h1>");
        printWriter.println("<h1>Discount Amount: " + discount_amount + "</h1>");
        printWriter.println("<h1>Discount Price: " + total + "</h1>");
        printWriter.println("</html>");
    }
}
