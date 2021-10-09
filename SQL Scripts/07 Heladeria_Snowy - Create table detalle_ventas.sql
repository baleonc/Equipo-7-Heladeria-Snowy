USE db_heladeria_snowy;

CREATE TABLE IF NOT EXISTS detalle_ventas
(
	codigo_detalle_ventas INT AUTO_INCREMENT,
    cantidad_producto INT,
    codigo_producto VARCHAR(12),
    codigo_venta INT,
    valor_total DOUBLE,
    valor_venta DOUBLE,
    valor_iva DOUBLE,
    PRIMARY KEY(codigo_detalle_ventas),
    CONSTRAINT FK_producto_detalle_ventas FOREIGN KEY (codigo_producto) REFERENCES productos(codigo_producto),
    CONSTRAINT FK_ventas_detalle_ventas FOREIGN KEY (codigo_venta) REFERENCES ventas(codigo_venta)
);
    