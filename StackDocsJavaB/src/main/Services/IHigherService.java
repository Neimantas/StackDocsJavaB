package Services;

import Models.DTO.DocTagsDTO;
import Models.DTO.ExampleDTO;
import Models.DTO.TopicsDTO;

public interface IHigherService {
    DocTagsDTO getDocTagById(String... docTagIds);
    TopicsDTO getTopicById(String... topicIds);
    ExampleDTO getExampleById(String... exampleIds);

    DocTagsDTO getAllDocTags();
    TopicsDTO getAllTopics();
    ExampleDTO getAllEcamples();

    TopicsDTO getTopicsByDocTagId(String docTagId);
    ExampleDTO getExamplesByTopicsId(String... topicIds);

    TopicsDTO getTenTopicsById(Boolean after, String id);
}
