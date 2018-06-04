package main.Models.DTO;

import main.Models.DAL.DocTagsDAL;
import main.Models.DAL.ExampleDAL;
import main.Models.DAL.TopicsDAL;

import java.util.List;

public class HigherServiceDTO {
        public boolean success;
        public String message;
        public List<ExampleDAL> examplesList;
        public List<DocTagsDAL> docTagsList;
        public List<TopicsDAL> topicsList;


}
