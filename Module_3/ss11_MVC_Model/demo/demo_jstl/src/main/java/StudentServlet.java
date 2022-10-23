import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentServlet", urlPatterns = {"/student", "/sinh-vien"})
public class StudentServlet extends HttpServlet {

    private static List<Student> studentList = new ArrayList<>();

    static {
        studentList.add(new Student(1, "thành", true, "12/12/2022", 8, "thanhdt", 1, "thanhdt@1"));
        studentList.add(new Student(2, "trí", false, "12/12/2022", 7, "trind", 1, "trind@1"));
        studentList.add(new Student(3, "thanh", true, "12/12/2022", 3, "thanhlv", 1, "thanhlv@1"));
        studentList.add(new Student(4, "thư", true, "12/12/2022", 5, "thuhnk", 1, "thuhnk@1"));
        studentList.add(new Student(5, "thắng", true, "12/12/2022", 9, "thanglx", 1, "thanglx@1"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("views/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
