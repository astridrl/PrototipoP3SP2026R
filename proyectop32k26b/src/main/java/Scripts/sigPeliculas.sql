CREATE DATABASE IF NOT EXISTS sig
DEFAULT CHARACTER SET utf8mb4
COLLATE utf8mb4_general_ci;

USE sig;

SET SQL_MODE = NO_AUTO_VALUE_ON_ZERO;
SET time_zone = +0000;
SET FOREIGN_KEY_CHECKS = 0;

START TRANSACTION;

CREATE TABLE IF NOT EXISTS `peliculas` (
	idPeliculas INT NOT NULL AUTO_INCREMENT,
	Nombre VARCHAR(45) NOT NULL,
	Clasificacion VARCHAR(45) NOT NULL,
	Genero VARCHAR(45) NOT NULL,
	Subtitulado VARCHAR(45) NOT NULL,
	Idioma VARCHAR(45),
	Precio DOUBLE,
    PRIMARY KEY (idPeliculas)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO peliculas (idPeliculas, Nombre, Clasificacion, Genero, Subtitulado, Idioma, Precio) VALUES (1, 'Harry Potter', 'Niños', 'Fantasia', 'Español', 'Ingles', '25.00');

INSERT INTO aplicaciones (Aplcodigo, Aplnombre, Aplestado) VALUES (12, 'Peliculas', '1');