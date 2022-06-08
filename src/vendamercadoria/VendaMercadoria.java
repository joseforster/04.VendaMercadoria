package vendamercadoria;

import View.FrmLogin;
import View.FrmMenuPrincipal;
import java.sql.*;
import javax.swing.JOptionPane;

public class VendaMercadoria {
    
    public static void main(String[] args) {
        var login = new FrmLogin(new FrmMenuPrincipal(), true);
        
        login.setTitle("LOGIN");
        login.setVisible(true);
    }
}
