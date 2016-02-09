package fr.p10.miage.projet1.nanterasmusweb.model.util;

import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class Utility {
    /**
     * Null check Method
     * 
     * @param txt
     * @return
     */
    public static boolean isNotNull(String txt) {
        return txt != null && txt.trim().length() >= 0 ? true : false;
    }
 
    /**
     * Method to construct JSON
     * 
     * @param data
     * @param status
     * @return
     */
    public static String constructJSON(Map<String,Object> data, boolean status) {
        JSONObject obj = new JSONObject();
        try {
            for (String mapKey : data.keySet()) {
                obj.put(mapKey, data.get(mapKey));
            }
            obj.put("status", new Boolean(status));
        } catch (JSONException e) {
            
        }
        return obj.toString();
    }
 
    /**
     * Method to construct JSON with Error Msg
     * 
     * @param data
     * @param status
     * @param err_msg
     * @return
     */
    public static String constructJSON(Map<String,Object> data, boolean status,String err_msg) {
        JSONObject obj = new JSONObject();
        try {
            for (String mapKey : data.keySet()) {
                obj.put(mapKey, data.get(mapKey));
            }
            obj.put("status", new Boolean(status));
            obj.put("error_msg", err_msg);
        } catch (JSONException e) {
            
        }
        return obj.toString();
    }
 
}
