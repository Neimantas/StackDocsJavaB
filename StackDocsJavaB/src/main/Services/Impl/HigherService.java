package Services.Impl;

import Models.DAL.DocTagsDAL;
import Models.DAL.ExampleDAL;
import Models.DAL.TopicsDAL;
import Models.DBQueryModel;
import Models.DTO.DBqueryDTO;
import Models.DTO.DocTagsDTO;
import Models.DTO.ExampleDTO;
import Models.DTO.TopicsDTO;
import Services.ICache;
import Services.ICrud;
import Services.IHigherService;

public class HigherService implements IHigherService {

    private ICrud crud = new Crud();
    private ICache cache = Cache.getInstance();
    private final static String MESSAGE = "DB connection was successful, but cant find anything by Id or crud is not working properly";

    @Override
    public DocTagsDTO getDocTagById(String... docTagIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "DocTags";
        model.where = "id";
        model.whereValue = docTagIds;
        DBqueryDTO<DocTagsDAL> dBqueryDTO = crud.read(model, DocTagsDAL.class);

        if (!dBqueryDTO.success) return new DocTagsDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new DocTagsDTO(false, MESSAGE, null);

        return new DocTagsDTO(true, null, dBqueryDTO.data);
    }

    @Override
    public TopicsDTO getTopicById(String... topicIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        model.where = "id";
        model.whereValue = topicIds;
        DBqueryDTO<TopicsDAL> dBqueryDTO = crud.read(model, TopicsDAL.class);

        if (!dBqueryDTO.success) return new TopicsDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new TopicsDTO(false, MESSAGE, null);

        return new TopicsDTO(true, null, dBqueryDTO.data);
    }

    @Override
    public ExampleDTO getExampleById(String... exampleIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        model.where = "id";
        model.whereValue = exampleIds;
        DBqueryDTO<ExampleDAL> dBqueryDTO = crud.read(model, ExampleDAL.class);

        if (!dBqueryDTO.success) return new ExampleDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new ExampleDTO(false, MESSAGE, null);

        return new ExampleDTO(true, null, dBqueryDTO.data);
    }

    @Override
    public DocTagsDTO getAllDocTags() {
        String cachePlacement = "allDocTags";
        if (cache.get(cachePlacement) != null) return (DocTagsDTO) cache.get(cachePlacement);

        DBQueryModel model = new DBQueryModel();
        model.table = "DocTags";
        DBqueryDTO<DocTagsDAL> dBqueryDTO = crud.read(model, DocTagsDAL.class);

        if (!dBqueryDTO.success) return new DocTagsDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new DocTagsDTO(false, MESSAGE, null);

        DocTagsDTO docTagsDTO = new DocTagsDTO(true, null, dBqueryDTO.data);
        cache.put(cachePlacement, docTagsDTO);
        return docTagsDTO;
    }

    @Override
    public TopicsDTO getAllTopics() {
        String cachePlacement = "allTopics";
        if (cache.get(cachePlacement) != null) return (TopicsDTO) cache.get(cachePlacement);

        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        DBqueryDTO<TopicsDAL> dBqueryDTO = crud.read(model, TopicsDAL.class);

        if (!dBqueryDTO.success) return new TopicsDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new TopicsDTO(false, MESSAGE, null);

        TopicsDTO topicsDTO = new TopicsDTO(true, null, dBqueryDTO.data);
        cache.put(cachePlacement, topicsDTO);
        return topicsDTO;
    }

    @Override
    public ExampleDTO getAllExamples() {
        String cachePlacement = "allDocTags";
        if (cache.get(cachePlacement) != null) return (ExampleDTO) cache.get(cachePlacement);

        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        DBqueryDTO<ExampleDAL> dBqueryDTO = crud.read(model, ExampleDAL.class);

        if (!dBqueryDTO.success) return new ExampleDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new ExampleDTO(false, MESSAGE, null);

        ExampleDTO exampleDTO = new ExampleDTO(true, null, dBqueryDTO.data);
        cache.put(cachePlacement, exampleDTO);
        return exampleDTO;
    }

    @Override
    public TopicsDTO getTopicsByDocTagId(String... docTagIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        model.where = "DocTagId";
        model.whereValue = docTagIds;
        DBqueryDTO<TopicsDAL> dBqueryDTO = crud.read(model, TopicsDAL.class);

        if (!dBqueryDTO.success) return new TopicsDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new TopicsDTO(false, MESSAGE, null);

        return new TopicsDTO(true, null, dBqueryDTO.data);
    }

    @Override
    public ExampleDTO getExamplesByTopicsId(String... topicIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        model.where = "TopicsId";
        model.whereValue = topicIds;
        DBqueryDTO<ExampleDAL> dBqueryDTO = crud.read(model, ExampleDAL.class);

        if (!dBqueryDTO.success) return new ExampleDTO(false, dBqueryDTO.message,null);

        if (dBqueryDTO.data == null) return new ExampleDTO(false, MESSAGE, null);

        return new ExampleDTO(true, null, dBqueryDTO.data);
    }
}
