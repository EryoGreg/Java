package main.connecteur;

import main.maBanqueApp.Utilisateur;
import org.junit.jupiter.api.Test;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class ClientManagerTest extends ClientManager{
    @Test
    public final void testSave() {

        Date date_naissance = new Date(00-00-0000);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Pessiot");
        utilisateur.setPrenom("Gregoire");
        utilisateur.setEmail("gregoire.pessiot@gmail.com");
        utilisateur.setLogin("EryoGerg");
        utilisateur.setPassword("Passw0rd");
        utilisateur.setDate_of_birth(date_naissance);
        utilisateur.setAddress("74 Cours du Médoc");
        utilisateur.setPhone("0640988496");

        saveClient(utilisateur);


    }

    @Test
    public final void testLoad() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setNom("Pessiot");
        utilisateur.setPrenom("Gregoire");
        utilisateur.setLogin("EryoGreg");
        utilisateur.setId(4);

        assertEquals(utilisateur, loadClientById(4));

    }


    @Test
    public final void loadClientByLoginAndPassword(){
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setLogin("EryoGreg");
        utilisateur.setPassword("Passw0rd");

        assertEquals(utilisateur, loadClientByLoginAndPassword(utilisateur, void));
    }



}