<%-- 
    Document   : InsertionFormule
    Created on : 19 déc. 2023, 16:00:18
    Author     : Miarantsoa
--%>

<%@page import="Model.V_details_matiere_look"%>
<%@page import="Model.V_formule_model"%>
<%@page import="Model.Modele"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<V_details_matiere_look> listMatiere = (List<V_details_matiere_look>)request.getAttribute("listeMatiere"); 
    List<V_formule_model> listFormule = (List<V_formule_model>)request.getAttribute("listeFormule"); 
    Modele modele = (Modele)request.getAttribute("modele"); 
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Formule Modele <%=modele.getNomModel() %></h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Matiere</th>
                                      <th>Quantite</th>
                                      <th>Unite</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (V_formule_model form : listFormule) { %>
                                        <tr>
                                          <td><%=form.getNommatiere()%></td>
                                          <td><%=form.getQuantite()%></td>
                                          <td><%=form.getNomunite()%></td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>

                                <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Formule</button>
                                <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form method="post" action="AddFormule">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="varyModalLabel">Nouveau Formule</h5>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group mb-3">
                                                <input type="hidden" value="<%=modele.getIdModele() %>" name="modele" />
                                                <label for="matiere-select">Matiere</label>
                                                <select class="form-control" id="matiere-select" name="matiere">
                                                    <% for(V_details_matiere_look matiere : listMatiere) { %>
                                                    <option value="<%=matiere.idmatiere %>"><%=matiere.nommatiere %></option>
                                                    <% } %>
                                                </select>
                                                <label for="quantite-formule">Quantite</label>
                                                <input type="number" id="quantite-formule" class="form-control" name="quantite" step="0.01">
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
