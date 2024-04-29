<%-- 
    Document   : CaracteristiqueProfil
    Created on : 23 janv. 2024, 16:52:59
    Author     : Tohy
--%>
<%@page import="Model.Profil"%>
<%@page import="Model.CaracteristiqueProfil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<CaracteristiqueProfil> allCaracteristiqueProfil = (List<CaracteristiqueProfil>)request.getAttribute("listeCaracteristiqueProfil"); 
    List<Profil> listProfil = (List<Profil>)request.getAttribute("allprofil"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Caractéristique Profil</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>Id Profil</th>
                                  <th>Année exp 1</th>
                                  <th>Année exp 2</th>
                                </tr>
                              </thead>
                                <tbody>
                                    <% for (CaracteristiqueProfil cp : allCaracteristiqueProfil) { %>
                                    <tr>
                                        <td><%=cp.getIdProfil()%></td>
                                        <td><%=cp.getAnnee1()%></td>
                                        <td><%=cp.getAnnee2()%></td>
                                    </tr>
                                    <% } %>
                                </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Caractéristique Profil</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddCaracteristiqueProfil">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Caractéristique Profil</h5>
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
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Année exp 1</label>
                                                    <input type="number" id="simpleinput" class="form-control" name="annee1">
                                                </div>
                                            </div>
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Année exp 2</label>
                                                    <input type="number" id="simpleinput" class="form-control" name="annee2">
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
