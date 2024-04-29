<%-- 
    Document   : PrixVente
    Created on : 16 janv. 2024, 16:44:22
    Author     : Tohy
--%>


<%@page import="Model.PrixVente"%>
<%@page import="Model.Modele"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Modele> listModele = (List<Modele>)request.getAttribute("listeModele"); 
    List<PrixVente> listPrixVente = (List<PrixVente>)request.getAttribute("listePrixVente"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Table de PrixVente</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>idModele</th>
                                  <th>Montant</th>                                
                                </tr>
                              </thead>
                              <tbody>
                                <% for (PrixVente pv : listPrixVente) { %>
                                    <tr>
                                      <td><%=pv.getIdModele()%></td>
                                      <td><%=pv.getMontant()%></td>
                                    </tr>
                                <% } %>
                              </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Prix Vente</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddPrixVente">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Prix Vente</h5>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group mb-3">
                                                <label for="modele-select">Modele</label>
                                                <select class="form-control" id="modele-select" name="modele">
                                                  <% for(Modele modele : listModele) { %>
                                                  <option value="<%=modele.getIdModele()%>"><%=modele.getNomModel()%></option>
                                                  <% } %>
                                                </select>
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="montant">Montant</label>
                                                <input type="number" id="montant" class="form-control" name="montant" step="0.01">
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

