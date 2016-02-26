# m1c20152016-mobonline
Dépôt de Bruno Veraldi, Adrien Dos Santos, Florian Roy

# Application WEB

## Principe

L'application Web à pour but de permettre aux administrateurs des différentes facultés de créer du contenu pour l'application mobile.
L'application fournit aussi un webservice permettant aux applications mobile d'intéragir avec la BDD via des servlets (accès non direct à la base, donc plus sécurisé).

Exemple de JSON sorti par le webservice pour l'url "http://localhost:8080/NanterasmusWEB/REST/university/pages/enfants.json?university=1&cat_parent=1":

{
	"categories":[
		{
			"pages":
			[
				{
					"page_id":1,
					"page_title":"Administrative Register",
					"page_content":"The place to be"
				},
				{
					"page_id":3,
					"page_title":"Pedagogical Registration ",
					"page_content":"Choose your courses"
				}
			],
			"cat_name":"Inscription",
			"cat_id":2
		},
		{
			"pages":
			[
				{
					"page_id":2,
					"page_title":"Teaching Registration",
					"page_content":"You need to have"
				}
			],
			"cat_name":"ScholarShip",
			"cat_id":3
		}
	],
	"status":true
}

## Installation :

Vous devrez installer maven et executer la commande :
mvn install:install-file -Dfile={Path/to/your/ojdbc.jar} -DgroupId=com.oracle 
-DartifactId=ojdbc6 -Dversion=11.2.0 -Dpackaging=jar

Comme dit dans le tuto : <http://www.mkyong.com/maven/how-to-add-oracle-jdbc-driver-in-your-maven-local-repository>
