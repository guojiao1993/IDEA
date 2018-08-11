package RMITest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    public String getFormatedDateFromLong(long l) throws RemoteException;
}
