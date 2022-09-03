/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles.admin.orderetail;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.coolstyles.admin.AdminServlet;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.OrderDetailDao;

/**
 *
 * @author User
 */
public class DeleteOrderDetailServlet extends AdminServlet {
    @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
       
        int orderDetailId = Integer.parseInt(req.getParameter("orderDetailId"));
        OrderDetailDao orderDetailDao = DatabaseDao.getInstance().getOrderDetailDao();
        orderDetailDao.delete(orderDetailId);
        
        resp.sendRedirect("IndexOrderDetailServlet");
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
   protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
