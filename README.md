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


|La page de connexion|
|:---:|
|**Fonctionnalités :** <ul><li> La connexion (possibilité de se connecter via un login et mot de passe)</li><li> La déconnexion </li><li> La configuration du profil </li><li> consulter les News de l’université</li><ul>|


|La page d'accueil|
|:---:|
|**Fonctionnalités :** <ul><li> Les News du bandeau défilant</li></br>Un clic sur une news permet l'affichage détaillé de cette news.<li> Le bloc des 6 boutons principaux</li><li></br>Un clic sur l'un de ces boutons permet la redirection vers la catégorie choisie|

|La page How To ?|
|:---:|
|**Fonctionnalités :**
*Se renseigner sur les moyens de transport, d’hébergement, restauration les ainsi que les tâches administratives tel que l’inscription pédagogique, la demande de bourse, le contrat d’échange inter-université|


|La page To Do List|
|:---:|
|**Fonctionnalités**
*Consultation des activités à effectuer
Une liste d'activités est proposée de base à l'étudiant erasmus afin de lui premettre de s'intégrer plus facilement.
*Valider une activité
*Supprimer une activité
*Ajouter une activité|


|La page Culture|
|:---:|
|**Fonctionnalités :**
*Consultation des activités culturelles proposées
*Affichage par catégorie
Un clic sur une catégorie fait apparaitre les différentes activités liés à la catégorie avec un effet drop-down.|


|La page Map|
|:---:|
|**Fonctionnalités :**
*Consulter le plan de l’université
*Affichage du menu latéral en drop-right en cliquant sur le bouton loupe
*Localisation des différents endroits en fonction de la selection du menu latéral à l'aide des puces de localisation
*Un clic sur une puce sur le plan affiche l'image et la description du lieu en bas de l'interface|




|La page Contact|
|:---:|
|**Fonctionnalités :**
*Consultation de la liste de contacts
Un clic sur l'une des catégories (par exemple : inscription) fait apparaitre les différents contacts de la catégorie.
*Envoyer de messages
Un clic sur un contact fait apparaitre une fenêtre permettant l'envoi de mail.|


|La page Learn French|
|:---:|
|**Fonctionnalités :**
*l’apprentissage de la langue locale
Dans cette page il y aura les différents mots clés et phrases courantes de la langue française traduites dans la langue de l'utilisateur.|



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

# Les diagrammes

|UseCase|
|:---:|
|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/UseCase.png "Use case")|

* Diagramme de séquences

|StudentSequence|NanterreUniversityAdmin|UniversityAdmin|
|:---:|:---:|:---:|
|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/StudentSequence.png "StudentSequence")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/NanterreUniversityAdmin.png "NanterreUniversityAdmin")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/UniversityAdmin.png "UniversityAdmin")|


* Diagramme de classe
* Diagramme technique

