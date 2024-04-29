<%-- 
    Document   : InsertionModel
    Created on : 19 déc. 2023, 15:57:47
    Author     : Tohy
--%>

<%@page import="Model.Taille"%>
<%@page import="Model.Modele"%>
<%@page import="Model.Type"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Look"%>
<%@page import="java.util.List"%>
<% 
    List<Look> listLook = (List<Look>)request.getAttribute("listeLook"); 
    List<Type> listType = (List<Type>)request.getAttribute("listeType"); 
    List<Modele> listModele = (List<Modele>)request.getAttribute("listeModele"); 
    List<Taille> listTaille = (List<Taille>)request.getAttribute("listeTaille"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Table de modele</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>id</th>
                                  <th>Libellé</th>
                                  <th>Action</th>
                                </tr>
                              </thead>
                              <tbody>
                                <% for (Modele modele : listModele) { %>
                                    <tr>
                                      <td><%=modele.getIdModele()%></td>
                                      <td><%=modele.getNomModel()%></td>
                                      <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                          <span class="text-muted sr-only">Action</span>
                                        </button>
                                        <div class="dropdown-menu dropdown-menu-right">
                                          <a class="dropdown-item" href="InsertionFormule?idModele=<%=modele.getIdModele() %>">Formule</a>
                                          <a class="dropdown-item" href="AjoutMetierPersonnelModele?idModele=<%=modele.getIdModele() %>">Personnel</a>
                                        </div>
                                      </td>
                                    </tr>
                                <% } %>
                              </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Modele</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddModel">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Modele</h5>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group mb-3">
                                                <label for="type-select">Type</label>
                                                <select class="form-control" id="type-select" name="type">
                                                  <% for(Type type : listType) { %>
                                                  <option value="<%=type.getIdType()%>"><%=type.getNom()%></option>
                                                  <% } %>
                                                </select>
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="look-select">Look</label>
                                                <select class="form-control" id="look-select" name="look">
                                                  <% for(Look look : listLook) { %>
                                                  <option value="<%=look.getIdLook() %>"><%=look.getNomLook() %></option>
                                                  <% } %>
                                                </select>
                                            </div>
                                            <div>
                                                <label for="taille-select">Taille</label>
                                                <select class="form-control" id="taille-select" name="taille">
                                                    <% for(Taille taille : listTaille) { %>
                                                    <option value="<%=taille.getIdTaille()%>"><%=taille.getNom()%></option>
                                                    <% } %>
                                                </select>
                                            </div>
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn mb-2 btn-secondary" data-dismiss="modal">Close</button>
                                            <input class="btn mb-2 btn-success" type="submit" value="Valider" name="btnValider" />
                                        </div>
                                    </form>
                                </div>
                              </div>
                            </div>
                            
                          </div>
                        </div>
                      </div>
                    </div>
                </div>
            </div>
            </div>
        </main>
