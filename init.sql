CREATE TABLE USUARIOS (
    id INT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    rol VARCHAR(255) NOT NULL,
    avatar VARCHAR(255),
    games VARCHAR(255),
    notifications VARCHAR(255)
);

CREATE TABLE eventos (
    id BIGINT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    ubicacion VARCHAR(255) NOT NULL,
    organizadores VARCHAR(255) NOT NULL,
    servicios VARCHAR(255) NOT NULL
);