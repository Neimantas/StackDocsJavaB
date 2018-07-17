package Services;

import Models.BL.Topic;
import Models.DTO.TopicsDTO;
import Models.URLSettingsModel;
import Services.Impl.Cache;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Pagination {

    private IHigherService hs;
    private ICache cache = Cache.getInstance();
    private List<String[]> topicsAndDocTagsIds = new ArrayList<>();
    private List<String> collectedIds = new ArrayList<>();
    private List<Topic> topicsList = new ArrayList<>();
    private boolean allConnectionsWithDataBaseIsSuccess;

    public Pagination(){
        hs = DIContainer.getInjector().getInstance(IHigherService.class);
    }

    public List<Topic> getList(URLSettingsModel model) {
        resetValues();
        getListOftopicsAndDocTagsIdsFromDataBaseOrCache();
        reduceListByDocTagIdAndSearchQuery(model.getDocTagId(), model.getSearchQuery());
        collectTopicsIds(model.getTopicId(), model.isAfter());
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
            allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
            if (topicsDTO.isSuccess()) {
                List<String[]> tempList = new ArrayList<>();
                for (int i = 0; i < topicsDTO.getList().size(); i++) {
                    for (int j = 0; j < queries.length; j++) {
                        String docId = "" + topicsDTO.getList().get(i).getDocTagId();
                        String title = topicsDTO.getList().get(i).getTitle().toLowerCase();
                        String introduction = topicsDTO.getList().get(i).getIntroductionMarkdown().toLowerCase();
                        String parameters = topicsDTO.getList().get(i).getParametersMarkdown().toLowerCase();
                        String remarks = topicsDTO.getList().get(i).getRemarksMarkdown().toLowerCase();
                        String syntax = topicsDTO.getList().get(i).getSyntaxMarkdown().toLowerCase();

                        if(docId.equals(docTagId) && (title.contains(normalizeText((queries[j])))
                                || introduction.contains(normalizeText((queries[j])))
                                || parameters.toLowerCase().contains(normalizeText((queries[j])))
                                || remarks.contains(normalizeText((queries[j])))
                                || syntax.contains(normalizeText((queries[j]))))) {
                            String[] arr = {"" + topicsDTO.getList().get(i).getId(), "" + topicsDTO.getList().get(i).getDocTagId()};
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
            allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
            if (topicsDTO.isSuccess()) {
                List<String[]> tempList = new ArrayList<>();
                for (int i = 0; i < topicsDTO.getList().size(); i++) {
                    for (int j = 0; j < queries.length; j++) {

                        String title = topicsDTO.getList().get(i).getTitle().toLowerCase();
                        String introduction = topicsDTO.getList().get(i).getIntroductionMarkdown().toLowerCase();
                        String parameters = topicsDTO.getList().get(i).getParametersMarkdown().toLowerCase();
                        String remarks = topicsDTO.getList().get(i).getRemarksMarkdown().toLowerCase();
                        String syntax = topicsDTO.getList().get(i).getSyntaxMarkdown().toLowerCase();

                        if (title.contains(normalizeText((queries[j])))
                                || introduction.contains(normalizeText((queries[j])))
                                || parameters.contains(normalizeText((queries[j])))
                                || remarks.contains(normalizeText((queries[j])))
                                || syntax.contains(normalizeText((queries[j])))) {
                            String[] arr = {"" + topicsDTO.getList().get(i).getId(), "" + topicsDTO.getList().get(i).getDocTagId()};
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
        String[] idsArr = collectedIds.toArray(new String[0]);
        TopicsDTO topicsDTO = hs.getTopicById(idsArr);
        allConnectionsWithDataBaseIsSuccess = allConnectionsWithDataBaseIsSuccess && topicsDTO.isSuccess();
        if (topicsDTO.isSuccess() && topicsDTO.getList() != null) {
            for (int i = 0; i < topicsDTO.getList().size(); i++) {
                ModelMapper modelMapper = new ModelMapper();
                topicsList.add(modelMapper.map(topicsDTO.getList().get(i), Topic.class));
            }
        } else {
            Topic topic = new Topic();
            topic.setTitle("No results");
            topicsList.add(topic);
        }
    }

    private void getListOftopicsAndDocTagsIdsFromDataBaseOrCache() {
        String LIST_PLACEMENT_IN_CACHE = "topicsAndDocTagsIds";
        if (cache.get(LIST_PLACEMENT_IN_CACHE) == null) {
            TopicsDTO tdto = hs.getAllTopics();
            allConnectionsWithDataBaseIsSuccess = tdto.isSuccess();
            if (tdto.isSuccess()) {
                for (int i = 0; i < tdto.getList().size(); i++) {
                    String[] arr = {"" + tdto.getList().get(i).getId(), "" + tdto.getList().get(i).getDocTagId()};
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
