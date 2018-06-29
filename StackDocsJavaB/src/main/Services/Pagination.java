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
import org.modelmapper.ModelMapper;

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
        resetValues();
        getListOftopicsAndDocTagsIdsFromDataBaseOrCache();
        reduceListByDocTagIdAndSearchQuery(model.docTagId, model.searchQuery);
        collectTopicsIds(model.topicId, model.after);
        makeListFromColletedIds();
        if (!allConnectionsWithDataBaseIsSuccess) {
            return null;
        }
        return topicsList;
    }

    private void resetValues() {
        collectedIds = new ArrayList<>();
        topicsList = new ArrayList<>();
        allConnectionsWithDataBaseIsSuccess = true;
    }

    private void reduceListByDocTagIdAndSearchQuery(String docTagId, String searchQuery) {

        if ((searchQuery != null && !searchQuery.trim().equals("")) && (docTagId != null && !docTagId.trim().equals(""))) {
            String[] queries = searchQuery.trim().toLowerCase().split(" ");
            TopicsDTO topicsDTO = hs.getAllTopics();
            allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.success;
            if (topicsDTO.success) {
                List<String[]> tempList = new ArrayList<>();
                for (int i = 0; i < topicsDTO.data.size(); i++) {
                    for (int j = 0; j < queries.length; j++) {
                        String docId = "" + topicsDTO.data.get(i).DocTagId;
                        String title = topicsDTO.data.get(i).Title.toLowerCase();
                        String introduction = topicsDTO.data.get(i).IntroductionMarkdown.toLowerCase();
                        String parameters = topicsDTO.data.get(i).ParametersMarkdown.toLowerCase();
                        String remarks = topicsDTO.data.get(i).RemarksMarkdown.toLowerCase();
                        String syntax = topicsDTO.data.get(i).SyntaxMarkdown.toLowerCase();

                        if ((title.contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (introduction.contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (parameters.toLowerCase().contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (remarks.contains(normalizeText((queries[j]))) && docId.equals(docTagId))
                                || (syntax.contains(normalizeText((queries[j]))) && docId.equals(docTagId))) {
                            String[] arr = {"" + topicsDTO.data.get(i).Id, "" + topicsDTO.data.get(i).DocTagId};
                            tempList.add(arr);
                        }
                    }
                }
                topicsAndDocTagsIds = tempList;
            }
        }
        else if (docTagId != null && !docTagId.trim().equals("")) {
            List<String[]> tempList = new ArrayList<>();
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (topicsAndDocTagsIds.get(i)[1].equals(docTagId)) tempList.add(topicsAndDocTagsIds.get(i));
            }
            topicsAndDocTagsIds = tempList;
        }
        else if (searchQuery != null && !searchQuery.trim().equals("")) {
            String[] queries = searchQuery.trim().toLowerCase().split(" ");
            TopicsDTO topicsDTO = hs.getAllTopics();
            allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.success;
            if (topicsDTO.success) {
                List<String[]> tempList = new ArrayList<>();
                for (int i = 0; i < topicsDTO.data.size(); i++) {
                    for (int j = 0; j < queries.length; j++) {

                        String title = topicsDTO.data.get(i).Title.toLowerCase();
                        String introduction = topicsDTO.data.get(i).IntroductionMarkdown.toLowerCase();
                        String parameters = topicsDTO.data.get(i).ParametersMarkdown.toLowerCase();
                        String remarks = topicsDTO.data.get(i).RemarksMarkdown.toLowerCase();
                        String syntax = topicsDTO.data.get(i).SyntaxMarkdown.toLowerCase();

                        if (title.contains(normalizeText((queries[j])))
                                || introduction.contains(normalizeText((queries[j])))
                                || parameters.contains(normalizeText((queries[j])))
                                || remarks.contains(normalizeText((queries[j])))
                                || syntax.contains(normalizeText((queries[j])))) {
                            String[] arr = {"" + topicsDTO.data.get(i).Id, "" + topicsDTO.data.get(i).DocTagId};
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
        int indexOfTopicFound = 0;
        if (topicId == null) {
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (counter < 10) {
                    collectedIds.add("" + topicsAndDocTagsIds.get(i)[0]);
                    counter++;
                } else {
                    break;
                }
            }
        } else if (after) {
            //finding index of topic in list
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (topicsAndDocTagsIds.get(i)[0].equals(topicId)) indexOfTopicFound = i;
            }
            if (indexOfTopicFound + 10 < topicsAndDocTagsIds.size()) {
                for (int i = indexOfTopicFound; i < topicsAndDocTagsIds.size(); i++) {
                    if (counter < 10 && i + 10 < topicsAndDocTagsIds.size()) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i + 10)[0]);
                        counter++;
                    }
                    if (counter == 10) {
                        break;
                    }
                }
            } else {
                for (int i = indexOfTopicFound; i < topicsAndDocTagsIds.size(); i++) {
                    if (counter < 10) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i)[0]);
                        counter++;
                    } else {
                        break;
                    }
                }
            }
        } else if (!after) {
            //finding index of topic in list
            for (int i = 0; i < topicsAndDocTagsIds.size(); i++) {
                if (topicsAndDocTagsIds.get(i)[0].equals(topicId)) indexOfTopicFound = i;
            }
            if (indexOfTopicFound - 1 >= 0) {
                for (int i = indexOfTopicFound - 10; i < topicsAndDocTagsIds.size(); i++) {
                    if (counter < 10 && i >= 0) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i)[0]);
                        counter++;
                    }
                    if (counter == 10) {
                        break;
                    }
                }
            } else {
                for (int i = indexOfTopicFound; i < topicsAndDocTagsIds.size(); i++) {
                    if (counter < 10) {
                        collectedIds.add("" + topicsAndDocTagsIds.get(i)[0]);
                        counter++;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    private void makeListFromColletedIds() {
        String[] idsArr = collectedIds.toArray(new String[collectedIds.size()]);
        TopicsDTO topicsDTO = hs.getTopicById(idsArr);
        allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.success;
        if (topicsDTO.success && topicsDTO.data != null) {
            for (int i = 0; i < topicsDTO.data.size(); i++) {
                ModelMapper modelMapper = new ModelMapper();
                topicsList.add(modelMapper.map(topicsDTO.data.get(i), Topic.class));
            }
        } else {
            Topic topic = new Topic();
            topic.Title = "No results";
            topicsList.add(topic);
        }
    }

    private void getListOftopicsAndDocTagsIdsFromDataBaseOrCache() {
        String LIST_PLACEMENT_IN_CACHE = "topicsAndDocTagsIds";
        if (cache.get(LIST_PLACEMENT_IN_CACHE) == null) {
            TopicsDTO tdto = hs.getAllTopics();
            allConnectionsWithDataBaseIsSuccess = tdto.success;
            if (tdto.success) {
                for (int i = 0; i < tdto.data.size(); i++) {
                    String[] arr = {"" + tdto.data.get(i).Id, "" + tdto.data.get(i).DocTagId};
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
        return text != null ? text.trim().toLowerCase() : null;
    }
}
