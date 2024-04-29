<%-- 
    Document   : InsertionPersonnel
    Created on : 16 janv. 2024, 15:04:35
    Author     : Tohy
--%>

<%@page import="Model.Personnel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Personnel> listPersonnel = (List<Personnel>)request.getAttribute("listePersonnel"); 
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Liste Personnel</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Fonction</th>
                                      <th>Taux Horaire</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (Personnel perso : listPersonnel) { %>
                                        <tr>
                                          <td><%=perso.getFonction()%></td>
                                          <td><%=perso.getTauxHoraire()%></td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>

                                <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Personnel</button>
                                <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form method="post" action="AddPersonnel">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="varyModalLabel">Nouveau Personnel</h5>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                                <label for="fonction">Fonction</label>
                                                <input type="text" id="fonction" class="form-control" name="fonction">
                                                <label for="taux">Taux Horaire</label>
                                                <input type="number" id="fonction" class="form-control" name="taux" step="0.01">
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

