<%-- 
    Document   : login
    Created on : Dec 12, 2020, 10:58:57 AM
    Author     : Riett
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <meta name="description" content="Toko Kasir - E-TOKO">
    <title>E-TOKO - Login</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="vendors/fontawesomes/css/all.min.css">
    <link rel="stylesheet" href="css/login.css">
  </head>
  <body>
    <div id="login-wrapper" th:fragment="login-wrapper">
      <form class="login-form" method="POST" th:action="@{/login}">
        <h3 class="title-form">E-TOKO</h3>
        <!-- <div class="form-group">
          <div th:if="${param.error}" class="alert alert-danger" role="alert">Username/Password tidak sesuai. Masukkan ulang.</div>
        </div> -->
        <div class="form-group">
          <input type="text" class="form-control" name="username" placeholder="Username" required />
        </div>
        <div class="form-group">
          <input type="password" class="form-control" name="password" placeholder="Password" required />
        </div>
        <button type="submit" class="submit-button btn-primary-custom">Login</button>
      </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script>
  </body>
</html>
