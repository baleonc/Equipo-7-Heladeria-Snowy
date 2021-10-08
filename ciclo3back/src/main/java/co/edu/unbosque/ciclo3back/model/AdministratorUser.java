package co.edu.unbosque.ciclo3back.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="usuarios")
public class AdministratorUser 
{		
	
	@NotNull
	@Pattern(regexp="")
	@Id
	private long cedulaUsuario;	
	private String emailUsuario;
	private String nombreUsuario;
	private String password;
	private String usuario;	
	
	public AdministratorUser() 
	{
		
	}
	
	public AdministratorUser(long cedulaUsuarioIn, String emailUsuarioIn, String nombreUsuarioIn,
					String passwordIn, String usuarioIn)
	{
		cedulaUsuario = cedulaUsuarioIn;
		emailUsuario = emailUsuarioIn;
		nombreUsuario = nombreUsuarioIn;
		password = passwordIn;
		usuario = usuarioIn;
	}
	
	public long getCedulaUsuario() 
	{
		return cedulaUsuario;
	}

	public void setCedulaUsuario(long cedulaUsuarioIn) 
	{
		cedulaUsuario = cedulaUsuarioIn;
	}

	public String getEmailUsuario() 
	{
		return emailUsuario;
	}
		
	public void setEmailUsuario(String emailUsuarioIn) 
	{
		emailUsuario = emailUsuarioIn;
	}
	
	public String getNombreUsuario()
	{
		return nombreUsuario;
	}
	
	public void setNombreUsuario(String nombreUsuarioIn)
	{
		nombreUsuario = nombreUsuarioIn;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public void setPassword(String passwordIn)
	{
		password = passwordIn;
	}
	
	public String getUsuario()
	{
		return usuario;
	}
	
	public void setUsuario(String usuarioIn)
	{
		usuario = usuarioIn;
	}
	
	@Override
	public String toString()
	{
		return String.format("Usuario[ cedulaUsuario=%d, emailUsuario = %s" + " " +
							"nombreUsuario = %s, password = %s, usuario = %s]", 
							cedulaUsuario, emailUsuario, nombreUsuario,
							password, usuario);
	}
}
