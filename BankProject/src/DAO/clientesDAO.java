package DAO;

import Conexao.conexao;
import entity.clientes;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class clientesDAO {
    public void criarLogin(String nome, String senha, String cpf, String email){
        String sql = "INSERT INTO clientes (nome, senha, cpf, email) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;

        try{
        ps = conexao.getConexao().prepareStatement(sql);
        ps.setString(1, nome);
        ps.setString(2, senha);
        ps.setString(3, cpf);
        ps.setString(4, email);

        ps.executeUpdate();

        }catch(SQLException e){
            e.printStackTrace();
        }

    }
}
