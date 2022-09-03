/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package org.coolstyles;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.coolstyles.dao.Database;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.dao.UserDao;
import org.coolstyles.model.User;
import org.coolstyles.util.Flash;

/**
 *
 * @author Admin
 */
public class RegisterServlet extends BaseServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Flash.init(request.getSession());
        request.setAttribute("error", Flash.getError());
        request.getRequestDispatcher("register.jsp").forward(request, response);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        UserDao userDao = DatabaseDao.getInstance().getUserDao();
        User findUser = userDao.findByEmail(email);
        if(findUser != null){
            Flash.init(request.getSession());
            Flash.pushError("Email is existed!");
            response.sendRedirect("RegisterServlet");
        }else{
            User user = new User(email, password, "user");
            userDao.insert(user);
            response.sendRedirect("LoginServlet");
        }
    }

}
