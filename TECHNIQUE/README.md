[![Build Status](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline.svg?branch=master)](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline)
[![Build Status](https://www.bitrise.io/app/7cc3309433bce2bd.svg?token=WaGTybCNGhSIs-4xaGABSQ&branch=master)](https://www.bitrise.io/app/7cc3309433bce2bd)
# m1c20152016-mobonline
Dépôt de Bruno Veraldi, Adrien Dos Santos, Florian Roy


## Les spécifications Techniques:

Notre application Nanterasmus, est une application mobile fonctionnant sous android.
Une application web d'administration sera développée afin de permettre aux universités de proposer du contenu dynamique aux étudiants en Erasmus.
L'application Web fournit aussi des webservices permettant à l'application d'avoir des données dynamiques cherchées dans une base qui est requêtée par le serveur.

Dans l'objectif de développer ces applications nous avons utilisés les environnements suivants:

### Environnement de développement:
* Utilisation du JAVA pour le développement de l’application sous android.
* Utilisation de JAVA WEB pour le serveur et la partie administration

l’implémentation des différentes fonctionnalité se fera par la création d’activités. Ces activités récolterons les informations en base via des requêtes HTTP (via une API de type REST).

### Environnement matériel :
**Ordinateurs utilisés :**
* 3 Ordinateurs windows 8 et 10

**Smartphones physiques de tests :**
* Samsung Galaxy S5
* Samsung Grand Prime

### Environnement logiciel, outils et ressources :

**UML :** 
* PlantUML
Afin de créer les différents diagramme (exemple: le diagramme de cas d'utilisation)

Prototypage et maquette :
Création du prototype de l'application représentant les différentes vues de l'application
* Justinmind *(logiciel libre de droit)*

**Serveur :**
* Base de données :
	Oracle
* Apache
* Conteneur WEB (pour faire tourner les Servlets Java) :  
	- GlassFish Server  

**IDE :**
* Android Studio pour l'application mobile
* Netbeans pour l'application web d'administration

**Frameworks / API utilisés :**
* Pour le site web:  
	- Struts un framework MVC pour les applications Web Java.  
	- BootStrap un framework pour rendre responsive simplement une application Web, via du HTML5/CSS3 et JS.

**Versionning :**
* Github
Service d'hébergement et de gestion de développement.

* Git
Logiciel de gestion de versions.

**Bureautique :**
* Notepad++
Pour la rédaction des README.md et la modification

* Microsoft Office (picture manager, word)
Pour la correction des documents textes

**Graphique :**
Pour la création et modification des ressources graphiques nous avons utilisés les outils suivants :

* Gimp *(logiciel libre de droit)*
* Paint
* Microsoft Office Picture Manager

* Diagramme de séquences

|StudentSequence|NanterreUniversityAdmin|UniversityAdmin|
|:---:|:---:|:---:|
|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/Sequence/StudentSequence.png "StudentSequence")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/Sequence/NanterreUniversityAdmin.png "NanterreUniversityAdmin")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/Sequence/UniversityAdmin.png "UniversityAdmin")|

