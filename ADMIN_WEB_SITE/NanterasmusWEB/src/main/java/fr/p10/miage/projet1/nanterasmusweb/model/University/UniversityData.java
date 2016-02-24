/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.model.University;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author florian
 */
public class UniversityData {
    
    private String adresse;
    private Integer city;
    private Integer id;
    private String webSite;
    private Map<Integer,CategoryPage> categories;
    
    public UniversityData(Integer id, String adresse, Integer city, String webSite) {
        this.adresse = adresse;
        this.city = city;
        this.id = id;
        this.webSite = webSite;
        this.categories=new HashMap<Integer,CategoryPage>();
    }
    
    public void addCategory(CategoryPage cp){
        this.categories.put(cp.getId(),cp);
    }
    
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Integer getCity() {
        return city;
    }

    public void setCity(Integer city) {
        this.city = city;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Map<Integer, CategoryPage> getCategories() {
        return categories;
    }
    
}
