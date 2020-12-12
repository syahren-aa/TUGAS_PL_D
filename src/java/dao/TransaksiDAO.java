/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Koneksi.Koneksi;
import dao.object.Transaksi;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author acer
 */
public class TransaksiDAO {
    public List<Transaksi> getAll() {
        List<Transaksi> list = new ArrayList<Transaksi>();
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_transaksi");
            while (rs.next()) {
                Transaksi transaksi = new Transaksi();
                transaksi.setId(rs.getInt("id"));
                transaksi.setWaktu(rs.getDate("waktu"));
                transaksi.setTotal_harga(rs.getFloat("total_harga") );
                transaksi.setTotal_bayar(rs.getFloat("total_bayar"));
                transaksi.setTotal_kembalian(rs.getFloat("total_kembalian"));
                list.add(transaksi);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read all error: "+ex.getMessage());
        }
       return list;
    } 
    
    public Transaksi getById(int id){
        Transaksi transaksi = null;
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_transaksi WHERE id = '"+id+"'");
            while (rs.next()) {
                transaksi = new Transaksi();
                transaksi.setId(rs.getInt("id"));
                transaksi.setWaktu(rs.getDate("waktu"));
                transaksi.setTotal_harga(rs.getFloat("total_harga"));
                transaksi.setTotal_bayar(rs.getFloat("total_bayar"));
                transaksi.setTotal_kembalian(rs.getFloat("total_kembalian"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read one error: "+ex.getMessage());
        }
        return transaksi;
    }
    
    public int insertOne(int id, Date waktu, float total_harga, float total_bayar, float total_kembalian) {
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            String sql = "INSERT INTO tb_barang (id,nama,harga,stok) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setDate(2, waktu);
            ps.setFloat(3, total_harga);
            ps.setFloat(4, total_bayar);
            ps.setFloat(5, total_kembalian);
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
            String sql = "DELETE FROM tb_transaksi WHERE id=?";
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
    public int updateOne(int id, Date waktu, float total_harga, float total_bayar, float total_kembalian) {
        try {
            Connection con = Koneksi();
            String sql = "UPDATE tb_transaksi SET waktu=?, total_harga=?, total_bayar=?, total_kembalian=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.setDate(2, waktu);
            ps.setFloat(3, total_harga);
            ps.setFloat(4, total_bayar);
            ps.setFloat(5, total_kembalian);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
}
