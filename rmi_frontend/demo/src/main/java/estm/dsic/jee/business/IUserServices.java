package estm.dsic.jee.business;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IUserServices extends Remote{

     double compute (double amount , double tva) throws RemoteException;
     
     
}  