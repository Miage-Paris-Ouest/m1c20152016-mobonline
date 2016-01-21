[![Build Status](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline.svg?branch=master)](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline)
[![Build Status](https://www.bitrise.io/app/9a01f62986353791.svg?token=tM1xWmh_96658JMlJn7Ccg)](https://www.bitrise.io/app/9a01f62986353791)
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
* La déconnexion
* La configuration du profil
* consulter les News de l’université
* consulter le plan de l’université
* Se renseigner sur les moyens de transport, d’hébergement et restauration
* Se renseigner sur les tâches administratives tel que l’inscription pédagogique, la demande de bourse, le contrat d’échange inter-université
* l’apprentissage de la langue locale
* la liste des choses à faire (To Do List)
* la consultation de la liste de contact et l’envoi de messages
* La possibilité de se renseigner sur la culture et la activités culturelles

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
(https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/UseCase.png "Use case")

* Diagramme de classe
* Diagramme de classes
* Diagramme technique

diagramme package
diagramme classe

Merise: