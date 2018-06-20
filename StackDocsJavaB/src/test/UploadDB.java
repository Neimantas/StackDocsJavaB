//
//
//import Models.DAL.DocTagsDAL;
//import Models.DTO.DBqueryDTO;
//import Services.ICrud;
//import Services.Impl.Crud;
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//import org.junit.Assert;
//import org.junit.Test;
//
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.Reader;
//
//public class UploadDB {
//
//    @Test
//    public void JSONparseDocTags() {
//        ICrud crud = new Crud();
//
//        JsonParser parser = new JsonParser();
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("doctags.json");
//        Reader reader = new InputStreamReader(inputStream);
//        JsonElement rootElement = parser.parse(reader);
//        JsonArray rootArray = rootElement.getAsJsonArray();
//        System.out.println(rootArray.get(0).toString());
//        rootArray.forEach(element -> {
//            JsonObject jsonObject = element.getAsJsonObject();
//            int id = jsonObject.get("Id").getAsInt();
//            String tag = jsonObject.get("Tag").getAsString();
//            String title = jsonObject.get("Title").getAsString();
//            String creationDate = jsonObject.get("CreationDate").getAsString();
//            int helloWorldDocTopicId = jsonObject.get("HelloWorldDocTopicId").getAsInt();
//            int topicCount = jsonObject.get("TopicCount").getAsInt();
//            String values = "" + id + ", '" + tag + "', '" + title + "', '" + creationDate + "', " +
//                            helloWorldDocTopicId + ", " + topicCount;
//            DBqueryDTO dto = crud.create("doctags", values);
//            if (!dto.isSuccess()) {
//                System.out.println("SHIT!");
//            }
//        });
//    }
//
//    @Test
//    public void JSONparseTopics() {
//        ICrud crud = new Crud();
//        JsonParser parser = new JsonParser();
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("topics.json");
//        Reader reader = new InputStreamReader(inputStream);
//        JsonElement rootElement = parser.parse(reader);
//        JsonArray rootArray = rootElement.getAsJsonArray();
//        System.out.println(rootArray.get(0).toString());
//        rootArray.forEach(element -> {
//            JsonObject jsonObject = element.getAsJsonObject();
//
//            int id = jsonObject.get("Id").getAsInt();
//            int docTagId = jsonObject.get("DocTagId").getAsInt();
//            int isHelloWorldTopic = jsonObject.get("IsHelloWorldTopic").getAsBoolean() ? 1 : 0;
//            String title = jsonObject.get("Title").getAsString().replace("'", "''");
//            String creationDate = jsonObject.get("CreationDate").getAsString().replace("'", "''");
//            int viewCount = jsonObject.get("ViewCount").getAsInt();
//            String lastEditDate = jsonObject.has("LastEditDate") ? jsonObject.get("LastEditDate").getAsString().replace("'", "''") : "";
//            int contributorCount = jsonObject.get("ContributorCount").getAsInt();
//            String introductionHtml= jsonObject.has("IntroductionHtml") ? jsonObject.get("IntroductionHtml").getAsString().replace("'", "''") : "";
//            String syntaxHtml = jsonObject.get("SyntaxHtml").getAsString().replace("'", "''");
//            String parametersHtml = jsonObject.get("ParametersHtml").getAsString().replace("'", "''");
//            String remarksHtml = jsonObject.get("RemarksHtml").getAsString().replace("'", "''");
//            String helloWorldVersionsHtml = jsonObject.has("HelloWorldVersionsHtml") ? jsonObject.get("HelloWorldVersionsHtml").getAsString().replace("'", "''") : "";
//            String versionsJson = jsonObject.has("VersionsJson") ? jsonObject.get("VersionsJson").getAsString().replace("'", "''") : "";
//            int exampleCount = jsonObject.get("ExampleCount").getAsInt();
//            int exampleScore = jsonObject.get("ExampleScore").getAsInt();
//            int lastEditUserId = jsonObject.has("LastEditUserId") ? jsonObject.get("LastEditUserId").getAsInt() : 0;
//            String lastEditUserDisplayName = jsonObject.has("LastEditUserDisplayName") ? jsonObject.get("LastEditUserDisplayName").getAsString().replace("'", "''") : "";
//            String introductionMarkdown = jsonObject.get("IntroductionMarkdown").getAsString().replace("'", "''");
//            String syntaxMarkdown = jsonObject.get("SyntaxMarkdown").getAsString().replace("'", "''");
//            String parametersMarkdown = jsonObject.get("ParametersMarkdown").getAsString().replace("'", "''");
//            String remarksMarkdown = jsonObject.get("RemarksMarkdown").getAsString().replace("'", "''");
//
//            String values = "" + id + ", " + docTagId + ", " + isHelloWorldTopic + ", '" + title + "', '" +
//                    creationDate + "', " + viewCount + ", '" + lastEditDate + "', " + contributorCount + ", '" +
//                    introductionHtml + "', '" + syntaxHtml + "', '" + parametersHtml + "', '" + remarksHtml + "', '" +
//                    helloWorldVersionsHtml + "', '" + versionsJson + "', " + exampleCount + ", " + exampleScore + ", " +
//                    lastEditUserId + ", '" + lastEditUserDisplayName + "', '" + introductionMarkdown + "', '" + syntaxMarkdown +
//                    "', '" + parametersMarkdown + "', '" + remarksMarkdown + "'";
//            DBqueryDTO dto = crud.create("topics", values);
//            if (!dto.isSuccess()) {
//                System.out.println("SHIT!");
//            }
//        });
//        System.out.println("DONE!!!!!!!");
//    }
//
//    @Test
//    public void JSONparseExamples() {
//        ICrud crud = new Crud();
//        JsonParser parser = new JsonParser();
//        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("examples.json");
//        Reader reader = new InputStreamReader(inputStream);
//        JsonElement rootElement = parser.parse(reader);
//        JsonArray rootArray = rootElement.getAsJsonArray();
//        System.out.println(rootArray.get(0).toString());
//        rootArray.forEach(element -> {
//            JsonObject jsonObject = element.getAsJsonObject();
//            int id = jsonObject.get("Id").getAsInt();
//            int docTopicId = jsonObject.get("DocTopicId").getAsInt();
//            String title = jsonObject.get("Title").getAsString().replace("'", "''");
//            String creationDate = jsonObject.get("CreationDate").getAsString().replace("'", "''");
//            String lastEditDate = jsonObject.has("LastEditDate") ? jsonObject.get("LastEditDate").getAsString().replace("'", "''") : "";
//            int score = jsonObject.get("Score").getAsInt();
//            int contributorCount = jsonObject.get("ContributorCount").getAsInt();
//            String bodyHtml = jsonObject.get("BodyHtml").getAsString().replace("'", "''");
//            int isPinned = jsonObject.get("IsPinned").getAsBoolean() ? 1 : 0;
//            String bodyMarkdown = jsonObject.get("BodyMarkdown").getAsString().replace("'", "''");
//
//
//            String values = "" + id + ", " + docTopicId + ", '" + title + "', '" + creationDate + "', '" +
//                            lastEditDate + "', " + score + ", " + contributorCount + ", '" + bodyHtml + "', " +
//                            + isPinned + ", '" + bodyMarkdown + "'";
//            DBqueryDTO dto = crud.create("examples", values);
//            if (!dto.isSuccess()) {
//                System.out.println("SHIT!");
//            }
//        });
//    }
//}
