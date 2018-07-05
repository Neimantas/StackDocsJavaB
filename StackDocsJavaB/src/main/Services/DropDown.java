package Services;

import Models.BusinessLogic.DocTag;
import Models.DAL.DocTagsDAL;
import Models.DTO.DocTagsDTO;
import Services.Impl.Cache;
import Services.Impl.HigherService;
import org.modelmapper.ModelMapper;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

public class DropDown {

    private String getDropDown = "dropdownGet";
    private String[] dropDownsNeeded = {"3", "4", "5", "8"};

    public int getSize() {
        return dropDownsNeeded.length;
    }

    public List<DocTag> getList() {
        Cache cache = Cache.getInstance();
        List<DocTag> docTagsList = new ArrayList<>();
        Object obj = cache.get(getDropDown);
        if (cache.get(getDropDown) != null) {
            docTagsList = (List<DocTag>) obj;
            return docTagsList;

        } else {
            IHigherService higher = new HigherService();
            DocTagsDTO docTagsDTO = higher.getDocTagById(dropDownsNeeded);
            if (docTagsDTO.isSuccess()) {
                List<DocTagsDAL> docTagsDALsList = docTagsDTO.getList();
                for (int i = 0; i < docTagsDALsList.size(); i++) {
                    ModelMapper modelMapper = new ModelMapper();
                    docTagsList.add(modelMapper.map(docTagsDALsList.get(i) ,DocTag.class));
                }
            }
            cache.put(getDropDown, docTagsList);
            return docTagsList;
        }
    }
}