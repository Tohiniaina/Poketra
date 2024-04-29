<%-- 
    Document   : InsertionMetierPersonnelModele
    Created on : 16 janv. 2024, 15:54:51
    Author     : Tohy
--%>
<%@page import="Model.Personnel"%>
<%@page import="Model.MetierPersonnelModele"%>
<%@page import="Model.Modele"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<MetierPersonnelModele> listMetierPersonnelModele = (List<MetierPersonnelModele>)request.getAttribute("listeMetierPersonnelModele"); 
    Modele modele = (Modele)request.getAttribute("modele"); 
    List<Personnel> listPersonnel = (List<Personnel>)request.getAttribute("listePersonnel"); 
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Metier Modele <%=modele.getNomModel() %></h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Personnel</th>
                                      <th>Nbr</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (MetierPersonnelModele mpm : listMetierPersonnelModele) { %>
                                        <tr>
                                          <td><%=mpm.getIdPersonnel()%></td>
                                          <td><%=mpm.getNbr()%></td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>

                                <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau MetierPersonnelModele</button>
                                <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form method="post" action="AddMetierPersonnelModele">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="varyModalLabel">Nouveau MetierPersonnelModele</h5>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group mb-3">
                                                <input type="hidden" value="<%=modele.getIdModele() %>" name="modele" />
                                                <label for="personnel-select">Poste</label>
                                                <select class="form-control" id="personnel-select" name="personnel">
                                                    <% for(Personnel perso : listPersonnel) { %>
                                                    <option value="<%=perso.getIdPersonnel() %>"><%=perso.getFonction() %></option>
                                                    <% } %>
                                                </select>
                                                <label for="nbr-formule">Nbr</label>
                                                <input type="number" id="nbr-formule" class="form-control" name="nbr">
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
