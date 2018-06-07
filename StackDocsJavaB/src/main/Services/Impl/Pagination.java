package Services.Impl;

import Models.BusinessLogic.DocTag;
import Models.BusinessLogic.Example;
import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.ExampleDAL;
import Models.DAL.TopicsDAL;
import Models.DTO.TopicsDTO;
import Services.IPagination;

import java.util.List;

public class Pagination implements IPagination {

    int currentPage = 1;
    List<String> currentPages;
    HigherService hServ = new HigherService();


    // cia tikriausiai tures grazint DTO
    @Override
    public List<String> nextTenPages() {
        currentPage++;
        TopicsDTO tDto = hServ.getAllTopics();
        if (tDto.isSuccess()) {
            tDto.getData();


            return null;
        } else {

            return null;
        }
    }

    @Override
    public List<String> previousTenPages() {
        if (currentPage > 1) {
            currentPage--;
        }
        return null;
    }





    private DocTag changeDocTagsDALtoDocTag(DocTagsDAL dal) {
        DocTag dt = new DocTag();
        dt.setId(dal.getId());
        dt.setTag(dal.getTag());
        dt.setTitle(dal.getTitle());
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
