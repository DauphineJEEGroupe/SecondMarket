-- You can use this file to load seed data into the database using SQL statements
insert into Member (id, name, email, phone_number) values (0, 'John Smith', 'john.smith@mailinator.com', '2125551212')
insert into Statut (id, nom) values (0, 'REFERENCEE');
insert into Statut (id, nom) values (1, 'ACCREDITEE');
insert into Societe (id, nom, siren, ville, pays, statut) values (0,'nom1','siren1','ville1','pays1',0);
insert into Societe (id, nom, siren, ville, pays, statut) values (1,'nom2','siren2','ville2','pays2',1);