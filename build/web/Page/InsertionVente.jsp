<%-- 
    Document   : InsertionVente
    Created on : 25 janv. 2024, 14:54:05
    Author     : Tohy
--%>

<%@page import="Model.Modele"%>
<%@page import="Model.Vente"%>
<%@page import="Model.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Personne> listPersonne = (List<Personne>)request.getAttribute("listePersonne"); 
    List<Vente> listVente = (List<Vente>)request.getAttribute("allVente"); 
    List<Modele> listModele = (List<Modele>)request.getAttribute("listeModele"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Liste Des Ventes</h2>
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
                                  <th>Client</th>
                                </tr>
                              </thead>
                              <tbody>
                                    <% for (Vente vente : listVente) { %>
                                    <tr>
                                        <td><%=vente.getIdModele()%></td>
                                      <td><%=vente.getNombre()%></td>
                                      <td><%=vente.getIdClient()%></td>
                                    </tr>
                                    <% } %>
                              </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Vente</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddVente">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Vente</h5>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group mb-3">
                                                <label for="modele-select">Modele</label>
                                                <select class="form-control" id="profil-select" name="modele">
                                                  <% for (Modele modele : listModele) { %>
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
                                                <label for="personne-select">Personne</label>
                                                <select class="form-control" id="profil-select" name="personne">
                                                  <% for (Personne perso : listPersonne) { %>
                                                  <option value="<%=perso.getIdPersonne()%>"><%=perso.getNom()%></option>
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
