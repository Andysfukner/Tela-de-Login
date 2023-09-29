
package mapaprog2.dao;

import mapaprog2.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
    
    public void inserir(Usuario usuario){
        
        String cadastro = "insert into usuario(nome, login, senha, email) values (?,?,?,?)";
        PreparedStatement ps = null;
        
        try {
            ps=Conexao.getConexao().prepareStatement(cadastro);
            
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            
            ps.execute();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                ps.close();
            } catch (SQLException ex){
            }
        }
        
    }
    
    public Usuario buscarUsuarioLogin(String login, String senha){
        
        String acessaLogin = "SELECT id, nome, login, senha , email from usuario where binary login = ?  and binary senha = ?";
        PreparedStatement ps = null;
        ResultSet rs = null;

        
        
        try{
            ps = Conexao.getConexao().prepareStatement(acessaLogin);
            ps.setString(1, login);
            ps.setString(2, senha);
            
            rs = ps.executeQuery();
            
            
            
            if(rs.next()){
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setLogin(rs.getString("login"));
                u.setSenha(rs.getString("senha"));
                u.setEmail(rs.getString("email"));
                return u;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try{
                ps.close();
                rs.close();
            } catch (SQLException ex){
            }
    } 
}
}
