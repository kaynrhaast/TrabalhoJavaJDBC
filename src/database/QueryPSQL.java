/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author caique
 */
public class QueryPSQL extends ConnectionPSQL {

    public void InsertLivro(String titulo, String isbn, String editora, float preco) {

        String query = "INSERT INTO books (Title,ISBN,Publisher_Id,Price) VALUES (?,?,?,?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, titulo);
            pstm.setString(2, isbn);
            pstm.setString(3, editora);
            pstm.setFloat(4, preco);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertAutor(String id, String nome, String pnome) {

        String query = "INSERT INTO authors (Author_id,name,fname) VALUES (?,?,?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            pstm.setString(2, nome);
            pstm.setString(3, pnome);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void InsertEditora(String id, String nome, String url) {

        String query = "INSERT INTO publishers (publisher_id,name,url) VALUES (?,?,?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            pstm.setString(2, nome);
            pstm.setString(3, url);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateLivro(String titulo, String editora, float preco, String isbn) {

        String query = "UPDATE books SET Title = (?),Publisher_Id = (?),Price WHERE ISBN = (?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, titulo);
            pstm.setString(2, editora);
            pstm.setFloat(3, preco);
            pstm.setString(4, isbn);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateAutor(String nome, String pnome, String id) {

        String query = "UPDATE authors SET name = (?),fname = (?) WHERE Author_id = (?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, nome);
            pstm.setString(2, pnome);
            pstm.setString(3, id);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void UpdateEditora(String nome, String url, String id) {

        String query = "UPDATE publishers SET name = (?),url = (?) WHERE publisher_id = (?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, nome);
            pstm.setString(2, url);
            pstm.setString(3, id);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteLivro(String isbn) {

        String query = "DELETE FROM books WHERE isbn = (?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, isbn);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteAutor(String id) {

        String query = "DELETE FROM authors WHERE Author_id = (?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void DeleteEditora(String id) {

        String query = "DELETE FROM publishers WHERE Publisher_id = (?);";

        try {
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1, id);
            pstm.executeUpdate();
            closeConnection(con, pstm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SelectLivros(String titulo){
        
        String query = "SELECT * FROM books WHERE title = (?);";
        
        try{
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,"%"+titulo+"%");
            ResultSet rs = pstm.executeQuery();
            
        }catch(Exception e){
            e.printStackTrace();
        }    
    }

    public void SelectAutor(String nome){
        
        String query = "SELECT * FROM authors WHERE name = (?);";
        
        try{
            Connection con = getConecction();
            PreparedStatement pstm = con.prepareStatement(query);
            pstm.setString(1,"%"+nome+"%");
            ResultSet rs = pstm.executeQuery();
            
        }catch(Exception e){
            e.printStackTrace();
        }    
    }
    
}
