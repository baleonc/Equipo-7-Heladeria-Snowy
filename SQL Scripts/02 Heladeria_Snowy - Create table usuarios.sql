USE db_heladeria_snowy;

CREATE TABLE IF NOT EXISTS usuarios
(	
	cedula_usuario VARCHAR(12) NOT NULL,
    email_usuario VARCHAR(255),
    nombre_usuario VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    usuario VARCHAR(255) NOT NULL,
    PRIMARY KEY (cedula_usuario)
);
    
