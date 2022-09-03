/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles.admin.user;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.coolstyles.BaseServlet;
import org.coolstyles.admin.AdminServlet;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.UserDao;
import org.coolstyles.model.User;

/**
 *
 * @author User
 */
public class EditUserServlet extends AdminServlet {
  @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {        
        super.doGet(req, resp);
        int userId = Integer.parseInt(req.getParameter("userId"));
        
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);
        
        req.setAttribute("user", user);
        req.getRequestDispatcher("admin/users/edit.jsp").include(req, resp);
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
            throws ServletException, IOException {
        super.doGet(req, resp);
         int userId = Integer.parseInt(req.getParameter("userId"));
          
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User user = userDao.find(userId);
        
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        user.setEmail(email);
        user.setPassword(password);
        user.setRole(role);
        
        userDao.update(user);
        
        resp.sendRedirect("IndexUserServlet");
    }
}
