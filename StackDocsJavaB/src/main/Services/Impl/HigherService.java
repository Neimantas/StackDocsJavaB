package main.Services.Impl;

import main.Models.DAL.DocTagsDAL;
import main.Models.DAL.ExampleDAL;
import main.Models.DAL.TopicsDAL;
import main.Models.DTO.DBqueryDTO;
import main.Models.DTO.DocTagsDTO;
import main.Models.DTO.ExampleDTO;
import main.Models.DTO.TopicsDTO;
import main.Services.IHigherService;
import java.util.ArrayList;
import java.util.List;

public class HigherService implements IHigherService {

    Crud crud = new Crud();

    @Override
    public DocTagsDTO getDocTagById(String docTagId) {
        DBqueryDTO dbDTO = crud.read("DocTags");
        DocTagsDTO dtDTO = new DocTagsDTO();

        dtDTO.setSuccess(dbDTO.isSuccess());
        dtDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<DocTagsDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                if (columns.get(0) == docTagId) {
                    list.add(createDocTagsDALfromResultSet(columns));
                }
            }

            if (!list.isEmpty()) {
                dtDTO.setData(list);
                return dtDTO;
            } else {
                dtDTO.setMessage("DB connection vas successful, but cant find anything by Id");
                return dtDTO;
            }

        } else {
            return dtDTO;
        }
    }

    @Override
    public TopicsDTO getTopicById(String topicId) {
        DBqueryDTO dbDTO = crud.read("Topics");
        TopicsDTO tDTO = new TopicsDTO();

        tDTO.setSuccess(dbDTO.isSuccess());
        tDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<TopicsDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                if (columns.get(0) == topicId) {
                    list.add(createTopicsDALfromResultSet(columns));
                }
            }

            if (!list.isEmpty()) {
                tDTO.setData(list);
                return tDTO;
            } else {
                tDTO.setMessage("DB connection vas successful, but cant find anything by Id");
                return tDTO;
            }

        } else {
            return tDTO;
        }
    }

    @Override
    public ExampleDTO getExampleById(String exampleId) {
        DBqueryDTO dbDTO = crud.read("Examples");
        ExampleDTO eDTO = new ExampleDTO();

        eDTO.setSuccess(dbDTO.isSuccess());
        eDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<ExampleDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                if (columns.get(0) == exampleId) {
                    list.add(createExampleDALfromResultSet(columns));
                }
            }

            if (!list.isEmpty()) {
                eDTO.setData(list);
                return eDTO;
            } else {
                eDTO.setMessage("DB connection vas successful, but cant find anything by Id");
                return eDTO;
            }

        } else {
            return eDTO;
        }
    }

    @Override
    public DocTagsDTO getAllDocTags() {
        DBqueryDTO dbDTO = crud.read("DocTags");
        DocTagsDTO dtDTO = new DocTagsDTO();

        dtDTO.setSuccess(dbDTO.isSuccess());
        dtDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<DocTagsDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                list.add(createDocTagsDALfromResultSet(columns));
            }

            if (!list.isEmpty()) {
                dtDTO.setData(list);
                return dtDTO;
            } else {
                dtDTO.setMessage("DB connection vas successful, but cant find any DocTags");
                return dtDTO;
            }

        } else {
            return dtDTO;
        }
    }

    @Override
    public TopicsDTO getAllTopics() {
        DBqueryDTO dbDTO = crud.read("Topics");
        TopicsDTO tDTO = new TopicsDTO();

        tDTO.setSuccess(dbDTO.isSuccess());
        tDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<TopicsDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                list.add(createTopicsDALfromResultSet(columns));
            }

            if (!list.isEmpty()) {
                tDTO.setData(list);
                return tDTO;
            } else {
                tDTO.setMessage("DB connection vas successful, but cant find any Topics");
                return tDTO;
            }

        } else {
            return tDTO;
        }
    }

    @Override
    public ExampleDTO getAllEcamples() {
        DBqueryDTO dbDTO = crud.read("Examples");
        ExampleDTO eDTO = new ExampleDTO();

        eDTO.setSuccess(dbDTO.isSuccess());
        eDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<ExampleDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                    list.add(createExampleDALfromResultSet(columns));
            }

            if (!list.isEmpty()) {
                eDTO.setData(list);
                return eDTO;
            } else {
                eDTO.setMessage("DB connection vas successful, but cant find any Examples");
                return eDTO;
            }

        } else {
            return eDTO;
        }
    }

    @Override
    public TopicsDTO getTopicsByDocTagId(String docTagId) {
        DBqueryDTO dbDTO = crud.read("Topics");
        TopicsDTO tDTO = new TopicsDTO();

        tDTO.setSuccess(dbDTO.isSuccess());
        tDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<TopicsDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                if (columns.get(1) == docTagId) {
                    list.add(createTopicsDALfromResultSet(columns));
                }
            }

            if (!list.isEmpty()) {
                tDTO.setData(list);
                return tDTO;
            } else {
                tDTO.setMessage("DB connection vas successful, but cant find anything by Id");
                return tDTO;
            }

        } else {
            return tDTO;
        }
    }

    @Override
    public ExampleDTO getExamplesByTopicsId(String topicId) {
        DBqueryDTO dbDTO = crud.read("Examples");
        ExampleDTO eDTO = new ExampleDTO();

        eDTO.setSuccess(dbDTO.isSuccess());
        eDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<ExampleDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                if (columns.get(1) == topicId) {
                    list.add(createExampleDALfromResultSet(columns));
                }
            }

            if (!list.isEmpty()) {
                eDTO.setData(list);
                return eDTO;
            } else {
                eDTO.setMessage("DB connection vas successful, but cant find anything by Id");
                return eDTO;
            }

        } else {
            return eDTO;
        }
    }

    private DocTagsDAL createDocTagsDALfromResultSet(List<Object> col) {

        DocTagsDAL dal = new DocTagsDAL();

        dal.setId((long) col.get(0));
        dal.setTag((String) col.get(1));
        dal.setTitle((String) col.get(2));
        dal.setCreationDate((String) col.get(3));
        dal.setHelloWorldDocTopicId((long) col.get(4));
        dal.setTopicCount((long) col.get(5));

        return dal;
    }

    private ExampleDAL createExampleDALfromResultSet(List<Object> col) {

        ExampleDAL dal = new ExampleDAL();

        dal.setId((long) col.get(0));
        dal.setDocTopicId((long) col.get(1));
        dal.setTitle((String) col.get(2));
        dal.setCreationDate((String) col.get(3));
        dal.setLastEditDate((String) col.get(4));
        dal.setScore((long) col.get(5));
        dal.setContributorCount((long)col.get(6));
        dal.setBodyHtml((String) col.get(7));
        dal.setBodyMarkdown((String) col.get(8));
        dal.setPinned((boolean) col.get(9));

        return dal;
    }

    private TopicsDAL createTopicsDALfromResultSet(List<Object> col) {

        TopicsDAL dal = new TopicsDAL();

        dal.setId((long) col.get(0));
        dal.setDocTagId((long) col.get(1));
        dal.setHelloWorldTopic((boolean) col.get(2));
        dal.setTitle((String) col.get(3));
        dal.setCreationDate((String) col.get(4));
        dal.setViewCount((long) col.get(5));
        dal.setLastEditDate((String) col.get(6));
        dal.setLastEditUserId((long) col.get(7));
        dal.setLastEditUserDisplayName((String) col.get(8));
        dal.setContributorCount((long) col.get(9));
        dal.setExampleCount((long) col.get(10));
        dal.setExampleScore((long) col.get(11));
        //HTML
        dal.setIntroductionHtml((String) col.get(12));
        dal.setSyntaxHtml((String) col.get(13));
        dal.setParametersHtml((String) col.get(14));
        dal.setRemarksHtml((String) col.get(15));
        //Markdown
        dal.setIntroductionMarkdown((String) col.get(16));
        dal.setSyntaxMarkdown((String) col.get(17));
        dal.setParametersMarkdown((String) col.get(18));
        dal.setRemarksMarkdown((String) col.get(19));
        //
        dal.setHelloWorldVersionsHtml((String) col.get(20));
        dal.setVersionsJson((String) col.get(21));

        return dal;
    }
}
