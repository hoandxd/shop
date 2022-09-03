/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import org.coolstyles.dao.Database;
import org.coolstyles.dao.DatabaseDao;

/**
 *
 * @author User
 */
public class BaseServlet extends HttpServlet{
    @Override
    public void init() throws ServletException{
        super.init();
            DatabaseDao.init(new Database());
    }
    
}
