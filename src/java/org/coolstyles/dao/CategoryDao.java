/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles.dao;

import java.util.List;
import org.coolstyles.model.Category;

/**
 *
 * @author Category
 */
public interface CategoryDao  {
    public boolean insert(Category category);
    public boolean update(Category id);
    public boolean delete(int category);
    
    public List<Category> all();
    public Category find(int id);
    public Category findByName(String name);
}
