package main.webapp.controller;

import main.webapp.model.Client;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/transactions")
public class Transactions extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int value = Integer.valueOf(req.getParameter("id"));
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/transactions.jsp");
        Client currentClient = (Client)req.getSession().getAttribute("client");
        req.setAttribute("comptes", currentClient.getCompteByID(value));
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}