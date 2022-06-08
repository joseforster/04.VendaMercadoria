package vendamercadoria;

import View.FrmLogin;
import View.FrmMenuPrincipal;
import java.sql.*;
import javax.swing.JOptionPane;

public class VendaMercadoria {
    
    public static void main(String[] args) {
        new FrmLogin(new FrmMenuPrincipal(), true).setVisible(true);
        
    }
}
