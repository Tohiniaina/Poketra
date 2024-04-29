<%-- 
    Document   : AjoutPrixMatiere
    Created on : 9 janv. 2024, 14:35:20
    Author     : Tohy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Matiere"%>
<%@page import="java.util.List"%>
<% 
    List<Matiere> listMatiere = (List<Matiere>)request.getAttribute("listeMatiere"); 
%>
        <main role="main" class="main-content">
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-8">
                <h2 class="page-title">Ajout Prix Matiere</h2>
                <div class="card shadow mb-4">
                    <div class="card-header">
                        <strong class="card-title">Prix Matiere</strong>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col-md-12">
                                <form method="post" action="AddPrixMatiere">
                                    <div class="form-group mb-3">
                                        <div class="form-group mb-3">
                                            <label for="matiere-select">Matiere</label>
                                            <select class="form-control" id="matiere-select" name="matiere">
                                                <% for(Matiere matiere : listMatiere) { %>
                                                <option value="<%=matiere.getIdMatiere() %>"><%=matiere.getNom() %></option>
                                                <% } %>
                                            </select>
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="simpleinput">Prix</label>
                                            <input type="number" id="simpleinput" class="form-control" name="prixunitaire" step="0.01">
                                        </div>
                                        <div class="form-group mb-3">
                                            <label for="simpleinput">Date</label>
                                            <input type="date" id="simpleinput" class="form-control" name="date">
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