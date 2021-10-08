package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Product 
{
	@Id
	private int codigoProducto;	
	private double ivaCompra;
	private long nitProveedor;
	private String nombreProducto;
	private double precioCompra;
	private double precioVenta;
	
	public Product()
	{
		
	}

	public Product(int codigoProducto, double ivaCompra, long nitProveedor, String nombreProducto, double precioCompra,
			double precioVenta) 
	{
		super();
		this.codigoProducto = codigoProducto;
		this.ivaCompra = ivaCompra;
		this.nitProveedor = nitProveedor;
		this.nombreProducto = nombreProducto;
		this.precioCompra = precioCompra;
		this.precioVenta = precioVenta;
	}

	public int getCodigoProducto() 
	{
		return codigoProducto;
	}

	public void setCodigoProducto(int codigoProducto) 
	{
		this.codigoProducto = codigoProducto;
	}

	public double getIvaCompra() 
	{
		return ivaCompra;
	}

	public void setIvaCompra(double ivaCompra) 
	{
		this.ivaCompra = ivaCompra;
	}

	public long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(long nitProveedor) 
	{
		this.nitProveedor = nitProveedor;
	}

	public String getNombreProducto() 
	{
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) 
	{
		this.nombreProducto = nombreProducto;
	}

	public double getPrecioCompra() 
	{
		return precioCompra;
	}

	public void setPrecioCompra(double precioCompra) 
	{
		this.precioCompra = precioCompra;
	}

	public double getPrecioVenta() 
	{
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) 
	{
		this.precioVenta = precioVenta;
	}

	@Override
	public String toString() {
		return "Product [codigoProducto=" + codigoProducto + ", ivaCompra=" + ivaCompra + ", nitProveedor="
				+ nitProveedor + ", nombreProducto=" + nombreProducto + ", precioCompra=" + precioCompra
				+ ", precioVenta=" + precioVenta + "]";
	}	
}
