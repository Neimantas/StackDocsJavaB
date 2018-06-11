import Models.DAL.DocTagsDAL;
import Models.DAL.ExampleDAL;
import Services.Impl.HigherService;
import org.junit.Test;

import java.util.List;

public class HigherServiseTest {

    @Test
    public void getalldoctags() {
        HigherService hs = new HigherService();
        List<DocTagsDAL> list = hs.getAllDocTags().getData();
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Id: " + list.get(i).getId() + ", title: " + list.get(i).getTitle() + ", tag: " + list.get(i).getTag());
        }
    }

    @Test
    public void getallexampl() {
        HigherService hs = new HigherService();
        List<ExampleDAL> list = hs.getAllEcamples().getData();
        for (int i = 0; i < list.size(); i++) {
//            System.out.println("Id: " + list.get(i).getId() + ", title: " + list.get(i).getTitle());
            System.out.println("IsPinned: " + list.get(i).isPinned());
        }
    }


}
