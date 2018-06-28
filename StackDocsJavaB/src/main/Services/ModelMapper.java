package Services;

import Models.BusinessLogic.DocTag;
import Models.BusinessLogic.Example;
import Models.BusinessLogic.Topic;
import Models.DAL.DocTagsDAL;
import Models.DAL.ExampleDAL;
import Models.DAL.TopicsDAL;

public class ModelMapper <T>{
    <T> T map(T obj) {
        if (obj instanceof DocTagsDAL) {
            DocTag docTag = new DocTag();
            docTag.id =((DocTagsDAL) obj).getId();
            docTag.tag = ((DocTagsDAL) obj).getTag();
            return (T)docTag;
        }
        if (obj instanceof TopicsDAL) {
            Topic topic = new Topic();
            topic.id = ((TopicsDAL) obj).getId();
            topic.title = ((TopicsDAL) obj).getTitle();
            return (T)topic;
        }
        if (obj instanceof ExampleDAL) {
            Example example = new Example();
            example.id = ((ExampleDAL) obj).getId();
            example.bodyHTML =((ExampleDAL) obj).getBodyHtml();
            return (T) example;
        }
        return null;
    }
}
