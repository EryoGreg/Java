package main.webapp;

import main.webapp.manager.ClientManager;
import main.webapp.model.Client;

public class App {
    public static void main(String[] args) {
        ClientManager cm = new ClientManager();
        cm.purgeTable();
    }
}
