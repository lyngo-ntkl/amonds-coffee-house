package com.lyngo.amondscoffeehouse.filter;

import com.lyngo.amondscoffeehouse.dao.CategoryDAO;
import com.lyngo.amondscoffeehouse.dao.ICategoryDAO;
import com.lyngo.amondscoffeehouse.dao.IProductDAO;
import com.lyngo.amondscoffeehouse.dao.ProductDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebFilter(filterName = "ProductPageFilter", urlPatterns = "/productManagementPage.jsp, /index.jsp", dispatcherTypes = {DispatcherType.REQUEST,DispatcherType.FORWARD,})
public class LoadMenuFilter implements Filter {
    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        ServletContext context = request.getServletContext();
        if (context.getAttribute("CATEGORIES") == null) {
            ICategoryDAO categoryDAO = new CategoryDAO();
            context.setAttribute("CATEGORIES", categoryDAO.getCategories());
        }
        if (context.getAttribute("PRODUCTS") == null) {
            IProductDAO productDAO = new ProductDAO();
            context.setAttribute("PRODUCTS",productDAO.getProducts());
        }
        // Pass request back to the filter chain
        chain.doFilter(request, response);
    }
}
