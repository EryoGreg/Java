package main.webapp.controller;

import main.webapp.manager.CompteManager;
import main.webapp.model.Compte;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/solde")
public class Solde extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int value = Integer.valueOf(req.getParameter("id"));
        Compte compte = CompteManager.loadCompteById(value);
        String soldejson = "{" +
                "\"id\" : " + compte.getId() + ", " +
                "\"solde\" : " + compte.getSolde() + ", " +
                "}";
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.print(soldejson);
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }



}
