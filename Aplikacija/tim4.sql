-- phpMyAdmin SQL Dump
-- version 4.5.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 23, 2016 at 10:33 PM
-- Server version: 5.7.11
-- PHP Version: 5.6.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tim4`
--

-- --------------------------------------------------------

--
-- Table structure for table `artikal`
--

CREATE TABLE `artikal` (
  `id` bigint(20) NOT NULL,
  `barkod` varchar(255) DEFAULT NULL,
  `cijena` double DEFAULT NULL,
  `kolicina` double DEFAULT NULL,
  `mjera` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `klasa_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `artikal`
--

INSERT INTO `artikal` (`id`, `barkod`, `cijena`, `kolicina`, `mjera`, `naziv`, `klasa_id`) VALUES
(1, '0000000000001', 3, 50, 'kg', 'Jabuke', 9),
(2, '0000000000002', 2.5, 70, 'kg', 'Kruske', 9);

-- --------------------------------------------------------

--
-- Table structure for table `inventura`
--

CREATE TABLE `inventura` (
  `id` bigint(20) NOT NULL,
  `datum` datetime DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `trenutnoStanje` int(11) NOT NULL,
  `skladistar_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `inventura`
--

INSERT INTO `inventura` (`id`, `datum`, `opis`, `trenutnoStanje`, `skladistar_id`) VALUES
(5, '2016-05-18 14:45:30', 'ProbnaInventura', 4, 10),
(7, '2016-05-18 15:27:55', 'ProbnaInventura2', 200, 10),
(9, '2016-05-18 15:42:11', 'coko manja 20\nslatkis viska 29', -72, 10);

-- --------------------------------------------------------

--
-- Table structure for table `izvjestaj`
--

CREATE TABLE `izvjestaj` (
  `id` bigint(20) NOT NULL,
  `Datum` datetime DEFAULT NULL,
  `Opis` varchar(255) DEFAULT NULL,
  `Vrsta` varchar(255) DEFAULT NULL,
  `i` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `izvjestaj`
--

INSERT INTO `izvjestaj` (`id`, `Datum`, `Opis`, `Vrsta`, `i`) VALUES
(4, '2016-05-18 12:50:09', 'Izlazni-1', 'Izlaz', 45),
(7, '2016-05-18 13:49:43', 'Visak-1\r\n', 'Visak', 184),
(11, '2016-05-18 14:45:30', '4viska', 'Visak', 4),
(14, '2016-05-18 15:27:55', '25manjka', 'Manjak', 25),
(15, '2016-05-18 15:27:55', '225viska', 'Visak', 225),
(16, '2016-05-18 15:34:31', '250viska', 'Visak', 250),
(17, '2016-05-18 15:42:11', 'coko manja 20\nslatkis viska 29', 'Manjak', 100);

-- --------------------------------------------------------

--
-- Table structure for table `klasaartikla`
--

CREATE TABLE `klasaartikla` (
  `id` bigint(20) NOT NULL,
  `naziv` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `klasaartikla`
--

INSERT INTO `klasaartikla` (`id`, `naziv`) VALUES
(9, 'Voce');

-- --------------------------------------------------------

--
-- Table structure for table `klasaartikla_artikal`
--

CREATE TABLE `klasaartikla_artikal` (
  `KlasaArtikla_id` bigint(20) NOT NULL,
  `artikli_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `skladiste`
--

CREATE TABLE `skladiste` (
  `id` bigint(20) NOT NULL,
  `lokacija` varchar(255) DEFAULT NULL,
  `naziv` varchar(255) DEFAULT NULL,
  `sef_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `skladiste`
--

INSERT INTO `skladiste` (`id`, `lokacija`, `naziv`, `sef_id`) VALUES
(3, 'Milana Preloga', 'Delta', 9);

-- --------------------------------------------------------

--
-- Table structure for table `skladiste_artikal`
--

CREATE TABLE `skladiste_artikal` (
  `Skladiste_id` bigint(20) NOT NULL,
  `artikli_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `skladiste_tipzaposlenika`
--

CREATE TABLE `skladiste_tipzaposlenika` (
  `Skladiste_id` bigint(20) NOT NULL,
  `skladistari_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `stanjeinventure`
--

CREATE TABLE `stanjeinventure` (
  `id` bigint(20) NOT NULL,
  `stanje` int(11) NOT NULL,
  `inventura_id` bigint(20) DEFAULT NULL,
  `izvjestaj_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `tipzaposlenika`
--

CREATE TABLE `tipzaposlenika` (
  `id` bigint(20) NOT NULL,
  `adresa` varchar(255) DEFAULT NULL,
  `brojTel` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `jmbg` varchar(255) DEFAULT NULL,
  `korisnickoIme` varchar(255) DEFAULT NULL,
  `lozinka` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `privilegija` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tipzaposlenika`
--

INSERT INTO `tipzaposlenika` (`id`, `adresa`, `brojTel`, `email`, `ime`, `jmbg`, `korisnickoIme`, `lozinka`, `prezime`, `privilegija`) VALUES
(9, 'Adresa9', '061598745', 'muha@gmail.com', 'Muharem', '0000000000009', 'muharem', 'muharem', 'Hadzic', 'Sef'),
(10, 'Adresa10', '061123456', 'senka@gmail.com', 'Senka', '0000000000010', 'senka', 'senka', 'Ibrahimpasic', 'Skladistar'),
(20, 'Adresa20', '061899888', 'amra@gmail.com', 'Amra', '0000000000020', 'amra', 'amra', 'Hadziarapovic', 'Sef'),
(23, 'Adresa23', '061589999', 'predrag@gmail.com', 'Predrag', '0000000000023', 'predrag', 'predrag', 'Simanic', 'obrisan'),
(25, 'Adresa25', '061578485', 'faruk@gmail.com', 'Faruk', '0000000000025', 'faruk', 'faruk', 'Goro', 'Sef');

-- --------------------------------------------------------

--
-- Table structure for table `tipzaposlenika_skladiste`
--

CREATE TABLE `tipzaposlenika_skladiste` (
  `TipZaposlenika_id` bigint(20) NOT NULL,
  `skladiste_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artikal`
--
ALTER TABLE `artikal`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_h4rm0wfljpg90yrhwn389kckb` (`klasa_id`);

--
-- Indexes for table `inventura`
--
ALTER TABLE `inventura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_5ymtyqqhrq6vquko69qcv9c80` (`skladistar_id`);

--
-- Indexes for table `izvjestaj`
--
ALTER TABLE `izvjestaj`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klasaartikla`
--
ALTER TABLE `klasaartikla`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `klasaartikla_artikal`
--
ALTER TABLE `klasaartikla_artikal`
  ADD UNIQUE KEY `UK_47d56uflgn0uwtofy39l61t1v` (`artikli_id`),
  ADD KEY `FK_g9gphetcf8np48b0q3vrs9rwq` (`KlasaArtikla_id`);

--
-- Indexes for table `skladiste`
--
ALTER TABLE `skladiste`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_eleya81fbyedrfe0itlkgkips` (`sef_id`);

--
-- Indexes for table `skladiste_artikal`
--
ALTER TABLE `skladiste_artikal`
  ADD UNIQUE KEY `UK_dv12hbuujr8rsb8obf035s83l` (`artikli_id`),
  ADD KEY `FK_ert5uf7diacixm9xwu35wureb` (`Skladiste_id`);

--
-- Indexes for table `skladiste_tipzaposlenika`
--
ALTER TABLE `skladiste_tipzaposlenika`
  ADD UNIQUE KEY `UK_1gxtx00veg0o3899wa1drt9u0` (`skladistari_id`),
  ADD KEY `FK_sb2scgq6e3a40fp9f8ek9osrc` (`Skladiste_id`);

--
-- Indexes for table `stanjeinventure`
--
ALTER TABLE `stanjeinventure`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_7emq8pueclajvawrrewclgu3k` (`inventura_id`),
  ADD KEY `FK_qku86lx2w12o9wvosqoxc8qrg` (`izvjestaj_id`);

--
-- Indexes for table `tipzaposlenika`
--
ALTER TABLE `tipzaposlenika`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `tipzaposlenika_skladiste`
--
ALTER TABLE `tipzaposlenika_skladiste`
  ADD UNIQUE KEY `UK_396jgxon3leui8tvx9r4r34x9` (`skladiste_id`),
  ADD KEY `FK_tkad5sght00gl3djltfbpun8s` (`TipZaposlenika_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artikal`
--
ALTER TABLE `artikal`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT for table `inventura`
--
ALTER TABLE `inventura`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT for table `izvjestaj`
--
ALTER TABLE `izvjestaj`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `klasaartikla`
--
ALTER TABLE `klasaartikla`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
--
-- AUTO_INCREMENT for table `skladiste`
--
ALTER TABLE `skladiste`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `stanjeinventure`
--
ALTER TABLE `stanjeinventure`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tipzaposlenika`
--
ALTER TABLE `tipzaposlenika`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
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

--
-- Constraints for table `tipzaposlenika_skladiste`
--
ALTER TABLE `tipzaposlenika_skladiste`
  ADD CONSTRAINT `FK_396jgxon3leui8tvx9r4r34x9` FOREIGN KEY (`skladiste_id`) REFERENCES `skladiste` (`id`),
  ADD CONSTRAINT `FK_tkad5sght00gl3djltfbpun8s` FOREIGN KEY (`TipZaposlenika_id`) REFERENCES `tipzaposlenika` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
