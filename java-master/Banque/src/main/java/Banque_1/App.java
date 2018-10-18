package Banque_1;

import Connecteurs.ClientManager;
import model.Utilisateur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Date date = new GregorianCalendar(1997, Calendar.JUNE, 26).getTime();
        Utilisateur user = new Utilisateur(1,"Poussard","Antoine","test","apoussard","12345","phone",date,"test");
        ClientManager cm = new ClientManager();
        //cm.saveUser(user);
        ResultSet rs = cm.getDBUser();
        try{
            while(rs.next()) {
                System.out.println(rs.getString("nom"));
            }
        } catch (SQLException sqle){
            System.out.println(sqle);
        }


    }
}
