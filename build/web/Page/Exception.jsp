<%-- 
    Document   : Exception.jsp
    Created on : 16 janv. 2024, 10:46:04
    Author     : Tohy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% String ex = request.getAttribute("exception").toString(); %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="favicon.ico">
    <title>Exception</title>
    <!-- Simple bar CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/simplebar.css">
    <!-- Fonts CSS -->
    <link href="https://fonts.googleapis.com/css2?family=Overpass:ital,wght@0,100;0,200;0,300;0,400;0,600;0,700;0,800;0,900;1,100;1,200;1,300;1,400;1,600;1,700;1,800;1,900&display=swap" rel="stylesheet">
    <!-- Icons CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/feather.css">
    <!-- Date Range Picker CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/daterangepicker.css">
    <!-- App CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/app-light.css">
  </head>
  <body class="light ">
    <div class="wrapper vh-100">
      <div class="align-items-center h-100 d-flex w-50 mx-auto">
        <div class="mx-auto text-center">
          <h1 class="display-1 m-0 font-weight-bolder text-muted" style="font-size:80px;">Exception</h1>
          <h1 class="mb-1 text-muted font-weight-bold">OOPS!</h1>
          <h4 class="mb-3 text-muted"><%=ex %></h4>
          <a href="AjoutFabrication" class="btn btn-lg btn-primary px-5">Back</a>
        </div>
      </div>
    </div>
  </body>
</html>
</body>
</html>