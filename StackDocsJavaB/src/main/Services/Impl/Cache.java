package Services.Impl;

import Services.ICache;

import java.util.List;

public class Cache implements ICache {
    private int currentPage;
    private List<String> listOfThemes;
    private String valueOfSerchField;
    private String chosenLanguage;

    @Override
    public void setCurrentPage(int page) {
        currentPage = page;
    }

    @Override
    public int getCurrentPage() {
        return currentPage;
    }

    @Override
    public void setListOfThemes(List<String> list) {
        listOfThemes = list;
    }

    @Override
    public List<String> getListOfThemes() {
        return listOfThemes;
    }

    @Override
    public void setValueOfSearchField(String value) {
        valueOfSerchField = value;
    }

    @Override
    public String getValueOfSearchField() {
        return valueOfSerchField;
    }

    @Override
    public void setLanguage(String language) {
        chosenLanguage = language;
    }

    @Override
    public String getLaguage() {
        return chosenLanguage;
    }
}
