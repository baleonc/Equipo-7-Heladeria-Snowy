USE db_heladeria_snowy;

CREATE TABLE IF NOT EXISTS productos
(
	codigo_producto VARCHAR(12) NOT NULL,
    iva_compra DOUBLE NOT NULL,
    nit_proveedor VARCHAR(12),
    nombre_producto VARCHAR(255) NOT NULL,
    precio_compra DOUBLE NOT NULL,
    precio_venta DOUBLE NOT NULL,
    PRIMARY KEY (codigo_producto),
    CONSTRAINT FK_proveedores_productos FOREIGN KEY (nit_proveedor)
    REFERENCES proveedores(nit_proveedor)
);
