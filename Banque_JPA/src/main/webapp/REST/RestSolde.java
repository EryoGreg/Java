package main.webapp.REST;


import org.json.JSONException;
import org.json.JSONObject;
import main.webapp.manager.CompteManager;
import main.webapp.model.Compte;

import static main.webapp.manager.ClientManager.loadClientById;
import static main.webapp.manager.CompteManager.loadCompteById;
import static main.webapp.manager.CompteManager.loadComptes;
import static main.webapp.manager.CompteManager.saveCompte;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/comptes")
public class RestSolde extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String param = req.getParameter("id");

        if(param == null ) {
            ArrayList<JSONObject> finalJSON = new ArrayList<>();
            List<Object[]> listcomptes;
            listcomptes = loadComptes();
            for (Object[] compte : listcomptes) {
                JSONObject json = new JSONObject();
                try {
                    json.put("id", compte[0]);
                    json.put("date", compte[1]);
                    json.put("libelle", compte[2]);
                    json.put("solde", compte[3]);
                    json.put("owner", compte[4]);
                    finalJSON.add(json);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(finalJSON);
            out.flush();
        } else {
            int id = Integer.valueOf(param);
            Compte compte = loadCompteById(id);

            JSONObject json = new JSONObject();
            try {
                json.put("id", compte.getId());
                json.put("libelle", compte.getLibelle());
                json.put("solde", compte.getSolde());

            } catch (JSONException e) {
                e.printStackTrace();
            }

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(json);
            out.flush();
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.valueOf(req.getParameter("id"));

        CompteManager cm = new CompteManager();
        cm.deleteCompte(id);

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.print(true);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int client_id = Integer.valueOf(req.getParameter("id"));
        String libelle = req.getParameter("libelle");
        float solde = Float.valueOf(req.getParameter("solde"));

        Compte compte = new Compte(solde, libelle, loadClientById(client_id));
        saveCompte(compte);

        resp.setContentType("text/plain");
        PrintWriter out = resp.getWriter();
        out.print(true);
        out.flush();
    }
}
