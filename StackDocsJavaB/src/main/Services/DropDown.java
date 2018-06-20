package Services;


import Models.BusinessLogic.DocTag;
import Models.DAL.DocTagsDAL;
import Models.DTO.DocTagsDTO;
import Services.Impl.Cache;
import Services.Impl.HigherService;

import java.lang.reflect.Field;
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

            List<DocTagsDTO> dtoList = new ArrayList<>();

            for (int i = 0; i < dropDownsNeeded.length; i++) {
                dtoList.add(higher.getDocTagById(dropDownsNeeded[i]));
            }

            for (int i = 0; i < dtoList.size(); i++) {
                if (!dtoList.get(i).isSuccess()) {
                    return null;
                }
            }


            DocTag docTag = new DocTag();

            for (int i = 0; i < dtoList.size(); i++) {

                List<DocTagsDAL> list = dtoList.get(i).getData();

                DocTagsDAL mydal = list.get(0);

                docTag.setId(mydal.getId());

                docTag.setTag(mydal.getTag());

                drop.add(docTag);

//                cache.put(getDropDown+i, docTag);

            }

            cache.put(getDropDown, drop);

            return drop;

        }


    }

}



