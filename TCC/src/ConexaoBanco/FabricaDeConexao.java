package ConexaoBanco;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaDeConexao {

    final static String usuario = "sql10169257";
    final static String senha = "8ZR1yXGEIi";
    final static String enderecoBanco = "sql10.freesqldatabase.com:3306/sql10169257";

//    final static String usuario = "u545438409_info";
//    final static String senha = "123456";
//    final static String enderecoBanco = "mysql.hostinger.com.br:3306/u545438409_info";
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://" + enderecoBanco, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String args[]) {
        FabricaDeConexao.getConnection();
    }
}
