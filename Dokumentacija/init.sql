-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema tim4
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `tim4` ;

-- -----------------------------------------------------
-- Schema tim4
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `tim4` DEFAULT CHARACTER SET utf8 ;
USE `tim4` ;

-- -----------------------------------------------------
-- Table `tim4`.`klasaartikla`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`klasaartikla` ;

CREATE TABLE IF NOT EXISTS `tim4`.`klasaartikla` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `naziv` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`artikal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`artikal` ;

CREATE TABLE IF NOT EXISTS `tim4`.`artikal` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `barkod` VARCHAR(255) NULL DEFAULT NULL,
  `cijena` DOUBLE NULL DEFAULT NULL,
  `kolicina` DOUBLE NULL DEFAULT NULL,
  `mjera` VARCHAR(255) NULL DEFAULT NULL,
  `naziv` VARCHAR(255) NULL DEFAULT NULL,
  `klasaArtikla_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_8exti1x7flq9ls7yw50tw21d1` (`klasaArtikla_id` ASC),
  CONSTRAINT `FK_8exti1x7flq9ls7yw50tw21d1`
    FOREIGN KEY (`klasaArtikla_id`)
    REFERENCES `tim4`.`klasaartikla` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`tipzaposlenika`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`tipzaposlenika` ;

CREATE TABLE IF NOT EXISTS `tim4`.`tipzaposlenika` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `adresa` VARCHAR(255) NULL DEFAULT NULL,
  `brojTel` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `ime` VARCHAR(255) NULL DEFAULT NULL,
  `jmbg` VARCHAR(255) NULL DEFAULT NULL,
  `korisnickoIme` VARCHAR(255) NULL DEFAULT NULL,
  `lozinka` VARCHAR(255) NULL DEFAULT NULL,
  `prezime` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`skladistar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`skladistar` ;

CREATE TABLE IF NOT EXISTS `tim4`.`skladistar` (
  `id` BIGINT(20) NOT NULL,
  `inventura_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_cxq5obem3dmgo38w00mg4yud6` (`inventura_id` ASC),
  CONSTRAINT `FK_cxq5obem3dmgo38w00mg4yud6`
    FOREIGN KEY (`inventura_id`)
    REFERENCES `tim4`.`inventura` (`id`),
  CONSTRAINT `FK_g5667cktu959k9vor0cn0x1p4`
    FOREIGN KEY (`id`)
    REFERENCES `tim4`.`tipzaposlenika` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`inventura`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`inventura` ;

CREATE TABLE IF NOT EXISTS `tim4`.`inventura` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `datum` DATETIME NULL DEFAULT NULL,
  `opis` VARCHAR(255) NULL DEFAULT NULL,
  `trenutnoStanje` INT(11) NOT NULL,
  `skladistar_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_5ymtyqqhrq6vquko69qcv9c80` (`skladistar_id` ASC),
  CONSTRAINT `FK_5ymtyqqhrq6vquko69qcv9c80`
    FOREIGN KEY (`skladistar_id`)
    REFERENCES `tim4`.`skladistar` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`izvjestaj`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`izvjestaj` ;

CREATE TABLE IF NOT EXISTS `tim4`.`izvjestaj` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `Datum` DATETIME NULL DEFAULT NULL,
  `Opis` VARCHAR(255) NULL DEFAULT NULL,
  `Vrsta` VARCHAR(255) NULL DEFAULT NULL,
  `i` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`sef`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`sef` ;

CREATE TABLE IF NOT EXISTS `tim4`.`sef` (
  `id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_bxyjinqoxcv235fyqj19uxy5x`
    FOREIGN KEY (`id`)
    REFERENCES `tim4`.`tipzaposlenika` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`skladiste`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`skladiste` ;

CREATE TABLE IF NOT EXISTS `tim4`.`skladiste` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `lokacija` VARCHAR(255) NULL DEFAULT NULL,
  `naziv` VARCHAR(255) NULL DEFAULT NULL,
  `sef_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_eleya81fbyedrfe0itlkgkips` (`sef_id` ASC),
  CONSTRAINT `FK_eleya81fbyedrfe0itlkgkips`
    FOREIGN KEY (`sef_id`)
    REFERENCES `tim4`.`sef` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`skladiste_artikal`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`skladiste_artikal` ;

CREATE TABLE IF NOT EXISTS `tim4`.`skladiste_artikal` (
  `Skladiste_id` BIGINT(20) NOT NULL,
  `artikli_id` BIGINT(20) NOT NULL,
  UNIQUE INDEX `UK_dv12hbuujr8rsb8obf035s83l` (`artikli_id` ASC),
  INDEX `FK_ert5uf7diacixm9xwu35wureb` (`Skladiste_id` ASC),
  CONSTRAINT `FK_dv12hbuujr8rsb8obf035s83l`
    FOREIGN KEY (`artikli_id`)
    REFERENCES `tim4`.`artikal` (`id`),
  CONSTRAINT `FK_ert5uf7diacixm9xwu35wureb`
    FOREIGN KEY (`Skladiste_id`)
    REFERENCES `tim4`.`skladiste` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`skladiste_skladistar`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`skladiste_skladistar` ;

CREATE TABLE IF NOT EXISTS `tim4`.`skladiste_skladistar` (
  `Skladiste_id` BIGINT(20) NOT NULL,
  `skladistari_id` BIGINT(20) NOT NULL,
  UNIQUE INDEX `UK_1pjhh1hjxa1xu3odwj8xl54m2` (`skladistari_id` ASC),
  INDEX `FK_1156915welaaad0gdfmqrv1il` (`Skladiste_id` ASC),
  CONSTRAINT `FK_1156915welaaad0gdfmqrv1il`
    FOREIGN KEY (`Skladiste_id`)
    REFERENCES `tim4`.`skladiste` (`id`),
  CONSTRAINT `FK_1pjhh1hjxa1xu3odwj8xl54m2`
    FOREIGN KEY (`skladistari_id`)
    REFERENCES `tim4`.`skladistar` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `tim4`.`stanjeinventure`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `tim4`.`stanjeinventure` ;

CREATE TABLE IF NOT EXISTS `tim4`.`stanjeinventure` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `stanje` INT(11) NOT NULL,
  `inventura_id` BIGINT(20) NULL DEFAULT NULL,
  `izvjestaj_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FK_7emq8pueclajvawrrewclgu3k` (`inventura_id` ASC),
  INDEX `FK_qku86lx2w12o9wvosqoxc8qrg` (`izvjestaj_id` ASC),
  CONSTRAINT `FK_7emq8pueclajvawrrewclgu3k`
    FOREIGN KEY (`inventura_id`)
    REFERENCES `tim4`.`inventura` (`id`),
  CONSTRAINT `FK_qku86lx2w12o9wvosqoxc8qrg`
    FOREIGN KEY (`izvjestaj_id`)
    REFERENCES `tim4`.`izvjestaj` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
