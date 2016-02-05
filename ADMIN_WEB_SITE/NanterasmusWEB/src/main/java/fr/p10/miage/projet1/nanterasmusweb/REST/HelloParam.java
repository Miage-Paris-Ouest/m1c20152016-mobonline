/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.REST;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author florian
 */
@WebService(serviceName = "HelloParam")
public class HelloParam {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    @Produces("application/xml")
    public String hello(@WebParam(name = "a") int a,@WebParam(name = "b") int b) {
        return "Hello "+a+"+"+b+ "="+(a+b)+"!";
    }
}
