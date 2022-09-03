/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles.model;

import org.coolstyles.dao.DatabaseDao;

/**
 *
 * @author User
 */
public class User {
    private int id;
    private String email;
    private String password;
    private String role;
    
    public static User find(int id) {
        return DatabaseDao.getInstance().getUserDao().find(id);
    }
    
    public User(String email, String password, String role){
        this.email = email;
        this.password = password;
        this.role = role;
    }
      public User(int id,String email, String password ,String role){
        this.id= id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    
}
