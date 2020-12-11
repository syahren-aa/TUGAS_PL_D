/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.object;

/**
 *
 * @author acer
 */
public class Detail_Transaksi {
int id;
    int id_transaksi;
    int id_barang;
    int jumlah;
    float sub_total_harga;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_transaksi() {
        return id_transaksi;
    }

    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public float getSub_total_harga() {
        return sub_total_harga;
    }

    public void setSub_total_harga(float sub_total_harga) {
        this.sub_total_harga = sub_total_harga;
    }
    
}
