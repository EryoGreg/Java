package main.webapp.controller;

import main.webapp.manager.CompteManager;
import main.webapp.model.Client;
import main.webapp.model.Compte;
import main.webapp.model.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

import static main.webapp.manager.BaseManager.*;
import static main.webapp.manager.ClientManager.loadClientById;
import static main.webapp.manager.CompteManager.loadCompteById;
import static main.webapp.manager.CompteManager.updateAccountAmount;
import static main.webapp.manager.TransactionManager.saveTransaction;

@WebServlet("/secu/maketransactions")
public class MakeTransactions extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/makeTransactions.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int accountFrom = Integer.valueOf(req.getParameter("from"));
        int accountTo = Integer.valueOf(req.getParameter("to"));
        float amount = Float.valueOf(req.getParameter("amount"));
        String libelle = req.getParameter("libelle");

        Compte compteFrom = loadCompteById(accountFrom);
        Compte compteTo = loadCompteById(accountTo);
        Transaction transaction = new Transaction(libelle, amount, compteFrom, compteTo);

        updateAccountAmount(compteFrom, (-1 * amount));
        updateAccountAmount(compteTo, amount);

        saveTransaction(transaction);

        Client tmpClient = (Client)req.getSession().getAttribute("client");
        Client newClient = loadClientById(tmpClient.getId());
        req.getSession().setAttribute("client", newClient);

        resp.sendRedirect(req.getContextPath() + "/secu/comptes");

    }
}
