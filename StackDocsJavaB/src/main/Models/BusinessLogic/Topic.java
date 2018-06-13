package Models.BusinessLogic;

public class Topic {
    private long Id;
    private String Title;
    private String DocTagTitle;

    public String getDocTagTitle() {
        return DocTagTitle;
    }

    public void setDocTagTitle(String docTagTitle) {
        DocTagTitle = docTagTitle;
    }

    long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

}