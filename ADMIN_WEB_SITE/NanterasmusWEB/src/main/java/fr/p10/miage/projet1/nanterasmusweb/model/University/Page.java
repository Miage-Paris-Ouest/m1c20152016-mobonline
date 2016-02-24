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
public class Page {
    
    private Integer id;
    private String title;
    private String content;
    private Map<String,String> meta;
    
    public Page(Integer id, String title) {
        this.id = id;
        this.title = title;
        meta = new HashMap<String,String>();
    }

    public Page(Integer id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        meta = new HashMap<String,String>();
    }

    public Page(Integer id, String title, String content, Map<String, String> meta) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.meta = meta;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Map<String, String> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, String> meta) {
        this.meta = meta;
    }

    public Integer getId() {
        return id;
    }
    
}
