<%-- 
    Document   : beranda_content
    Created on : Dec 12, 2020, 12:28:58 PM
    Author     : Riett
--%>
<% 
    if(session.getAttribute("E_TOKO_NAMA") == null || session.getAttribute("E_TOKO_ROLE") == null) {
        response.sendRedirect("login.jsp");
    } else {
%>
<div class="greetings-box">
  <span class="greetings-text">Selamat Datang, <span class="user-name"><%= session.getAttribute("E_TOKO_NAMA") %></span></span>
</div>
<% } %>