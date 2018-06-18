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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pagination {

    private int listSize = 10;
    private IHigherService hs = new HigherService();

    //gali buti pagerintas kad grazintu DTO, pvz PaginationDTO
    //reikia dar vieno kintamojo kuris butu ieskojimai, pvz pagal kalbas, ir dar vieno search field
    public List<Topic> listOfThemes(int pageNumber, String docTagid, String searchQuery) {
        TopicsDTO topicsDTO = hs.getAllTopics();
        DocTagsDTO docTagsDTO = hs.getAllDocTags();
        if (topicsDTO.isSuccess() && docTagsDTO.isSuccess()) {
            List<DocTagsDAL> listD = docTagsDTO.getData();
            List<TopicsDAL> listT = searchValues(topicsDTO.getData(), listD, docTagid, searchQuery);
            List<Topic> topics = new ArrayList<>();
            int counter = (pageNumber - 1) * listSize;
            for (int i = 0; i < listT.size(); i++) {
                if (pageNumber * listSize > counter) {
                    Topic dt = new Topic();
                    dt.setId(listT.get(counter).getId());
                    dt.setTitle(listT.get(counter).getTitle());
                    for (int j = 0; j < listD.size(); j++) {
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

    private List<TopicsDAL> searchValues(List<TopicsDAL> listT, List<DocTagsDAL> listD, String docTagId, String searchQuery) {
        List<TopicsDAL> tempT = new ArrayList<>();
        //If docTags exist, reducing list to chosen language by docTagId
        if (docTagId != null) {
            for (int i = 0; i < listT.size(); i++) {
                if (listT.get(i).getDocTagId() == Long.parseLong(docTagId)) {
                    tempT.add(listT.get(i));
                }
            }
        } else {
            tempT = listT;
        }
        //If searchQuery exists, searching if list of Topics contains query's
        List<TopicsDAL> newTemp = new ArrayList<>();
        if (searchQuery != null) {
            String[] querys = searchQuery.split(" ");
            for (int i = 0; i < tempT.size(); i++) {
                for (int j = 0; j < querys.length; j++) {
                    if (hs.getDocTagById("" + tempT.get(i).getDocTagId()).getData().get(0).getTitle().equals(querys[j]) || tempT.get(i).getTitle().equals(querys[j])) {
                        newTemp.add(tempT.get(i));
                    }
                }
            }
        } else {
            newTemp = tempT;
        }

        return newTemp;
    }
}
