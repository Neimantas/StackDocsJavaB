package Services;

import java.util.List;

public interface ICache {
    void setCurrentPage(int page);
    int getCurrentPage();

    void setListOfThemes(List<String> list);
    List<String> getListOfThemes();

    void setValueOfSearchField(String value);
    String getValueOfSearchField();

    void setLanguage(String language);
    String getLaguage();
}
