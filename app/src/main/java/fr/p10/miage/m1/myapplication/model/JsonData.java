package fr.p10.miage.m1.myapplication.model;

import org.json.*;


/**
 * Created by adrie_000 on 18/02/2016.
 */
public class JsonData {
    private String url;

    public JsonData(String url){
        this.url=url;
    }

    public JSONObject dataList() throws Exception {

        String page = new Communicator().executeHttpGet(url);
        JSONArray jsonArray = new JSONArray(page);
        JSONObject entry = null;
        for (int i = 0 ; i < jsonArray.length(); i++ ) {
            entry = (JSONObject) jsonArray.get(i);
            // now get the data from each entry
        }


        return entry;

    }

}
