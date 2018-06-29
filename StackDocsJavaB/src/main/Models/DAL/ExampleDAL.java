package Models.DAL;

public class ExampleDAL {
    private int Id;
    private int DocTopicId;
    private String Title;
    private String CreationDate;
    private String LastEditDate;
    private int Score;
    private int ContributorCount;
    private String BodyHtml;
    private String BodyMarkdown;
    private boolean IsPinned;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDocTopicId() {
        return DocTopicId;
    }

    public void setDocTopicId(int docTopicId) {
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

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }

    public int getContributorCount() {
        return ContributorCount;
    }

    public void setContributorCount(int contributorCount) {
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
