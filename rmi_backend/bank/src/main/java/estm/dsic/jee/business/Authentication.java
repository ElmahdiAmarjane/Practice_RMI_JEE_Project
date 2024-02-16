package estm.dsic.jee.business;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import estm.dsic.jee.Models.User;
import estm.dsic.jee.dal.UserDAO;

public class Authentication extends UnicastRemoteObject implements IAuthentication {

     protected Authentication() throws RemoteException {
        super();
        //TODO Auto-generated constructor stub
    }

    @Override
    public User isAutentication(String email , String password){            
          UserDAO userDAO = new UserDAO();
          return userDAO.getUserByEmail(email);
     }
    
}
