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
  <div class="add-circle-button d-flex justify-content-center align-items-center touch-button" data-toggle="modal" data-target="#barang-modal">
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
                          + "<span class='action-button touch-button alert-warning' data-toggle='modal' data-target='#barang-modal'>Edit</span>"
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

<div class="modal fade" id="barang-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Data Barang</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="barang-form">
          <div class="form-group">
            <label for="barang__nama">Nama</label>
            <input type="text" id="barang__nama" class="form-control" />
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="barang__harga">Harga</label>
              <input type="text" id="barang__harga" class="form-control" />
            </div>
            <div class="form-group col-md-6">
              <label for="barang__stok">Stok</label>
              <input type="text" id="barang__stok" class="form-control" />
            </div>
          </div>
        </form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn-primary-custom touch-button">Simpan</button>
      </div>
    </div>
  </div>
</div>