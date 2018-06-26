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

    ICrud crud = new Crud();
    ICache cache = Cache.getInstance();

    @Override
    public DocTagsDTO getDocTagById(String... docTagIds) {
        DocTagsDTO docTagsDTO = new DocTagsDTO();
        List<DocTagsDAL> list = new ArrayList<>();

        for (int i = 0; i < docTagIds.length; i++) {
            // Paruosiam modeli
            DBQueryModel model = new DBQueryModel();
            model.table = "DocTags";
            model.where = "id";
            model.whereValue = new String[]{docTagIds[i]};
            model.single = true;
            // Pernesam zinutes
            DBqueryDTO dBqueryDTO = crud.read(model);
            docTagsDTO.setSuccess(dBqueryDTO.isSuccess());
            docTagsDTO.setMessage(dBqueryDTO.getMessage());
            // Tikrinam
            if (dBqueryDTO.isSuccess()) {
                // mano pirmasis narys, nes tik viena id is duombazes
                List<Object> dataById = dBqueryDTO.getData().get(0);
                list.add(createDocTagsDALfromList(dataById));
            }
        }
        if (!list.isEmpty()) {
            docTagsDTO.setData(list);
            return docTagsDTO;
        } else if (list.isEmpty()) {
            docTagsDTO.setMessage("DB connection vas successful, but cant find anything by Id");
            return docTagsDTO;
        } else {
            return docTagsDTO;
        }
    }

    @Override
    public TopicsDTO getTopicById(String... topicIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        model.where = "id";
        model.whereValue = topicIds;
        DBqueryDTO dbDTO = crud.read(model);

        TopicsDTO tDTO = new TopicsDTO();

        tDTO.setSuccess(dbDTO.isSuccess());
        tDTO.setMessage(dbDTO.getMessage());
        List<TopicsDAL> list = new ArrayList<>();
        if (dbDTO.isSuccess()) {
            List<List<Object>> data = dbDTO.getData();
            for (int i = 0; i < data.size(); i++) {
                list.add(createTopicsDALfromList(data.get(i)));
            }
        }

        if (!list.isEmpty()) {
            tDTO.setData(list);
            return tDTO;
        } else if (list.isEmpty()){
            tDTO.setMessage("DB connection vas successful, but cant find anything by Id");
            return tDTO;
        }
        return tDTO;
}

    @Override
    public ExampleDTO getExampleById(String... exampleIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        DBqueryDTO dbDTO = crud.read(model);
        ExampleDTO eDTO = new ExampleDTO();

        eDTO.setSuccess(dbDTO.isSuccess());
        eDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<ExampleDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                for (int j = 0; j < exampleIds.length; j++) {
                    if (columns.get(0).toString().equals(exampleIds[j])) {
                        list.add(createExampleDALfromList(columns));
                    }
                }
            }

            if (!list.isEmpty()) {
                eDTO.setData(list);
                return eDTO;
            } else {
                eDTO.setMessage("DB connection vas successful, but cant find anything by Id");
                return eDTO;
            }
        }
        return eDTO;
    }

    @Override
    public DocTagsDTO getAllDocTags() {
        DBQueryModel model = new DBQueryModel();
        model.table = "DocTags";
        DBqueryDTO dbDTO = crud.read(model);
        DocTagsDTO dtDTO = new DocTagsDTO();

        dtDTO.setSuccess(dbDTO.isSuccess());
        dtDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<DocTagsDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                list.add(createDocTagsDALfromList(columns));
            }

            if (!list.isEmpty()) {
                dtDTO.setData(list);
                return dtDTO;
            } else {
                dtDTO.setMessage("DB connection vas successful, but cant find any DocTags");
                return dtDTO;
            }
        }
        return dtDTO;
    }

    @Override
    public TopicsDTO getAllTopics() {
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        DBqueryDTO dbDTO = crud.read(model);
        TopicsDTO tDTO = new TopicsDTO();

        tDTO.setSuccess(dbDTO.isSuccess());
        tDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<TopicsDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                list.add(createTopicsDALfromList(columns));
            }

            if (!list.isEmpty()) {
                tDTO.setData(list);
                return tDTO;
            } else {
                tDTO.setMessage("DB connection vas successful, but cant find any Topics");
                return tDTO;
            }
        }
        return tDTO;
    }

    @Override
    public ExampleDTO getAllEcamples() {
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        DBqueryDTO dbDTO = crud.read(model);
        ExampleDTO eDTO = new ExampleDTO();

        eDTO.setSuccess(dbDTO.isSuccess());
        eDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<ExampleDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                list.add(createExampleDALfromList(columns));
            }

            if (!list.isEmpty()) {
                eDTO.setData(list);
                return eDTO;
            } else {
                eDTO.setMessage("DB connection vas successful, but cant find any Examples");
                return eDTO;
            }
        }
        return eDTO;
    }

    @Override
    public TopicsDTO getTopicsByDocTagId(String docTagId) {
        //model
        DBQueryModel model = new DBQueryModel();
        model.table = "Topics";
        model.where = "DocTagId";
        model.whereValue = new String[]{docTagId};
        //Get data, set messages
        DBqueryDTO dbDTO = crud.read(model);
        TopicsDTO tDTO = new TopicsDTO();
        tDTO.setSuccess(dbDTO.isSuccess());
        tDTO.setMessage(dbDTO.getMessage());

        if (!dbDTO.isSuccess()) {
            return tDTO;
        }

        List<TopicsDAL> list = new ArrayList<>();
        List<List<Object>> data = dbDTO.getData();
        for (int i = 0; i < data.size(); i++) {
            List<Object> columns = data.get(i);
            list.add(createTopicsDALfromList(columns));
        }

        if (list.isEmpty()) {
            tDTO.setMessage("DB connection vas successful, but cant find anything by Id");
            return tDTO;
        }
        tDTO.setData(list);
        return tDTO;
    }


    @Override
    public ExampleDTO getExamplesByTopicsId(String... topicIds) {
        DBQueryModel model = new DBQueryModel();
        model.table = "Examples";
        DBqueryDTO dbDTO = crud.read(model);
        ExampleDTO eDTO = new ExampleDTO();

        eDTO.setSuccess(dbDTO.isSuccess());
        eDTO.setMessage(dbDTO.getMessage());

        if (dbDTO.isSuccess()) {

            List<ExampleDAL> list = new ArrayList<>();
            List<List<Object>> data = dbDTO.getData();

            for (int i = 0; i < data.size(); i++) {
                List<Object> columns = data.get(i);
                for (int j = 0; j < topicIds.length; j++) {
                    if (columns.get(1).toString().equals(topicIds[j])) {
                        list.add(createExampleDALfromList(columns));
                    }
                }
            }

            if (!list.isEmpty()) {
                eDTO.setData(list);
                return eDTO;
            } else {
                eDTO.setMessage("DB connection vas successful, but cant find anything by Id");
                return eDTO;
            }
        }
        return eDTO;
    }


    @Override
    public TopicsDTO getTenTopicsById(Boolean after, String id) {
        TopicsDTO topicsDTO = new TopicsDTO();
        List<TopicsDAL> list = new ArrayList<>();

        if (after) {
            DBQueryModel model = new DBQueryModel();
            model.table = "Topics";
            model.where = "id";
            model.whereValue = new String[]{id};
            // Pernesam zinutes
            DBqueryDTO dBqueryDTO = crud.read(model);
            topicsDTO.setSuccess(dBqueryDTO.isSuccess());
            topicsDTO.setMessage(dBqueryDTO.getMessage());

            // Tikrinam
            if (dBqueryDTO.isSuccess()) {
                // mano pirmasis narys, nes tik viena id is duombazes
                List<List<Object>> data = dBqueryDTO.getData();
                for (int i = 0; i < data.size(); i++) {
                    list.add(createTopicsDALfromList(data.get(i)));
                }
            }
        }
        if (!after) {
            DBQueryModel model = new DBQueryModel();
            model.table = "Topics";
            model.where = "id";
            model.whereValue = new String[]{id};
            model.after = false;

            DBqueryDTO dBqueryDTO = crud.read(model);
            topicsDTO.setSuccess(dBqueryDTO.isSuccess());
            topicsDTO.setMessage(dBqueryDTO.getMessage());

            // Tikrinam
            if (dBqueryDTO.isSuccess()) {
                // mano pirmasis narys, nes tik viena id is duombazes
                List<List<Object>> data = dBqueryDTO.getData();
                for (int i = 0; i < data.size(); i++) {
                    list.add(createTopicsDALfromList(data.get(i)));
                }
            }
        }
        if (!list.isEmpty()) {
            topicsDTO.setData(list);
            return topicsDTO;
        } else if (list.isEmpty()) {
            topicsDTO.setMessage("DB connection vas successful, but cant find anything by Id");
            return topicsDTO;
        } else {
            return topicsDTO;
        }
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
        System.out.println((String) col.get(3));
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
        dal.setIntroductionHtml((String) col.get(8));
        dal.setSyntaxHtml((String) col.get(9));
        dal.setParametersHtml((String) col.get(10));
        dal.setRemarksHtml((String) col.get(11));
        dal.setHelloWorldVersionsHtml((String) col.get(12));
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
