create database poketra ;
\c poketra

create sequence seq_matiere;
create sequence seq_type;
create sequence seq_look;
create sequence seq_ml;
create sequence seq_unite;

CREATE TABLE unite (
    idUnite varchar(20) PRIMARY KEY DEFAULT 'UNIT'||nextval('seq_unite'),
    libelle VARCHAR(50),
    nomUnite VARCHAR(50) NOT NULL
);

create table matiere(
    idMatiere varchar(20) DEFAULT 'MATIERE'||nextval('seq_matiere') ,
    nom varchar(50) not null ,
    idUnite VARCHAR(20),
    primary key(idMatiere),
    foreign key (idUnite) references unite(idUnite)
);

create table type(
    idType varchar(20) DEFAULT 'TYPE'||nextval('seq_type'),
    nom varchar(50) not null ,
    primary key(idType)
);

create table look(
    idLook varchar(20) DEFAULT 'LOOK'||nextval('seq_look'),
    nomLook varchar(50) not null ,
    primary key (idLook)
);

create table matiereLook (
    idML varchar(20) DEFAULT 'ML'||nextval('seq_ml'),
    idLook varchar(20) ,
    idMatiere varchar(20),
    foreign key (idLook) references look(idLook),
    foreign key (idMatiere) references matiere(idMatiere)
);

CREATE OR REPLACE VIEW v_details_matiere_look AS
    SELECT ml.*, l.nomLook, m.nom as nomMatiere
    FROM matiereLook as ml
        JOIN look as l
            ON ml.idLook = l.idLook
        JOIN matiere as m
            ON ml.idMatiere = m.idMatiere;

create sequence seq_taille;
create sequence seq_model;

CREATE TABLE taille (
    idTaille varchar(20) DEFAULT 'TAILLE' || nextval('seq_taille'), 
    nom varchar(50), 
    primary key(idTaille)
);

CREATE TABLE model (
    idModel varchar(20) DEFAULT 'MODEL' || nextval('seq_model'),
    idType varchar(20),
    idLook varchar(20),
    idTaille varchar(20),
    primary key(idModel),
    foreign key (idType) references type(idType),
    foreign key (idLook) references look(idLook),
    foreign key (idTaille) references taille(idTaille)
);

CREATE OR REPLACE VIEW v_model AS 
    SELECT m.idmodel, tp.idtype, tp.nom nomtype, lk.*, tl.idtaille, tl.nom nomtaille
        FROM model m 
            JOIN type tp 
                ON m.idtype = tp.idtype
            JOIN look lk
                ON m.idlook = lk.idlook
            JOIN taille tl
                ON m.idtaille = tl.idtaille;

CREATE TABLE formule (
    idModel varchar(20),
    idMatiere varchar(20),
    quantite decimal(11,2),
    foreign key (idModel) references model(idModel),
    foreign key (idMatiere) references matiere(idMatiere)
);

CREATE OR REPLACE VIEW v_formule_model AS 
    SELECT m.idmodel, tp.idtype, tp.nom nomtype, lk.*, tl.idtaille, 
    tl.nom nomtaille, 
    mat.idmatiere, mat.nom nommatiere, f.quantite, unit.*
        FROM model m 
            JOIN type tp 
                ON m.idtype = tp.idtype
            JOIN look lk
                ON m.idlook = lk.idlook
            JOIN taille tl
                ON m.idtaille = tl.idtaille
            JOIN formule f 
                ON m.idmodel=f.idmodel
            JOIN matiere mat
                ON f.idmatiere = mat.idmatiere
            JOIN unite unit
                ON mat.idunite = unit.idunite;


CREATE TABLE PrixMatiere (
    idMatiere varchar(20),
    prix decimal(11,2),
    date DATE,
    foreign key (idMatiere) references matiere(idMatiere) 
);


CREATE OR REPLACE VIEW v_prix_model AS    
    SELECT m.*, tp.nom nomtype, lk.nomlook, tl.nom nomtaille, 
    sum(f.quantite*pm.prix) as prix
        FROM model m
            JOIN type tp 
                ON m.idtype = tp.idtype
            JOIN look lk
                ON m.idlook = lk.idlook
            JOIN taille tl
                ON m.idtaille = tl.idtaille
            JOIN formule f
                ON m.idModel = f.idModel
            JOIN PrixMatiere pm 
                ON f.idMatiere = pm.idMatiere 
                where pm.date = (SELECT MAX(date) FROM PrixMatiere 
                WHERE idmatiere = f.idmatiere)
        GROUP BY m.idModel, nomtype, nomlook, nomtaille;


