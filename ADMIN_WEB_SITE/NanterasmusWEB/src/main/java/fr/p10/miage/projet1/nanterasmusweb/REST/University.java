/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.REST;

import fr.p10.miage.projet1.nanterasmusweb.model.DB.QueryDB;
import fr.p10.miage.projet1.nanterasmusweb.model.University.UniversityData;
import fr.p10.miage.projet1.nanterasmusweb.model.person.Personne;
import fr.p10.miage.projet1.nanterasmusweb.model.util.Utility;
import java.util.HashMap;
import java.util.Map;
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
    public String getPages(@QueryParam("university") Integer universityId){
        Map<String, Object> datas=new HashMap<String,Object>();
        String response = "";
        UniversityData university=checkUniversity(universityId);
        if(university != null){
            
            datas.put("univ_id", university.getId());
            datas.put("univ_city", university.getCity());
            datas.put("univ_website", university.getWebSite());
            //datas.put("university", person.getUniversityId());
            try {
                database.getParentCategories(university);
                
                response = Utility.constructJSON(datas,true);
            } catch (Exception ex) {
                response = Utility.constructJSON(datas, false, "No pages found");
            }
        }else{
            response = Utility.constructJSON(datas, false, "Incorrect Id of university");
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
