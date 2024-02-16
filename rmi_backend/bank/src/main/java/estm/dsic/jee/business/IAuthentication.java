package estm.dsic.jee.business;

import java.rmi.Remote;

import estm.dsic.jee.Models.User;

public interface IAuthentication extends Remote{

      User isAutentication(String email , String password);
    
}