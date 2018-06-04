package main.Services.Impl;

import main.Models.DAL.DocTagsDAL;
import main.Models.DAL.ExampleDAL;
import main.Models.DAL.TopicsDAL;
import main.Models.DTO.DBqueryDTO;
import main.Models.DTO.HigherServiceDTO;
import main.Services.IHigherService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class HigherService implements IHigherService {

    Crud crud = new Crud();


    @Override
    public HigherServiceDTO getByThemeTytle(String title) throws SQLException {

        DBqueryDTO dto = crud.read("Examples");
        if (dto.isSuccess()) {

            List<ExampleDAL> examplesList = new ArrayList<>();
            ResultSet rs = dto.getData();

            while(rs.next()) {
                if (rs.getString("Title") == title) {
                    ExampleDAL dal = createExampleDALfromResultSet(rs);
                    examplesList.add(dal);
                }
            }

            if (!examplesList.isEmpty()) {
                HigherServiceDTO hDTO = new HigherServiceDTO();
                hDTO.success = dto.isSuccess();
                hDTO.examplesList = examplesList;
                return hDTO;
            } else {
                HigherServiceDTO hDTO = new HigherServiceDTO();
                hDTO.success = dto.isSuccess();
                hDTO.message = "DB connection vas successfull, but cant find anything by title";
                return hDTO;
            }
        } else {
            return null;
        }
    }

    @Override
    public HigherServiceDTO getByTopicId(String topicId) throws SQLException {
        DBqueryDTO dto = crud.read("Topics");
        if (dto.isSuccess()) {

            List<TopicsDAL> examplesList = new ArrayList<>();

            ResultSet rs = dto.getData();

            while(rs.next()) {
                if (rs.getString("Id") == topicId) {


                }
            }

            if (!examplesList.isEmpty()) {
                HigherServiceDTO hDTO = new HigherServiceDTO();
                hDTO.success = dto.isSuccess();
                hDTO.examplesList = examplesList;
                return hDTO;
            } else {
                HigherServiceDTO hDTO = new HigherServiceDTO();
                hDTO.success = dto.isSuccess();
                hDTO.message = "DB connection vas successfull, but cant find anything by title";
                return hDTO;
            }
        } else {
            return null;
        }
    }

    @Override
    public HigherServiceDTO getByDocTagId(String doctagId) {
        return null;
    }

    @Override
    public HigherServiceDTO getByExampleId(String exampleId) {
        return null;
    }


    private DocTagsDAL createDocTagsDALfromResultSet(ResultSet rs) throws SQLException {

        DocTagsDAL dal = new DocTagsDAL();

        dal.setId(rs.getLong("Id"));
        dal.setTag(rs.getString("Tag"));
        dal.setTitle(rs.getString("Title"));
        dal.setCreationDate(rs.getString("CreationDate"));
        dal.setHelloWorldDocTopicId(rs.getLong("HelloWorldDocTopicId"));
        dal.setTopicCount(rs.getLong("TopicCount"));

        return dal;
    }

    private ExampleDAL createExampleDALfromResultSet(ResultSet rs) throws SQLException {

        ExampleDAL dal = new ExampleDAL();

        dal.setId(rs.getLong("Id"));
        dal.setDocTopicId(rs.getLong("DocTopicId"));
        dal.setTitle(rs.getString("Title"));
        dal.setCreationDate(rs.getString("CreationDate"));
        dal.setLastEditDate(rs.getString("LastEditData"));
        dal.setScore(rs.getLong("Score"));
        dal.setContributorCount(rs.getLong("ContributorCount"));
        dal.setBodyHtml(rs.getString("BodyHtml"));
        dal.setBodyMarkdown(rs.getString("BodyMarkdown"));
        dal.setPinned(rs.getBoolean("IsPinned"));

        return dal;
    }

    private TopicsDAL createTopicsDALfromResultSet(ResultSet rs) throws SQLException {

        TopicsDAL dal = new TopicsDAL();

        dal.setId(rs.getLong("Id"));
        dal.setDocTagId(rs.getLong("DocTagId"));
        dal.setHelloWorldTopic(rs.getBoolean("IsHelloWorldTopic"));
        dal.setTitle(rs.getString("Title"));
        dal.setCreationDate(rs.getString("CreationDate"));
        dal.setViewCount(rs.getLong("ViewCount"));
        dal.setLastEditDate(rs.getString("LastEditDate"));
        dal.setLastEditUserId(rs.getLong("LastEditUserId"));
        dal.setLastEditUserDisplayName(rs.getString("LastEditUserDisplayName"));
        dal.setContributorCount(rs.getLong("ContributorCount"));
        dal.

        return dal;
    }

    private Examples changeDocTagsDALtoDocTags(DocTagsDAL dal) {

        return new Examples();
    }

    private Examples changeExampleDALtExamples(ExampleDAL dal) {

        return new Examples();
    }

    private Examples changeTopicsDALtoTopics(TopicsDAL dal) {

        return new Examples();
    }
}

class Examples {

}

class Crud {
    DBqueryDTO read(String tableName) { return null;}
    DBqueryDTO create(String tableName, String columns) {return null;}
    DBqueryDTO unpdate(String tableName, String values) {return null;}
    DBqueryDTO delete(String tableName, String columns) {return null;}
}