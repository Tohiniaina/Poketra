<%-- 
    Document   : StatistiqueVente
    Created on : 25 janv. 2024, 15:18:12
    Author     : Tohy
--%>



<%@page import="Model.StatistiqueVente"%>
<%@page import="Model.Modele"%>
<%@page import="Model.Vente"%>
<%@page import="Model.Personne"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<% 
    List<Vente> listVente = (List<Vente>)request.getAttribute("allVente"); 
    List<Modele> listModele = (List<Modele>)request.getAttribute("listeModele"); 
    List<StatistiqueVente> listStatistiqueVente = (List<StatistiqueVente>)request.getAttribute("listeStatistique"); 
    String nomModele = request.getAttribute("nomModele").toString(); 
    int homme = 0;
    int femme = 0;
    for (StatistiqueVente stat : listStatistiqueVente) {
        if (stat.getSexe().equals("Homme")) {
                homme += stat.getNombre();
            } else {
            femme += stat.getNombre();
        }
    }
%>
        <script src="${pageContext.request.contextPath}/assets/js/chart.js"></script>
        <main role="main" class="main-content">
                                            
            <div class="container-fluid">
            <div class="row justify-content-center">
                <div class="col-10">
                    <form method="post" action="StatistiqueVente">
                        <div class="form-group mb-3">
                            <label for="matiere-select">Modele</label>
                            <select class="form-control" id="profil-select" name="modele">
                                <option value="tous">Tous</option>
                                <% for (Modele modele : listModele) { %>
                                <option value="<%=modele.getIdModele()%>"><%=modele.getNomModel()%></option>
                                <% } %>
                            </select>
                            <input class="btn btn-success ml-1" type="submit" value="Valider" name="btnValider" />
                        </div>
                    </form>
                    <h2 class="mb-2 page-title">Liste Des Ventes Modele : <%=nomModele%></h2>
                    <div class="row my-4">
                      <div class="col-md-12">
                        <div class="card shadow">
                          <div class="card-body">
                            <!-- table -->
                            <table class="table datatables" id="dataTable-1">
                              <thead>
                                <tr>
                                  <th>Homme</th>
                                  <th>Femme</th>
                                </tr>
                              </thead>
                              <tbody>
                                    <tr>
                                        <td><%=homme %></td>
                                        <td><%=femme %></td>
                                    </tr>
                              </tbody>
                            </table>
                          </div>
                        </div>
                      </div>
                    </div>
                    
                    <div class="chart">
                        <div class="title"><h2>Graphe</h2></div>
                        <div class="text-center" style="width: 350px">
                            <canvas id="myChart"></canvas>
                        </div>
                        <script>
                            const label = ["Homme","Femme"];
                            const values1 = [<%=homme %>, <%=femme %>];


                            const ctx = document.getElementById("myChart");

                            const data = {
                                labels: label,
                                datasets: [
                                    {
                                        label: "# of Votes",
                                        data: values1,
                                        borderWidth: 1,
                                    },
                                ],
                            };

                            new Chart(ctx, {
                                type: "pie",
                                data: data,
                                options: {
                                    scales: {
                                        y: {

                                            beginAtZero: true,
                                        },
                                    },
                                },
                            });
                        </script>
                    </div>
                </div>
            </div>
            </div>
        </main>
