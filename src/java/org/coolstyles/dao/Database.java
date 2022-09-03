/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles.dao;

import org.coolstyles.impl.CategoryDaoImpl;
import org.coolstyles.impl.OrderDaoImpl;
import org.coolstyles.impl.OrderDetailDaoImpl;
import org.coolstyles.impl.ProductDaoImpl;
import org.coolstyles.impl.UserDaoImpl;

/**
 *
 * @author User
 */
public class Database extends DatabaseDao{

    @Override
    public UserDao getUserDao() {
        return new UserDaoImpl();
    }

    @Override
    public CategoryDao getCategoryDao() {
        return new CategoryDaoImpl();
    }

    @Override
    public ProductDao getProductDao() {
        return new ProductDaoImpl();
    }

    @Override
    public OrderDao getOrderDao() {
        return new OrderDaoImpl();
    }

    @Override
    public OrderDetailDao getOrderDetailDao() {
        return new OrderDetailDaoImpl();
    }
}
