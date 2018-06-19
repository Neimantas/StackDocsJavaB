package Controllers;

import Models.BusinessLogic.DocTag;
import Models.DAL.DocTagsDAL;
import Models.DTO.DocTagsDTO;
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
            response.sendRedirect( "http://localhost:8080/index.jsp");
        } else {
            IHigherService higher = new HigherService();
            DocTagsDTO dto = higher.getAllDocTags();
            if (dto.isSuccess()){
                List<DocTagsDAL> dalList = dto.getData();
                List<DocTag> tagList = new ArrayList<>();
                dalList.forEach(dal -> {
                    DocTag docTag = new DocTag();
                    docTag.setId(dal.getId());
                    docTag.setTag(dal.getTag());
                    docTag.setTitle(dal.getTitle());
                    tagList.add(docTag);
                });
//            ArrayList<String> tagList = new ArrayList<>();
//            tagList.add("Jonas");
//            tagList.add("Petras");
//            tagList.add("Jonas");
                request.setAttribute("data", tagList);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
//            request.setAttribute("name", "Krabas Kebabas");
//            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

//        response.getWriter().print(request.getParameter("kalba") + " -> kalba");
    }
}
