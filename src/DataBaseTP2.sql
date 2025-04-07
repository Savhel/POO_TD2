-- Création de la base de données
CREATE DATABASE IF NOT EXISTS TP2;
USE TP2;

-- Table des utilisateurs
CREATE TABLE Users (
    id_user INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100),
    prenom VARCHAR(100),
    email VARCHAR(100) UNIQUE,
    numtel VARCHAR(20),
    address VARCHAR(255)
);

-- Table des téléphones
CREATE TABLE Phones (
    id_phone INT AUTO_INCREMENT PRIMARY KEY,
    IdPropretaire INT,
    Nom VARCHAR(100),
    Marque VARCHAR(100),
    Modele VARCHAR(100),
    memoire_ROM FLOAT,
    memoire_RAM FLOAT,
    numero_serie VARCHAR(100) UNIQUE,
    IMEI VARCHAR(100) UNIQUE
);

-- Table des équipements
CREATE TABLE Equipements (
    id_equipement INT AUTO_INCREMENT PRIMARY KEY,
    IdPropretaire INT,
    address_MAC VARCHAR(100) UNIQUE,
    Nom VARCHAR(100),
    Marque VARCHAR(100),
    Modele VARCHAR(100),
    memoire_ROM FLOAT,
    memoire_RAM FLOAT,
    numero_serie VARCHAR(100) UNIQUE
);
