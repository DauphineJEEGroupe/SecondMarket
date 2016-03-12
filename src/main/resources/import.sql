-- You can use this file to load seed data into the database using SQL statements
insert into User (TYPE_USER, id, nom, prenom, email, motdepasse, emploi, phone_number, role, actif) values ('EMP',0, 'admin', 'admin', 'admin@secondMarket.com', 'admin','administrateur', '2125551212',1,1)
insert into Statut (id, code) values (0, 'REFERENCEE');
insert into Statut (id, code) values (1, 'ACCREDITEE');

insert into TypeContrat (id, code) values (0, 'ACTION');
insert into TypeContrat (id, code) values (1, 'STOCK_OPTION');
--insert into Societe (id, nom, siren, ville, pays, statut) values (0,'nom1','siren1','ville1','pays1',0);
--insert into Societe (id, nom, siren, ville, pays, statut) values (1,'nom2','siren2','ville2','pays2',1);