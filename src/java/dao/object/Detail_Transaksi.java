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
    private int idTransaksi;
    private int idDetailTransaksi;
    private int idBarang;
    private int jumlah;
    private int harga;
    private int stok;
    private String nama;
    
    public int getIdTransaksi() {
        return this.idTransaksi;
    }
    
    public void setIdTransaksi(int id) {
        this.idTransaksi = id;
    }
    
    public int getIdDetailTransaksi() {
        return this.idDetailTransaksi;
    }
    
    public void setIdDetailTransaksi(int id) {
        this.idDetailTransaksi = id;
    }
    
    public int getIdBarang() {
        return this.idBarang;
    }
    
    public void setIdBarang(int id) {
        this.idBarang = id;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String n) {
        this.nama = n;
    }
    
    public int getHarga() {
        return this.harga;
    }
    
    public void setHarga(int h) {
        this.harga = h;
    }
    
    public int getJumlah() {
        return this.jumlah;
    }
    
    public void setJumlah(int j) {
        this.jumlah = j;
    }
    
    public int getStok() {
        return this.stok;
    }
    
    public void setStok(int s) {
        this.stok = s;
    }
}
