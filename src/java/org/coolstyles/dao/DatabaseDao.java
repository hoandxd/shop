/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles.dao;

/**
 *
 * @author User
 */
public abstract class DatabaseDao {
    private static DatabaseDao instance;
    
    public static void init(DatabaseDao inst){
    instance = inst;
}
    public static DatabaseDao getInstance(){
        return instance;
    }
    public abstract UserDao getUserDao();
    public abstract CategoryDao getCategoryDao();
    public abstract ProductDao getProductDao();
    public abstract OrderDao getOrderDao();
    public abstract OrderDetailDao getOrderDetailDao();
}
