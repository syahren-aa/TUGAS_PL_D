/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.object.Detail_Transaksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;

/**
 *
 * @author acer
 */
public class DetailTransaksiDAO {
    public List<Detail_Transaksi> getAll() {
        List<Detail_Transaksi> list = new ArrayList<Detail_Transaksi>();
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_detail_transaksi");
            while (rs.next()) {
                Detail_Transaksi detail = new Detail_Transaksi();
                detail.setId(rs.getInt("id"));
                detail.setId_barang(rs.getInt("id_barang"));
                detail.setId_transaksi(rs.getInt("id_transaksi") );
                detail.setSub_total_harga(rs.getFloat("stok"));
                list.add(detail);
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read all error: "+ex.getMessage());
        }
       return list;
    } 
    
    public Detail_Transaksi getById(int id){
        Detail_Transaksi detail = null;
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_detail_transaksi WHERE id = '"+id+"'");
            while (rs.next()) {
                detail = new Detail_Transaksi();
                detail.setId(rs.getInt("id"));
                detail.setId_barang(rs.getInt("id_transaksi"));
                detail.setId_transaksi(rs.getInt("id_barang"));
                detail.setJumlah(rs.getInt("jumlah"));
                detail.setSub_total_harga(rs.getFloat("sub_total_harga"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read one error: "+ex.getMessage());
        }
        return detail;
    }
    
    public int insertOne(int id, int id_transaksi, int id_barang, int jumlah, int sub_total_harga) {
        try {
            Connection con = Koneksi.getConnection();
            Statement st = con.createStatement();
            String sql = "INSERT INTO tb_detail_transaksi (id,id_transaksi,id_barang,jumlah, sub_total_harga) VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id_transaksi);
            ps.setInt(3, id_barang);
            ps.setInt(4, jumlah);
            ps.setFloat(5, sub_total_harga);
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
    public int updateOne(int id, int id_transaksi, int id_barang, int jumlah, int sub_total_harga) {
        try {
            Connection con = Koneksi.getConnection();
            String sql = "UPDATE tb_detail_transaksi SET id_transaksi=?, id_barang=?, jumlah=?, sub_total_harga where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_transaksi);
            ps.setInt(2, id_barang);
            ps.setInt(3, jumlah);
            ps.setFloat(4, sub_total_harga);
            ps.setInt(5, id);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
}
