package com.lyngo.amondscoffeehouse.controller.general;

import com.lyngo.amondscoffeehouse.dao.AccountDAO;
import com.lyngo.amondscoffeehouse.dao.IAccountDAO;
import com.lyngo.amondscoffeehouse.dto.Account;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginController", value = "/LoginController")
public class LoginController extends HttpServlet {

    private static final String ERROR = "loginPage.jsp";
    private static final String USER_PAGE = "index.jsp";
    private static final String ADMIN_PAGE = "adminIndex.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            IAccountDAO accountDAO = new AccountDAO();
            Account account = accountDAO.getAccount(email, password);
            if (account != null) {
                HttpSession session = request.getSession();
                session.setAttribute("USER", account);
                if(Account.ROLEID_ADMIN.equals(account.getRoleId())){
                    url = ADMIN_PAGE;
                } else {
                    url = USER_PAGE;
                }
            } else {
                request.setAttribute("ERROR", "Invalid email or password");
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.toString());
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
