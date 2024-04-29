<%-- 
    Document   : InsertionLook
    Created on : 12 déc. 2023, 15:48:21
    Author     : Tohy
--%>
<%@page import="Model.Look"%>
<%@page import="java.util.List"%>
<% 
    List<Look> listLook = (List<Look>)request.getAttribute("listeLook"); 
%>
        <main role="main" class="main-content">
            
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Liste des Look</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>id</th>
                                      <th>Look</th>
                                      <th>Action</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (Look look : listLook) { %>
                                        <tr>
                                          <td><%=look.getIdLook()%></td>
                                          <td><%=look.getNomLook()%></td>
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

                                <button type="button" class="btn mb-2 btn-outline-info" data-toggle="modal" data-target="#varyModal" data-whatever="@mdo">Nouveau Look</button>
                                <div class="modal fade" id="varyModal" tabindex="-1" role="dialog" aria-labelledby="varyModalLabel" aria-hidden="true">
                                  <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <form method="post" action="AddLook">
                                            <div class="modal-header">
                                              <h5 class="modal-title" id="varyModalLabel">Nouveau Look</h5>
                                              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                <span aria-hidden="true">&times;</span>
                                              </button>
                                            </div>
                                            <div class="modal-body">
                                                <div class="form-group mb-3">
                                                    <label for="simpleinput">Nom Look</label>
                                                    <input type="text" id="simpleinput" class="form-control" name="nomLook">
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
