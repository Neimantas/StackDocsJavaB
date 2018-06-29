package Models;

public class URLSettingsModel {
    private String TopicId;
    private String DocTagId;
    private String SearchQuery;
    private boolean After;

    public URLSettingsModel(String topicId, String docTagId, String searchQuery, boolean after) {
        TopicId = topicId;
        DocTagId = docTagId;
        SearchQuery = searchQuery;
        After = after;
    }

    public String getTopicId() {
        return TopicId;
    }

    public void setTopicId(String topicId) {
        TopicId = topicId;
    }

    public String getDocTagId() {
        return DocTagId;
    }

    public void setDocTagId(String docTagId) {
        DocTagId = docTagId;
    }

    public String getSearchQuery() {
        return SearchQuery;
    }

    public void setSearchQuery(String searchQuery) {
        SearchQuery = searchQuery;
    }

    public boolean isAfter() {
        return After;
    }

    public void setAfter(boolean after) {
        After = after;
    }
}
