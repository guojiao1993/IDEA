package RMITest;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        System.out.println("Client start");
        String url = "rmi://139.199.129.174:1099/server";
        Server server = (Server) Naming.lookup(url);
        System.out.println(server.getFormatedDateFromLong(28800000));
        System.out.println("Client end");
    }
}
