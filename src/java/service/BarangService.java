/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author acer
 */
public class BarangService extends HttpServlet{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nama = request.getParameter("nama");
        float harga  = Float.parseFloat(request.getParameter("harga"));
        int stok = Integer.parseInt(request.getParameter("stok"));
        String resp="";
        if (request.getParameter("action").equals("insert")){
            int result = new dao.BarangDAO().insertOne(id, nama, harga, stok);
            resp=(result>0)?"Berhasil Tambah Data":"Gagal Tambah Data";
        }
        else if (request.getParameter("action").equals("update")){
            int result = new dao.BarangDAO().updateOne(id, nama, harga, stok);
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
