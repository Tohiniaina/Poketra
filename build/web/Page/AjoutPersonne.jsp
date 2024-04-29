<%-- 
    Document   : AjoutPersonne
    Created on : 23 janv. 2024, 15:25:15
    Author     : Tohy
--%>

<%@page import="Model.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Personne> listPersonne = (List<Personne>)request.getAttribute("listePersonne"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Liste Des Personnes</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>Nom</th>
                                  <th>Genre</th>
                                  <th>Date de Naissance</th>
                                </tr>
                              </thead>
                              <tbody>
                                    <% for (Personne perso : listPersonne) { %>
                                    <tr>
                                        <td><%=perso.getNom()%></td>
                                      <td><%=perso.getGenreString()%></td>
                                      <td><%=perso.getDtn()%></td>
                                    </tr>
                                    <% } %>
                              </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Personne</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddPersonne">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Personne</h5>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Nom</label>
                                                    <input type="text" id="simpleinput" class="form-control" name="nom">
                                                </div>
                                            </div>
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Date de Naissance</label>
                                                    <input type="date" id="simpleinput" class="form-control" name="dtn">
                                                </div>
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="genre-select">Genre</label>
                                                <select class="form-control" id="type-select" name="genre">
                                                  <option value="1">Homme</option>
                                                  <option value="0">Femme</option>
                                                </select>
                                            </div>
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Adresse</label>
                                                    <input type="texte" id="simpleinput" class="form-control" name="adresse">
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
