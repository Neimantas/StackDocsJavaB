package Services;

import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.TopicsDAL;
import Models.DTO.DocTagsDTO;
import Models.DTO.TopicsDTO;
import Services.Impl.HigherService;
import java.util.ArrayList;
import java.util.List;

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
        if (docTagId == null && searchQuery == null) return listT;

        //If docTags exist, reducing list to chosen language by docTagId
        if (docTagId != null) {
            List<TopicsDAL> tempT = new ArrayList<>();
            for (int i = 0; i < listT.size(); i++) {
                if (listT.get(i).getDocTagId() == Long.parseLong(docTagId)) {
                    tempT.add(listT.get(i));
                }
            }
            listT = tempT; // might work like that might new another temp list
        }

        //If searchQuery exists, searching if list of Topics contains query's
        if (searchQuery != null) {
            List<TopicsDAL> tempT = new ArrayList<>();
            String[] queries = searchQuery.split(" ");
            for (int i = 0; i < listT.size(); i++) {
                for (int j = 0; j < queries.length; j++) {
                    if (hs.getDocTagById("" + listT.get(i).getDocTagId()).getData().get(0).getTitle().equals(queries[j]) || listT.get(i).getTitle().equals(queries[j])) {
                        tempT.add(listT.get(i));
                    }
                }
            }
            listT = tempT;
        }
        return listT;
    }
}
