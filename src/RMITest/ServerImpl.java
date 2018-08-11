package RMITest;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServerImpl extends UnicastRemoteObject implements Server {
    public ServerImpl() throws RemoteException {
    }

    @Override
    public String getFormatedDateFromLong(long l) {
        System.out.println("Server processing");
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(l));
    }
}
