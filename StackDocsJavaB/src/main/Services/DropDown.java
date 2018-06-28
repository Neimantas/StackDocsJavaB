package Services;

import Models.BusinessLogic.DocTag;
import Models.DAL.DocTagsDAL;
import Models.DTO.DocTagsDTO;
import Services.Impl.Cache;
import Services.Impl.HigherService;

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

        List<DocTag> drop = new ArrayList<>();

        Object some = cache.get(getDropDown);

        if (cache.get(getDropDown) != null) {

            drop = (List<DocTag>) some;

            return drop;

        } else {

            IHigherService higher = new HigherService();

            DocTagsDTO dtoList = higher.getDocTagById(dropDownsNeeded);

            List<DocTagsDAL> dropDown = dtoList.getData();


            for (int i = 0; i < dropDown.size(); i++) {

                DocTag docTag = new DocTag();

                DocTagsDAL mydal = dropDown.get(i);

                docTag.id = mydal.getId();

                docTag.tag = mydal.getTag();

                drop.add(docTag);

            }

            cache.put(getDropDown, drop);

            return drop;

        }

    }

}



