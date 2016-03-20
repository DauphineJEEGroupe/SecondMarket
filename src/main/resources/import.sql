-- You can use this file to load seed data into the database using SQL statements
insert into User (TYPE_USER, nom, prenom, email, motdepasse, emploi, phone_number, role, actif) values ('EMP', 'admin', 'admin', 'admin@secondMarket.com', 'admin','administrateur', '2125551212',1,1)
insert into Statut ( code) values ('REFERENCEE');
insert into Statut ( code) values ('ACCREDITEE');

insert into TypeContrat ( code) values ('ACTION');
insert into TypeContrat ( code) values ('STOCK_OPTION');
insert into Societe (nom, siren, ville, pays, statut_id) values ('Societe1','siren1','ville1','pays1',1);
insert into Societe (nom, siren, ville, pays, statut_id) values ('Societe2','siren2','ville2','pays2',1);