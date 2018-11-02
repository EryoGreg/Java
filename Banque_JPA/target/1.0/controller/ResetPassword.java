package main.webapp.controller;

import main.webapp.model.Client;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static main.webapp.manager.ClientManager.updatePassword;


@WebServlet("/resetPassword")
public class ResetPassword extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/resetPassword.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/resetPassword.jsp");
        String oldPassword = req.getParameter("oldpassword");
        String newPassword = req.getParameter("newpassword");
        Client client = (Client) req.getSession().getAttribute("client");
        if (oldPassword.equals(client.getPassword()) && !newPassword.equals(client.getPassword()))  {
            updatePassword(client, newPassword);
            req.getSession().setAttribute("client", null);
            resp.sendRedirect(req.getContextPath() + "/login");
        }

        else if (oldPassword != client.getPassword() && !newPassword.equals(client.getPassword())){
            req.setAttribute("errorMsg", "Veuillez entrer l'ancien mot de passe");
            dispatcher.forward(req, resp);
        }
        else if (oldPassword.equals(client.getPassword()) && newPassword.equals(client.getPassword())){
            req.setAttribute("errorMsg", "Veuillez changer de mot de passe");
            dispatcher.forward(req, resp);
        }
        else if (oldPassword != client.getPassword()) {
            req.setAttribute("errorMsg", "Veuillez rentrer votre ancien mot de passe valide");
            dispatcher.forward(req, resp);
        }
        else if (oldPassword.equals(client.getPassword())) {
            req.setAttribute("errorMsg", "Veuillez changer de mot de passe 2");
            dispatcher.forward(req, resp);
        }

    }

}