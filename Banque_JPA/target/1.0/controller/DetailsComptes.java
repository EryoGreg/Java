package main.webapp.controller;

import main.webapp.manager.ClientManager;
import main.webapp.manager.CompteManager;
import main.webapp.model.Client;
import main.webapp.model.Compte;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet("/detailsCompte")
public class DetailsComptes extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/details_compte.jsp");
        Client client = (Client) request.getSession().getAttribute("client");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String compte_libelle = String.valueOf(request.getParameter("compte_libelle"));
        Client client = (Client) request.getSession().getAttribute("client");
        Compte compte = new Compte();
        compte.setSolde((float) 0);
        compte.setDate_creation(new Date());
        compte.setLibelle(compte_libelle);
        compte.setOwner(client);
        CompteManager.saveCompte(compte);
        Client client2 = ClientManager.loadClientById(client.getId());
        request.getSession().setAttribute("client", client2);
        request.getSession().setMaxInactiveInterval(2*60);
        response.sendRedirect("/login");
    }



}