USE db_heladeria_snowy;

CREATE TABLE IF NOT EXISTS clientes
(
	cedula_cliente VARCHAR(20) PRIMARY KEY NOT NULL,
    direccion_cliente VARCHAR(255),
    email_cliente VARCHAR(255),
    nombre_cliente VARCHAR(255) NOT NULL,
    telefono_cliente VARCHAR(255)
);