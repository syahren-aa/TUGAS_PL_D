/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.object.Barang;
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
public class BarangDAO {
    public List<Barang> getAll() {
        List<Barang> list = new ArrayList<Barang>();
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_barang");
            while (rs.next()) {
                Barang barang = new Barang();
                barang.setId(rs.getInt("id"));
                barang.setNama(rs.getString("nama"));
                barang.setHarga(rs.getFloat("harga") );
                barang.setStok(rs.getInt("stok"));
                list.add(barang);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read all error: "+ex.getMessage());
        }
       return list;
    } 
    
    public Barang getById(int id){
        Barang barang = null;
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_barang WHERE id = '"+id+"'");
            while (rs.next()) {
                barang = new Barang();
                barang.setId(rs.getInt("id"));
                barang.setNama(rs.getString("nama"));
                barang.setHarga(rs.getFloat("harga"));
                barang.setStok(rs.getInt("stok"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read one error: "+ex.getMessage());
        }
        return barang;
    }
    
    public int insertOne(int id, String nama, float harga, int stok) {
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO tb_barang (id,nama,harga,stok) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, nama);
            ps.setFloat(3, harga);
            ps.setInt(4, stok);
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
            Connection con = Koneksi.getConnection();
            String sql = "DELETE FROM tb_barang WHERE id=?";
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
    public int updateOne(int id, String nama, float harga, int stok) {
        try {
            Connection con = Koneksi.getConnection();
            String sql = "UPDATE barang SET nama=?, harga=?, stok=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1,nama);
            ps.setFloat(2,harga);
            ps.setInt(3, stok);
            ps.setInt(4,id);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
}
