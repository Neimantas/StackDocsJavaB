package Controllers;

import Models.BusinessLogic.Topic;
import Models.DAL.TopicsDAL;
import Models.DTO.TopicsDTO;
import Services.IHigherService;
import Services.Impl.HigherService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletIndex", urlPatterns = {"/servletindex"})
public class ServletIndex extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameterMap().size());


        if (request.getParameterMap().size() == 0) {
            response.sendRedirect("http://localhost:8080/index.jsp");
        } else {
            IHigherService higher = new HigherService();
            TopicsDTO dto = higher.getAllTopics();
            if (dto.isSuccess()) {
                List<TopicsDAL> dalList = dto.getData();
                List<Topic> topicsList = new ArrayList<>();
                dalList.forEach(dal -> {
                    Topic topic = new Topic();
                    topic.setId(dal.getId());
                    topic.setTitle(dal.getTitle());
                    topicsList.add(topic);
                });

                request.setAttribute("data", topicsList);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
//            request.setAttribute("name", "Krabas Kebabas");
//            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

//        response.getWriter().print(request.getParameter("kalba") + " -> kalba");
    }
}
