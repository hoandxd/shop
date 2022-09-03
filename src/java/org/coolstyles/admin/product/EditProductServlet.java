/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles.admin.product;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import org.coolstyles.BaseServlet;
import org.coolstyles.admin.AdminServlet;
import org.coolstyles.dao.CategoryDao;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.ProductDao;
import org.coolstyles.model.Category;
import org.coolstyles.model.Product;


/**
 *
 * @author User
 */
public class EditProductServlet extends AdminServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {  
        super.doGet(req, resp);
         CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        List<Category> categoryList = categoryDao.all();
        
        req.setAttribute("categoryList", categoryList);
      
        int productId = Integer.parseInt(req.getParameter("productId"));
        
        ProductDao ProductDao = DatabaseDao.getInstance().getProductDao();
        Product product = ProductDao.find(productId);
        
        req.setAttribute("product", product);
        req.getRequestDispatcher("admin/products/edit.jsp").include(req, resp);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param req servlet req
     * @param resp servlet resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException, NumberFormatException{
        super.doGet(req, resp);
        int productId = Integer.parseInt(req.getParameter("productId"));
          
        ProductDao ProductDao = DatabaseDao.getInstance().getProductDao();
        Product product = ProductDao.find(productId);
        
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        String desc = req.getParameter("desc");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        
        product.setName(name);
        product.setImg(img);
        product.setDesc(desc);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategoryId(categoryId);
        
        ProductDao.update(product);
        
        resp.sendRedirect("IndexProductServlet");
    }}
