package com.lyngo.amondscoffeehouse.controller.general;

import com.lyngo.amondscoffeehouse.dao.IProductDAO;
import com.lyngo.amondscoffeehouse.dao.ProductDAO;
import com.lyngo.amondscoffeehouse.dto.Account;
import com.lyngo.amondscoffeehouse.dto.Product;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchProductController", value = "/SearchProductController")
public class SearchProductController extends HttpServlet {
    private static final String ERROR = "errorPage.html";
    private static final String ADMIN_PAGE = "productManagementPage.jsp";
    private static final String USER_PAGE = "index.jsp";
    private static final String UNAUTHORIZED_USER_PAGE = "index.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            String searchKey = request.getParameter("key");
            String type = request.getParameter("type");
            IProductDAO productDAO = new ProductDAO();
            List<Product> product = productDAO.searchProducts(searchKey, type);
            if(product != null){
                request.setAttribute("PRODUCTS",product);
                HttpSession session = request.getSession();
                Account account = (Account)session.getAttribute("USER");
                if(account == null){
                    url = UNAUTHORIZED_USER_PAGE;
                } else if(Account.ROLEID_ADMIN.equals(account.getRoleId())){
                    url = ADMIN_PAGE;
                } else {
                    url = USER_PAGE;
                }
            }
        } catch (Exception e){
            log("Error at SearchProductController: " + e.toString());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
