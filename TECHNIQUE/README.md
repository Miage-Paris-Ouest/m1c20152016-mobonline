[![Build Status](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline.svg?branch=master)](https://travis-ci.org/Miage-Paris-Ouest/m1c20152016-mobonline)
[![Build Status](https://www.bitrise.io/app/7cc3309433bce2bd.svg?token=WaGTybCNGhSIs-4xaGABSQ&branch=master)](https://www.bitrise.io/app/7cc3309433bce2bd)
# m1c20152016-mobonline
D�p�t de Bruno Veraldi, Adrien Dos Santos, Florian Roy


## Les sp�cifications Techniques:

Notre application Nanterasmus, est une application mobile fonctionnant sous android.
Une application web d'administration sera d�velopp�e afin de permettre aux universit�s de proposer du contenu dynamique aux �tudiants en Erasmus.
L'application Web fournit aussi des webservices permettant � l'application d'avoir des donn�es dynamiques cherch�es dans une base qui est requ�t�e par le serveur.

Dans l'objectif de d�velopper ces applications nous avons utilis�s les environnements suivants:

### Environnement de d�veloppement:
* Utilisation du JAVA pour le d�veloppement de l�application sous android.
* Utilisation de JAVA WEB pour le serveur et la partie administration

l�impl�mentation des diff�rentes fonctionnalit� se fera par la cr�ation d�activit�s. Ces activit�s r�colterons les informations en base via des requ�tes HTTP (via une API de type REST).

### Environnement mat�riel :
**Ordinateurs utilis�s :**
* 3 Ordinateurs windows 8 et 10

**Smartphones physiques de tests :**
* Samsung Galaxy S5
* Samsung Grand Prime

### Environnement logiciel, outils et ressources :

**UML :** 
* PlantUML
Afin de cr�er les diff�rents diagramme (exemple: le diagramme de cas d'utilisation)

Prototypage et maquette :
Cr�ation du prototype de l'application repr�sentant les diff�rentes vues de l'application
* Justinmind *(logiciel libre de droit)*

**Serveur :**
* Base de donn�es :
	Oracle
* Apache
* Conteneur WEB (pour faire tourner les Servlets Java) :  
	- GlassFish Server  

**IDE :**
* Android Studio pour l'application mobile
* Netbeans pour l'application web d'administration

**Frameworks / API utilis�s :**
* Pour le site web:  
	- Struts un framework MVC pour les applications Web Java.  
	- BootStrap un framework pour rendre responsive simplement une application Web, via du HTML5/CSS3 et JS.

**Versionning :**
* Github
Service d'h�bergement et de gestion de d�veloppement.

* Git
Logiciel de gestion de versions.

**Bureautique :**
* Notepad++
Pour la r�daction des README.md et la modification

* Microsoft Office (picture manager, word)
Pour la correction des documents textes

**Graphique :**
Pour la cr�ation et modification des ressources graphiques nous avons utilis�s les outils suivants :

* Gimp *(logiciel libre de droit)*
* Paint
* Microsoft Office Picture Manager

* Diagramme de s�quences

|StudentSequence|NanterreUniversityAdmin|UniversityAdmin|
|:---:|:---:|:---:|
|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/Sequence/StudentSequence.png "StudentSequence")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/Sequence/NanterreUniversityAdmin.png "NanterreUniversityAdmin")|![alt text](https://github.com/Miage-Paris-Ouest/m1c20152016-mobonline/blob/master/diagrams/Sequence/UniversityAdmin.png "UniversityAdmin")|

