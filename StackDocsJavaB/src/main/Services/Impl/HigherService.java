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
import com.google.inject.Inject;

public class HigherService implements IHigherService {

    private ICrud crud;
    private ICache cache = Cache.getInstance();
    private final static String MESSAGE = "DB connection was successful, but cant find anything by Id or crud is not working properly";
    private DBQueryModel model;
    
    @Inject
    public HigherService(ICrud iCrud) {
        crud = iCrud;
    }

    @Override
    public DocTagsDTO getDocTagById(String... docTagIds) {
        model = new DBQueryModel();
        model.setTable("DocTags");
        model.setWhere("id");
        model.setWhereValue(docTagIds);
        DBqueryDTO<DocTagsDAL> dBqueryDTO = crud.read(model, DocTagsDAL.class);

        if (!dBqueryDTO.isSuccess()) return new DocTagsDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new DocTagsDTO(false, MESSAGE, null);

        return new DocTagsDTO(true, null, dBqueryDTO.getList());
    }

    @Override
    public TopicsDTO getTopicById(String... topicIds) {
        model = new DBQueryModel();
        model.setTable("Topics");
        model.setWhere("id");
        model.setWhereValue(topicIds);
        DBqueryDTO<TopicsDAL> dBqueryDTO = crud.read(model, TopicsDAL.class);

        if (!dBqueryDTO.isSuccess()) return new TopicsDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new TopicsDTO(false, MESSAGE, null);

        return new TopicsDTO(true, null, dBqueryDTO.getList());
    }

    @Override
    public ExampleDTO getExampleById(String... exampleIds) {
        model = new DBQueryModel();
        model.setTable("Examples");
        model.setWhere("id");
        model.setWhereValue(exampleIds);
        DBqueryDTO<ExampleDAL> dBqueryDTO = crud.read(model, ExampleDAL.class);

        if (!dBqueryDTO.isSuccess()) return new ExampleDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new ExampleDTO(false, MESSAGE, null);

        return new ExampleDTO(true, null, dBqueryDTO.getList());
    }

    @Override
    public DocTagsDTO getAllDocTags() {
        String cachePlacement = "allDocTags";
        if (cache.get(cachePlacement) != null) return (DocTagsDTO) cache.get(cachePlacement);

        model = new DBQueryModel();
        model.setTable("DocTags");
        DBqueryDTO<DocTagsDAL> dBqueryDTO = crud.read(model, DocTagsDAL.class);

        if (!dBqueryDTO.isSuccess()) return new DocTagsDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new DocTagsDTO(false, MESSAGE, null);

        DocTagsDTO docTagsDTO = new DocTagsDTO(true, null, dBqueryDTO.getList());
        cache.put(cachePlacement, docTagsDTO);
        return docTagsDTO;
    }

    @Override
    public TopicsDTO getAllTopics() {
        String cachePlacement = "allTopics";
        if (cache.get(cachePlacement) != null) return (TopicsDTO) cache.get(cachePlacement);

        model = new DBQueryModel();
        model.setTable("Topics");
        DBqueryDTO<TopicsDAL> dBqueryDTO = crud.read(model, TopicsDAL.class);

        if (!dBqueryDTO.isSuccess()) return new TopicsDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new TopicsDTO(false, MESSAGE, null);

        TopicsDTO topicsDTO = new TopicsDTO(true, null, dBqueryDTO.getList());
        cache.put(cachePlacement, topicsDTO);
        return topicsDTO;
    }

    @Override
    public ExampleDTO getAllExamples() {
        String cachePlacement = "allDocTags";
        if (cache.get(cachePlacement) != null) return (ExampleDTO) cache.get(cachePlacement);

        model = new DBQueryModel();
        model.setTable("Examples");
        DBqueryDTO<ExampleDAL> dBqueryDTO = crud.read(model, ExampleDAL.class);

        if (!dBqueryDTO.isSuccess()) return new ExampleDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new ExampleDTO(false, MESSAGE, null);

        ExampleDTO exampleDTO = new ExampleDTO(true, null, dBqueryDTO.getList());
        cache.put(cachePlacement, exampleDTO);
        return exampleDTO;
    }

    @Override
    public TopicsDTO getTopicsByDocTagId(String... docTagIds) {
        model = new DBQueryModel();
        model.setTable("Topics");
        model.setWhere("DocTagId");
        model.setWhereValue(docTagIds);
        DBqueryDTO<TopicsDAL> dBqueryDTO = crud.read(model, TopicsDAL.class);

        if (!dBqueryDTO.isSuccess()) return new TopicsDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new TopicsDTO(false, MESSAGE, null);

        return new TopicsDTO(true, null, dBqueryDTO.getList());
    }

    @Override
    public ExampleDTO getExamplesByTopicsId(String... topicIds) {
        model = new DBQueryModel();
        model.setTable("Examples");
        model.setWhere("DocTopicId");
        model.setWhereValue(topicIds);
        DBqueryDTO<ExampleDAL> dBqueryDTO = crud.read(model, ExampleDAL.class);

        if (!dBqueryDTO.isSuccess()) return new ExampleDTO(false, dBqueryDTO.getMessage(),null);

        if (dBqueryDTO.getList() == null) return new ExampleDTO(false, MESSAGE, null);

        return new ExampleDTO(true, null, dBqueryDTO.getList());
    }
}
