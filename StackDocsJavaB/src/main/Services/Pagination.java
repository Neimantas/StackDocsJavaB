package Services;

import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.TopicsDAL;
import Models.DBQueryModel;
import Models.DTO.DocTagsDTO;
import Models.DTO.TopicsDTO;
import Models.URLSettingsModel;
import Services.Impl.Cache;
import Services.Impl.HigherService;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    private IHigherService hs = new HigherService();
    private ICache cache = Cache.getInstance();
    private List<String[]> topicsAndDocTagsIds = new ArrayList<>();
    private List<String> collectedIds = new ArrayList<>();
    private List<Topic> topicsList = new ArrayList<>();
    private boolean allConnectionsWithDataBaseIsSuccess;

    public List<Topic> getList(URLSettingsModel model) {
        collectedIds = new ArrayList<>();
        topicsList = new ArrayList<>();
        allConnectionsWithDataBaseIsSuccess = true;
        getListOftopicsAndDocTagsIdsFromDataBaseOrCache();
        reduceListByDocTagIdAndSearchQuery(model.docTagId, model.searchQuery);
        collectTopicsIds(model.topicId, model.after);
        makeListFromColletedIds();
        if (!allConnectionsWithDataBaseIsSuccess) {
            return null;
        }
        return topicsList;
    }

    private void reduceListByDocTagIdAndSearchQuery(String docTagId, String searchQuery) {

        if (searchQuery != null && docTagId != null) {
            String[] queries = searchQuery.trim().toLowerCase().split(" ");
            TopicsDTO topicsDTO = hs.getAllTopics();
            allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
            if (topicsDTO.isSuccess()) {
                List<String[]> tempList = new ArrayList<>();
                for (int i = 0; i < topicsDTO.getData().size(); i++) {
                    for (int j = 0; j < queries.length; j++) {
                        String docId = "" + topicsDTO.getData().get(i).getDocTagId();
                        String title = topicsDTO.getData().get(i).getTitle().toLowerCase();
                        String introduction = topicsDTO.getData().get(i).getIntroductionMarkdown().toLowerCase();
                        String parameters = topicsDTO.getData().get(i).getParametersMarkdown().toLowerCase();
                        String remarks = topicsDTO.getData().get(i).getRemarksMarkdown().toLowerCase();
                        String syntax = topicsDTO.getData().get(i).getSyntaxMarkdown().toLowerCase();

                        if ((title.contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (introduction.contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (parameters.toLowerCase().contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (remarks.contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (syntax.contains(normalizeText((queries[j]))) && docId.equals(docTagId))) {
                            String[] arr = {"" + topicsDTO.getData().get(i).getId(), "" + topicsDTO.getData().get(i).getDocTagId()};
                            tempList.add(arr);
                        }
                    }
                }
                topicsAndDocTagsIds = tempList;
            }

        }
        //Reduce topicsAndDocTagsIds by docTagId
        else if (docTagId != null) {
            List<String[]> tempList = new ArrayList<>();
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (topicsAndDocTagsIds.get(i)[1].equals(docTagId)) tempList.add(topicsAndDocTagsIds.get(i));
            }
            topicsAndDocTagsIds = tempList;
        }
        //Reduce topicsAndDocTagsIds by queries
        else if (searchQuery != null) {
            String[] queries = searchQuery.trim().toLowerCase().split(" ");
            TopicsDTO topicsDTO = hs.getAllTopics();
            allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
            if (topicsDTO.isSuccess()) {
                List<String[]> tempList = new ArrayList<>();
                for (int i = 0; i < topicsDTO.getData().size(); i++) {
                    for (int j = 0; j < queries.length; j++) {

                        String title = topicsDTO.getData().get(i).getTitle().toLowerCase();
                        String introduction = topicsDTO.getData().get(i).getIntroductionMarkdown().toLowerCase();
                        String parameters = topicsDTO.getData().get(i).getParametersMarkdown().toLowerCase();
                        String remarks = topicsDTO.getData().get(i).getRemarksMarkdown().toLowerCase();
                        String syntax = topicsDTO.getData().get(i).getSyntaxMarkdown().toLowerCase();

                        if (title.contains(normalizeText((queries[j])))
                                || introduction.contains(normalizeText((queries[j])))
                                || parameters.toLowerCase().contains(normalizeText((queries[j])))
                                || remarks.contains(normalizeText((queries[j])))
                                || syntax.contains(normalizeText((queries[j])))) {
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
        //dar prideti logikos jeigu neimanoma eiti atgal i - 10
        if (topicId == null) {
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (counter >= 0 && counter < listSize) {
                    collectedIds.add("" + topicsAndDocTagsIds.get(i)[0]);
                    counter++;
                }
                if (counter == 10) {
                    break;
                }
            }
        }
        else if (after) {
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (counter == 0 && topicsAndDocTagsIds.get(i)[0].equals(topicId)) {
                    if (i + 10 < topicsAndDocTagsIds.size()) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i + 10)[0]);
                        counter++;
                    }
                }
                else if (counter > 0 && counter < listSize) {
                    if (i + 10 < topicsAndDocTagsIds.size()) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i + 10)[0]);
                        counter++;
                    }
                }
                if (counter == 10) {
                    break;
                }
            }
        }
        else if (!after) {
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (counter == 0 && topicsAndDocTagsIds.get(i)[0].equals(topicId)) {
                    if (i - 10 >= 0) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i - 10)[0]);
                        counter++;
                    }
                }
                else if (counter > 0 && counter < listSize) {
                    if (i - 10 >= 0) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i - 10)[0]);
                        counter++;
                    }
                }
                if (counter == 10) {
                    break;
                }
            }
        }
    }

    private void makeListFromColletedIds() {
        String[] idsArr = collectedIds.toArray(new String[collectedIds.size()]);
        TopicsDTO topicsDTO = hs.getTopicById(idsArr);
        allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
        if (topicsDTO.isSuccess() && topicsDTO.getData() != null) {
            for (int i = 0; i < topicsDTO.getData().size(); i++) {
                topicsList.add(makeTopicFromTopicsDal(topicsDTO.getData().get(i)));
            }
        }
        else {
            Topic topic = new Topic();
            topic.setTitle("No results");
            topicsList.add(topic);
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
