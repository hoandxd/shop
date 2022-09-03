/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles.admin.order;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.coolstyles.BaseServlet;
import org.coolstyles.admin.AdminServlet;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.OrderDao;
import org.coolstyles.model.Order;

/**
 *
 * @author User
 */
public class EditOrderServlet extends AdminServlet {
@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);     
        int orderId = Integer.parseInt(req.getParameter("orderId"));
        
        OrderDao OrderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = OrderDao.find(orderId);
        
        req.setAttribute("order", order);
        req.getRequestDispatcher("admin/orders/edit.jsp").include(req, resp);
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
        int orderId = Integer.parseInt(req.getParameter("OrderId"));
          
        OrderDao OrderDao = DatabaseDao.getInstance().getOrderDao();
        Order order = OrderDao.find(orderId);
        
        String code = req.getParameter("code");
        String status = req.getParameter("status");
        
        order.setCode(code);
        order.setStatus(status);
        
        OrderDao.update(order);
        
        resp.sendRedirect("IndexOrderServlet");
    }
}
