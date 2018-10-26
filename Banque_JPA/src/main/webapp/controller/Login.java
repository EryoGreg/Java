package main.webapp.controller;

import main.webapp.manager.ClientManager;
import main.webapp.model.Client;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"","/login"})
public class Login extends HttpServlet {

    Logger logger = LogManager.getLogger(Login.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher loginDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        if (login == null || login.length() == 0) {
            req.setAttribute("errorMsg", "Le champ login est obligatoire");
            loginDispatcher.forward(req, resp);
        } else if (password == null || password.length() == 0) {
            req.setAttribute("errorMsg", "Le champ password est obligatoire");
            loginDispatcher.forward(req, resp);
        } else {
            Client client = ClientManager.loadClientByLoginAndPassword(login, password);
            if (client == null ) {
                req.setAttribute("errorMsg","Aucun utilisateur connu avec ce mot de passe");
                loginDispatcher.forward(req, resp);
            } else {
                req.getSession().setAttribute("client", client);
                req.getSession().setMaxInactiveInterval(2*60);
                resp.sendRedirect(req.getContextPath() + "/compte");
            }
        }
    }
}