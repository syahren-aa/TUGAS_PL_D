/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.object;

import java.util.Date;
/**
 *
 * @author acer
 */
public class Transaksi {
   int id;
   String waktu;
   float total_harga;
   float total_bayar;
   float total_kembalian;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public float getTotal_harga() {
        return total_harga;
    }

    public void setTotal_harga(float total_harga) {
        this.total_harga = total_harga;
    }

    public float getTotal_bayar() {
        return total_bayar;
    }

    public void setTotal_bayar(float total_bayar) {
        this.total_bayar = total_bayar;
    }

    public float getTotal_kembalian() {
        return total_kembalian;
    }

    public void setTotal_kembalian(float total_kembalian) {
        this.total_kembalian = total_kembalian;
    }

   
   public Transaksi(){
        
   }
    
    
    
    
}
