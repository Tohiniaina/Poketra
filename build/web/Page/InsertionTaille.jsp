<%-- 
    Document   : InsertionTaille
    Created on : 19 déc. 2023, 15:40:16
    Author     : Tohy
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Taille"%>
<%@page import="java.util.List"%>
<%
    List<Taille> allTaille = (List<Taille>) request.getAttribute("allTaille");
%>
        <main role="main" class="main-content">
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <h2 class="mb-2 page-title">Table de Taille</h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>id</th>
                                  <th>Libellé</th>
                                  <th>Action</th>
                                </tr>
                              </thead>
                              <tbody>
                                <% for (Taille taille : allTaille) { %>
                                    <tr>
                                      <td><%=taille.getIdTaille()%></td>
                                      <td><%=taille.getNom()%></td>
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
                              
                            <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Taille</button>
                            <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                              <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <form method="post" action="AddTaille">
                                        <div class="modal-header">
                                          <h5 class="modal-title" id="varyModalLabel">Nouveau Taille</h5>
                                          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                          </button>
                                        </div>
                                        <div class="modal-body">
                                            <div class="form-group mb-3">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Taille</label>
                                                    <input type="text" id="simpleinput" class="form-control" name="taille">
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
