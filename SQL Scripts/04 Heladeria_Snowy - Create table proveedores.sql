USE db_heladeria_snowy;

CREATE TABLE IF NOT EXISTS proveedores
(
	nit_proveedor VARCHAR(12),
    ciudad_proveedor VARCHAR(255),
    direccion_proveedor VARCHAR(255),
    nombre_proveedor VARCHAR(255),
    telefono_proveedor VARCHAR(255),
    PRIMARY KEY(nit_proveedor)
);