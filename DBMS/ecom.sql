CREATE SCHEMA IF NOT EXISTS `E_COM_DB` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `E_COM_DB` ;

-- -----------------------------------------------------
-- Table `E_COM_DB`.`Product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `E_COM_DB`.`Product` (
  `Product_Id` INT NOT NULL AUTO_INCREMENT ,
  `Product_Name` VARCHAR(45) NOT NULL ,
  `Parent_Id` INT NULL ,
  PRIMARY KEY (`Product_Id`) );
  PRIMARY KEY (`Product_Id`) );