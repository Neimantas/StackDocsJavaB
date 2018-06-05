package main.Services;

import main.Models.DTO.DocTagsDTO;
import main.Models.DTO.ExampleDTO;
import main.Models.DTO.TopicsDTO;

public interface IHigherService {
    DocTagsDTO getDocTagById(String docTagId);
    TopicsDTO getTopicById(String topicId);
    ExampleDTO getExampleById(String exampleId);

    DocTagsDTO getAllDocTags();
    TopicsDTO getAllTopics();
    ExampleDTO getAllEcamples();

    TopicsDTO getTopicsByDocTagId(String docTagId);
    ExampleDTO getExamplesByTopicsId(String topicId);
}
