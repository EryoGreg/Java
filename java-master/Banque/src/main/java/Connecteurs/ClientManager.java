package Connecteurs;

import model.Utilisateur;

import java.sql.*;

public class ClientManager extends BaseManager{
    public static void saveUser(Utilisateur user) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatement ps = conn.prepareStatement("INSERT INTO Utilisateur(id, nom, prenom, email, login, password, phone, date_of_birth, address)"
                    +"VALUES (?,?,?,?,?,?,?,?,?)");
            ps.setInt(1, user.getId());
            ps.setString(2, user.getNom());
            ps.setString(3, user.getPrenom());
            ps.setString(4, user.getEmail());
            ps.setString(5, user.getLogin());
            ps.setString(6, user.getPassword());
            ps.setString(7, user.getPhone());
            ps.setDate(8, convertUtilToSql(user.getDate_of_birth()));
            ps.setString(9, user.getAddress());

            int result = ps.executeUpdate();
            conn.close();

            System.out.println("saveClient return code" + result);

        } catch (SQLException sqle) {
            System.out.println(sqle);
        }
    }

    public static ResultSet getDBUser() {
        ResultSet res=null;
        // détecter si sql contient une table OU une requête SELECT...
        Statement stmt;
        String sql = "Select * from Utilisateur";
        try {
            Connection m_Con = getConnection();
            stmt = m_Con.createStatement();
            res=stmt.executeQuery(sql);
            m_Con.close();
        } catch (SQLException exc) {
            System.out.println(exc);
        }
        return res;

    }

    private static java.sql.Date convertUtilToSql(java.util.Date uDate) {
        java.sql.Date sDate = new java.sql.Date(uDate.getTime());
        return sDate;
    }
}
