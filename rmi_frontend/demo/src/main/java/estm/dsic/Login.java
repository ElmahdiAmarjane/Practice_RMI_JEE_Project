package estm.dsic;

import java.net.InetAddress;
import java.rmi.Naming;

import estm.dsic.jee.business.IAuthentication;
import estm.dsic.jee.business.IUserServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Login {
     @FXML
        private Button loginBtn;
     @FXML
        private  TextField emailInput;
     @FXML
        private  TextField passwordInput;
        
        public boolean userLogin(){
            try {
               
                String url = "rmi://"+InetAddress.getLocalHost().getHostAddress()+":9090/IAuthentication";
             
                IAuthentication user = (IAuthentication) Naming.lookup(url) ;
            
                System.out.println(user.isAutentication(emailInput.getText(), passwordInput.getText())); 
                
            } catch (Exception e) {
              
                System.err.println(e);
            }
            return true;
    
        }

        



}
