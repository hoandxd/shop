package org.coolstyles.admin.category;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.coolstyles.admin.AdminServlet;
import org.coolstyles.dao.CategoryDao;
import org.coolstyles.dao.DatabaseDao;
import org.coolstyles.model.Category;

/**
 *
 * @author Admin
 */
public class CreateCategoryServlet extends AdminServlet {

    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        
         req.getRequestDispatcher("admin/categories/create.jsp").include(req, resp);
    }

    
    @Override
     protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
        
        String name = req.getParameter("name");
        String desc = req.getParameter("description");
        
        Category category = new Category(name, desc);
        
        CategoryDao categoryDao = DatabaseDao.getInstance().getCategoryDao();
        categoryDao.insert(category);
        
        resp.sendRedirect("IndexCategoryServlet");
    }

}
