package fr.p10.miage.m1.myapplication.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by florian on 25/02/2016.
 */
public class CategoryPage {

    private Integer id;
    private String title;
    private CategoryPage parent;
    private Map<Integer,Page> pages;

    public CategoryPage(Integer id, String title, CategoryPage parent) {
        this.id = id;
        this.title = title;
        this.parent = parent;
        this.pages = new HashMap<Integer,Page>();
    }

    public void addPage(Page p){
        this.pages.put(p.getId(),p);
    }

    public CategoryPage(Integer id) {
        this.id = id;
        this.pages = new HashMap<Integer,Page>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CategoryPage getParent() {
        return parent;
    }

    public void setParent(CategoryPage parent) {
        this.parent = parent;
    }

    public Map<Integer, Page> getPages() {
        return pages;
    }

}