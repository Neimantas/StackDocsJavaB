package Controllers;

import Models.BusinessLogic.DocTag;

import Models.URLSettingsModel;
import Services.DropDown;

import Services.Pagination;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        String topic = request.getParameter("topicid");
        boolean after = request.getParameter("after") != null && Boolean.parseBoolean(request.getParameter("after"));
        int pageNum = page != null ? Integer.parseInt(page) : 1;
        System.out.println(paramSize);
        System.out.println(language + " || " + search + " || " + page + " || " + topic);
        if (paramSize > 0) {
            Pagination pagination = new Pagination();
            URLSettingsModel url = new URLSettingsModel();
            url.docTagId = language;
            url.topicId = topic;
            url.searchQuery = search;
            url.after = after;
            List<Topic> topicList = pagination.getList(url);
            request.setAttribute("topicList", topicList);

            DropDown dropDown = new DropDown();
            List<DocTag> docList = dropDown.getList();
            request.setAttribute("doctags", docList);
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