SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';

DROP DATABASE IF EXISTS `pokedex`;
CREATE DATABASE `pokedex` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `pokedex`;

CREATE TABLE `pokemon` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_species` int NOT NULL,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `weight` double DEFAULT NULL,
  `age` int DEFAULT NULL,
  `attack` double DEFAULT NULL,
  `defense` double DEFAULT NULL,
  `gender` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_species` (`id_species`),
  CONSTRAINT `pokemon_ibfk_1` FOREIGN KEY (`id_species`) REFERENCES `species` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;


CREATE TABLE `pokemon_skills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_pokemon` int NOT NULL,
  `id_skill` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_pokemon` (`id_pokemon`),
  KEY `id_skill` (`id_skill`),
  CONSTRAINT `pokemon_skills_ibfk_1` FOREIGN KEY (`id_pokemon`) REFERENCES `pokemon` (`id`),
  CONSTRAINT `pokemon_skills_ibfk_2` FOREIGN KEY (`id_skill`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;


CREATE TABLE `pokemon_type` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

CREATE TABLE `skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  `effect` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=166 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

CREATE TABLE `species` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=152 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

CREATE TABLE `species_skills` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_specie` int NOT NULL,
  `id_skill` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_specie` (`id_specie`),
  KEY `id_skill` (`id_skill`),
  CONSTRAINT `species_skills_ibfk_1` FOREIGN KEY (`id_specie`) REFERENCES `species` (`id`),
  CONSTRAINT `species_skills_ibfk_2` FOREIGN KEY (`id_skill`) REFERENCES `skill` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5019 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;

CREATE TABLE `types_species` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_species` int NOT NULL,
  `id_type` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_species` (`id_species`),
  KEY `id_type` (`id_type`),
  CONSTRAINT `types_species_ibfk_1` FOREIGN KEY (`id_species`) REFERENCES `species` (`id`),
  CONSTRAINT `types_species_ibfk_2` FOREIGN KEY (`id_type`) REFERENCES `pokemon_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=212 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_bin;