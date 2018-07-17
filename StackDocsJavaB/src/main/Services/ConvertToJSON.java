package Services;

import com.google.gson.Gson;

public final class ConvertToJSON {
    public static String getJSON (Object ob) {
        return new Gson().toJson(ob);
    }
    private ConvertToJSON(){}
}
