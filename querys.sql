CREATE DATABASE db_myDiccionarium;

USE db_mydiccionarium;

CREATE TABLE `db_mydiccionarium` . `tipoDiccionario` (
    `idDic` INT NOT NULL AUTO_INCREMENT,
    `nombreDic` VARCHAR(255) NULL,
    `versionDic` VARCHAR(255) NULL,
    PRIMARY KEY (`idDic`)
)ENGINE= InnoDB;

CREATE TABLE `db_mydiccionarium` . `menuItems` (
    `idMenu` INT NOT NULL AUTO_INCREMENT,
    `nombreMenu` VARCHAR(255) NULL,
    `idDic` INT NULL,
    PRIMARY KEY (`idMenu`)
)ENGINE= InnoDB;

CREATE TABLE `db_mydiccionarium` . `regCodigo` (
    `idCodigo` INT NOT NULL AUTO_INCREMENT,
    `codex` VARCHAR(255) NULL,
    `idMenu` INT NULL,
    PRIMARY KEY (`idCodigo`)
)ENGINE= InnoDB;

ALTER TABLE  `db_mydiccionarium` . `menuItems`
ADD CONSTRAINT `docDic_ibfk_1` FOREIGN KEY (`idDic`) REFERENCES `tipoDiccionario` (`idDic`);

ALTER TABLE  `db_mydiccionarium` . `regCodigo`
ADD CONSTRAINT `regCod_ibfk_1` FOREIGN KEY (`idMenu`) REFERENCES `menuItems` (`idMenu`);