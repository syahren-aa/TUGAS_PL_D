/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import static dao.Koneksi.Koneksi;
import dao.object.Detail_Transaksi;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Types;
import java.sql.PreparedStatement;

/**
 *
 * @author acer
 */
public class DetailTransaksiDAO {
    public Detail_Transaksi getAllByIdTransaksi(int id){
        Detail_Transaksi detail = null;
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM tb_detail_transaksi WHERE id = '"+id+"'");
            while (rs.next()) {
                detail = new Detail_Transaksi();
                detail.setIdTransaksi(rs.getInt("id_transaksi"));
                detail.setIdDetailTransaksi(rs.getInt("id_detail_transaksi"));
                detail.setIdBarang(rs.getInt("id_barang"));
                detail.setNama(rs.getString("nama"));
                detail.setJumlah(rs.getInt("jumlah"));
                detail.setHarga(rs.getInt("harga"));
                detail.setStok(rs.getInt("stok"));
            }
            rs.close();
        } catch (SQLException ex) {
            System.err.println("read one error: "+ex.getMessage());
        }
        return detail;
    }
    
    public int insertOne(int id_transaksi, int id_barang, int jumlah) {
        try {
            Connection con = Koneksi();
            Statement st = con.createStatement();
            String sql = "INSERT INTO tb_detail_transaksi (id, id_transaksi, id_barang, jumlah) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, Types.NULL);
            ps.setInt(2, id_transaksi);
            ps.setInt(3, id_barang);
            ps.setInt(4, jumlah);
            int i = ps.executeUpdate();
            st.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("insert error: "+ex.getMessage());
            return 0;
        }
    }
    
    public int updateOne(int id, int id_transaksi, int id_barang, int jumlah, float sub_total_harga) {
        try {
            Connection con = Koneksi();
            String sql = "UPDATE tb_detail_transaksi SET id_transaksi=?, id_barang=?, jumlah=? where id=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id_transaksi);
            ps.setInt(2, id_barang);
            ps.setInt(3, jumlah);
            ps.setInt(4, id);
            int i= ps.executeUpdate(); 
            ps.close();
            return i;
        } catch (SQLException ex) {
            System.err.println("delete error: "+ex.getMessage());
            return 0;
        }
    }
}
