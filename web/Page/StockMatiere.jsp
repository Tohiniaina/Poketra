<%-- 
    Document   : StockMatiere
    Created on : 16 janv. 2024, 11:53:58
    Author     : Tohy
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Stock"%>
<%@page import="java.util.List"%>
<% 
    List<Stock> listStock = (List<Stock>)request.getAttribute("listeStock"); 
%>
        <main role="main" class="main-content"> 
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-10">
                        <h2 class="mb-2 page-title">Stock de Matiere</h2>
                        <div class="row my-4">
                          <div class="col-md-12">
                            <div class="card shadow">
                              <div class="card-body">
                                <!-- table -->
                                <table class="table datatables" id="dataTable-1">
                                  <thead>
                                    <tr>
                                      <th>Matiere</th>
                                      <!--<th>Entrer</th>
                                      <th>Sortie</th>-->
                                      <th>Quantite</th>
                                    </tr>
                                  </thead>
                                  <tbody>
                                    <% for (Stock stock : listStock) { %>
                                        <tr>
                                          <td><%=stock.getNomMatiere()%></td>
                                          <td><%=stock.getQuantite()%></td>
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
