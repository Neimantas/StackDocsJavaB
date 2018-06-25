package Services;

import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.TopicsDAL;
import Models.DBQueryModel;
import Models.DTO.DocTagsDTO;
import Models.DTO.TopicsDTO;
import Services.Impl.Cache;
import Services.Impl.HigherService;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    private IHigherService hs = new HigherService();
    private ICache cache = Cache.getInstance();
    private List<String[]> topicsAndDocTagsIds = new ArrayList<>();
    private String[] collectedIds = new String[10];
    private List<Topic> topicsList = new ArrayList<>();
    private boolean allConnectionsWithDataBaseIsSuccess;

    public List<Topic> getList(String topicId, String docTagId, String searchQuery, Boolean after) {
        getListOftopicsAndDocTagsIdsFromDataBaseOrCache();
        reduceListByDocTagIdAndSearchQuery(docTagId, searchQuery);
        collectTopicsIds(topicId, after);
        makeListFromColletedIds();
        if (!allConnectionsWithDataBaseIsSuccess) {
            return null;
        }
        return topicsList;
    }

    private void reduceListByDocTagIdAndSearchQuery(String docTagId, String searchQuery) {
        //Reduce topicsAndDocTagsIds by docTagId
        if (docTagId != null) {
            List<String[]> tempList = new ArrayList<>();
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (topicsAndDocTagsIds.get(i)[1].equals(docTagId)) tempList.add(topicsAndDocTagsIds.get(i));
            }
            topicsAndDocTagsIds = tempList;
        }
        //Reduce topicsAndDocTagsIds by queries
        if (searchQuery != null || !normalizeText(searchQuery).equals("")) {
            String[] queries = searchQuery.trim().split(" ");
            //Take all list of topic ids
            String[] idsOfTopic = new String[topicsAndDocTagsIds.size()];
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                idsOfTopic[i] = topicsAndDocTagsIds.get(i)[0];
            }
            TopicsDTO topicsDTO = hs.getTopicById(idsOfTopic);
            allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
            if (topicsDTO.isSuccess()) {
                List<String[]> tempList = new ArrayList<>();
                for (int i = 0; i < topicsDTO.getData().size(); i++) {
                    for (int j = 0; j < queries.length; j++) {
                        if (topicsDTO.getData().get(i).getTitle().contains(normalizeText((queries[j])))
                                && topicsDTO.getData().get(i).getIntroductionMarkdown().contains(normalizeText((queries[j])))
                                && topicsDTO.getData().get(i).getParametersMarkdown().contains(normalizeText((queries[j])))
                                && topicsDTO.getData().get(i).getRemarksMarkdown().contains(normalizeText((queries[j])))
                                && topicsDTO.getData().get(i).getSyntaxMarkdown().contains(normalizeText((queries[j])))) {
                            String[] arr = {"" + topicsDTO.getData().get(i).getId(), "" + topicsDTO.getData().get(i).getDocTagId()};
                            tempList.add(arr);
                        }
                    }
                }
                topicsAndDocTagsIds = tempList;
            }
        }
    }

    private void collectTopicsIds(String topicId, Boolean after) {
        int counter = 0;
        int listSize = 10;
        if (after & topicId == null) {
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (counter >= 0 && counter < listSize) {
                    collectedIds[counter] = "" + topicsAndDocTagsIds.get(i)[0];
                    counter++;
                }
                if (counter == 10) {
                    break;
                }
            }
        }
        if (after) {
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (counter == 0 && topicsAndDocTagsIds.get(i)[0].equals(topicId)) {
                    collectedIds[counter] = "" + topicsAndDocTagsIds.get(i + 10)[0];
                    counter++;
                }
                if (counter > 0 && counter < listSize) {
                    collectedIds[counter] = "" + topicsAndDocTagsIds.get(i + 10)[0];
                    counter++;
                }
                if (counter == 10) {
                    break;
                }
            }
        }
        if (!after) {
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (counter == 0 && topicsAndDocTagsIds.get(i)[0].equals(topicId)) {
                    collectedIds[counter] = "" + topicsAndDocTagsIds.get(i - 10)[0];
                    counter++;
                }
                if (counter > 0 && counter < listSize) {
                    collectedIds[counter] = "" + topicsAndDocTagsIds.get(i - 10)[0];
                    counter++;
                }
                if (counter == 10) {
                    break;
                }
            }
        }
    }

    private void makeListFromColletedIds() {
        TopicsDTO topicsDTO = hs.getTopicById(collectedIds);
        allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
        if (topicsDTO.isSuccess()) {
            for (int i = 0; i < topicsDTO.getData().size(); i++) {
                topicsList.add(makeTopicFromTopicsDal(topicsDTO.getData().get(i)));
            }
        }
    }

    private Topic makeTopicFromTopicsDal(TopicsDAL dal) {
        Topic topic = new Topic();
        topic.setId(dal.getId());
        topic.setTitle(dal.getTitle());
        //topic.setDocTagTitle(hs.getDocTagById("" + dal.getDocTagId()).getData().get(0).getTag());
        return topic;
    }

    private void getListOftopicsAndDocTagsIdsFromDataBaseOrCache() {
        String LIST_PLACEMENT_IN_CACHE = "topicsAndDocTagsIds";
        if (cache.get(LIST_PLACEMENT_IN_CACHE) == null) {
            TopicsDTO tdto = hs.getAllTopics();
            allConnectionsWithDataBaseIsSuccess = tdto.isSuccess();
            if (tdto.isSuccess()) {
                for (int i = 0; i < tdto.getData().size(); i++) {
                    String[] arr = {"" + tdto.getData().get(i).getId(), "" + tdto.getData().get(i).getDocTagId()};
                    topicsAndDocTagsIds.add(arr);
                    cache.put(LIST_PLACEMENT_IN_CACHE, topicsAndDocTagsIds);
                }
            }
        } else {
            Object obj = cache.get(LIST_PLACEMENT_IN_CACHE);
            topicsAndDocTagsIds = (List<String[]>) obj;
        }
    }

    private String normalizeText(String text) {
        return text != null? text.trim().toLowerCase(): null;
    }
}
