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


@WebServlet("/compte")
public class RestSolde extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int value = Integer.valueOf(req.getParameter("id"));
        main.webapp.model.Compte compte = CompteManager.loadCompteById(value);
        String soldejson = "{" +
                "\"id\" : " + compte.getId() + ", " +
                "\"libelle\" : " + compte.getLibelle() +
                "\"solde\" : " + compte.getSolde() + ", " +
                "}";
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.print(soldejson);
        writer.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int value = Integer.valueOf(req.getParameter("id"));
        CompteManager cm = new CompteManager();
        cm.deleteCompte(value);

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.print(true);
        out.flush();
    }

}

package fr.ynov.m1.valleau_elien.bank_projectv2.rest;
        import fr.ynov.m1.valleau_elien.bank_projectv2.Managers.CompteManager;
        import fr.ynov.m1.valleau_elien.bank_projectv2.modele.Compte;

        import javax.servlet.ServletException;
        import javax.servlet.annotation.WebServlet;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;

//solde?id=7
@WebServlet("/solde")
public class RestSolde extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        Compte compte = CompteManager.getCompteById(id);
        String json = String.valueOf(compte.soldeToJson());

        resp.setContentType("application/json");
        resp.getWriter().print(json);
        resp.getWriter().flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}











//package fr.ynov.m1.valleau_elien.bank_projectv2.rest;
//
//import fr.ynov.m1.valleau_elien.bank_projectv2.Managers.CompteManager;
//import fr.ynov.m1.valleau_elien.bank_projectv2.modele.Compte;
//
//import javax.json.JsonObject;
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//
//@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
//@Path("/solde")
//public class RestSolde {
//    @GET
//    @Path("/{id}")
//    public JsonObject findSoldeById(@PathParam("id") Integer id){
//        Compte compte = CompteManager.getCompteById(id);
//        return compte != null ? compte.soldeToJson() : null;
//    }
//}
