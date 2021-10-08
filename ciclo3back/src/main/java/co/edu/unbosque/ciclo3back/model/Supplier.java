package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="proveedores")
public class Supplier 
{
	//@Pattern()
	@Id
	private Long nitProveedor;	
	private String ciudadProveedor;
	private String direccionProveedor;
	private String nombreProveedor;
	private String telefonoProveedor;
	
	public Supplier()
	{
		
	}
	
	public Supplier(Long nitProveedorIn, String ciudadProveedorIn, String direccionProveedorIn,
						String nombreProveedorIn, String telefonoProveedorIn)
	{
		nitProveedor = nitProveedorIn;
		ciudadProveedor = ciudadProveedorIn;
		direccionProveedor = direccionProveedorIn;
		nombreProveedor = nombreProveedorIn;
		telefonoProveedor = telefonoProveedorIn;
	}

	public Long getNitProveedor() {
		return nitProveedor;
	}

	public void setNitProveedor(Long nitProveedor) {
		this.nitProveedor = nitProveedor;
	}

	public String getCiudadProveedor() {
		return ciudadProveedor;
	}

	public void setCiudadProveedor(String ciudadProveedor) {
		this.ciudadProveedor = ciudadProveedor;
	}

	public String getDireccionProveedor() {
		return direccionProveedor;
	}

	public void setDireccionProveedor(String direccionProveedor) {
		this.direccionProveedor = direccionProveedor;
	}

	public String getNombreProveedor() {
		return nombreProveedor;
	}

	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}

	public String getTelefonoProveedor() {
		return telefonoProveedor;
	}

	public void setTelefonoProveedor(String telefonoProveedor) {
		this.telefonoProveedor = telefonoProveedor;
	}

	@Override
	public String toString() 
	{
		return "Supplier [nitProveedor = " + nitProveedor + ", ciudadProveedor = " + ciudadProveedor
				+ ", direccionProveedor = " + direccionProveedor + ", nombreProveedor = " + nombreProveedor
				+ ", telefonoProveedor = " + telefonoProveedor + "]";
	}	
}
