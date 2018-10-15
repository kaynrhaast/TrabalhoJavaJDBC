/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;
import java.util.logging.Logger;
import java.util.logging.Level;
/**
 *
 * @author caique
 */
public class ConnectionPSQL {
    
    private static final String url = "jdbc:postgresql://localhost:5433";
    private static final String user = "root";
    private static final String passwd = "root";
    
    public static Connection getConecction() throws SQLException, ClassNotFoundException{
      Connection conexao;
        try{
            conexao = DriverManager.getConnection(url, user, passwd);
            System.out.println("Conexao estabelecida");
            return conexao;           
        }
        catch(Exception e){
            throw new SQLException("Erro ao se conectar no banco de dados: " + e.getMessage());
        }    
    }
    
    public static void closeConnection(Connection conexao) throws SQLException{
        try{
            if(conexao != null){
                conexao.close();
                System.out.println("Conexao fechada");
            }
        }
        catch(Exception e){
            System.out.println("Nao foi possivel sair do banco de dados "+ e.getMessage());
        }
    }
    
    public static void closeConnection(Connection conexao,PreparedStatement stm) throws SQLException{
        try{
            if(conexao != null){
                closeConnection(conexao);
            }
            if(stm != null){
                stm.close();
                System.out.println("Statement fechado");
            }
        }
        catch(Exception e){
            System.out.println("Nao foi possivel fechar o statement "+ e.getMessage());
        }
    }
    
        public static void closeConnection(Connection conexao,PreparedStatement stm, ResultSet rs) throws SQLException{
        try{
            if(conexao != null || stm != null){
                closeConnection(conexao, stm);
            }
            if(rs != null){
                rs.close();
                System.out.println("ResultSet fechado com sucesso");
            }
        }
        catch(Exception e){
            System.out.println("Nao foi possivel fechar o resultset "+ e.getMessage());
        }
    }
}
    

