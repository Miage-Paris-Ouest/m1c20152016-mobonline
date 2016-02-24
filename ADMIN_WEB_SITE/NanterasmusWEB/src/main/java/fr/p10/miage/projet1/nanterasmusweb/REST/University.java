/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.REST;

import fr.p10.miage.projet1.nanterasmusweb.model.DB.QueryDB;
import fr.p10.miage.projet1.nanterasmusweb.model.University.CategoryPage;
import fr.p10.miage.projet1.nanterasmusweb.model.University.Page;
import fr.p10.miage.projet1.nanterasmusweb.model.University.UniversityData;
import fr.p10.miage.projet1.nanterasmusweb.model.person.Personne;
import fr.p10.miage.projet1.nanterasmusweb.model.util.Utility;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author florian
 */
@Path("university")
public class University {

    @Context
    private UriInfo context;
    
    protected static QueryDB database;

    /**
     * Creates a new instance of Login
     */
    public University() {
        database=new QueryDB();
    }
    
    @GET
    @Path("/pages/parents.json")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    public String getParentPages(@QueryParam("university") Integer universityId){
        Map<String, Object> datas=new HashMap<String,Object>();
        String response = "";
        UniversityData university=checkUniversity(universityId);
        if(university != null){
            
            /*datas.put("univ_id", university.getId());
            datas.put("univ_city", university.getCity());
            datas.put("univ_website", university.getWebSite());*/
            //datas.put("university", person.getUniversityId());
            try {
                database.getParentCategories(university);
                //System.out.println("category:"+university.getCategories());
                
                JSONArray jsonA = new JSONArray();
                for(Entry<Integer, CategoryPage> entry : university.getCategories().entrySet()) {
                    CategoryPage category = entry.getValue();
                    JSONObject cat = new JSONObject();
                    
                    cat.put("cat_id", category.getId());
                    cat.put("cat_name", category.getTitle());

                    jsonA.put(cat);
                }
                
                datas.put("categories", jsonA);
                    
                response = Utility.constructJSON(datas,true);
            } catch (Exception ex) {
                response = Utility.constructJSON(datas, false, "No pages found");
            }
        }else{
            response = Utility.constructJSON(datas, false, "Incorrect Id of university");
        }
        return response;        
    }
    
    @GET
    @Path("/pages/enfants.json")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    public String getChildrenPages(@QueryParam("university") Integer universityId,@QueryParam("cat_parent") Integer parentId){
        Map<String, Object> datas=new HashMap<String,Object>();
        String response = "";
        UniversityData university=checkUniversity(universityId);
        if(university != null && parentId != null){
            
            try {
                database.getChildrenCategories(university,parentId);
                
                JSONArray jsonA = new JSONArray();
                for(Entry<Integer, CategoryPage> entry : university.getCategories().entrySet()) {
                    CategoryPage category = entry.getValue();
                    JSONObject cat = new JSONObject();
                    
                    cat.put("cat_id", category.getId());
                    cat.put("cat_name", category.getTitle());
                    
                    JSONArray jsonA2 = new JSONArray();
                    for(Entry<Integer, Page> entryPage : category.getPages().entrySet()) {
                        Page page = entryPage.getValue();
                        JSONObject pageJson = new JSONObject();
                        pageJson.put("page_id", page.getId());
                        pageJson.put("page_title", page.getTitle());
                        pageJson.put("page_content", page.getContent());
                        jsonA2.put(pageJson);
                    }
                    cat.put("pages", jsonA2);
                    jsonA.put(cat);
                }
                datas.put("categories", jsonA);
                    
                response = Utility.constructJSON(datas,true);
            } catch (Exception ex) {
                response = Utility.constructJSON(datas, false, "No pages found");
            }
        }else{
            response = Utility.constructJSON(datas, false, "Incorrect Id of university or incorrect Parent Cat id");
        }
        return response;        
    }
    
    /**
     * Method to check whether the entered credential is valid
     * 
     * @param uname
     * @param pwd
     * @return
     */
    private UniversityData checkUniversity(Integer universityId){
        UniversityData university=null;
        if(Utility.isNotNull(universityId)){
            try {
                university = database.CheckUniversity(universityId);
            } catch (Exception e) {
                university=null;
            }
        }
        return university;
    }
}
