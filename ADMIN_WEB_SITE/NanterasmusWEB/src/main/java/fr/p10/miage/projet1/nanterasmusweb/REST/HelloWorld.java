/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.REST;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author florian
 */
@Path("helloworld")
public class HelloWorld {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelloWorld
     */
    public HelloWorld() {
    }

    /**
     * Retrieves representation of an instance of fr.p10.miage.projet1.nanterasmusweb.HelloWorld
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
     * PUT method for updating or creating an instance of HelloWorld
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
        System.out.println("PUT:"+content);
    }
}
