package main.webapp.REST;

import main.webapp.manager.CompteManager;
import main.webapp.model.Compte;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/comptes")
public class RestSolde extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer id = Integer.parseInt(req.getParameter("id"));
        Compte compte = CompteManager.getCompteById(id);
        //String json = String.valueOf(compte.soldeToJson());

        resp.setContentType("application/json");
        //resp.getWriter().print(json);
        resp.getWriter().flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
