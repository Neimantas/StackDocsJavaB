import Models.DAL.DocTagsDAL;
import Models.DAL.ExampleDAL;
import Models.DAL.TopicsDAL;
import Services.Impl.HigherService;
import org.junit.Test;

import java.util.List;

public class HigherServiseTest {

    @Test
    public void showAllexmaples() {
        HigherService hs = new HigherService();
        List<ExampleDAL> list = hs.getAllEcamples().getData();
        for (ExampleDAL item: list) {
            System.out.println("---------------------------------------------");
            System.out.println("Id: " + item.getId() + ", title: " + item.getTitle());
            System.out.println("DocTopicId: " + item.getDocTopicId() + ", IsPinned: " + item.isPinned());
            System.out.println("BODYHTML: " + item.getBodyHtml());
            System.out.println("---------------------------------------------/n");
        }
    }

    @Test
    public void showAllTopics() {
        HigherService hs = new HigherService();
        List<TopicsDAL> list = hs.getAllTopics().getData();
        for (TopicsDAL item: list) {
            System.out.println("---------------------------------------------");
            System.out.println("Id: " + item.getId() + ", title: " + item.getTitle());
            System.out.println("DocTagId: " + item.getDocTagId());
            System.out.println("IntroductionHTML: " + item.getIntroductionHtml());
            System.out.println("---------------------------------------------/n");
        }
    }

    @Test
    public void showAllDocTag() {
        HigherService hs = new HigherService();
        List<DocTagsDAL> list = hs.getAllDocTags().getData();
        for (DocTagsDAL item: list) {
            System.out.println("---------------------------------------------");
            System.out.println("Id: " + item.getId() + ", title: " + item.getTitle());
            System.out.println("Tag: " + item.getTag());
            System.out.println("---------------------------------------------/n");
        }
    }
}


