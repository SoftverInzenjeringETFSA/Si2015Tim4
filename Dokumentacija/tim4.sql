-- phpMyAdmin SQL Dump
-- version 4.5.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 11, 2016 at 01:09 PM
-- Server version: 5.7.12-log
-- PHP Version: 5.6.16

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tim4`
--
CREATE SCHEMA IF NOT EXISTS `tim4` DEFAULT CHARACTER SET utf8 ;
USE `tim4`;

-- --------------------------------------------------------

--
-- Table structure for table `artikal`
--

DROP TABLE IF EXISTS `tim4`.`artikal`;
CREATE TABLE IF NOT EXISTS `tim4`.`artikal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `barkod` varchar(255) DEFAULT NULL,
  `cijena` double DEFAULT NULL,
  `kolicina` double DEFAULT NULL,
  `mjera` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `klasa_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_h4rm0wfljpg90yrhwn389kckb` (`klasa_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `artikal`
--

INSERT INTO `artikal` (`id`, `barkod`, `cijena`, `kolicina`, `mjera`, `naziv`, `klasa_id`) VALUES
(1, '3', 3, 3, 'komad', 'vato', 3),
(2, '3', 3, 3, 'komad', 'vato', 3);

-- --------------------------------------------------------

--
-- Table structure for table `inventura`
--

DROP TABLE IF EXISTS `tim4`.`inventura`;
CREATE TABLE IF NOT EXISTS `tim4`.`inventura` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datum` datetime DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `trenutnoStanje` int(11) NOT NULL,
  `skladistar_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_5ymtyqqhrq6vquko69qcv9c80` (`skladistar_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventura`
--

INSERT INTO `inventura` (`id`, `datum`, `opis`, `trenutnoStanje`, `skladistar_id`) VALUES
(1, NULL, NULL, 0, NULL),
(2, NULL, NULL, 0, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `izvjestaj`
--

DROP TABLE IF EXISTS `tim4`.`izvjestaj`;
CREATE TABLE IF NOT EXISTS `tim4`.`izvjestaj` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Datum` datetime DEFAULT NULL,
  `Opis` varchar(255) DEFAULT NULL,
  `Vrsta` varchar(255) DEFAULT NULL,
  `i` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `izvjestaj`
--

INSERT INTO `izvjestaj` (`id`, `Datum`, `Opis`, `Vrsta`, `i`) VALUES
(1, NULL, '', '', 0),
(2, NULL, '', '', 0);

-- --------------------------------------------------------

--
-- Table structure for table `klasaartikla`
--

DROP TABLE IF EXISTS `tim4`.`klasaartikla`;
CREATE TABLE IF NOT EXISTS `tim4`.`klasaartikla` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `klasaartikla`
--

INSERT INTO `klasaartikla` (`id`, `naziv`) VALUES
(3, 'hahahah'),
(5, ''),
(6, 'sdss'),
(7, '');

-- --------------------------------------------------------

--
-- Table structure for table `klasaartikla_artikal`
--

DROP TABLE IF EXISTS `tim4`.`klasaartikla_artikal`;
CREATE TABLE IF NOT EXISTS `tim4`.`klasaartikla_artikal` (
  `KlasaArtikla_id` bigint(20) NOT NULL,
  `artikli_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_47d56uflgn0uwtofy39l61t1v` (`artikli_id`),
  KEY `FK_g9gphetcf8np48b0q3vrs9rwq` (`KlasaArtikla_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `skladiste`
--

DROP TABLE IF EXISTS `tim4`.`skladiste`;
CREATE TABLE IF NOT EXISTS `tim4`.`skladiste` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `lokacija` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `sef_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_eleya81fbyedrfe0itlkgkips` (`sef_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skladiste`
--

INSERT INTO `skladiste` (`id`, `lokacija`, `naziv`, `sef_id`) VALUES
(1, NULL, NULL, 2),
(2, NULL, NULL, 5);

-- --------------------------------------------------------

--
-- Table structure for table `skladiste_artikal`
--

DROP TABLE IF EXISTS `tim4`.`skladiste_artikal`;
CREATE TABLE IF NOT EXISTS `tim4`.`skladiste_artikal` (
  `Skladiste_id` bigint(20) NOT NULL,
  `artikli_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_dv12hbuujr8rsb8obf035s83l` (`artikli_id`),
  KEY `FK_ert5uf7diacixm9xwu35wureb` (`Skladiste_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `skladiste_tipzaposlenika`
--

DROP TABLE IF EXISTS `tim4`.`skladiste_tipzaposlenika`;
CREATE TABLE IF NOT EXISTS `tim4`.`skladiste_tipzaposlenika` (
  `Skladiste_id` bigint(20) NOT NULL,
  `skladistari_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_1gxtx00veg0o3899wa1drt9u0` (`skladistari_id`),
  KEY `FK_sb2scgq6e3a40fp9f8ek9osrc` (`Skladiste_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `stanjeinventure`
--

DROP TABLE IF EXISTS `tim4`.`stanjeinventure`;
CREATE TABLE IF NOT EXISTS `tim4`.`stanjeinventure` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `stanje` int(11) NOT NULL,
  `inventura_id` bigint(20) DEFAULT NULL,
  `izvjestaj_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_7emq8pueclajvawrrewclgu3k` (`inventura_id`),
  KEY `FK_qku86lx2w12o9wvosqoxc8qrg` (`izvjestaj_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `stanjeinventure`
--

INSERT INTO `stanjeinventure` (`id`, `stanje`, `inventura_id`, `izvjestaj_id`) VALUES
(1, 0, 1, 1),
(2, 0, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `tipzaposlenika`
--

DROP TABLE IF EXISTS `tim4`.`tipzaposlenika`;
CREATE TABLE IF NOT EXISTS `tim4`.`tipzaposlenika` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(255) DEFAULT NULL,
  `brojTel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `jmbg` varchar(255) DEFAULT NULL,
  `korisnickoIme` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `privilegija` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipzaposlenika`
--

INSERT INTO `tipzaposlenika` (`id`, `adresa`, `brojTel`, `email`, `ime`, `jmbg`, `korisnickoIme`, `lozinka`, `prezime`, `privilegija`) VALUES
(2, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(8, 'sd', '90909', 'dsds', 'dacxzcxz', '2222', 'dsds', 'dsdsd', 'asd', 'Skladistar');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `artikal`
--
ALTER TABLE `artikal`
  ADD CONSTRAINT `FK_h4rm0wfljpg90yrhwn389kckb` FOREIGN KEY (`klasa_id`) REFERENCES `klasaartikla` (`id`);

--
-- Constraints for table `inventura`
--
ALTER TABLE `inventura`
  ADD CONSTRAINT `FK_5ymtyqqhrq6vquko69qcv9c80` FOREIGN KEY (`skladistar_id`) REFERENCES `tipzaposlenika` (`id`);

--
-- Constraints for table `klasaartikla_artikal`
--
ALTER TABLE `klasaartikla_artikal`
  ADD CONSTRAINT `FK_47d56uflgn0uwtofy39l61t1v` FOREIGN KEY (`artikli_id`) REFERENCES `artikal` (`id`),
  ADD CONSTRAINT `FK_g9gphetcf8np48b0q3vrs9rwq` FOREIGN KEY (`KlasaArtikla_id`) REFERENCES `klasaartikla` (`id`);

--
-- Constraints for table `skladiste`
--
ALTER TABLE `skladiste`
  ADD CONSTRAINT `FK_eleya81fbyedrfe0itlkgkips` FOREIGN KEY (`sef_id`) REFERENCES `tipzaposlenika` (`id`);

--
-- Constraints for table `skladiste_artikal`
--
ALTER TABLE `skladiste_artikal`
  ADD CONSTRAINT `FK_dv12hbuujr8rsb8obf035s83l` FOREIGN KEY (`artikli_id`) REFERENCES `artikal` (`id`),
  ADD CONSTRAINT `FK_ert5uf7diacixm9xwu35wureb` FOREIGN KEY (`Skladiste_id`) REFERENCES `skladiste` (`id`);

--
-- Constraints for table `skladiste_tipzaposlenika`
--
ALTER TABLE `skladiste_tipzaposlenika`
  ADD CONSTRAINT `FK_1gxtx00veg0o3899wa1drt9u0` FOREIGN KEY (`skladistari_id`) REFERENCES `tipzaposlenika` (`id`),
  ADD CONSTRAINT `FK_sb2scgq6e3a40fp9f8ek9osrc` FOREIGN KEY (`Skladiste_id`) REFERENCES `skladiste` (`id`);

--
-- Constraints for table `stanjeinventure`
--
ALTER TABLE `stanjeinventure`
  ADD CONSTRAINT `FK_7emq8pueclajvawrrewclgu3k` FOREIGN KEY (`inventura_id`) REFERENCES `inventura` (`id`),
  ADD CONSTRAINT `FK_qku86lx2w12o9wvosqoxc8qrg` FOREIGN KEY (`izvjestaj_id`) REFERENCES `izvjestaj` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
