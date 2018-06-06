

import Models.DAL.DocTagsDAL;
import Models.DTO.DBqueryDTO;
import Services.ICrud;
import Services.Impl.Crud;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class UploadDB {

    @Test
    public void JSONparseDocTags() {
        ICrud crud = new Crud();

        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("doctags.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonArray rootArray = rootElement.getAsJsonArray();
        System.out.println(rootArray.get(0).toString());
        rootArray.forEach(element -> {
            JsonObject jsonObject = element.getAsJsonObject();
            String tag = jsonObject.get("Tag").getAsString();
            String title = jsonObject.get("Title").getAsString();
            String creationDate = jsonObject.get("CreationDate").getAsString();
            int helloWorldDocTopicId = jsonObject.get("HelloWorldDocTopicId").getAsInt();
            int topicCount = jsonObject.get("TopicCount").getAsInt();
            String values = "null, '" + tag + "', '" + title + "', '" + creationDate + "', " +
                            helloWorldDocTopicId + ", " + topicCount;
            DBqueryDTO dto = crud.create("doctags", values);
            if (!dto.isSuccess()) {
                System.out.println("SHIT!");
            }
        });
    }

    @Test
    public void JSONparseTopics() {
        ICrud crud = new Crud();
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("topics.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonArray rootArray = rootElement.getAsJsonArray();
        System.out.println(rootArray.get(0).toString());
        rootArray.forEach(element -> {
            JsonObject jsonObject = element.getAsJsonObject();

            int id = jsonObject.get("Id").getAsInt();
            int docTagId = jsonObject.get("DocTagId").getAsInt();
            int isHelloWorldTopic = jsonObject.get("IsHelloWorldTopic").getAsBoolean() ? 1 : 0;
            String title = jsonObject.get("Title").getAsString().replace("'", "''");
            String creationDate = jsonObject.get("CreationDate").getAsString().replace("'", "''");
            int viewCount = jsonObject.get("ViewCount").getAsInt();
            String lastEditDate = jsonObject.has("LastEditDate") ? jsonObject.get("LastEditDate").getAsString().replace("'", "''") : "";
            int lastEditUserId = jsonObject.has("LastEditUserId") ? jsonObject.get("LastEditUserId").getAsInt() : 0;
            int contributorCount = jsonObject.get("ContributorCount").getAsInt();
            int exampleCount = jsonObject.get("ExampleCount").getAsInt();
            int exampleScore = jsonObject.get("ExampleScore").getAsInt();
            String syntaxHtml = jsonObject.get("SyntaxHtml").getAsString().replace("'", "''");
            String parametersHtml = jsonObject.get("ParametersHtml").getAsString().replace("'", "''");
            String remarksHtml = jsonObject.get("RemarksHtml").getAsString().replace("'", "''");
            String introductionMarkdown = jsonObject.get("IntroductionMarkdown").getAsString().replace("'", "''");
            String syntaxMarkdown = jsonObject.get("SyntaxMarkdown").getAsString().replace("'", "''");
            String parametersMarkdown = jsonObject.get("ParametersMarkdown").getAsString().replace("'", "''");
            String remarksMarkdown = jsonObject.get("RemarksMarkdown").getAsString().replace("'", "''");
            String helloWorldVersionsHtml = jsonObject.has("HelloWorldVersionsHtml") ? jsonObject.get("HelloWorldVersionsHtml").getAsString().replace("'", "''") : "";

            String values = "" + id + ", " + docTagId + ", " + isHelloWorldTopic + ", '" + title + "', '" +
                    creationDate + "', " + viewCount + ", '" + lastEditDate + "', " + lastEditUserId +
                    ", " + contributorCount + ", " + exampleCount + ", " + exampleScore + ", '" + syntaxHtml +
                    "', '" + parametersHtml + "', '" + remarksHtml + "', '" + introductionMarkdown + "', '" +
                    syntaxMarkdown + "', '" + parametersMarkdown + "', '" + remarksMarkdown + "', '" +
                    helloWorldVersionsHtml + "'";
            DBqueryDTO dto = crud.create("topics", values);
            if (!dto.isSuccess()) {
                System.out.println("SHIT!");
            }
        });
        System.out.println("DONE!!!!!!!");
    }

    @Test
    public void JSONparseExamples() {
        ICrud crud = new Crud();
        JsonParser parser = new JsonParser();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("examples.json");
        Reader reader = new InputStreamReader(inputStream);
        JsonElement rootElement = parser.parse(reader);
        JsonArray rootArray = rootElement.getAsJsonArray();
        System.out.println(rootArray.get(0).toString());
        rootArray.forEach(element -> {
            JsonObject jsonObject = element.getAsJsonObject();
            int id = jsonObject.get("Id").getAsInt();
            int docTopicId = jsonObject.get("DocTopicId").getAsInt();
            String title = jsonObject.get("Title").getAsString().replace("'", "''");
            String creationDate = jsonObject.get("CreationDate").getAsString().replace("'", "''");
            int score = jsonObject.get("Score").getAsInt();
            int contributorCount = jsonObject.get("ContributorCount").getAsInt();
            String bodyHtml = jsonObject.get("BodyHtml").getAsString().replace("'", "''");
            String bodyMarkdown = jsonObject.get("BodyMarkdown").getAsString().replace("'", "''");
            int isPinned = jsonObject.get("IsPinned").getAsBoolean() ? 1 : 0;

            String values = "" + id + ", " + docTopicId + ", '" + title + "', '" + creationDate + "', " +
                            score + ", " + contributorCount + ", '" + bodyHtml + "', '" + bodyMarkdown +
                            "', " + isPinned;
            DBqueryDTO dto = crud.create("examples", values);
            if (!dto.isSuccess()) {
                System.out.println("SHIT!");
            }
        });
    }
}
