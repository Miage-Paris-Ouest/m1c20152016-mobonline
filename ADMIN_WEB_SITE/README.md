# m1c20152016-mobonline
D�p�t de Bruno Veraldi, Adrien Dos Santos, Florian Roy

# Application WEB

L'application Web � pour but de permettre aux administrateurs des diff�rentes facult�s de cr�er du contenu pour l'application mobile.
L'application fournit aussi un webservice permettant aux applications mobile d'int�ragir avec la BDD via des servlets (acc�s non direct � la base, donc plus s�curis�).

Exemple de JSON sorti par le webservice pour l'url "http://localhost:8080/NanterasmusWEB/REST/university/pages/enfants.json?university=1&cat_parent=1":
**{
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
}**