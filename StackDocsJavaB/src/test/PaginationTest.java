import Models.BusinessLogic.Topic;
import Services.Pagination;

import org.junit.Test;

import java.util.List;

public class PaginationTest {

    @Test
    public void pgTest() {
        Pagination pg = new Pagination();
        List<Topic> list = pg.listOfThemes(3);
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Id: " + list.get(i).getId() + ", title: "
                    + list.get(i).getTitle() + ", doctag title: " + list.get(i).getDocTagTitle());
        }
    }
}
