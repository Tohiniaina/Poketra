<%-- 
    Document   : ProfilStandard
    Created on : 23 janv. 2024, 16:03:54
    Author     : Tohy
--%>

<%@page import="Model.ProfilNonStandard"%>
<%@page import="Model.Profil"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Profil> listProfil = (List<Profil>)request.getAttribute("allprofil"); 
    List<ProfilNonStandard> profilNonStand = (List<ProfilNonStandard>)request.getAttribute("profilnonstandard"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Profil Standard</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>id Profil</th>
                                  <th>Coefficient</th>
                                </tr>
                              </thead>
                                <tbody>
                                    <% for (ProfilNonStandard pns : profilNonStand) { %>
                                        <tr>
                                            <td><%=pns.getIdProfil()%></td>
                                            <td><%=pns.getCoefficient()%></td>
                                        </tr>
                                    <% } %>
                                </tbody>
                            </table>
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Profil Non Standard</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddProfilNonStandard">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Profil Non Standard</h5>
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
                                                    <label for="simpleinput">Coefficient</label>
                                                    <input type="texte" id="simpleinput" class="form-control" name="coefficient">
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
