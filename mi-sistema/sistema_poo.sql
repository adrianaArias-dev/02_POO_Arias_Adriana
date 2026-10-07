-- Ejecutar en MySQL Workbench (conexión mysql-poo, puerto 3307)
CREATE DATABASE IF NOT EXISTS sistema_poo
    CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE sistema_poo;

CREATE TABLE IF NOT EXISTS usuarios (
    id       INT AUTO_INCREMENT PRIMARY KEY,
    nombre   VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo   VARCHAR(150) NOT NULL,
    estado   VARCHAR(30)  NOT NULL
);

INSERT INTO usuarios (nombre, apellido, correo, estado) VALUES
 ('Ana',   'Torres', 'ana@correo.com',   'Activo'),
 ('Luis',  'Pérez',  'luis@correo.com',  'Activo'),
 ('María', 'Quispe', 'maria@correo.com', 'Inactivo');
