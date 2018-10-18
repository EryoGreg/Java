import main.webapp.manager.ClientManager;
import main.webapp.model.Client;
import main.webapp.model.Compte;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;

import java.util.Date;


public class Test01 extends TestCase {

    @Before
    public void purgeTableBeforeTest(){
        ClientManager cm = new ClientManager();
        cm.purgeTable();
    }

    @Test
    public void test1SaveClient() throws Exception{
        Client cli = new Client();
        ClientManager cm = new ClientManager();
        boolean transaction_success = cm.saveClient(cli);
        assertEquals(true, transaction_success);
    }

    @Test
    public void test2LoadClient() throws Exception{
        ClientManager cm = new ClientManager();
        //assertEquals("Pessiot", cm.loadClientById(1).getNom());
    }

    @Test
    public void test3CreateClient(){
        Client client = new Client();
        Client client2 = new Client("test","test","test","test2","test","test",new Date(),"test");
        Compte cpt = new Compte("Compte courant");
        Compte cpt_destination = new Compte("Compte courant 2");
        cpt.addTransaction("Mcdo", 15, cpt_destination);
        cpt.addTransaction("Mcdo2", 17, cpt_destination);
        cpt.addTransaction("Mcdo3", 5, cpt_destination);
        cpt.addTransaction("Mcdo4", 14, cpt_destination);

        client.setComptes(cpt);
        client2.setComptes(cpt_destination);


        ClientManager cm = new ClientManager();
        cm.saveClient(client2);
        cm.saveClient(client);
    }
}
