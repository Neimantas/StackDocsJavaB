package Services;


import Models.BusinessLogic.DocTag;
import Models.DAL.DocTagsDAL;
import Models.DTO.DocTagsDTO;
import Services.Impl.HigherService;

import java.util.ArrayList;
import java.util.List;

public class DropDown {

    private IHigherService higher = new HigherService();
    private int[] dropDownsNeeded = {3, 4, 5, 8};

    public int getSize(){
        return dropDownsNeeded.length;
    }


    public List<DocTag> getList() {

        List<DocTagsDTO> dtoList = new ArrayList<>();


        for (int i = 0; i < dropDownsNeeded.length; i++) {
            dtoList.add(higher.getDocTagById("" + dropDownsNeeded[i]));
        }

        for (int i = 0; i < dtoList.size(); i++) {
            if (!dtoList.get(i).isSuccess()) {
                return null;
            }
        }

        List<DocTag> drop = new ArrayList<>();

        DocTag docTag = new DocTag();

        for (int i = 0; i < dtoList.size(); i++) {

            List<DocTagsDAL> list = dtoList.get(i).getData();

            for (int j = 0; j < list.size(); j++) {
                System.out.println(list.get(i));
            }

//            DocTagsDAL mydal = list.get(0);
//
//            docTag.setId(mydal.getId());
//
//            docTag.setTag(mydal.getTag());
//
//            drop.add(docTag);

        }

        return drop;
    }

}
