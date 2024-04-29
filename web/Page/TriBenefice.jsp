<%-- 
    Document   : TriBenefice
    Created on : 16 janv. 2024, 16:42:05
    Author     : Tohy
--%>


<%@page import="Model.Benefice"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<Benefice> listeBenefice = (List<Benefice>) request.getAttribute("listeBenefice");
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <form method="post" action="VoirBenefice">
                            <div class="form-group mb-3">
                                <label for="matiere-select">Benefice</label>
                                <div class="row ml-1">
                                    <div class="form-group mb-3 mr-3">
                                        <label for="simpleinput">Benefice Min</label>
                                        <input type="number" id="simpleinput" value="0" class="form-control" name="prixmin" step="0.01">
                                    </div>
                                    <div class="form-group mb-3">
                                        <label for="simpleinput">Benefice Max</label>
                                        <input type="number" id="simpleinput" value="0" class="form-control" name="prixmax" step="0.01">
                                    </div>
                                </div>
                                <input class="btn btn-success ml-1" type="submit" value="Valider" name="btnValider" />
                            </div>
                        </form>
                        <h2 class="mb-2 page-title">Liste Benefice</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Model</th>
                                      <th>Montant</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (Benefice benefice : listeBenefice) { %>
                                        <tr>
                                          <td><%=benefice.getIdModele()%></td>
                                          <td><%=benefice.getMontant()%></td>
                                        </tr>
                                    <% } %>
                                  </tbody>
                                </table>
                              </div>
                            </div>
                          </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
