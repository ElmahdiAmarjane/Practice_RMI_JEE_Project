package estm.dsic.jee;

import java.net.InetAddress;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.SQLException;

import estm.dsic.jee.business.IUserServices;
import estm.dsic.jee.business.ImplUserService;
import estm.dsic.jee.dal.DatabaseConnector;

public class Main {
    public static void main(String[] args)  {
    try {
        Connection con = DatabaseConnector.getConnection();
    } catch (Exception e) {
         System.out.println(e);
    }
        

        try {
            IUserServices userServices = new ImplUserService();
            Registry rmiRegistry = LocateRegistry.createRegistry(9090);
            IUserServices compute_ttc = new ImplUserService();
            rmiRegistry.bind("IUserServices", compute_ttc);

            System.out.println("Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}