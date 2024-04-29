<%-- 
    Document   : TriModelPrix
    Created on : 9 janv. 2024, 15:03:48
    Author     : Tohy
--%>

<%@page import="Model.V_prix_model"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<V_prix_model> TriPrixModel = (List<V_prix_model>) request.getAttribute("TriPrixModel");
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <form method="post" action="VoirTriModelPrix">
                            <div class="form-group mb-3">
                                <label for="matiere-select">Matiere</label>
                                <div class="row ml-1">
                                    <div class="form-group mb-3 mr-3">
                                        <label for="simpleinput">Prix Min</label>
                                        <input type="number" id="simpleinput" value="0" class="form-control" name="prixmin" step="0.01">
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="simpleinput">Prix Max</label>
                                        <input type="number" id="simpleinput" value="0" class="form-control" name="prixmax" step="0.01">
                                    </div>
                                </div>
                                <input class="btn btn-success ml-1" type="submit" value="Valider" name="btnValider" />
                            </div>
                        </form>
                        <h2 class="mb-2 page-title">Liste Sac Matiere</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Model</th>
                                      <th>Prix</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (V_prix_model prixmodel : TriPrixModel) { %>
                                        <tr>
                                          <td><%=prixmodel.getNomtype()+" "+prixmodel.getNomlook()+" "+prixmodel.getNomtaille()%></td>
                                          <td><%=prixmodel.getPrix()%></td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>
                              </div>
                            </div>
                          </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>