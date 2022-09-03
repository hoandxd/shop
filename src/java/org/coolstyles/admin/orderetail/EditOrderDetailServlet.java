/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles.admin.orderetail;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import org.coolstyles.BaseServlet;
import org.coolstyles.admin.AdminServlet;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.OrderDao;
import org.coolstyles.dao.OrderDetailDao;
import org.coolstyles.dao.ProductDao;
import org.coolstyles.model.Order;
import org.coolstyles.model.OrderDetail;
import org.coolstyles.model.Product;

/**
 *
 * @author User
 */
public class EditOrderDetailServlet extends AdminServlet {
@Override
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        List<Product> productList = productDao.all();
        
        req.setAttribute("productList", productList);
        
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();
        List<Order> orderList = orderDao.all();
        
        req.setAttribute("orderList", orderList);
      
        int orderDetailId = Integer.parseInt(req.getParameter("orderDetailId"));
        
        OrderDetailDao OrderDetailDao = DatabaseDao.getInstance().getOrderDetailDao();
        OrderDetail orderDetail = OrderDetailDao.find(orderDetailId);
        
        req.setAttribute("orderDetail", orderDetail);
        req.getRequestDispatcher("admin/ordersDetails/edit.jsp").include(req, resp);
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
    
        int orderDetailId = Integer.parseInt(req.getParameter("OrderDetailId"));
          
        OrderDetailDao OrderDetailDao = DatabaseDao.getInstance().getOrderDetailDao();
        OrderDetail orderDetail = OrderDetailDao.find(orderDetailId);
        
        int quantity = Integer.parseInt("quantity");
        int productId = Integer.parseInt("productId");
        int orderId = Integer.parseInt("orderId");
        
        orderDetail.setQuantity(quantity);
        orderDetail.setProductId(productId);
        orderDetail.setOrderId(orderId);
        
        OrderDetailDao.update(orderDetail);
        
        resp.sendRedirect("IndexOrderDetailServlet");
    }
}
