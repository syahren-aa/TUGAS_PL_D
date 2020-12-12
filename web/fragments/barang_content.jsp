<%-- 
    Document   : barang_content
    Created on : Dec 12, 2020, 12:29:13 PM
    Author     : Riett
--%>

<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="dao.object.Barang"%>
<%@page import="java.util.List"%>
<div class="content-area">
  <div class="add-circle-button d-flex justify-content-center align-items-center touch-button">
    <div class="vertical-box"></div>
    <div class="horizontal-box"></div>
  </div>
  <div class="box-content">
    <div class="box-content-head">
      <span class="head-text">Data Barang</span>
    </div>
    <div class="box-content-body">
      <table id="barang-table" class="table">
        <thead>
          <tr>
            <th>No</th>
            <th>Nama</th>
            <th>Harga</th>
            <th>Stok</th>
            <th>Opsi</th>
          </tr>
        </thead>
        <tbody>
          <%
            try {
                dao.BarangDAO barangDao = new dao.BarangDAO();
                List<Barang> listBarang = barangDao.getAll();
                
                int num = 0;
                
                if(listBarang.size() > 0) {
                  for(Barang barang : listBarang) {
                    out.print(
                        "<tr>"
                        + "<td>" + (++num) + "</td>"
                        + "<td>" + barang.getNama() + "</td>"
                        + "<td>" + NumberFormat.getCurrencyInstance(new Locale("in","ID")).format(barang.getHarga()) + "</td>"
                        + "<td>" + barang.getStok() + "</td>"
                        + "<td>"
                          + "<span class='action-button touch-button alert-warning'>Edit</span>"
                          + "<span class='action-button touch-button alert-danger'>Hapus</span>"
                        + "</td>"
                      + "</tr>"
                    );
                  }
                } else {
                  out.print(
                      "<tr>"
                      + "<td colspan='5' align='center'>" + "Data tidak tersedia" + "</td>"
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
