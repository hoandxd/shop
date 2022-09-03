/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles.dao;
import org.coolstyles.model.Product;

import java.util.List;

/**
 *
 * @author ProductDao
 */
public interface ProductDao  {
    public boolean insert(Product product);
    public boolean update(Product product);
    public boolean delete(int product);
    
    public List<Product> all();
    public Product find(int id);
    public ProductDao findByName(String name);
    public List<Product> findByCategoryId(int categoryId);
    public List<Product> searchByName(String productName);

    public int countProduct();
}
