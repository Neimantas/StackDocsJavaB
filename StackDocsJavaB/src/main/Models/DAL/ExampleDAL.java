package Models.DAL;

public class ExampleDAL {
    long Id;
    long DocTopicId;
    String Title;
    String CreationDate;
    String LastEditDate;
    long Score;
    long ContributorCount;
    String BodyHtml;
    String BodyMarkdown;
    boolean IsPinned;

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getDocTopicId() {
        return DocTopicId;
    }

    public void setDocTopicId(long docTopicId) {
        DocTopicId = docTopicId;
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

    public String getLastEditDate() {
        return LastEditDate;
    }

    public void setLastEditDate(String lastEditDate) {
        LastEditDate = lastEditDate;
    }

    public long getScore() {
        return Score;
    }

    public void setScore(long score) {
        Score = score;
    }

    public long getContributorCount() {
        return ContributorCount;
    }

    public void setContributorCount(long contributorCount) {
        ContributorCount = contributorCount;
    }

    public String getBodyHtml() {
        return BodyHtml;
    }

    public void setBodyHtml(String bodyHtml) {
        BodyHtml = bodyHtml;
    }

    public String getBodyMarkdown() {
        return BodyMarkdown;
    }

    public void setBodyMarkdown(String bodyMarkdown) {
        BodyMarkdown = bodyMarkdown;
    }

    public boolean isPinned() {
        return IsPinned;
    }

    public void setPinned(boolean pinned) {
        IsPinned = pinned;
    }


}
