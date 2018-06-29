package Controllers;

import Models.DAL.ExampleDAL;
import Models.DAL.TopicsDAL;
import Models.DTO.ExampleDTO;
import Models.DTO.TopicsDTO;
import Services.IHigherService;
import Services.Impl.HigherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletTopics", urlPatterns = {"/topics"})
public class ServletTopics extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String topicID = request.getParameter("topicId");
        System.out.println(topicID);
        if (topicID == null) {
            response.sendRedirect("http://localhost:8080/index.jsp");
        } else {
            IHigherService higher = new HigherService();
            TopicsDTO dto = higher.getTopicById(topicID);
            ExampleDTO exDto = higher.getExamplesByTopicsId(topicID);
            TopicsDAL topic;
            ExampleDAL example;
            if (dto.isSuccess()) {
                topic = dto.getList().get(0);
                request.setAttribute("data", topic);
                example = exDto.getList().get(0);
                request.setAttribute("exData", example);
                request.getRequestDispatcher("topics.jsp").forward(request, response);
            } else {
                response.sendRedirect("http://localhost:8080/index.jsp");
            }
        }
    }
}

