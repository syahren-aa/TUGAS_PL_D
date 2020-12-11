/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.object;

public class Barang {
 private int id;
    private String nama;
    private float harga;
    private int stok;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public float getHarga() {
        return harga;
    }

    public void setHarga(float harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
   
    
    public Barang(){
        
    }
    
    public Barang(int id, String nama, float harga, int stok ){
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
           

    
   
}
    