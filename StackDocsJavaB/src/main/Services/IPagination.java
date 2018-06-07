package Services;

import java.util.List;

public interface IPagination {
    List<String> nextTenPages();
    List<String> previousTenPages();
}
