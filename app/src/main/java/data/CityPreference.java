package data;

import android.app.Activity;
import android.content.SharedPreferences;

/**
 * Created by Hytham on 2/1/2017.
 */

public class CityPreference {
    SharedPreferences prefs;
    public CityPreference(Activity activity){
        prefs = activity.getPreferences(Activity.MODE_PRIVATE);
    }
    public String getCity(){

        return prefs.getString("city" , "Cairo,Egypt");
    }
    public void setCity(String city){
        prefs.edit().putString("city" , city).apply();
    }
}
