SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

CREATE DATABASE IF NOT EXISTS `secondmarket` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `secondmarket`;

CREATE TABLE IF NOT EXISTS `contrat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `codeIsin` varchar(255) DEFAULT NULL,
  `valeur` bigint(20) NOT NULL,
  `nbTitres` int(10) NOT NULL,
  `proprietaire_id` bigint(20) DEFAULT NULL,
  `societe_id` bigint(20) DEFAULT NULL,
  `typeContrat_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5mqjy6schgtcxwf2k8sry6l7g` (`proprietaire_id`),
  KEY `FK_1br662tmx1am2pmhbc9mrrce8` (`societe_id`),
  KEY `FK_eo3a7gelepn9dbpifqkdpeh1j` (`typeContrat_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=7 ;

CREATE TABLE IF NOT EXISTS `etattransaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_9dmye668ubw05as0rdj47ts5u` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

CREATE TABLE IF NOT EXISTS `modenegociation` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_cigqi7yg2l9ljl22pd7t332kj` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

CREATE TABLE IF NOT EXISTS `societe` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) DEFAULT NULL,
  `pays` varchar(255) DEFAULT NULL,
  `siren` varchar(255) DEFAULT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `representant_id` bigint(20) DEFAULT NULL,
  `statut_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_391dnhb1ngw6bl3lc6w77grus` (`siren`),
  KEY `FK_flwcc395yqeufbrdaf7mp75tj` (`representant_id`),
  KEY `FK_jy9kua55wdrdnhl3nvkupu2oi` (`statut_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

CREATE TABLE IF NOT EXISTS `statut` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_tbaeqhr2bcy0vm2phj0319lpw` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

CREATE TABLE IF NOT EXISTS `transaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `dateCloture` datetime DEFAULT NULL,
  `dateDebut` datetime DEFAULT NULL,
  `isActif` bit(1) NOT NULL,
  `prixCloture` bigint(20) DEFAULT NULL,
  `prixOuverture` bigint(20) DEFAULT NULL,
  `prixTransaction` bigint(20) DEFAULT NULL,
  `quantite` int(11) NOT NULL,
  `acheteur_id` bigint(20) DEFAULT NULL,
  `etatTransaction_id` bigint(20) DEFAULT NULL,
  `modeNegociation_id` bigint(20) DEFAULT NULL,
  `titre_id` bigint(20) DEFAULT NULL,
  `typeTransaction_id` bigint(20) DEFAULT NULL,
  `vendeur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_d4dwu63v267097kmuxf6b9ecd` (`acheteur_id`),
  KEY `FK_ostr9secwr3beq5bd8aksaom5` (`etatTransaction_id`),
  KEY `FK_a5g6afmuuduyqt6gk9i1t478w` (`modeNegociation_id`),
  KEY `FK_g483b4jbx0hvt2tr0gm3ix3gw` (`titre_id`),
  KEY `FK_mti0xeyp21s04iqc8snugacg7` (`typeTransaction_id`),
  KEY `FK_fpxk7n1tf7t271jtn2gxyaql3` (`vendeur_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

CREATE TABLE IF NOT EXISTS `typecontrat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_1vtqdgch0r1pcdva9dr1b4hja` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

CREATE TABLE IF NOT EXISTS `typetransaction` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_54lwku25xff13uy6fx4equlyn` (`code`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

CREATE TABLE IF NOT EXISTS `user` (
  `TYPE_USER` varchar(31) NOT NULL,
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actif` bit(1) DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `motdepasse` varchar(20) NOT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `prenom` varchar(50) DEFAULT NULL,
  `role` int(11) NOT NULL,
  `emploi` varchar(255) DEFAULT NULL,
  `profilInvestisseur` varchar(255) DEFAULT NULL,
  `societe_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_e6gkqunxajvyxl5uctpl2vl2p` (`email`),
  KEY `FK_8pqcegnffo34a8l8n62wa3b7s` (`societe_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;


ALTER TABLE `contrat`
  ADD CONSTRAINT `FK_1br662tmx1am2pmhbc9mrrce8` FOREIGN KEY (`societe_id`) REFERENCES `societe` (`id`),
  ADD CONSTRAINT `FK_5mqjy6schgtcxwf2k8sry6l7g` FOREIGN KEY (`proprietaire_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_eo3a7gelepn9dbpifqkdpeh1j` FOREIGN KEY (`typeContrat_id`) REFERENCES `typecontrat` (`id`);

ALTER TABLE `societe`
  ADD CONSTRAINT `FK_flwcc395yqeufbrdaf7mp75tj` FOREIGN KEY (`representant_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_jy9kua55wdrdnhl3nvkupu2oi` FOREIGN KEY (`statut_id`) REFERENCES `statut` (`id`);

ALTER TABLE `transaction`
  ADD CONSTRAINT `FK_a5g6afmuuduyqt6gk9i1t478w` FOREIGN KEY (`modeNegociation_id`) REFERENCES `modenegociation` (`id`),
  ADD CONSTRAINT `FK_d4dwu63v267097kmuxf6b9ecd` FOREIGN KEY (`acheteur_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_fpxk7n1tf7t271jtn2gxyaql3` FOREIGN KEY (`vendeur_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FK_g483b4jbx0hvt2tr0gm3ix3gw` FOREIGN KEY (`titre_id`) REFERENCES `contrat` (`id`),
  ADD CONSTRAINT `FK_mti0xeyp21s04iqc8snugacg7` FOREIGN KEY (`typeTransaction_id`) REFERENCES `typetransaction` (`id`),
  ADD CONSTRAINT `FK_ostr9secwr3beq5bd8aksaom5` FOREIGN KEY (`etatTransaction_id`) REFERENCES `etattransaction` (`id`);

ALTER TABLE `user`
  ADD CONSTRAINT `FK_8pqcegnffo34a8l8n62wa3b7s` FOREIGN KEY (`societe_id`) REFERENCES `societe` (`id`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
