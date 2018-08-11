package RMITest;

import java.io.IOException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.RMISocketFactory;

public class ServerMain {
    public static void main(String[] args) throws IOException, AlreadyBoundException {
        System.out.println("Server starting");
        System.setProperty("java.rmi.server.hostname", "139.199.129.174");
        LocateRegistry.createRegistry(1099);
        RMISocketFactory.setSocketFactory (new MyRMISocket());
        Naming.bind("server", new ServerImpl());
        System.out.println("Server started");
    }
}
