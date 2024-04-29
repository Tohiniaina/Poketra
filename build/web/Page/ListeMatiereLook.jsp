<%-- 
    Document   : Index
    Created on : 12 déc. 2023, 15:48:21
    Author     : Tohy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.V_details_matiere_look"%>
<%@page import="java.util.List"%>
<% 
    List<V_details_matiere_look> listDetails = (List<V_details_matiere_look>)request.getAttribute("lisMatiere"); 
%>
        <main role="main" class="main-content">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-8">
                        <div class="card shadow mb-4">
                            <div class="card-header">
                                <strong class="card-title">Liste Matiere Look <%if(!listDetails.isEmpty()) out.print(listDetails.get(0).nomlook);%></strong>
                            </div>
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <ul>
                                        <% for(V_details_matiere_look details : listDetails) { %>
                                        <li><p><%=details.nommatiere %></p></li>
                                        <% } %>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>