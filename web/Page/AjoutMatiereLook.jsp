<%-- 
    Document   : AjoutMatiereLook
    Created on : 12 déc. 2023, 16:48:35
    Author     : Tohy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Matiere"%>
<%@page import="Model.Look"%>
<%@page import="java.util.List"%>
<% 
    List<Look> listLook = (List<Look>)request.getAttribute("listeLook"); 
    List<Matiere> listMatiere = (List<Matiere>)request.getAttribute("listeMatiere"); 
%>
        <main role="main" class="main-content">
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-8">
                <h2 class="page-title">Ajout Matiere Look</h2>
                <div class="card shadow mb-4">
                    <div class="card-header">
                        <strong class="card-title">Matiere Look</strong>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form method="post" action="AddMatiereLook">
                                    <div class="form-group mb-3">
                                        <div class="form-group mb-3">
                                            <label for="look-select">Look</label>
                                            <select class="form-control" id="look-select" name="look">
                                              <% for(Look look : listLook) { %>
                                              <option value="<%=look.getIdLook() %>"><%=look.getNomLook() %></option>
                                              <% } %>
                                            </select>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="matiere-select">Matiere</label>
                                            <select class="form-control" id="matiere-select" name="matiere">
                                                <% for(Matiere matiere : listMatiere) { %>
                                                <option value="<%=matiere.getIdMatiere() %>"><%=matiere.getNom() %></option>
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
            </div>
        </main>