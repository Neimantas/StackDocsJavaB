package Controllers;

import Models.BusinessLogic.DocTag;
import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.TopicsDAL;
import Models.DTO.DocTagsDTO;
import Models.DTO.TopicsDTO;
import Services.DropDown;
import Services.IHigherService;
import Services.Impl.HigherService;
import Services.Pagination;

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
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int paramSize = request.getParameterMap().size();
        String language = request.getParameter("kalba");
        String search = request.getParameter("paieska");
        String page = request.getParameter("puslapis");
        int pageNum = page != null ? Integer.parseInt(page) : 1;
        System.out.println(paramSize);
        System.out.println(language + " || " + search + " || " + page);
        if (paramSize > 0) {
            Pagination pagination = new Pagination();
//            List<Topic> dataList = pagination.getList(pageNum, language, search);
//            request.setAttribute("data", dataList);
        } else {
            DropDown dropDown = new DropDown();
            List<DocTag> dataList = dropDown.getList();
            request.setAttribute("doctags", dataList);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
//        response.sendRedirect("http://localhost:8080/index.jsp");
    }
}


//            IHigherService higher = new HigherService();
//            TopicsDTO dto = higher.getAllTopics();
//
//            if (dto.isSuccess()){
//                List<TopicsDAL> dalList = dto.getData();
//                List<Topic> topicList = new ArrayList<>();
//                dalList.forEach(dal -> {
//                    Topic topic = new Topic();
//                    topic.setId(dal.getId());
//                    topic.setTitle(dal.getTitle());
//                    topic.setDocTagTitle();
//                    topicList.add(topic);
//                });
//                request.setAttribute("data", topicList);
//                request.getRequestDispatcher("index.jsp").forward(request, response);
//            } else {
//                response.sendRedirect("http://localhost:8080/index.jsp");
//            }