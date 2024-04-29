<%-- 
    Document   : Fabrication
    Created on : 11 janv. 2024, 15:26:55
    Author     : Tohy
--%>

<%@page import="Model.Modele"%>
<%@page import="Model.Fabrication"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Modele> listModele = (List<Modele>)request.getAttribute("listeModele"); 
    List<Fabrication> listFabrication = (List<Fabrication>)request.getAttribute("listeFabrication"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Historique de Fabrication</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>Modele</th>
                                  <th>Nombre</th>
                                  <th>Date</th>
                                </tr>
                              </thead>
                              <tbody>
                                    <% for (Fabrication fab : listFabrication) { %>
                                    <tr>
                                      <td><%=fab.getNomModel() %></td>
                                      <td><%=fab.getNombre() %></td>
                                      <td><%=fab.getDateFabrication()%></td>
                                    </tr>
                                    <% } %>
                              </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Fabrication</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddFabrication">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Fabrication Sac</h5>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group mb-3">
                                                <label for="type-select">Modele</label>
                                                <select class="form-control" id="type-select" name="modele">
                                                  <% for(Modele modele : listModele) { %>
                                                  <option value="<%=modele.getIdModele()%>"><%=modele.getNomModel()%></option>
                                                  <% } %>
                                                </select>
                                            </div>
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Nombre</label>
                                                    <input type="number" id="simpleinput" class="form-control" name="nombre">
                                                </div>
                                            </div>
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Date</label>
                                                    <input type="date" id="simpleinput" class="form-control" name="date">
                                                </div>
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
