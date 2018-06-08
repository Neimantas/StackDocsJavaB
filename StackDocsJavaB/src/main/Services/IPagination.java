package Services;

import java.util.List;

public interface IPagination {
    List<String> nextTenPages(String title);
    List<String> previousTenPages(String title);
}
