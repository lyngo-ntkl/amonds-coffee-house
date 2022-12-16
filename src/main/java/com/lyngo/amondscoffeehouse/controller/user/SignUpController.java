package com.lyngo.amondscoffeehouse.controller.user;

import com.lyngo.amondscoffeehouse.dao.AccountDAO;
import com.lyngo.amondscoffeehouse.dto.Account;
import com.lyngo.amondscoffeehouse.utils.EncryptionUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SignUpController", value = "/SignUpController")
public class SignUpController extends HttpServlet {
    private static final String ERROR = "registrationPage.jsp";
    private static final String SUCCESS = "loginPage.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            String email = request.getParameter("email");
            String password = EncryptionUtils.encrypt(request.getParameter("password"));
            String username = request.getParameter("username");
            String phone = request.getParameter("phone");
            String roleId = Account.ROLEID_USER;
            boolean status = true;
            Account account = new Account(email, password, username, roleId, phone, status);
            AccountDAO accountDAO = new AccountDAO();
            if(accountDAO.insertAccount(account)){
                url = SUCCESS;
            } else {
                request.setAttribute("ERROR", "Duplicated email");
            }
        } catch (Exception e){
            log("Error at : " + e.toString());
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
