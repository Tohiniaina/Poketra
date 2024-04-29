<%-- 
    Document   : Index
    Created on : 12 déc. 2023, 15:48:21
    Author     : Tohy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Poketra</title>
        <!-- Simple bar CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/simplebar.css">
        <!-- Icons CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/feather.css">
        
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/app-light.css" id="lightTheme">
    </head>
    <body class="vertical  light">
        <div class="wrapper">
            <nav class="topnav navbar navbar-light mt-2">
                <button type="button" class="navbar-toggler text-muted mt-2 p-0 mr-3 collapseSidebar">
                    <i class="fe fe-menu navbar-toggler-icon"></i>
                </button>
                <form class="form-inline mr-auto searchform text-muted">
                    <input class="form-control mr-sm-2 bg-transparent border-0 pl-4 text-muted" type="search" placeholder="Type something..." aria-label="Search">
                </form>
            </nav>
            <aside class="sidebar-left border-right bg-white shadow" id="leftSidebar" data-simplebar>
                <a href="#" class="btn collapseSidebar toggle-btn d-lg-none text-muted ml-2 mt-3" data-toggle="toggle">
                    <i class="fe fe-x"><span class="sr-only"></span></i>
                </a>
                <nav class="vertnav navbar navbar-light">
                <!-- nav bar -->
                    <div class="w-100 mb-4 d-flex">
                        <a class="navbar-brand mx-auto mt-2 flex-fill text-center" href="./index.html">
                            <h3>Poketra</h3>
                        </a>
                    </div>
                    <ul class="navbar-nav flex-fill w-100 mb-2">
                        <li class="nav-item dropdown">
                            <a href="#dashboard" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                                <i class="fe fe-edit fe-16"></i>
                                <span class="ml-3 item-text">Forms</span><span class="sr-only">(current)</span>
                            </a>
                            <ul class="collapse list-unstyled pl-4 w-100" id="dashboard">
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="InsertionUnite"><span class="ml-1 item-text">Unite</span></a>
                                </li>
                                <li class="nav-item active">
                                    <a class="nav-link pl-3" href="InsertionMatiere"><span class="ml-1 item-text">Matiere</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="InsertionType"><span class="ml-1 item-text">Type</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="InsertionLook"><span class="ml-1 item-text">Look</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="InsertionTaille"><span class="ml-1 item-text">Taille</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="InsertionMatiereLook"><span class="ml-1 item-text">Matiere Look</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="AjoutPrixMatiere"><span class="ml-1 item-text">Ajout Prix Matiere</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="AjoutStock"><span class="ml-1 item-text">Ajout de Stock</span></a>
                                </li>
                            </ul>
                        </li>
                    </ul>
                    <ul class="navbar-nav flex-fill w-100 mb-2">
                        <li class="nav-item dropdown">
                          <a href="#pages" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                            <i class="fe fe-package fe-16"></i>
                            <span class="ml-3 item-text">Modele</span>
                          </a>
                          <ul class="collapse list-unstyled pl-4 w-100 w-100" id="pages">
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="InsertionModel"><span class="ml-1 item-text">Liste de Modele</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutPrixVente"><span class="ml-1 item-text">Ajout Prix Vente</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutFabrication"><span class="ml-1 item-text">Fabrication de Sac</span></a>
                            </li>
                          </ul>
                        </li>
                        <li class="nav-item dropdown">
                          <a href="#profile" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                            <i class="fe fe-users fe-16"></i>
                            <span class="ml-3 item-text">Gestion Personnel</span>
                          </a>
                          <ul class="collapse list-unstyled pl-4 w-100" id="profile">
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutPersonnel"><span class="ml-1 item-text">Ajout Poste</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutPersonnelTaille"><span class="ml-1 item-text">Nbr Personnel/Taille</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutVolumeHoraire"><span class="ml-1 item-text">Ajout Volume Horaire</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutPersonne"><span class="ml-1 item-text">Personne</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutProfil"><span class="ml-1 item-text">Profil</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutProfilStandard"><span class="ml-1 item-text">Profil Standard</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutProfilNonStandard"><span class="ml-1 item-text">Profil Non Standard</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutCaracteristiqueProfil"><span class="ml-1 item-text">Caractéristique Profil</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="AjoutProfilEmployer"><span class="ml-1 item-text">Profil Employer</span></a>
                            </li>
                          </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a href="#ui-elements" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                                <i class="fe fe-list fe-16"></i>
                                <span class="ml-3 item-text">Liste</span>
                            </a>
                            <ul class="collapse list-unstyled pl-4 w-100" id="ui-elements">
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="VoirLook"><span class="ml-1 item-text">Matiere Look</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="VoirListeSacMatiere"><span class="ml-1 item-text">Liste Model Sac Matiere</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="VoirTriModelPrix"><span class="ml-1 item-text">Tri Model/Prix</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="VoirStockMatiere"><span class="ml-1 item-text">Stock de Matiere Premiere</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="VoirProfilEmploye"><span class="ml-1 item-text">Profil Employé</span></a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link pl-3" href="VoirBenefice"><span class="ml-1 item-text">Benefice</span></a>
                                </li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                          <a href="#venteman" data-toggle="collapse" aria-expanded="false" class="dropdown-toggle nav-link">
                            <i class="fe fe-shopping-bag fe-16"></i>
                            <span class="ml-3 item-text">Gestion Vente</span>
                          </a>
                          <ul class="collapse list-unstyled pl-4 w-100 w-100" id="venteman">
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="InsertionVente"><span class="ml-1 item-text">Enregistrement de Vente</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link pl-3" href="StatistiqueVente"><span class="ml-1 item-text">Statistiques</span></a>
                            </li>
                          </ul>
                        </li>
                    </ul>
                </nav>
            </aside>