create sequence seq_mouvement;
create sequence seq_fabrication;

CREATE TABLE mouvement (
    idMouvement varchar(20) PRIMARY KEY DEFAULT 'MVO' || nextval('seq_mouvement'),
    idMatiere varchar(20),
    entrer FLOAT,
    sortie FLOAT,
    datemouvement DATE,
    foreign key (idMatiere) references matiere(idMatiere) 
);

CREATE TABLE fabrication (
    idFabrication varchar(20) PRIMARY KEY DEFAULT 'FAB' || nextval('seq_fabrication'),
    idModele VARCHAR(20),
    datefabrication DATE,
    nombre INT
);

CREATE OR REPLACE VIEW stock AS
SELECT mv.idMatiere, mt.nom,
    SUM(entrer-sortie) AS total_quantity,
    SUM(entrer) AS entrer,
    SUM(sortie) AS sortie
    FROM mouvement mv
    JOIN matiere mt ON mv.idmatiere = mt.idmatiere
    GROUP BY mv.idMatiere, mt.nom;


create sequence seq_personnel;

CREATE TABLE personnel (
    idPersonnel varchar(20) PRIMARY KEY DEFAULT 'PRS' || nextval('seq_personnel'),
    fonction VARCHAR(100),
    tauxhoraire FLOAT
);

CREATE TABLE personnelTaille (
    idTaille varchar(20),
    nbrPerso float,
    foreign key (idTaille) references taille(idtaille) 
);

CREATE TABLE MetierPersonnelModele (
    idModele VARCHAR(20),
    idPersonnel VARCHAR(20),
    nbr INT,
    foreign key (idModele) references model(idModel),
    foreign key (idPersonnel) references personnel(idPersonnel)
);

CREATE TABLE VolumeHoraire (
    idLook varchar(20),
    duree float,
    foreign key (idLook) references look(idLook)
);

CREATE TABLE prixVente (
    idModele VARCHAR(20),
    montant FLOAT,
    foreign key (idModele) references model(idModel)
);

CREATE OR REPLACE VIEW DepensePersonnel AS
SELECT mpm.idmodele, sum((p.tauxhoraire*vh.duree)*mpm.nbr) as prixtotal 
    FROM metierpersonnelmodele mpm
    JOIN personnel p ON mpm.idpersonnel = p.idpersonnel
    JOIN model mode ON mpm.idmodele = mode.idmodel
    JOIN volumehoraire vh ON mode.idlook = vh.idlook GROUP BY mpm.idmodele;

CREATE OR REPLACE VIEW DepenseMatierePremiere AS
SELECT f.idmodel, sum(f.quantite*pm.prix) prixtotal FROM formule f
JOIN prixmatiere pm ON f.idmatiere = pm.idmatiere
GROUP BY f.idmodel;

CREATE SEQUENCE seq_personne;

CREATE TABLE personne (
    idPersonne varchar(20) PRIMARY KEY DEFAULT 'PER' || nextval('seq_personne'),
    nom varchar(50),
    genre int,
    dtn date,
    adresse varchar(30)
);

CREATE SEQUENCE seq_profil;

CREATE TABLE profil (
    idProfil varchar(20) PRIMARY KEY DEFAULT 'PROFIL' || nextval('seq_profil'),
    libelle varchar(50)
); 

CREATE TABLE profilStandard(
    idProfil varchar(20),
    dateHeure timestamp,
    tauxhoraire decimal(11,2),
    foreign key (idProfil) references profil(idProfil)
);

CREATE TABLE profilNonStandard(
    idProfil varchar(20),
    coefficient double precision,
    foreign key (idProfil) references profil(idProfil)
);

CREATE TABLE caracteristiqueProfil(
    idProfil varchar(20),
    annee1 int,
    annee2 int,
    foreign key (idProfil) references profil(idProfil)
);

