import main.webapp.manager.ClientManager;
import main.webapp.model.Client;
import org.junit.Before;
import org.junit.Test;
import junit.framework.*;

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
        assertEquals("Pessiot", cm.loadClientById(1).getNom());
    }




}
