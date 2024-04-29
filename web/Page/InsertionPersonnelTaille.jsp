<%-- 
    Document   : InsertionPersonnelTaille
    Created on : 16 janv. 2024, 15:28:22
    Author     : Tohy
--%>

<%@page import="Model.Taille"%>
<%@page import="Model.PersonnelTaille"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<PersonnelTaille> listPersonnelTaille = (List<PersonnelTaille>)request.getAttribute("listePersonnelTaille"); 
    List<Taille> allTaille = (List<Taille>) request.getAttribute("allTaille");
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Nbr Personnel/Taille</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Taille</th>
                                      <th>Nbr Personnel</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (PersonnelTaille perso : listPersonnelTaille) { %>
                                        <tr>
                                          <td><%=perso.getIdTaille()%></td>
                                          <td><%=perso.getNbrPerso()%></td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>

                                <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Nbr Peronnel Taille</button>
                                <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form method="post" action="AddPersonnelTaille">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="varyModalLabel">Nouveau Nbr Peronnel Taille</h5>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                                <label for="taille-select">Taille</label>
                                                <select class="form-control" id="taille-select" name="taille">
                                                    <% for(Taille taille : allTaille) { %>
                                                    <option value="<%=taille.getIdTaille() %>"><%=taille.getNom() %></option>
                                                    <% } %>
                                                </select>
                                                <label for="nbrperso">Nombre Personnel</label>
                                                <input type="number" id="nbrperso" class="form-control" name="nbrperso">
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

