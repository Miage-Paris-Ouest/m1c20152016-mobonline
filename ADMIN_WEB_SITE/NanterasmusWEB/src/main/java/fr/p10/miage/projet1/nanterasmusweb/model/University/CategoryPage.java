/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.p10.miage.projet1.nanterasmusweb.model.University;

/**
 *
 * @author florian
 */
public class CategoryPage {
    
    private Integer id;
    private String title;
    private CategoryPage parent;
    
    public CategoryPage(Integer id, String title, CategoryPage parent) {
        this.id = id;
        this.title = title;
        this.parent = parent;
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
  
}
