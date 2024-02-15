package estm.dsic;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;

import estm.dsic.jee.business.IUserServices;

public class Main {
    public static void main(String[] args)  {
        try {
         
            String url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+":9090/IUserServices";
         
            IUserServices test1 = (IUserServices) Naming.lookup(url) ;
        
            System.out.println( test1.compute(200, 0.2));
        } catch (Exception e) {
          
            System.err.println(e);
        }
    
    }
}