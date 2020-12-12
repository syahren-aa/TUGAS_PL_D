/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Koneksi.Koneksi;
import dao.object.Pengguna;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */

public class PenggunaDAO {
    
    public Pengguna login(String username, String password){
        Pengguna pengguna = null;
        try{    
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM tb_pengguna WHERE username=? && password=?";
            ResultSet rs;
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            int i = ps.executeUpdate();
            rs = ps.executeQuery();
            pengguna.setId(rs.getInt("id"));
            pengguna.setNama(rs.getString("nama"));
            pengguna.setUsername(rs.getString("username") );
            pengguna.setPassword(rs.getString("password"));
            pengguna.setRole(rs.getString("role"));
        }catch(SQLException e){
            System.err.println("read all error: "+e.getMessage());
        }
        return pengguna;
    }
    
    public List<Pengguna> getAll() {
        List<Pengguna> list = new ArrayList<Pengguna>();
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_pengguna");
            while (rs.next()) {
                Pengguna pengguna = new Pengguna();
                pengguna.setId(rs.getInt("id"));
                pengguna.setNama(rs.getString("nama"));
                pengguna.setUsername(rs.getString("username") );
                pengguna.setPassword(rs.getString("password"));
                pengguna.setRole(rs.getString("role"));
                list.add(pengguna);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read all error: "+ex.getMessage());
        }
       return list;
    } 
    
    public Pengguna getById(int id){
        Pengguna pengguna = null;
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_pengguna WHERE id = '"+id+"'");
            while (rs.next()) {
                pengguna.setId(rs.getInt("id"));
                pengguna.setNama(rs.getString("nama"));
                pengguna.setUsername(rs.getString("username") );
                pengguna.setPassword(rs.getString("password"));
                pengguna.setRole(rs.getString("role"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read one error: "+ex.getMessage());
        }
        return pengguna;
    }
    
    public int insertOne(int id, String nama, String username, String password, String role) {
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            String sql = "INSERT INTO tb_pengguna (id,nama,username,password, role) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nama);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, role);
            int i = ps.executeUpdate();
            st.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("insert error: "+ex.getMessage());
            return 0;
        }
    }
    public int deleteOne(int id) {
        try {
            Connection con = Koneksi();
            String sql = "DELETE FROM tb_pengguna WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
    public int updateOne(int id, String nama, String username, String password, String role) {
        try {
            Connection con = Koneksi();
            String sql = "UPDATE tb_pengguna SET nama=?, username=?, password=?, role=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(2, nama);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, role);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
}