CREATE TABLE profilEmploye (
    idProfil varchar(20),
    dateEmbauche timestamp,
    idPersonne varchar(20),
    foreign key (idProfil) references profil(idProfil),
    foreign key (idPersonne) references personne(idPersonne)    
);

create or replace view v_niasana as (
SELECT e.idpersonne, 
       FLOOR(EXTRACT(EPOCH FROM age(current_date, e.dateembauche))/60/60/24/30.44/12) + ex.annee1 as annee
FROM profilEmploye e
JOIN caracteristiqueProfil ex ON e.idprofil = ex.idprofil);

create or replace view v_profil_personne as (
select * from v_niasana as v
join caracteristiqueProfil as e 
on v.annee>=annee1 and v.annee<annee2 );

create view v_standard as (
select s.idprofil,s.tauxhoraire from profilStandard s
join (
select max(tauxhoraire) as tauxhoraire from profilStandard s
) vu on s.tauxhoraire = vu.tauxhoraire 
);

create view v_profil as (
select per.nom as nom,pr.idprofil ,pr.libelle as profil,
(v.tauxhoraire * c.coefficient) as taux from v_profil_personne p
cross join v_standard v
join profilNonStandard c on c.idprofil = p.idprofil
join profil pr on pr.idprofil = c.idprofil
join personne per on per.idpersonne = p.idpersonne
);


SELECT
    pe.idProfil,
    p.libelle,
    pe.dateEmbauche,
    pe.idPersonne,
    hp.niveau,
    EXTRACT(YEAR FROM AGE(CURRENT_DATE, pe.dateEmbauche)) AS annees_experience
FROM
    profilEmploye pe
JOIN
    profil p ON pe.idProfil = p.idProfil
JOIN
    hierarchieProfil hp ON pe.idProfil = hp.idProfil;


CREATE SEQUENCE seq_vente;

CREATE TABLE vente (
    idVente varchar(20) PRIMARY KEY DEFAULT 'VNT' || nextval('seq_vente'),
    idModele varchar(20),
    nombre int,
    idPersonne VARCHAR(20),
    foreign key (idModele) references model(idModel),
    foreign key (idPersonne) references personne(idPersonne)
);

CREATE TABLE genre(
    idGenre VARCHAR(20) PRIMARY KEY,
    val int,
    libelle VARCHAR(25)
);

CREATE OR REPLACE VIEW vcross AS
SELECT m.*,g.* from model m
CROSS JOIN genre g;

create view reserv as (
select vu.idmodele,vu.sexe,sum(vu.nombre) as nombre from 
(SELECT v.idmodele, g.val as sexe ,
case when p.genre is null then 0 else v.nombre end as nombre  
FROM vente v 
cross join genre g
left join personne p on v.idpersonne = p.idpersonne and g.val = p.genre
) vu
 group by vu.idmodele,vu.sexe
);


create or replace view statistique as (
select v.idmodel,g.libelle as sexe,
case when r.idmodele is null then 0 else r.nombre end as nombre  
from vcross v
left join reserv r 
on r.idmodele = v.idmodel and v.val = r.sexe
join genre g on g.val = v.val
);

create view tous as (
    select sexe,sum(nombre) as nombre from statistique
    group by sexe
);
INSERT INTO genre(idGenre, val, libelle) VALUES('GENRE1', 0, 'Femme');
INSERT INTO genre(idGenre, val, libelle) VALUES('GENRE2', 1, 'Homme');

CREATE VIEW statistiques_vente_par_genre AS
SELECT
    v.idVente,
    p.genre,
    p.nom AS nom_personne,
    v.idModele,
    v.nombre,
    CASE WHEN p.genre = 1 THEN v.nombre ELSE 0 END AS ventes_hommes,
    CASE WHEN p.genre = 0 THEN v.nombre ELSE 0 END AS ventes_femmes
FROM
    vente v
JOIN
    personne p ON v.idPersonne = p.idPersonne
JOIN
    model m ON v.idModele = m.idModel;


CREATE SEQUENCE seq_mouvementsac;

CREATE TABLE MouvementSac(
    idMouvementSac varchar(20) PRIMARY KEY DEFAULT 'MVTSAC' || nextval('seq_mouvementsac'),
    idModele varchar(20),
    entrer FLOAT,
    sortie FLOAT,
    datemouvement DATE,
    foreign key (idModele) references model(idmodel) 
);