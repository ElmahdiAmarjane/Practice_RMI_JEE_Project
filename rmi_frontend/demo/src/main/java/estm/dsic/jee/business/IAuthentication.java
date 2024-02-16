package estm.dsic.jee.business;

import java.rmi.Remote;



public interface IAuthentication extends Remote{

      Object isAutentication(String email , String password);
    
}