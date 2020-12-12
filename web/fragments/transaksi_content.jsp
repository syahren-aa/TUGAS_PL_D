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
<% 
    if(session.getAttribute("E_TOKO_NAMA") == null || session.getAttribute("E_TOKO_ROLE") == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<div class="content-area">
  <div class="box-content">
    <div class="box-content-head">
      <span class="head-text">Data Transaksi</span>
    </div>
    <div class="box-content-body">
      <% if(session.getAttribute("E_TOKO_ROLE").equals("Kasir")) { %>
      <div class="add-circle-button d-flex justify-content-center align-items-center touch-button">
        <div class="vertical-box"></div>
        <div class="horizontal-box"></div>
      </div>
      <% } %>
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
                          + "<span class='action-button touch-button alert-info' data-toggle='modal' data-target='#detail-transaksi-modal'>Detail</span>"
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

<div class="modal fade" id="detail-transaksi-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Detail Transaksi</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="detail-transaksi-form">
          <div class="form-group">
            <label for="detail-transaksi__waktu">Waktu</label>
            <input type="text" id="detail-transaksi__waktu" class="form-control" />
          </div>
          <div class="form-row">
            <div class="form-group col-md-4">
              <label for="detail-transaksi__totalharga">Total harga</label>
              <input type="text" id="detail-transaksi__totalharga" class="form-control" />
            </div>
            <div class="form-group col-md-4">
              <label for="detail-transaksi__totalbayar">Total Bayar</label>
              <input type="text" id="detail-transaksi__totalbayar" class="form-control" />
            </div>
            <div class="form-group col-md-4">
              <label for="detail-transaksi__totalkembalian">Total Kembalian</label>
              <input type="text" id="detail-transaksi__totalkembalian" class="form-control" />
            </div>
          </div>
        </form>
        <table class="table">
          <thead>
            <tr>
              <th>No.</th>
              <th>Nama</th>
              <th>Jumlah</th>
              <th>Sub Total Harga</th>
            </tr>
          </thead>
          <tbody>
            <tr>
              <td>1.</td>
              <td>Beng-beng</td>
              <td>12</td>
              <td>Rp 12.500,00</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </div>
</div>
<% } %>