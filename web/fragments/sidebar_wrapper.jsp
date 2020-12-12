<%-- 
    Document   : sidebar
    Created on : Dec 12, 2020, 11:05:25 AM
    Author     : Riett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="sidebar-wrapper" class="d-flex flex-column">
  <div class="head-sidebar d-flex justify-content-center align-items-center">
    <h3>E-TOKO</h3>
  </div>
  <div class="body-sidebar">
    <div class="sidebar-list">
      <ul>
        <% if(request.getServletPath().equals("/index.jsp")) { %>
        <li class="single-sidebar-list active">
        <% } else { %> 
        <li class="single-sidebar-list">
        <% } %>
          <a href="index.jsp">Beranda</a>
        </li>
        <% if(request.getServletPath().equals("/barang.jsp")) { %>
        <li class="single-sidebar-list active">
        <% } else { %> 
        <li class="single-sidebar-list">
        <% } %>
          <a href="barang.jsp">Barang</a>
        </li>
        <% if(request.getServletPath().equals("/transaksi.jsp")) { %>
        <li class="single-sidebar-list active">
        <% } else { %> 
        <li class="single-sidebar-list">
        <% } %>
          <a href="transaksi.jsp">Transaksi</a>
        </li>
        <% if(request.getServletPath().equals("/pengguna.jsp")) { %>
        <li class="single-sidebar-list active">
        <% } else { %> 
        <li class="single-sidebar-list">
        <% } %>
          <a href="pengguna.jsp">Pengguna</a>
        </li>
      </ul>
    </div>
    <div class="foot-sidebar">
      <button type="submit" class="logout-button">Logout</button>
    </div>
  </div>
</div>
