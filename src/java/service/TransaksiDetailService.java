/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author acer
 */
public class TransaksiDetailService extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int idTransaksi = Integer.parseInt(request.getParameter("id_transaksi"));
        int idBarang = Integer.parseInt(request.getParameter("id_barang"));
        int jumlah = Integer.parseInt(request.getParameter("jumlah"));
        float subTotalHarga = Float.parseFloat(request.getParameter("sub_total_harga"));
        String resp="";
        if (request.getParameter("action").equals("insert")){
            int result = new dao.DetailTransaksiDAO().insertOne(id, idTransaksi, idBarang, jumlah, subTotalHarga);
            resp=(result>0)?"Berhasil Tambah Data":"Gagal Tambah Data";
        }
        else if (request.getParameter("action").equals("update")){
            int result = new dao.DetailTransaksiDAO().updateOne(id, idTransaksi, idBarang, jumlah, subTotalHarga);
            resp=(result>0)?"Berhasil Ubah Data":"Gagal Ubah Data";
        }
        else if (request.getParameter("action").equals("delete")){
            int result = new dao.TransaksiDAO().deleteOne(id);
            resp=(result>0)?"Berhasil Hapus Data":"Gagal Hapus Data";
        }        
        response.sendRedirect("index.jsp?res="+resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
