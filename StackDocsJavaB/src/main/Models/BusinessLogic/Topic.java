package Models.BusinessLogic;

public class Topic {
	private long _id;
	private long _docTagId;
	private String _title;

	private String _introductionHtml;
    private String _syntaxHtml;
    private String _parametersHtml;
    private String _remarksHtml;

    private String _introductionMarkdown;
    private String _syntaxMarkdown;
    private String _parametersMarkdown;
    private String _remarksMarkdown;


    public long getId() {
        return _id;
    }

    public void setId(long id) {
        _id = id;
    }

    public long getDocTagId() {
        return _docTagId;
    }

    public void setDocTagId(long docTagId) {
        _docTagId = docTagId;
    }

    public String getTitle() { return _title; }

    public void setTitle(String title) { _title = title; }

    public String getIntroductionHtml() {
        return _introductionHtml;
    }

    public void setIntroductionHtml(String introductionHtml) {
        _introductionHtml = introductionHtml;
    }

    public String getSyntaxHtml() {
        return _syntaxHtml;
    }

    public void setSyntaxHtml(String syntaxHtml) {
        _syntaxHtml = syntaxHtml;
    }

    public String getParametersHtml() {
        return _parametersHtml;
    }

    public void setParametersHtml(String parametersHtml) {
        _parametersHtml = parametersHtml;
    }

    public String getRemarksHtml() {
        return _remarksHtml;
    }

    public void setRemarksHtml(String remarksHtml) {
        _remarksHtml = remarksHtml;
    }

    public String getIntroductionMarkdown() {
        return _introductionMarkdown;
    }

    public void setIntroductionMarkdown(String introductionMarkdown) {
        _introductionMarkdown = introductionMarkdown;
    }

    public String getSyntaxMarkdown() {
        return _syntaxMarkdown;
    }

    public void setSyntaxMarkdown(String syntaxMarkdown) {
        _syntaxMarkdown = syntaxMarkdown;
    }

    public String getParametersMarkdown() {
        return _parametersMarkdown;
    }

    public void setParametersMarkdown(String parametersMarkdown) {
        _parametersMarkdown = parametersMarkdown;
    }

    public String getRemarksMarkdown() {
        return _remarksMarkdown;
    }

    public void setRemarksMarkdown(String remarksMarkdown) {
        _remarksMarkdown = remarksMarkdown;
    }

}
