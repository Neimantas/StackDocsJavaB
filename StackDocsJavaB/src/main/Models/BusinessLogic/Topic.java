package main.Models.BusinessLogic;

public class Topic {
	private int _id;
	private int _docTagId;

	private String _introductionHtml;
    private String _syntaxHtml;

    private String _parametersHtml;
    private String _remarksHtml;

    private String _introductionMarkdown;
    private String _syntaxMarkdown;

    private String _parametersMarkdown;
    private String _remarksMarkdown;


    public Topic(int id, int docTagId, String introductionHtml, String syntaxHtml, String parametersHtml, String remarksHtml, String introductionMarkdown, String syntaxMarkdown, String parametersMarkdown, String remarksMarkdown) {
        _id = id;
        _docTagId = docTagId;
        _introductionHtml = introductionHtml;
        _syntaxHtml = syntaxHtml;
        _parametersHtml = parametersHtml;
        _remarksHtml = remarksHtml;
        _introductionMarkdown = introductionMarkdown;
        _syntaxMarkdown = syntaxMarkdown;
        _parametersMarkdown = parametersMarkdown;
        _remarksMarkdown = remarksMarkdown;
    }
    public int getId() {
        return _id;
    }

    public void setId(int id) {
        _id = id;
    }

    public int getDocTagId() {
        return _docTagId;
    }

    public void setDocTagId(int docTagId) {
        _docTagId = docTagId;
    }

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
