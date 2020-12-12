<%-- 
    Document   : transaksi_content
    Created on : Dec 12, 2020, 12:29:25 PM
    Author     : Riett
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.sql.Date"%>
<%@page import="dao.object.Transaksi"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="content-area">
  <div class="box-content">
    <div class="box-content-head">
      <span class="head-text">Data Transaksi</span>
    </div>
    <div class="box-content-body">
      <table id="transaksi-table" class="table hover">
        <thead>
          <tr>
            <th>No</th>
            <th>Tanggal dan Waktu</th>
            <th>Total Harga</th>
            <th>Total Bayar</th>
            <th>Total Kembalian</th>
            <th>Opsi</th>
          </tr>
        </thead>
        <tbody>
          <%
            try {
                dao.TransaksiDAO transaksiDao = new dao.TransaksiDAO();
                List<Transaksi> listTransaksi = transaksiDao.getAll();
                
                int num = 0;
                
                if(listTransaksi.size() > 0) {
                  for(Transaksi transaksi : listTransaksi) {
                    out.print(
                        "<tr>"
                        + "<td>" + (++num) + "</td>"
                        + "<td>" + transaksi.getWaktu() + "</td>"
                        + "<td>" + NumberFormat.getCurrencyInstance(new Locale("in","ID")).format(transaksi.getTotal_harga()) + "</td>"
                        + "<td>" + NumberFormat.getCurrencyInstance(new Locale("in","ID")).format(transaksi.getTotal_bayar()) + "</td>"
                        + "<td>" + NumberFormat.getCurrencyInstance(new Locale("in","ID")).format(transaksi.getTotal_kembalian()) + "</td>"
                        + "<td>"
                          + "<span class='action-button touch-button alert-info'>Detail</span>"
                          + "<span class='action-button touch-button alert-danger'>Hapus</span>"
                        + "</td>"
                      + "</tr>"
                    );
                  }
                } else {
                  out.print(
                      "<tr>"
                      + "<td colspan='6' align='center'>" + "Data tidak tersedia" + "</td>"
                    + "</tr>"
                  );
                } 
            } catch(Exception e) {
                e.printStackTrace(new java.io.PrintWriter(out));
            }
          %>
        </tbody>
      </table>
    </div>
  </div>
</div>
