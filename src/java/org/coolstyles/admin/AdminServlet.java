/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.coolstyles.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.coolstyles.BaseServlet;
import org.coolstyles.model.User;

/**
 *
 * @author Admin
 */
public class AdminServlet extends BaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkPermission(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        checkPermission(req, resp);
    }
     private void checkPermission(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        HttpSession session = req.getSession();
        
        if(session.getAttribute("user") != null){
            User findUser = (User) session.getAttribute("user");
            if(!findUser.getRole().equals("admin"))
                resp.sendRedirect("DashboardServlet");
        }else{
            req.getRequestDispatcher("LoginServlet").forward(req, resp);
        }
    }
}
