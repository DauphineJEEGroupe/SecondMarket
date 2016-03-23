-- You can use this file to load seed data into the database using SQL statements
insert into User (TYPE_USER, nom, prenom, email, motdepasse, emploi, phone_number, role, actif) values ('EMP', 'admin', 'admin', 'admin@secondMarket.com', 'admin','administrateur', '2125551212',1,1)
insert into User (TYPE_USER, nom, prenom, email, motdepasse, emploi, phone_number, role, actif, profilInvestisseur) values ('INV', 'investisseur', 'investisseur', 'investisseur@secondMarket.com', 'investisseur','investisseur', '2125551212',2,1,'risqué')
insert into Statut ( code) values ('REFERENCEE');
insert into Statut ( code) values ('ACCREDITEE');

insert into TypeContrat ( code) values ('ACTION');
insert into TypeContrat ( code) values ('STOCK_OPTION');

insert into modenegociation ( code) values ('IMMEDIAT');
insert into modenegociation ( code) values ('ENCHERE');

insert into etattransaction ( code) values ('OUVERTE');
insert into etattransaction ( code) values ('FERMEE');
insert into etattransaction ( code) values ('ANNULEE');

insert into typetransaction ( code) values ('ACHAT');
insert into typetransaction ( code) values ('VENTE');

insert into Societe (nom, siren, ville, pays, statut_id) values ('Societe1','siren1','ville1','pays1',1);
insert into Societe (nom, siren, ville, pays, statut_id) values ('Societe2','siren2','ville2','pays2',1);

insert into contrat (codeIsin, typeContrat_id, societe_id, proprietaire_id,valeur,nbTitres) values ('FR0000130809SOC',1,1,2,5500,200);
insert into contrat (codeIsin, typeContrat_id, societe_id, proprietaire_id,valeur,nbTitres) values ('FR0000140809SOC',1,2,2,5500,100);
