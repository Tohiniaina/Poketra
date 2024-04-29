<%-- 
    Document   : Index
    Created on : 12 déc. 2023, 15:48:21
    Author     : Tohy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Look"%>
<%@page import="java.util.List"%>
<% 
    List<Look> listLook = (List<Look>)request.getAttribute("listeLook"); 
%>
        <main role="main" class="main-content">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-8">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12">
                                    <form method="post" action="VoirListMatiere">
                                        <div class="form-group mb-3">
                                            <div class="form-group mb-3">
                                                <label for="look-select">Look</label>
                                                <select class="form-control" id="look-select" name="look">
                                                  <% for(Look look : listLook) { %>
                                                  <option value="<%=look.getIdLook() %>"><%=look.getNomLook() %></option>
                                                  <% } %>
                                                </select>
                                            </div>
                                        </div>
                                        <input class="btn btn-success" type="submit" value="Valider" name="btnValider" />
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>