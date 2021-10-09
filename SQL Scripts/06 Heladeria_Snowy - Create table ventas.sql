USE db_heladeria_snowy;

CREATE TABLE IF NOT EXISTS ventas
(
	codigo_venta INT AUTO_INCREMENT,
    cedula_cliente VARCHAR(12) NOT NULL,
    cedula_usuario VARCHAR(12) NOT NULL,
    iva_venta DOUBLE NOT NULL,
    total_venta DOUBLE NOT NULL,
    valor_venta DOUBLE NOT NULL,
    PRIMARY KEY (codigo_venta),
    CONSTRAINT FK_clientes_ventas FOREIGN KEY (cedula_cliente)
    REFERENCES clientes(cedula_cliente),
    CONSTRAINT FK_usuarios_ventas FOREIGN KEY (cedula_usuario)
    REFERENCES usuarios(cedula_usuario)
);
