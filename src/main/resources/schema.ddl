
    create table Contrat (
        id bigint not null auto_increment,
        codeIsin varchar(255),
        valeur bigint not null,
        proprietaire_id bigint,
        societe_id bigint,
        typeContrat_id bigint,
        primary key (id)
    );

    create table EtatTransaction (
        id bigint not null auto_increment,
        code varchar(255),
        primary key (id)
    );

    create table ModeNegociation (
        id bigint not null auto_increment,
        code varchar(255),
        primary key (id)
    );

    create table Societe (
        id bigint not null auto_increment,
        nom varchar(255),
        pays varchar(255),
        siren varchar(255),
        ville varchar(255),
        representant_id bigint,
        statut_id bigint,
        primary key (id)
    );

    create table Statut (
        id bigint not null auto_increment,
        code varchar(255),
        primary key (id)
    );

    create table Transaction (
        id bigint not null auto_increment,
        dateCloture datetime,
        dateDebut datetime,
        isActif bit not null,
        prixCloture bigint,
        prixOuverture bigint,
        prixTransaction bigint,
        quantite integer not null,
        acheteur_id bigint,
        etatTransaction_id bigint,
        modeNegociation_id bigint,
        titre_id bigint,
        typeTransaction_id bigint,
        vendeur_id bigint,
        primary key (id)
    );

    create table TypeContrat (
        id bigint not null auto_increment,
        code varchar(255),
        primary key (id)
    );

    create table TypeTransaction (
        id bigint not null auto_increment,
        code varchar(255),
        primary key (id)
    );

    create table User (
        TYPE_USER varchar(31) not null,
        id bigint not null auto_increment,
        actif bit,
        email varchar(50) not null,
        nom varchar(25),
        motdepasse varchar(20) not null,
        phone_number varchar(255),
        prenom varchar(50),
        role integer not null,
        emploi varchar(255),
        profilInvestisseur varchar(255),
        societe_id bigint,
        primary key (id)
    );

    alter table EtatTransaction 
        add constraint UK_9dmye668ubw05as0rdj47ts5u  unique (code);

    alter table ModeNegociation 
        add constraint UK_cigqi7yg2l9ljl22pd7t332kj  unique (code);

    alter table Societe 
        add constraint UK_391dnhb1ngw6bl3lc6w77grus  unique (siren);

    alter table Statut 
        add constraint UK_tbaeqhr2bcy0vm2phj0319lpw  unique (code);

    alter table TypeContrat 
        add constraint UK_1vtqdgch0r1pcdva9dr1b4hja  unique (code);

    alter table TypeTransaction 
        add constraint UK_54lwku25xff13uy6fx4equlyn  unique (code);

    alter table User 
        add constraint UK_e6gkqunxajvyxl5uctpl2vl2p  unique (email);

    alter table Contrat 
        add constraint FK_5mqjy6schgtcxwf2k8sry6l7g 
        foreign key (proprietaire_id) 
        references User (id);

    alter table Contrat 
        add constraint FK_1br662tmx1am2pmhbc9mrrce8 
        foreign key (societe_id) 
        references Societe (id);

    alter table Contrat 
        add constraint FK_eo3a7gelepn9dbpifqkdpeh1j 
        foreign key (typeContrat_id) 
        references TypeContrat (id);

    alter table Societe 
        add constraint FK_flwcc395yqeufbrdaf7mp75tj 
        foreign key (representant_id) 
        references User (id);

    alter table Societe 
        add constraint FK_jy9kua55wdrdnhl3nvkupu2oi 
        foreign key (statut_id) 
        references Statut (id);

    alter table Transaction 
        add constraint FK_d4dwu63v267097kmuxf6b9ecd 
        foreign key (acheteur_id) 
        references User (id);

    alter table Transaction 
        add constraint FK_ostr9secwr3beq5bd8aksaom5 
        foreign key (etatTransaction_id) 
        references EtatTransaction (id);

    alter table Transaction 
        add constraint FK_a5g6afmuuduyqt6gk9i1t478w 
        foreign key (modeNegociation_id) 
        references ModeNegociation (id);

    alter table Transaction 
        add constraint FK_g483b4jbx0hvt2tr0gm3ix3gw 
        foreign key (titre_id) 
        references Contrat (id);

    alter table Transaction 
        add constraint FK_mti0xeyp21s04iqc8snugacg7 
        foreign key (typeTransaction_id) 
        references TypeTransaction (id);

    alter table Transaction 
        add constraint FK_fpxk7n1tf7t271jtn2gxyaql3 
        foreign key (vendeur_id) 
        references User (id);

    alter table User 
        add constraint FK_8pqcegnffo34a8l8n62wa3b7s 
        foreign key (societe_id) 
        references Societe (id);
