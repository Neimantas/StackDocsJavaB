import Models.DTO.DocTagsDTO;
import Services.DropDown;
import Services.IHigherService;
import Services.Impl.HigherService;

public class TestRunner {
    public void AssertAll() {
        System.out.println(AssertDbConnection());
        System.out.println(AssertDocTagsCollection());
        System.out.println(AssertDropDownCollection());
    }

    private boolean AssertDbConnection() {
        //some logic which checks db connection

        return false;
    }

    private boolean AssertDocTagsCollection() {
        IHigherService higher = new HigherService();
        DocTagsDTO dto = higher.getAllDocTags();
        if (dto.getData().size() > 0) return true;

        return false;
    }

    private boolean AssertDropDownCollection() {

        DropDown dropDown = new DropDown();
        if (dropDown.getList().size() == dropDown.getSize()) {
            return true;
        }

        return false;
    }
}
