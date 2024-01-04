-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema mybookstore
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mybookstore
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mybookstore` DEFAULT CHARACTER SET utf8mb3 ;
USE `mybookstore` ;

-- -----------------------------------------------------
-- Table `mybookstore`.`books`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mybookstore`.`books` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(200) NOT NULL,
  `author` VARCHAR(200) NOT NULL,
  `genre` VARCHAR(200) NOT NULL,
  `quantity` INT NOT NULL,
  `price` DECIMAL(20,2) NOT NULL,
  `image_url` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 71
DEFAULT CHARACTER SET = utf8mb3;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
