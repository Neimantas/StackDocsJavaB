package Services;

import Models.BusinessLogic.DocTag;
import Models.BusinessLogic.Example;
import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.ExampleDAL;
import Models.DAL.TopicsDAL;
import Models.DTO.DocTagsDTO;
import Models.DTO.TopicsDTO;
import Services.Impl.HigherService;
import java.util.ArrayList;
import java.util.List;

public class Pagination {

    private int listSize = 10;
    private HigherService hs = new HigherService();

    //gali buti pagerintas kad grazintu DTO, pvz PaginationDTO
    //reikia dar vieno kintamojo kuris butu ieskojimai, pvz pagal kalbas, ir dar vieno search field
    public List<Topic> listOfThemes(int pageNumber) { // 3
        TopicsDTO topicsDTO = hs.getAllTopics();
        DocTagsDTO docTagsDTO = hs.getAllDocTags();
        if (topicsDTO.isSuccess() && docTagsDTO.isSuccess()) {
            List<TopicsDAL> listT = topicsDTO.getData();
            List<DocTagsDAL> listD = docTagsDTO.getData();
            List<Topic> topics = new ArrayList<>();
            int counter = (pageNumber - 1) * listSize; // 20
            for (int i = 0; i < listT.size(); i++) {
                if (pageNumber * listSize > counter) { // 30 > 20
                    Topic dt = new Topic();
                    dt.setId(listT.get(counter).getId());
                    dt.setTitle(listT.get(counter).getTitle());
                    for (int j = 0; j < listD.size() ; j++) {
                        if (listT.get(counter).getDocTagId() == listD.get(j).getId())
                        dt.setDocTagTitle(listD.get(j).getTitle());
                    }
                    topics.add(dt);
                    counter++;
                }
            }
            return topics;
        } else {
            return null;
        }
    }
}
