import Models.DAL.ExampleDAL;
import Services.Impl.HigherService;
import org.junit.Test;

import java.util.List;

public class HigherServiseTest {

    @Test
    public void showAllexmaples() {
        HigherService hs = new HigherService();
        List<ExampleDAL> list = hs.getAllEcamples().getData();
        for (ExampleDAL item: list) {
            System.out.println("Id: " + item.getId() + ", title: " + item.getTitle());
        }
    }
}
