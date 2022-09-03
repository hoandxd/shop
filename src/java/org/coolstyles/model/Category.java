/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles.model;

import java.util.List;
import org.coolstyles.dao.DatabaseDao;

/**
 *
 * @author User
 */
public class Category {
    private int id;
    private String name;
    private String desc;
    
        public static Category find(int id){
        return DatabaseDao.getInstance().getCategoryDao().find(id);
    }
    
    public static List<Category> all(){
        return DatabaseDao.getInstance().getCategoryDao().all();
    }

    
    public Category(String name, String desc){
        this.name = name;
        this.desc = desc;
    }
      public Category(int id,String name, String desc){
        this.id= id;
        this.name = name;
        this.desc = desc;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
}
