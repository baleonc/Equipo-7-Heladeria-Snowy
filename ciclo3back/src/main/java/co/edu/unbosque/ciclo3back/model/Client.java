package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Client {
	
	@Id	
	private long cedulaCliente;
	private String direccionCliente;
	private String emailCliente;
	private String nombreCliente;
	private String telefonoCliente;
	
	public Client()
	{
		
	}
	
	public Client(long cedulaClienteIn, String direccionClienteIn, String emailClienteIn,
					String nombreClienteIn, String telefonoClienteIn)
	{       
		cedulaCliente = cedulaClienteIn;      
		direccionCliente = direccionClienteIn;
		emailCliente = emailClienteIn;
		nombreCliente = nombreClienteIn;
		telefonoCliente = telefonoClienteIn;
	}

	public long getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(long cedulaClienteIn) {
		cedulaCliente = cedulaClienteIn;
	}

	public String getDireccionCliente() {
		return direccionCliente;
	}

	public void setDireccionCliente(String direccionCliente) {
		this.direccionCliente = direccionCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getTelefonoCliente() {
		return telefonoCliente;
	}

	public void setTelefonoCliente(String telefonoCliente) {
		this.telefonoCliente = telefonoCliente;
	}
	
	@Override
	public String toString()
	{
		return String.format("Cliente[ cedula de Cliente=%d, email de Cliente = %s" + " " +
				"nombre de Cliente = %s, direccion de cliente = %s, telefono de Cliente = %s]", 
				cedulaCliente, emailCliente, nombreCliente,
				direccionCliente, telefonoCliente);
	}
}
