/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.ProductDao;
import org.coolstyles.model.Product;

/**
 *
 * @author User
 */
public class SearchServlet extends BaseServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = null;      
        if(request.getParameter("productName") == null){
            productList = productDao.all();            
        }
        else{
            String productName = request.getParameter("productName");
            productList = productDao.searchByName(productName);
        }
        
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }
}
