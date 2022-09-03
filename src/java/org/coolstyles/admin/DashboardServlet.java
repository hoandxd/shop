/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles.admin;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.OrderDao;
import org.coolstyles.dao.ProductDao;
import org.coolstyles.dao.UserDao;

/**
 *
 * @author Admin
 */
public class DashboardServlet extends AdminServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param req
     * @param resp
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        ProductDao productDao = DatabaseDao.getInstance().getProductDao();
        OrderDao orderDao = DatabaseDao.getInstance().getOrderDao();

        int countUser = userDao.countUser();
        int countProduct = productDao.countProduct();
        int countOrder = orderDao.countOrder();
        int countPendingOrder = orderDao.countPendingOrder();
//        int countShippingOrder = orderDao.countShippingOrder();
//        int countFinishedOrder = orderDao.countFinishedOrder();
//        int countCanceledOrder = orderDao.countCanceledOrder();

        req.setAttribute("countUser", countUser);
        req.setAttribute("countProduct", countProduct);
        req.setAttribute("countOrder", countOrder);
        req.setAttribute("countPendingOrder", countPendingOrder);
//        req.setAttribute("countFinishedOrder", countFinishedOrder);
//        req.setAttribute("countCanceledOrder", countCanceledOrder);ribute("countPendingOrder", countPendingOrder);
//        req.setAttribute("countShippingOrder", countShippingOrder);
//        req.setAttribute("countFinishedOrder", countFinishedOrder);
//        req.setAttribute("countCanceledOrder", countCanceledOrder);
        req.getRequestDispatcher("admin/index.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

}
