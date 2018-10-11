package App;

import Connecteur.ClientManager;
import Models.Utilisateur;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class App {

    public static void main(String[] args) {
        //CREATE USER
        Date date_of_birth = new GregorianCalendar(1998, Calendar.JANUARY,4).getTime();
        Utilisateur user = new Utilisateur("pes","greg","test","toto","tata",date_of_birth,"test ", "test");

        //END CRETE USER
        ClientManager cm = new ClientManager();
        cm.CreateUser(user);


        /*
        ClientManager cm = new ClientManager();
        cm.CheckUser(user);
         */

    }
}