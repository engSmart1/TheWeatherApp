package Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Hytham on 1/30/2017.
 */

public class Utils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";
    public static final String ICON_URL = "http://openweathermap.org/img/w/{}";
    public static final String APPID_ID = "&appid=7c7564c826b8d38aa8f8b76a4e24dd8e";
    //&appid=7c7564c826b8d38aa8f8b76a4e24dd8e
    //http://openweathermap.org/img/w/10d.png

    public static JSONObject getObject(String tagName , JSONObject jsonObject) throws JSONException {
        JSONObject jOgj = jsonObject.getJSONObject(tagName);
        return jOgj;
    }
    public static String getString(String tagName , JSONObject jsonObject) throws JSONException{
        return jsonObject.getString(tagName);
    }
    public static float getFloat(String tagName , JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }
    public static double getDouble(String tagName , JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }
    public static int getInt(String tagName , JSONObject jsonObject) throws  JSONException{
        return jsonObject.getInt(tagName);
    }
}
