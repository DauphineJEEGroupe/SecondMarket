SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--CREATE DATABASE IF NOT EXISTS `secondmarket` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `secondmarket`;

TRUNCATE TABLE `user`;
INSERT INTO `user` (`TYPE_USER`, `id`, `actif`, `email`, `nom`, `motdepasse`, `phone_number`, `prenom`, `role`, `emploi`, `profilInvestisseur`, `societe_id`) VALUES('EMP', 1, b'1', 'admin@secondMarket.com', 'admin', 'admin', '2125551212', 'admin', 1, 'administrateur', NULL, NULL);
INSERT INTO `user` (`TYPE_USER`, `id`, `actif`, `email`, `nom`, `motdepasse`, `phone_number`, `prenom`, `role`, `emploi`, `profilInvestisseur`, `societe_id`) VALUES('INV', 2, b'1', 'investisseur@secondMarket.com', 'investisseur', 'investisseur', '2125551212', 'investisseur', 2, 'investisseur', 'risqué', NULL);
INSERT INTO `user` (`TYPE_USER`, `id`, `actif`, `email`, `nom`, `motdepasse`, `phone_number`, `prenom`, `role`, `emploi`, `profilInvestisseur`, `societe_id`) VALUES('INV', 3, b'1', 'barou2000@hotmail.com', 'barou', 'newUser.set', '0681331615', 'barou', 2, NULL, '', NULL);
INSERT INTO `user` (`TYPE_USER`, `id`, `actif`, `email`, `nom`, `motdepasse`, `phone_number`, `prenom`, `role`, `emploi`, `profilInvestisseur`, `societe_id`) VALUES('INV', 4, b'1', 'barou2000@sm.com', 'barou', 'barou2000', '0681331615', 'barou', 2, NULL, '', NULL);
SET FOREIGN_KEY_CHECKS=1;


TRUNCATE TABLE `etattransaction`;
INSERT INTO `etattransaction` (`id`, `code`) VALUES(3, 'ANNULEE');
INSERT INTO `etattransaction` (`id`, `code`) VALUES(2, 'FERMEE');
INSERT INTO `etattransaction` (`id`, `code`) VALUES(1, 'OUVERTE');

TRUNCATE TABLE `modenegociation`;
INSERT INTO `modenegociation` (`id`, `code`) VALUES(2, 'ENCHERE');
INSERT INTO `modenegociation` (`id`, `code`) VALUES(1, 'IMMEDIAT');

TRUNCATE TABLE `statut`;
INSERT INTO `statut` (`id`, `code`) VALUES(2, 'ACCREDITEE');
INSERT INTO `statut` (`id`, `code`) VALUES(1, 'REFERENCEE');


TRUNCATE TABLE `typecontrat`;
INSERT INTO `typecontrat` (`id`, `code`) VALUES(1, 'ACTION');
INSERT INTO `typecontrat` (`id`, `code`) VALUES(2, 'STOCK_OPTION');

TRUNCATE TABLE `typetransaction`;
INSERT INTO `typetransaction` (`id`, `code`) VALUES(1, 'ACHAT');
INSERT INTO `typetransaction` (`id`, `code`) VALUES(2, 'VENTE');


TRUNCATE TABLE `societe`;
INSERT INTO `societe` (`id`, `nom`, `pays`, `siren`, `ville`, `representant_id`, `statut_id`) VALUES(1, 'Societe1', 'pays1', 'siren1', 'ville1', NULL, 1);
INSERT INTO `societe` (`id`, `nom`, `pays`, `siren`, `ville`, `representant_id`, `statut_id`) VALUES(2, 'Societe2', 'pays2', 'siren2', 'ville2', NULL, 1);

TRUNCATE TABLE `contrat`;
INSERT INTO `contrat` (`id`, `codeIsin`, `valeur`, `nbTitres`, `proprietaire_id`, `societe_id`, `typeContrat_id`) VALUES(1, 'FR0000130809SOC', 5500, 100, 2, 1, 1);
INSERT INTO `contrat` (`id`, `codeIsin`, `valeur`, `nbTitres`, `proprietaire_id`, `societe_id`, `typeContrat_id`) VALUES(2, 'FR0000140809SOC', 5500, 200, 2, 2, 1);
INSERT INTO `contrat` (`id`, `codeIsin`, `valeur`, `nbTitres`, `proprietaire_id`, `societe_id`, `typeContrat_id`) VALUES(3, 'lfhhz234kdhsklg87', 12324, 25, 2, 1, 1);
INSERT INTO `contrat` (`id`, `codeIsin`, `valeur`, `nbTitres`, `proprietaire_id`, `societe_id`, `typeContrat_id`) VALUES(4, 'lfhhz234kdhskdqq34', 2345, 28, 2, 1, 1);
INSERT INTO `contrat` (`id`, `codeIsin`, `valeur`, `nbTitres`, `proprietaire_id`, `societe_id`, `typeContrat_id`) VALUES(5, 'lfhhz234kdhsklged', 51, 17, 2, 2, 2);
INSERT INTO `contrat` (`id`, `codeIsin`, `valeur`, `nbTitres`, `proprietaire_id`, `societe_id`, `typeContrat_id`) VALUES(6, 'lfhhz234kdhsfs34', 49, 46, 4, 1, 1);

TRUNCATE TABLE `transaction`;
INSERT INTO `transaction` (`id`, `dateCloture`, `dateDebut`, `isActif`, `prixCloture`, `prixOuverture`, `prixTransaction`, `quantite`, `acheteur_id`, `etatTransaction_id`, `modeNegociation_id`, `titre_id`, `typeTransaction_id`, `vendeur_id`) VALUES(1, '2016-04-15 00:00:00', '2016-03-25 13:47:27', b'1', 40, 16, 360, 9, 4, 1, 2, 3, 2, 2);


COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
