package Connecteur;

import Models.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class ClientManager  extends BaseManager {

    public static void CreateUser(Utilisateur user){
        Connection conn = null;

        try{
            conn = getConnection();

            PreparedStatement ps = conn.prepareStatement("INSERT into Utilisateur (nom, prenom, email, login, password, " +
                    "date_of_birth, address, phone) " +
                    "values (?,?,?,?,?,?,?,?)");

            ps.setString(1, user.getNom());
            ps.setString(2, user.getPrenom());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getLogin());
            ps.setString(5, user.getPassword());
            ps.setDate(6, convertUtilToSql(user.getDate_of_birth()));
            ps.setString(7, user.getAddress());
            ps.setString(8, user.getPhone());

            int result = ps.executeUpdate();
            conn.close();

            System.out.println("saveClient return code: "+result);

        } catch(SQLException sqle){
            System.out.println(sqle);
        }
    }


    public static void CheckUser(){
        Connection conn = null;

        try{
            conn = getConnection();


            PreparedStatement ps = conn.prepareStatement("SELECT nom FROM Utilisateur");
            ResultSet result = ps.executeQuery();

            while (result.next()){
                String nom = result.getString("nom");
                System.out.println(nom + "\n");
            }

            conn.close();

            System.out.println("saveClient return code: "+result);

        } catch(SQLException sqle){
            System.out.println(sqle);
        }
    }






    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }

}
