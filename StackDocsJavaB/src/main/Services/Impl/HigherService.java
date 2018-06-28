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

import java.util.ArrayList;
import java.util.List;

public class HigherService implements IHigherService {

    private ICrud crud = new Crud();
    private ICache cache = Cache.getInstance();
    private final static String MESSAGE = "DB connection was successful, but cant find anything by Id or crud is not working properly";

    @Override
    public DocTagsDTO getDocTagById(String... docTagIds) {
        DocTagsDTO docTagsDTO = new DocTagsDTO();
        DBQueryModel model = new DBQueryModel();
        model.table = "DocTags";
        model.where = "id";
        model.whereValue = docTagIds;
        DBqueryDTO dBqueryDTO = crud.read(model);
        if (!dBqueryDTO.isSuccess()) {
            docTagsDTO.setSuccess(false);
            docTagsDTO.setMessage(dBqueryDTO.getMessage());
            return docTagsDTO;
        }
        if (dBqueryDTO.getData() == null) {
            docTagsDTO.setSuccess(false);
            docTagsDTO.setMessage(MESSAGE);
            return docTagsDTO;
        }
        List<DocTagsDAL> list = new ArrayList<>();
        List<List<Object>> data = dBqueryDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createDocTagsDALfromList(columns));
        }
        docTagsDTO.setSuccess(true);
        docTagsDTO.setData(list);
        return docTagsDTO;
    }

    @Override
    public TopicsDTO getTopicById(String... topicIds) {
        TopicsDTO topicsDTO = new TopicsDTO();
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        model.where = "id";
        model.whereValue = topicIds;
        DBqueryDTO dBqueryDTO = crud.read(model);
        if (!dBqueryDTO.isSuccess()) {
            topicsDTO.setSuccess(false);
            topicsDTO.setMessage(dBqueryDTO.getMessage());
            return topicsDTO;
        }
        if (dBqueryDTO.getData() == null) {
            topicsDTO.setSuccess(false);
            topicsDTO.setMessage(MESSAGE);
            return topicsDTO;
        }
        List<TopicsDAL> list = new ArrayList<>();
        List<List<Object>> data = dBqueryDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createTopicsDALfromList(columns));
        }
        topicsDTO.setSuccess(true);
        topicsDTO.setData(list);
        return topicsDTO;
    }

    @Override
    public ExampleDTO getExampleById(String... exampleIds) {
        ExampleDTO exampleDTO = new ExampleDTO();
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        model.where = "id";
        model.whereValue = exampleIds;
        DBqueryDTO dBqueryDTO = crud.read(model);
        if (!dBqueryDTO.isSuccess()) {
            exampleDTO.setSuccess(false);
            exampleDTO.setMessage(dBqueryDTO.getMessage());
            return exampleDTO;
        }
        if (dBqueryDTO.getData() == null) {
            exampleDTO.setSuccess(false);
            exampleDTO.setMessage(MESSAGE);
            return exampleDTO;
        }
        List<ExampleDAL> list = new ArrayList<>();
        List<List<Object>> data = dBqueryDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createExampleDALfromList(columns));
        }
        exampleDTO.setSuccess(true);
        exampleDTO.setData(list);
        return exampleDTO;
    }

    @Override
    public DocTagsDTO getAllDocTags() {
        DocTagsDTO docTagsDTO = new DocTagsDTO();
        String cachePlacement = "allDocTags";
        if (cache.get(cachePlacement) != null) {
            return (DocTagsDTO) cache.get(cachePlacement);
        }
        DBQueryModel model = new DBQueryModel();
        model.table = "DocTags";
        DBqueryDTO dBqueryDTO = crud.read(model);
        if (!dBqueryDTO.isSuccess()) {
            docTagsDTO.setSuccess(false);
            docTagsDTO.setMessage(dBqueryDTO.getMessage());
            return docTagsDTO;
        }
        if (dBqueryDTO.getData() == null) {
            docTagsDTO.setSuccess(false);
            docTagsDTO.setMessage(MESSAGE);
            return docTagsDTO;
        }
        List<DocTagsDAL> list = new ArrayList<>();
        List<List<Object>> data = dBqueryDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createDocTagsDALfromList(columns));
        }
        docTagsDTO.setSuccess(true);
        docTagsDTO.setData(list);
        cache.put(cachePlacement, docTagsDTO);
        return docTagsDTO;
    }

    @Override
    public TopicsDTO getAllTopics() {
        TopicsDTO topicsDTO = new TopicsDTO();
        String cachePlacement = "allTopics";
        if (cache.get(cachePlacement) != null) {
            return (TopicsDTO) cache.get(cachePlacement);
        }
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        DBqueryDTO dbDTO = crud.read(model);
        if (!dbDTO.isSuccess()) {
            topicsDTO.setSuccess(false);
            topicsDTO.setMessage(dbDTO.getMessage());
            return topicsDTO;
        }
        if (dbDTO.getData() == null) {
            topicsDTO.setSuccess(false);
            topicsDTO.setMessage(MESSAGE);
            return topicsDTO;
        }
        List<TopicsDAL> list = new ArrayList<>();
        List<List<Object>> data = dbDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createTopicsDALfromList(columns));
        }
        topicsDTO.setSuccess(true);
        topicsDTO.setData(list);
        cache.put(cachePlacement, topicsDTO);
        return topicsDTO;
    }

    @Override
    public ExampleDTO getAllExamples() {
        ExampleDTO exampleDTO = new ExampleDTO();
        String cachePlacement = "allDocTags";
        if (cache.get(cachePlacement) != null) {
            return (ExampleDTO) cache.get(cachePlacement);
        }
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        DBqueryDTO dBqueryDTO = crud.read(model);
        if (!dBqueryDTO.isSuccess()) {
            exampleDTO.setSuccess(false);
            exampleDTO.setMessage(dBqueryDTO.getMessage());
            return exampleDTO;
        }
        if (dBqueryDTO.getData() == null) {
            exampleDTO.setSuccess(false);
            exampleDTO.setMessage(MESSAGE);
            return exampleDTO;
        }
        List<ExampleDAL> list = new ArrayList<>();
        List<List<Object>> data = dBqueryDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createExampleDALfromList(columns));
        }
        exampleDTO.setSuccess(true);
        exampleDTO.setData(list);
        cache.put(cachePlacement, exampleDTO);
        return exampleDTO;
    }

    @Override
    public TopicsDTO getTopicsByDocTagId(String... docTagIds) {
        TopicsDTO topicsDTO = new TopicsDTO();
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        model.where = "DocTagId";
        model.whereValue = docTagIds;
        DBqueryDTO dBqueryDTO = crud.read(model);
        if (!dBqueryDTO.isSuccess()) {
            topicsDTO.setSuccess(false);
            topicsDTO.setMessage(dBqueryDTO.getMessage());
            return topicsDTO;
        }
        if (dBqueryDTO.getData() == null) {
            topicsDTO.setSuccess(false);
            topicsDTO.setMessage(MESSAGE);
            return topicsDTO;
        }
        List<TopicsDAL> list = new ArrayList<>();
        List<List<Object>> data = dBqueryDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createTopicsDALfromList(columns));
        }
        topicsDTO.setSuccess(true);
        topicsDTO.setData(list);
        return topicsDTO;
    }

    @Override
    public ExampleDTO getExamplesByTopicsId(String... topicIds) {
        ExampleDTO exampleDTO = new ExampleDTO();
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        model.where = "TopicsId";
        model.whereValue = topicIds;
        DBqueryDTO dBqueryDTO = crud.read(model);
        if (!dBqueryDTO.isSuccess()) {
            exampleDTO.setSuccess(false);
            exampleDTO.setMessage(dBqueryDTO.getMessage());
            return exampleDTO;
        }
        if (dBqueryDTO.getData() == null) {
            exampleDTO.setSuccess(false);
            exampleDTO.setMessage(MESSAGE);
            return exampleDTO;
        }
        List<ExampleDAL> list = new ArrayList<>();
        List<List<Object>> data = dBqueryDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createExampleDALfromList(columns));
        }
        exampleDTO.setSuccess(true);
        exampleDTO.setData(list);
        return exampleDTO;
    }

    private DocTagsDAL createDocTagsDALfromList(List<Object> col) {

        DocTagsDAL dal = new DocTagsDAL();
        dal.setId(Long.parseLong(col.get(0).toString()));
        dal.setTag((String) col.get(1));
        dal.setTitle((String) col.get(2));
        dal.setCreationDate((String) col.get(3));
        dal.setHelloWorldDocTopicId(Long.parseLong(col.get(4).toString()));
        dal.setTopicCount(Long.parseLong(col.get(5).toString()));

        return dal;
    }

    private ExampleDAL createExampleDALfromList(List<Object> col) {

        ExampleDAL dal = new ExampleDAL();
        dal.setId(Long.parseLong(col.get(0).toString()));
        dal.setDocTopicId(Long.parseLong(col.get(1).toString()));
        dal.setTitle((String) col.get(2));
        dal.setCreationDate((String) col.get(3));
        dal.setLastEditDate((String) col.get(4));
        dal.setScore(Long.parseLong(col.get(5).toString()));
        dal.setContributorCount(Long.parseLong(col.get(6).toString()));
        dal.setBodyHtml((String) col.get(7));
        dal.setPinned((int) col.get(8) == 1);
        dal.setBodyMarkdown((String) col.get(9));

        return dal;
    }

    private TopicsDAL createTopicsDALfromList(List<Object> col) {

        TopicsDAL dal = new TopicsDAL();
        dal.setId(Long.parseLong(col.get(0).toString()));
        dal.setDocTagId(Long.parseLong(col.get(1).toString()));
        dal.setHelloWorldTopic((int) col.get(2) == 1);
        dal.setTitle((String) col.get(3));
        dal.setCreationDate((String) col.get(4));
        dal.setViewCount(Long.parseLong(col.get(5).toString()));
        dal.setLastEditDate((String) col.get(6));
        dal.setContributorCount(Long.parseLong(col.get(7).toString()));
        //HTML
        dal.setIntroductionHtml(col.get(8).toString());
        dal.setSyntaxHtml(col.get(9).toString());
        dal.setParametersHtml(col.get(10).toString());
        dal.setRemarksHtml(col.get(11).toString());
        dal.setHelloWorldVersionsHtml(col.get(12).toString());
        //
        dal.setVersionsJson((String) col.get(13));
        dal.setExampleCount(Long.parseLong(col.get(14).toString()));
        dal.setExampleScore(Long.parseLong(col.get(15).toString()));
        dal.setLastEditUserId(Long.parseLong(col.get(16).toString()));
        dal.setLastEditUserDisplayName((String) col.get(17));
        //Markdown
        dal.setIntroductionMarkdown((String) col.get(18));
        dal.setSyntaxMarkdown((String) col.get(19));
        dal.setParametersMarkdown((String) col.get(20));
        dal.setRemarksMarkdown((String) col.get(21));

        return dal;
    }
}
