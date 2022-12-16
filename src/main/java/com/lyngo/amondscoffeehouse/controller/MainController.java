package com.lyngo.amondscoffeehouse.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "MainController", value = "/MainController")
public class MainController extends HttpServlet {

    private static final String ERROR = "errorPage.html";
    private static final String LOGIN = "Login";
    private static final String LOGIN_CONTROLLER = "LoginController";
    private static final String LOGOUT = "Logout";
    private static final String LOGOUT_CONTROLLER = "LogoutController";
    private static final String SIGN_UP = "Sign up";
    private static final String SIGN_UP_CONTROLLER = "SignUpController";
    private static final String SEARCH_PRODUCT = "Search";
    private static final String SEARCH_PRODUCT_CONTROLLER = "SearchProductController";
    private static final String UPDATE_PRODUCT = "Update";
    private static final String UPDATE_PRODUCT_CONTROLLER = "UpdateProductController";
    private static final String REMOVE_PRODUCT = "Remove";
    private static final String REMOVE_PRODUCT_CONTROLLER = "RemoveProductController";


    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            switch (action){
                case LOGIN:
                    url = LOGIN_CONTROLLER;
                    break;
                case LOGOUT:
                    url = LOGOUT_CONTROLLER;
                    break;
                case SIGN_UP:
                    url = SIGN_UP_CONTROLLER;
                    break;
                case SEARCH_PRODUCT:
                    url = SEARCH_PRODUCT_CONTROLLER;
                    break;
                case UPDATE_PRODUCT:
                    url = UPDATE_PRODUCT_CONTROLLER;
                    break;
                case REMOVE_PRODUCT:
                    url = REMOVE_PRODUCT_CONTROLLER;
                    break;
            }
        } catch (Exception e){
            log("Error at MainController: " + e.toString());
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
