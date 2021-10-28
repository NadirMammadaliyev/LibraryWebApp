package az.nadir.library.controller;

import az.nadir.library.dao.LoginUserDao;
import az.nadir.library.dao.impl.LoginUserDaoImpl;
import az.nadir.library.model.LoginUser;
import az.nadir.library.service.LoginUserService;
import az.nadir.library.service.impl.LoginUserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/ls")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String address = null;
        LoginUserDao loginUserDao = new LoginUserDaoImpl();
        LoginUserService loginUserService = new LoginUserServiceImpl(loginUserDao);

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
                LoginUser loginUser = loginUserService.login(username, password);
                if (loginUser != null) {
                    HttpSession session = request.getSession(true);
                    session.setAttribute("loginUser", loginUser);
                    address = "main.jsp";
                } else {
                    request.setAttribute("msg", "Username or password is invalid!");
                    address = "login.jsp";
                }
            } else {
                request.setAttribute("msg", "Username or password is empty!");
                address = "login.jsp";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher(address).forward(request, response);


    }
}
