<%-- 
    Document   : ProfilEmploye
    Created on : 30 janv. 2024, 15:43:40
    Author     : Tohy
--%>
<%@page import="Model.V_profil"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    List<V_profil> listV_profil = (List<V_profil>) request.getAttribute("allV_profil");
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Liste Profil Employé</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Nom</th>
                                      <th>Profil</th>
                                      <th>Taux</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (V_profil vp : listV_profil) { %>
                                        <tr>
                                          <td><%=vp.getNom() %></td>
                                          <td><%=vp.getProfil()%></td>
                                          <td><%=vp.getTaux() %></td>
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
