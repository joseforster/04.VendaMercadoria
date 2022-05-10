package vendamercadoria;

import tela.*;
import java.sql.*;
import javax.swing.JOptionPane;

public class VendaMercadoria {

    static Connection conexao = null;
    
    public static void main(String[] args) {
        if(openConnection()){
            new FrmMenuPrincipal().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Erro ao conectar no Banco de Dados!");
        }
    }
    
    private static boolean openConnection(){
        try {
            String dbdriver = "org.postgresql.Driver";
            String dburl = "jdbc:postgresql://localhost:5432/univates";
            String dbuser = "postgres";
            String dbsenha = "postgres";

            // Carrega Driver do Banco de Dados
            Class.forName(dbdriver);

            conexao = DriverManager.getConnection(dburl, dbuser, dbsenha);

            return true;

        } catch (Exception e) {
            System.err.println("Erro ao tentar conectar: " + e);
            return false;
        }
    }
}
