<%-- 
    Document   : ListeSacMatiere
    Created on : 27 déc. 2023, 15:45:00
    Author     : Tohy
--%>

<%@page import="Model.Matiere"%>
<%@page import="Model.V_formule_model"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<V_formule_model> listFormule = (List<V_formule_model>)request.getAttribute("listeFormule");
    List<Matiere> listMatiere = (List<Matiere>)request.getAttribute("listeMatiere"); 
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <form method="post" action="VoirListeSacMatiere">
                            <div class="form-group mb-3">
                                <label for="matiere-select">Matiere</label>
                                <div class="row ml-1">
                                    <select class="col-md-10 form-control" id="matiere-select" name="idMatiere">
                                        <% for(Matiere matiere : listMatiere) { %>
                                        <option value="<%=matiere.getIdMatiere() %>"><%=matiere.getNom() %></option>
                                        <% } %>
                                    </select>
                                    <input class="btn btn-success ml-4" type="submit" value="Valider" name="btnValider" />
                                </div>
                            </div>
                        </form>
                        <h2 class="mb-2 page-title">Liste Sac Matiere</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Type</th>
                                      <th>Look</th>
                                      <th>Taille</th>
                                      <th>Matiere</th>
                                      <th>Quantite</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (V_formule_model form : listFormule) { %>
                                        <tr>
                                          <td><%=form.getNomtype()%></td>
                                          <td><%=form.getNomlook()%></td>
                                          <td><%=form.getNomtaille()%></td>
                                          <td><%=form.getNommatiere()%></td>
                                          <td><%=form.getQuantite()%></td>
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
