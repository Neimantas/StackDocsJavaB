package Services;

import Models.BusinessLogic.DocTag;
import Models.BusinessLogic.Example;
import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.ExampleDAL;
import Models.DAL.TopicsDAL;
import Models.DTO.TopicsDTO;
import Services.Impl.HigherService;
import java.util.ArrayList;
import java.util.List;

public class Pagination {

    private int listSize = 10;
    private HigherService hServ = new HigherService();

    //gali buti pagerintas kad grazintu DTO, pvz PaginationDTO
    //reikia dar vieno kintamojo kuris butu ieskojimai, pvz pagal kalbas, ir dar vieno search field
    public List<String> listOfThemes(int pageNumber) {
        TopicsDTO tDto = hServ.getAllTopics();
        if (tDto.isSuccess()) {
            List<Topic> listTopics = new ArrayList<>();
            List<TopicsDAL> listDAL = tDto.getData();
            int counter = (pageNumber - 1) * listSize;
            for (int i = 0; i < listDAL.size(); i++) {
                if (pageNumber * listSize > counter) {
                    listTopics.add(changeTopicsDALtoTopic(listDAL.get(i)));
                    counter++;
                }
            }
            List<String> listOfThemes = new ArrayList<>();
            for (int i = 0; i < listTopics.size(); i++) {
                listOfThemes.add(listTopics.get(i).getTitle());
            }
            return listOfThemes;
        } else {
            return null;
        }
    }

    private DocTag changeDocTagsDALtoDocTag(DocTagsDAL dal) {
        DocTag dt = new DocTag();
        dt.setId(dal.getId());
        dt.setTag(dal.getTag());
        //dt.setTitle(dal.getTitle());
        return dt;
    }

    private Topic changeTopicsDALtoTopic(TopicsDAL dal) {
        Topic tp = new Topic();
        tp.setId(dal.getId());
        tp.setDocTagId(dal.getDocTagId());
        tp.setTitle(dal.getTitle());
        tp.setIntroductionHtml(dal.getIntroductionHtml());
        tp.setSyntaxHtml(dal.getSyntaxHtml());
        tp.setParametersHtml(dal.getParametersHtml());
        tp.setRemarksHtml(dal.getRemarksHtml());
        tp.setIntroductionMarkdown(dal.getIntroductionMarkdown());
        tp.setParametersMarkdown(dal.getParametersMarkdown());
        tp.setRemarksMarkdown(dal.getRemarksMarkdown());
        return tp;
    }

    private Example changeExaplesDALtoExample(ExampleDAL dal) {
        Example ex = new Example();
        ex.setId(dal.getId());
        ex.setDocTopicId(dal.getDocTopicId());
        ex.setTitle(dal.getTitle());
        ex.setBodyHTML(dal.getBodyHtml());
        ex.setBodyMarkdown(dal.getBodyMarkdown());
        return ex;
    }
}
