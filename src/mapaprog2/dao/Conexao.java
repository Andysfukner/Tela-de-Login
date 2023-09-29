
package mapaprog2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/mapa";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    
    public static Connection conn;
    
    public static Connection getConexao() {
        try {
            if(conn == null) {
                conn = DriverManager.getConnection(URL, USER, PASSWORD);
                return conn;
            } else {
                return conn;
            }
        } catch(SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao tentar se conectar ao Banco de Dados");
            return null;
        }
            
    }
}
