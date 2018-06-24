//package Controllers;
//
//import Models.BusinessLogic.Topic;
//import Models.DAL.DocTagsDAL;
//import Models.DAL.TopicsDAL;
//import Models.DTO.DocTagsDTO;
//import Models.DTO.TopicsDTO;
//import Services.IHigherService;
//import Services.Impl.HigherService;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//@WebServlet(name = "ServletTopics", urlPatterns = {"/topics"})
//public class ServletTopics extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//        String topicID = request.getParameter("topicId");
//        System.out.println(topicID);
//        if( topicID ==null){
//            response.sendRedirect( "http://localhost:8080/index.jsp");
//        }else {
//            IHigherService higher = new HigherService();
//            TopicsDTO dto = higher.getTopicById(topicID);
//            TopicsDAL topic = new TopicsDAL();
//
//            if (dto.isSuccess()) {
//                topic = dto.getData().get(0);
//                request.setAttribute("data", topic);
//                request.getRequestDispatcher("topics.jsp").forward(request, response);
//            } else {
//                response.sendRedirect( "http://localhost:8080/index.jsp");
//            }
//
//
////            if (dto.isSuccess()){
////                List<TopicsDAL> dalList = dto.getData();
////
////            }
//        }
//    }
//}
//
