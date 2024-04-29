<%-- 
    Document   : VolumeHoraire
    Created on : 16 janv. 2024, 16:31:49
    Author     : Tohy
--%>

<%@page import="Model.Look"%>
<%@page import="Model.VolumeHoraire"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Look> listLook = (List<Look>)request.getAttribute("listeLook"); 
    List<VolumeHoraire> listVolumeHoraire = (List<VolumeHoraire>)request.getAttribute("listeVolumeHoraire"); 
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
                                      <th>Look</th>
                                      <th>duree</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (VolumeHoraire vh : listVolumeHoraire) { %>
                                        <tr>
                                          <td><%=vh.getIdLook()%></td>
                                          <td><%=vh.getDuree()%></td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>

                                <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Volume Horaire</button>
                                <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form method="post" action="AddVolumeHoraire">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="varyModalLabel">Nouveau Volume Horaire</h5>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                                <label for="look-select">Look</label>
                                                <select class="form-control" id="look-select" name="look">
                                                  <% for(Look look : listLook) { %>
                                                  <option value="<%=look.getIdLook() %>"><%=look.getNomLook() %></option>
                                                  <% } %>
                                                </select>
                                                <label for="duree">Duree</label>
                                                <input type="number" id="duree" class="form-control" name="duree" step="0.01">
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

