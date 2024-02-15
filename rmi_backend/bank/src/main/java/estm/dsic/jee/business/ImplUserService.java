package estm.dsic.jee.business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ImplUserService extends UnicastRemoteObject implements IUserServices{

    public ImplUserService() throws RemoteException {
        super();
       
    }

    @Override
    public double compute(double amount, double tva) throws RemoteException {
        System.out.println("compt methode appel");
       return (amount * (1+tva));
       
    }


    
    
}