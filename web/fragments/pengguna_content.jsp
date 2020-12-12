<%-- 
    Document   : pengguna_content
    Created on : Dec 12, 2020, 7:19:58 PM
    Author     : Riett
--%>

<%@page import="dao.object.Pengguna"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    if(session.getAttribute("E_TOKO_NAMA") == null || session.getAttribute("E_TOKO_ROLE") == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<div class="content-area">
  <div class="add-circle-button d-flex justify-content-center align-items-center touch-button">
    <div class="vertical-box"></div>
    <div class="horizontal-box"></div>
  </div>
  <div class="box-content">
    <div class="box-content-head">
      <span class="head-text">Data Pengguna</span>
    </div>
    <div class="box-content-body">
      <div class="add-circle-button d-flex justify-content-center align-items-center touch-button" data-toggle="modal" data-target="#pengguna-modal">
        <div class="vertical-box"></div>
        <div class="horizontal-box"></div>
      </div>
      <table id="pengguna-table" class="table">
        <thead>
          <tr>
            <th>No</th>
            <th>Nama</th>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Opsi</th>
          </tr>
        </thead>
        <tbody>
          <%
            try {
                dao.PenggunaDAO penggunaDao = new dao.PenggunaDAO();
                List<Pengguna> listPengguna = penggunaDao.getAll();
                
                int num = 0;
                
                if(listPengguna.size() > 0) {
                  for(Pengguna pengguna : listPengguna) {
                    out.print(
                        "<tr>"
                        + "<td>" + (++num) + "</td>"
                        + "<td>" + pengguna.getNama() + "</td>"
                        + "<td>" + pengguna.getUsername() + "</td>"
                        + "<td>" + pengguna.getPassword() + "</td>"
                        + "<td>" + pengguna.getRole() + "</td>"
                        + "<td>"
                          + "<span class='action-button touch-button alert-warning' data-toggle='modal' data-target='#pengguna-modal'>Edit</span>"
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

<div class="modal fade" id="pengguna-modal" tabindex="-1" role="dialog" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Data Pengguna</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form id="pengguna-form" method="POST" action="pengguna">
          <div class="form-row">
            <input type="hidden" name="action" value="Simpan" />
            <div class="form-group col-md-6">
              <label for="pengguna__nama">Nama</label>
              <input type="text" id="pengguna__nama" name="nama" class="form-control" />
            </div>
            <div class="form-group col-md-6">
              <label for="pengguna__role">Role</label>
              <select class="form-control" name="role" id="pengguna__role">
                  <option value="Kasir">Admin</option>
                  <option value="Kasir">Kasir</option>
              </select>
            </div>
          </div>
          <div class="form-row">
            <div class="form-group col-md-6">
              <label for="pengguna__username">Username</label>
              <input type="text" id="pengguna__username" name="username" class="form-control" />
            </div>
            <div class="form-group col-md-6">
              <label for="pengguna__password">Password</label>
              <input type="text" id="pengguna__password" name="password" class="form-control" />
            </div>
          </div>
          <button type="submit" class="btn-primary-custom touch-button">Simpan</button>
        </form>
      </div>
    </div>
  </div>
</div>
<% } %>