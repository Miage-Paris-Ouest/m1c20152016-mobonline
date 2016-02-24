/* 
* Insertion des status des utilisateurs 
*/
INSERT INTO M1_STATUS VALUES(1,'Super Admin');
INSERT INTO M1_STATUS VALUES(2,'Admin');
INSERT INTO M1_STATUS VALUES(3,'Student');
INSERT INTO M1_STATUS VALUES(4,'Contact');

/* 
* Insertion des universités 
*/
INSERT INTO M1_UNIVERSITIES VALUES(1,'Université Paris Ouest Nanterre La Défense','200 Avenue de la République','http://www.u-paris10.fr/',3715);

/* 
* Insertion des personnes
*/
INSERT INTO M1_PERSONS VALUES(1,'Florian','Roy','florianroy@laposte.net','+33659853307',1,1);
INSERT INTO M1_PERSONS VALUES(2,'Bruno','Veraldi','bruno.veraldi@gmail.com','+33658018622',1,1);
INSERT INTO M1_PERSONS VALUES(3,'Adrien','Dos Santos','adriendossantos29@gmail.com','+33675290100',1,1);

/* 
* Création des status des utilisateurs des applications (mobile + web)
*/
INSERT INTO M1_USERS VALUES(1,'flo','flo123',1);
INSERT INTO M1_USERS VALUES(2,'bru','bruno123',2);
INSERT INTO M1_USERS VALUES(3,'adri','adrien123',3);

/* 
* Insertion des types de batîments
*/
INSERT INTO M1_BUILDING_TYPES VALUES(1,'Housing');
INSERT INTO M1_BUILDING_TYPES VALUES(2,'Station');
INSERT INTO M1_BUILDING_TYPES VALUES(3,'Restoration');
INSERT INTO M1_BUILDING_TYPES VALUES(4,'Sports Complex');
INSERT INTO M1_BUILDING_TYPES VALUES(5,'Medical Center');
INSERT INTO M1_BUILDING_TYPES VALUES(6,'Library');
INSERT INTO M1_BUILDING_TYPES VALUES(7,'Administration');


/* 
* Insertion des types de batîments
*/
INSERT INTO M1_BUILDINGS VALUES(1,'University Library','Bibliothèque Universitaire of Nanterre,\nWith much than 450 000 books which 80 % are in free access to read, Nanterre is one of the biggest île de France BU.',48.905279299779636, 2.215743468215919,1,6);
INSERT INTO M1_BUILDINGS VALUES(2,'Nanterre Université Station','Great Station desserved by RER A and Train L.', 48.90158384898947, 2.215217755249,1,2);
INSERT INTO M1_BUILDINGS VALUES(3,'Main Sports Complex','Swimming Pool, Badbinton court, Musculation machines all is there !', 48.903918220875866, 2.2132114629058606,1,4);
INSERT INTO M1_BUILDINGS VALUES(4,'University Residence','You can sleep here for not too much Money. \nThere are 770 rooms ...', 48.905787173863516, 2.212728770595504,1,1);

/* 
* Insertion des prix des produits
*/
INSERT INTO M1_PRODUCT_PRICES VALUES(1, 230, '€');
INSERT INTO M1_PRODUCT_PRICES VALUES(2, 225, '€');

/* 
* Insertion des produits
*/
INSERT INTO M1_PRODUCTS VALUES(1,'Student''s Room','Student take a Room in a calm place !');
INSERT INTO M1_PRODUCTS VALUES(2,'Student''s double Room','Students take a Room for 2 persons in a calm place !');

/* 
* Insertion des disponibilités des produits aux différents prix dans les différents batiments
*/
INSERT INTO M1_DISPONIBIITIES VALUES(1,4,1);
INSERT INTO M1_DISPONIBIITIES VALUES(2,4,2);

/* 
* Insertion des Catégories de pages
*/
INSERT INTO M1_CATEGORIES VALUES(1,'How To',0);
INSERT INTO M1_CATEGORIES VALUES(2,'To Do List',0);
INSERT INTO M1_CATEGORIES VALUES(3,'Culture',0);
INSERT INTO M1_CATEGORIES VALUES(4,'Map',0);
INSERT INTO M1_CATEGORIES VALUES(5,'Contact',0);
INSERT INTO M1_CATEGORIES VALUES(6,'Learning',0);
INSERT INTO M1_CATEGORIES VALUES(7,'Inscription',1);
INSERT INTO M1_CATEGORIES VALUES(8,'ScholarShip',1);

INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (1,1,1);
INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (2,1,7);
INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (3,1,8);
INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (4,1,2);
INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (5,1,3);
INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (6,1,4);
INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (7,1,5);
INSERT INTO M1_CATEGORIES_UNIVERSITY VALUES (8,1,6);

INSERT INTO M1_PAGES (PAGE_ID, PAGE_TITLE, PAGE_CONTENT, PAGE_CAT_UNIV_ID) VALUES (1,'Administrative Register','The place to be',2);
INSERT INTO M1_PAGES (PAGE_ID, PAGE_TITLE, PAGE_CONTENT, PAGE_CAT_UNIV_ID) VALUES(2,'Teaching Registration','You need to have',3);

SELECT * FROM M1_UNIVERSITIES;

SELECT * FROM M1_CATEGORIES CAT, M1_CATEGORIES_UNIVERSITY CU
  WHERE CAT.CATEGORY_ID=CU.PAGE_CATEGORY AND CAT.CATEGORY_PARENT=0 AND CU.UNIVERSITY=1;

SELECT * FROM M1_PAGES PAGE, M1_CATEGORIES CAT
  WHERE CAT.CATEGORY_ID=PAGE.PAGE_CATEGORY AND CAT.CATEGORY_PARENT=0 AND PAGE.UNIVERSITY=1;