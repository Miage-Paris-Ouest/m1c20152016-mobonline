/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.REST;

import fr.p10.miage.projet1.nanterasmusweb.model.DB.QueryDB;
import fr.p10.miage.projet1.nanterasmusweb.model.util.Utility;
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
@Path("login")
public class Login {

    @Context
    private UriInfo context;
    
    protected static QueryDB database;

    /**
     * Creates a new instance of Login
     */
    public Login() {
        database=new QueryDB();
    }
    
    @GET
    // Path: http://localhost/<appln-folder-name>/login/dologin
    @Path("/dologin")
    // Produces JSON as response
    @Produces(MediaType.APPLICATION_JSON) 
    // Query parameters are parameters: http://localhost/<appln-folder-name>/login/dologin?username=abc&password=xyz
    public String doLogin(@QueryParam("username") String uname, @QueryParam("password") String pwd){
        String response = "";
        if(checkCredentials(uname, pwd)){
            response = Utility.constructJSON("login",true);
        }else{
            response = Utility.constructJSON("login", false, "Incorrect Login or Password");
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
    private boolean checkCredentials(String uname, String pwd){
        System.out.println("Inside checkCredentials");
        boolean result = false;
        if(Utility.isNotNull(uname) && Utility.isNotNull(pwd)){
            try {
                result = database.checkLogin(uname, pwd);
            } catch (Exception e) {
                result = false;
            }
        }else{
            result = false;
        }
        
        return result;
    }

    /**
     * Retrieves representation of an instance of fr.p10.miage.projet1.nanterasmusweb.Login
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
     * PUT method for updating or creating an instance of Login
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
        System.out.println("PUT:"+content);
    }
}
