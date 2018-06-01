package main.Models.DAL;

public class DocTagsDAL {
    long Id;
    String Tag;
    String Title;
    String CreationDate;
    long HelloWorldDocTopicId;
    long TopicCount;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTag() {
        return Tag;
    }

    public void setTag(String tag) {
        Tag = tag;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getCreationDate() {
        return CreationDate;
    }

    public void setCreationDate(String creationDate) {
        CreationDate = creationDate;
    }

    public long getHelloWorldDocTopicId() {
        return HelloWorldDocTopicId;
    }

    public void setHelloWorldDocTopicId(long helloWorldDocTopicId) {
        HelloWorldDocTopicId = helloWorldDocTopicId;
    }

    public long getTopicCount() {
        return TopicCount;
    }

    public void setTopicCount(long topicCount) {
        TopicCount = topicCount;
    }


}
