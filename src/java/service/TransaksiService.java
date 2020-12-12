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

/**
 *
 * @author acer
 */
public class TransaksiService extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Date waktu = Date.valueOf(request.getParameter("waktu"));
        float total_harga = Float.parseFloat(request.getParameter("total_harga"));
        float total_bayar = Float.parseFloat(request.getParameter("total_bayar"));
        float total_kembalian = Float.parseFloat(request.getParameter("total_kembalian"));
        String resp="";
        if (request.getParameter("action").equals("insert")){
            int result = new dao.TransaksiDAO().insertOne(id, waktu, total_harga, total_bayar, total_kembalian);
            resp=(result>0)?"Berhasil Tambah Data":"Gagal Tambah Data";
        }
        else if (request.getParameter("action").equals("update")){
            int result = new dao.TransaksiDAO().updateOne(id, waktu, total_harga, total_bayar, total_kembalian);
            resp=(result>0)?"Berhasil Ubah Data":"Gagal Ubah Data";
        }
        else if (request.getParameter("action").equals("delete")){
            int result = new dao.TransaksiDAO().deleteOne(id);
            resp=(result>0)?"Berhasil Hapus Data":"Gagal Hapus Data";
        }        
        response.sendRedirect("index.jsp?res="+resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
