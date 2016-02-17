/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.REST;

import fr.p10.miage.projet1.nanterasmusweb.model.DB.QueryDB;
import fr.p10.miage.projet1.nanterasmusweb.model.person.Personne;
import fr.p10.miage.projet1.nanterasmusweb.model.util.Utility;
import java.util.HashMap;
import java.util.Map;
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
@Path("user")
public class User {

    @Context
    private UriInfo context;
    
    protected static QueryDB database;

    /**
     * Creates a new instance of Login
     */
    public User() {
        database=new QueryDB();
    }
    
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/connect.json")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public String doLogin(@QueryParam("username") String uname, @QueryParam("password") String pwd){
        Map<String, Object> datas=new HashMap<String,Object>();
        String response = "";
        Personne person=checkCredentials(uname, pwd);
        if(person != null){
            datas.put("first_name", person.getPrenom());
            datas.put("last_name", person.getNom());
            datas.put("email", person.getEmail());
            
            response = Utility.constructJSON(datas,true);
        }else{
            response = Utility.constructJSON(datas, false, "Incorrect Login or Password");
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
    private Personne checkCredentials(String uname, String pwd){
        Personne person=null;
        if(Utility.isNotNull(uname) && Utility.isNotNull(pwd)){
            try {
                person = database.checkLogin(uname, pwd);
            } catch (Exception e) {
                person=null;
            }
        }
        return person;
    }

    /**
     * Retrieves representation of an instance of fr.p10.miage.projet1.nanterasmusweb.User
     * @return an instance of java.lang.String
     */
    @GET
    @Consumes("text/plain")
    @Produces("application/xml")
    public String getXml(@DefaultValue("2") @QueryParam("a") int a,@DefaultValue("2") @QueryParam("b")int b) {
        return "<note>\n"
                + "<a>"+a+"</a>\n"
                +"<b>"+b+"</b>\n"
                + "<c>"+(a+b)+"</c>\n"
                + "</note>";
    }

    /**
     * PUT method for updating or creating an instance of User
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
        System.out.println("PUT:"+content);
    }
}
