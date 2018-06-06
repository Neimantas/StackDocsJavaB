import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/ServletIndex")
public class ServletIndex extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




//        response.setContentType("text/html");
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("VEIKIA.");
//        out.println("</body></html>");

//        response.getWriter().print(request.getParameter("getValue1"));

//        PrintWriter out = response.getWriter();
//        out.println("value 1 = " + request.getParameter("reikesme"));
//        out.println("value 2 = " + request.getParameter("reiksme2"));


    }
}
