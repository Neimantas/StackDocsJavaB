package Services;

import Models.BL.DocTag;
import Models.BL.Example;
import Models.BL.Topic;
import Models.DAL.ExamplesDAL;
import Models.DAL.TopicsDAL;

import java.util.List;

public final class ObjectConverterToString {
    // 5 is the maximum number of fields
    private static final int maxNumOfFields = 5;

    public static String[][] objectListToString(List list) {
        String[][] arr = new String[list.size()][maxNumOfFields];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = objectToString(list.get(i));
        }
        return arr;
    }

    public static String[] objectToString(Object ob) {
        String[] arr = new String[maxNumOfFields];
        if (ob instanceof Topic) {
            Topic tp = (Topic) ob;
            arr[0] = String.valueOf(tp.id);
            arr[1] = tp.title;
        } else if (ob instanceof DocTag) {
            DocTag dt = (DocTag) ob;
            arr[0] = String.valueOf(dt.id);
            arr[1] = dt.tag;
        } else if (ob instanceof Example) {
            Example ex = (Example) ob;
            arr[0] = String.valueOf(ex.id);
            arr[1] = ex.bodyHTML;
        } else if (ob instanceof TopicsDAL) {
            TopicsDAL td = (TopicsDAL) ob;
            arr[0] = td.title;
            arr[1] = td.introductionHtml;
            arr[2] = td.syntaxHtml;
            arr[3] = td.parametersHtml;
            arr[4] = td.remarksHtml;
        } else if (ob instanceof ExamplesDAL) {
            ExamplesDAL ed = (ExamplesDAL) ob;
            arr[0] = ed.bodyHtml;
        } else {
            throw new IllegalArgumentException("Can only except Topic or DocTag objects.");
        }
        return arr;
    }

    private ObjectConverterToString(){}
}
