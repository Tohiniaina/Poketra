<%-- 
    Document   : AjoutProfilEmployer
    Created on : 23 janv. 2024, 17:27:17
    Author     : Tohy
--%>

<%@page import="Model.ProfilEmployer"%>
<%@page import="Model.Personne"%>
<%@page import="Model.Profil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Personne> listPersonne = (List<Personne>)request.getAttribute("listePersonne"); 
    List<Profil> listProfil = (List<Profil>)request.getAttribute("listeProfil"); 
    List<ProfilEmployer> listProfilEmployer = (List<ProfilEmployer>)request.getAttribute("listeProfilEmployer"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Liste Employer</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>Id Personne</th>
                                  <th>Id Profil</th>
                                  <th>Date Embauche</th>
                                </tr>
                              </thead>
                                <tbody>
                                    <% for (ProfilEmployer pe : listProfilEmployer) { %>
                                    <tr>
                                        <td><%=pe.getIdpersonne()%></td>
                                        <td><%=pe.getIdProfil()%></td>
                                        <td><%=pe.getDateembauche()%></td>
                                    </tr>
                                    <% } %>
                                </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Employer</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddEmployer">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Employer</h5>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group mb-3">
                                                <label for="profil-select">Profil</label>
                                                <select class="form-control" id="profil-select" name="profil">
                                                  <% for (Profil prof : listProfil) { %>
                                                    <option value="<%=prof.getIdProfil() %>"><%=prof.getLibelle() %></option>
                                                  <% } %>
                                                </select>
                                            </div>
                                            <div class="form-group mb-3">
                                                <label for="personne-select">Personne</label>
                                                <select class="form-control" id="profil-select" name="personne">
                                                  <% for (Personne perso : listPersonne) { %>
                                                  <option value="<%=perso.getIdPersonne()%>"><%=perso.getNom()%></option>
                                                  <% } %>
                                                </select>
                                            </div>
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Date Embauche</label>
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
