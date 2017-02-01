package data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Util.Utils;
import model.Place;
import model.Weather;

/**
 * Created by Hytham on 1/30/2017.
 */

public class JSONWeatherParser {
    public static Weather getWeather (String data ){
        Weather weather = new Weather();

        //create json object from data

        try {
            JSONObject jsonObject = new JSONObject(data);

            Place place = new Place();
            JSONObject coordObj = Utils.getObject("coord" , jsonObject);
            place.setLat(Utils.getFloat("lat" , coordObj));
            place.setLon(Utils.getFloat("lon" , coordObj));


            //get the weather info
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.currentCondition.setWeatherId(Utils.getInt("id" , jsonWeather));
            weather.currentCondition.setDescription(Utils.getString("description" , jsonWeather));
            weather.currentCondition.setCondition(Utils.getString("main" , jsonWeather));
            weather.currentCondition.setIcon(Utils.getString("icon" ,jsonWeather));

            //get the Wind info
            JSONObject windObj = Utils.getObject("wind" , jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed" , windObj));
            weather.wind.setDeg(Utils.getFloat("deg" , windObj));

            //get clouds
            JSONObject cloudObj = Utils.getObject("clouds" , jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all", cloudObj));

            //get main
            JSONObject mainObj = Utils.getObject("main" , jsonObject);
            weather.currentCondition.setHumidity(Utils.getFloat("humidity" , mainObj));
            weather.currentCondition.setPressure(Utils.getFloat("pressure" , mainObj));
            weather.currentCondition.setMinTemp(Utils.getFloat("temp_min" , mainObj));
            weather.currentCondition.setMaxTemp(Utils.getFloat("temp_max" , mainObj));
            weather.currentCondition.setTemperature(Utils.getDouble("temp" , mainObj));




            //get the sys
            JSONObject sysObj = Utils.getObject("sys" , jsonObject);
            place.setCountry(Utils.getString("country" , sysObj));
            place.setLastUpdate(Utils.getInt("dt" , jsonObject));
            place.setSunrise(Utils.getInt("sunrise" ,sysObj));
            place.setSunset(Utils.getInt("sunset" , sysObj));
            place.setCity(Utils.getString("name" , jsonObject));
            weather.place = place;
            //get dt
          /*  JSONObject dtObj = Utils.getObject("dt" , jsonObject);
            place.setLastUpdate(Utils.getInt("dt" ,dtObj));*/
            return weather;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
