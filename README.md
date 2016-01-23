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
* La connexion (possibilité de se connecter via un login et mot de passe)

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master//GUI/img/login.png)

* La déconnexion
* La configuration du profil
* consulter les News de l’université

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master//GUI/img/accueil.png)

* consulter le plan de l’université

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master//GUI/img/map.png)

* Se renseigner sur les moyens de transport, d’hébergement, restaurationles ainsi que les tâches administratives tel que l’inscription pédagogique, la demande de bourse, le contrat d’échange inter-université

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master//GUI/img/how%20to.png)
![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/GUI/img/how%20to%202.png)
 
* l’apprentissage de la langue locale

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/GUI/img/learning%20french.png)

* la liste des choses à faire (To Do List)

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/GUI/img/to%20do%20list.png)

* la consultation de la liste de contact et l’envoi de messages

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/GUI/img/contact.png)

* La possibilité de se renseigner sur la culture et la activités culturelles

![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/GUI/img/culture.png)


### Pour les administrateurs de Nanterre et les universités partenaires :
* éditer les News
* inscription des étudiants d’échange
* gérer ses étudiants
* modifier les rubriques dans “How to ?”
* changer les contacts administratifs
* ajouter des mots dans learning french
* Pour les administrateurs de Nanterre uniquement :
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
* Diagramme de classes
* Diagramme technique

