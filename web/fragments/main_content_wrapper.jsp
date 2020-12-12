<%-- 
    Document   : main_content
    Created on : Dec 12, 2020, 11:05:37 AM
    Author     : Riett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="main-content-wrapper" clss="d-flex flex-column">
  <div class="head-main-content">
    <div class="user-section d-flex align-items-center">
      <div class="user-name">
        <span class="name-text">Budi Arman  - Kasir</span>
      </div>
    </div>
  </div>
  <div class="body-main-content">
    <% if(request.getServletPath().equals("/index.jsp")) { %>
    <%@include file="beranda_content.jsp" %>
    <% } else if(request.getServletPath().equals("/barang.jsp")) { %>
    <%@include file="barang_content.jsp" %>
    <% } else if(request.getServletPath().equals("/transaksi.jsp")) { %>
    <%@include file="transaksi_content.jsp" %>
    <% } else if(request.getServletPath().equals("/riwayat_trenseksi.jsp")) { %>
    <%@include file="riwayat_transaksi_content.jsp" %>
    <% } else if(request.getServletPath().equals("/pengguna.jsp")) { %>
    <%@include file="pengguna_content.jsp" %>
    <% } %>
  </div>
</div>
