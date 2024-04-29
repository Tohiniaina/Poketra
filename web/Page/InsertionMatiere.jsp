<%-- 
    Document   : InsertionMatiere
    Created on : 12 déc. 2023, 15:48:21
    Author     : Tohy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Matiere"%>
<%@page import="Model.Unite"%>
<%@page import="java.util.List"%>
<% 
    List<Unite> listUnite = (List<Unite>)request.getAttribute("listeUnite"); 
    List<Matiere> listMatiere = (List<Matiere>)request.getAttribute("listeMatiere"); 
%>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Liste des Matieres</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>id</th>
                                      <th>Matiere</th>
                                      <th>Action</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (Matiere matiere : listMatiere) { %>
                                        <tr>
                                          <td><%=matiere.getIdMatiere()%></td>
                                          <td><%=matiere.getNom()%></td>
                                          <td><button class="btn btn-sm dropdown-toggle more-horizontal" type="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                              <span class="text-muted sr-only">Action</span>
                                            </button>
                                            <div class="dropdown-menu dropdown-menu-right">
                                              <a class="dropdown-item" href="#">Edit</a>
                                              <a class="dropdown-item" href="#">Remove</a>
                                              <a class="dropdown-item" href="#">Assign</a>
                                            </div>
                                          </td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>

                                <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Matiere</button>
                                <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form method="post" action="AddMatiere">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="varyModalLabel">Nouveau Matiere</h5>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Nom Matiere</label>
                                                    <input type="text" id="simpleinput" class="form-control" name="nomMatiere">
                                                </div>
                                                <div class="form-group mb-3">
                                                    <label for="unite-select">Unite</label>
                                                    <select class="form-control" id="unite-select" name="unite">
                                                      <% for(Unite unite : listUnite) { %>
                                                      <option value="<%=unite.getIdUnite()%>"><%=unite.getNomUnite()%></option>
                                                      <% } %>
                                                    </select>
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