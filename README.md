[![Build Status](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline.svg?branch=master)](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline)
[![Build Status](https://www.bitrise.io/app/b8e29b159097b3aa.svg?token=-r6AHWMQwkUwy5rsRsW4Kw&branch=master)](https://www.bitrise.io/app/b8e29b159097b3aa)
[![Coverage Status](https://coveralls.io/github/Miage-Paris-Ouest/froy/badge.svg?branch=master&service=github)](https://coveralls.io/github/Miage-Paris-Ouest/froy?branch=master)
[![SonarQube Technical Debt](https://img.shields.io/badge/technical%20debt-0.0%-brightgreen.svg)](http://localhost:9000/dashboard/index/fr.uparis10.pascalpoizat:template-java-project)
# m1c20152016-mobonline
Dépôt de Bruno Veraldi, Adrien Dos Santos, Florian Roy


# Présentation Générale du projet

# Introduction

## Besoin : 
Mettre à disposition des étudiants d’échanges  erasmus de Nanterre une application leur “facilitant la vie “ tant du point de vue administratif que dans leur vie courante.


## Contexte :
Une  application Wherasmus à été développé par les étudiants d’Ankara, la personne en charge du SRI (Service des Relations Internationnales) a demandé le développement d’une application similaire à l’université de  Paris Ouest Nanterre la défense.


## Cibles
Les personnes concernés par l’application seront les étudiants possédant un smartphone android:
de Nanterre partant en Erasmus dans une université partenaire.
d’une université partenaire venant en Erasmus à Nanterre. 


# Les spécifications fonctionnelles
Les étudiants utilisent une application android et les administrateurs un portail WEB.

## L’application proposera les fonctionnalités suivantes:
### Pour les étudiants :


<TABLE BORDER="1"> 
<TR> 
  <TH> La page de connexion </TH> 
</TR> 
<TR> 
 <TD> Fonctionnalités : </br>
 <ul>
<li>La connexion (possibilité de se connecter via un login et mot de passe)</li>
<li>La déconnexion</li>
<li>La configuration du profil</li>
<li>consulter les News de l’université</li>
 </ul>
 </TD> 
</TR> 
</TABLE> 


<TABLE BORDER="1"> 
<TR> 
  <TH> La page d'accueil </TH> 
</TR> 
<TR> 
 <TD> Fonctionnalités : </br>
 <ul>
<li>Les News du bandeau défilant</li>
Un clic sur une news permet l'affichage détaillé de cette news.
<li>Le bloc des 6 boutons principaux</li>
Un clic sur l'un de ces boutons permet la redirection vers la catégorie choisie
 </ul>
 </TD> 
</TR> 
</TABLE>


<TABLE BORDER="1"> 
<TR> 
  <TH> La page How To ? </TH> 
</TR> 
 <TR>
 <TD > Fonctionnalités : </br>
 <ul>
<li>Se renseigner sur les moyens de transport, d’hébergement, restauration les ainsi que les tâches administratives tel que l’inscription pédagogique, la demande de bourse, le contrat d’échange inter-université</li>
 </ul>
 </TD> 
</TR> 
</TABLE>


 <TABLE BORDER="1"> 
<TR> 
  <TH  colspan=2> La page To Do List </TH> 
</TR> 
<TR> 
 <TD>
 <img src="https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/GUI/img/to%20do%20list.png" alt="page To Do List" />
 </TD> 
 <TD> Fonctionnalités : </br>
 <ul>
<li>Consultation des activités à effectuer</li>
Une liste d'activités est proposée de base à l'étudiant erasmus afin de lui premettre de s'intégrer plus facilement.
<li>Valider une activité</li>
<li>Supprimer une activité</li>
<li>Ajouter une activité</li>
 </ul>
 </TD> 
</TR> 
</TABLE>


 <TABLE BORDER="1"> 
<TR> 
  <TH> La page Culture </TH> 
</TR> 
<TR> 
 <TD> Fonctionnalités : </br>
 <ul>
<li>Consultation des activités culturelles proposées</li>
<li>Affichage par catégorie</li>
Un clic sur une catégorie fait apparaitre les différentes activités liés à la catégorie avec un effet drop-down.
 </ul>
 </TD> 
</TR> 
</TABLE>


<TABLE BORDER="1"> 
<TR> 
  <TH> La page Map </TH> 
</TR> 
<TR> 
 <TD> Fonctionnalités : </br>
 <ul>
<li>Consulter le plan de l’université</li>
<li>Affichage du menu latéral en drop-right en cliquant sur le bouton loupe</li>
<li>Localisation des différents endroits en fonction de la selection du menu latéral à l'aide des puces de localisation</li>
<li>Un clic sur une puce sur le plan affiche l'image et la description du lieu en bas de l'interface</li>
 </ul>
 </TD> 
</TR> 
</TABLE>


 <TABLE BORDER="1"> 
<TR> 
  <TH  colspan=2> La page Contact </TH> 
</TR> 
<TR> 
 <TD> Fonctionnalités : </br>
 <ul>
<li>Consultation de la liste de contacts</li>
Un clic sur l'une des catégories (par exemple : inscription) fait apparaitre les différents contacts de la catégorie.
<li>Envoyer de messages</li>
Un clic sur un contact fait apparaitre une fenêtre permettant l'envoi de mail.
 </ul>
 </TD> 
</TR> 
</TABLE>


<TABLE BORDER="1"> 
<TR> 
  <TH> La page Learn French </TH> 
</TR> 
<TR> 
 <TD> Fonctionnalités : </br>
 <ul>
<li>l’apprentissage de la langue locale</li>
Dans cette page il y aura les différents mots clés et phrases courantes de la langue française traduites dans la langue de l'utilisateur.
 </ul>
 </TD> 
</TR> 
</TABLE>


### Pour les administrateurs de Nanterre et les universités partenaires :
* éditer les News
* inscription des étudiants d’échange
* gérer ses étudiants
* modifier les rubriques dans “How to ?”
* changer les contacts administratifs
* ajouter des mots dans learning french

### Pour les administrateurs de Nanterre uniquement :
* ajout de nouveau partenaires (université)
* gérer les partenaires (université)



## Les spécifications Techniques:


### Environnement de développement:
* Utilisation du JAVA pour le développement de l’application sous android.
* Utilisation de PHP pour le serveur et la partie administration

l’implémentation des différentes fonctionnalité se fera par la création d’activités. Ces activités récolterons les informations en base via des requêtes HTTP (via une API de type REST).

### Outils Used + 
UML : 
* Diagramme de cas d'utlisation

|UseCase|
|:---:|
|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/UseCase.png "Use case")|

* Diagramme de séquences

|StudentSequence|NanterreUniversityAdmin|UniversityAdmin|
|:---:|:---:|:---:|
|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/StudentSequence.png "StudentSequence")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/NanterreUniversityAdmin.png "NanterreUniversityAdmin")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/UniversityAdmin.png "UniversityAdmin")|


* Diagramme de classe
* Diagramme technique

