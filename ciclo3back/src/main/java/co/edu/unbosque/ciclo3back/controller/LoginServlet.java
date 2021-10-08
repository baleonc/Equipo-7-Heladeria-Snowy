package co.edu.unbosque.ciclo3back.controller;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.JPAdataAccess.AdmUserRepository;
import co.edu.unbosque.ciclo3back.model.AdministratorUser;
import co.edu.unbosque.ciclo3back.model.Client;

/**This controller manages login of an user and the first view of the application
 * 
 * @author Brayan Leon
 * @version 3 OCT 2021
 */
@Controller
public class LoginServlet 
{	
	@Autowired
	private AdmUserRepository admUserRepositoryIn;
	
	/*@RequestMapping("/save")
	public String testCreate(@RequestParam(name = "cedulaCliente") long cedulaClienteIn,
									@RequestParam(name = "direccionCliente") String direccionClienteIn,
									@RequestParam(name = "emailCliente") String emailClienteIn,
									@RequestParam(name = "nombreCliente") String nombreClienteIn,
									@RequestParam(name = "telefonoCliente") String telefonoClienteIn) 			
	{	
		clientRepositoryIn.save(new Client(cedulaClienteIn, direccionClienteIn, emailClienteIn,
											nombreClienteIn,telefonoClienteIn));
		
		return "<html><title></title><body><h1>Prueba exitosa</h1></body></html>";
	}*/
	
	/*@RequestMapping("/update")
	public String testUpdate(@RequestParam(name = "cedulaCliente") String cedulaClienteIn,
								@RequestParam(name = "nombreCliente") String nombreClienteIn)
	{
		Optional<Client> OptexistentClient = clientRepositoryIn.findById((long) 85437379);
		if(OptexistentClient.isPresent())
		{
			Client existentClient = OptexistentClient.get();
			existentClient.setNombreCliente(nombreClienteIn);
			clientRepositoryIn.save(existentClient);
		}
		
		return "<html><title></title><body><h1>Prueba exitosa</h1></body></html>";*/
	
	/**This request manages login view
	 * 
	 * @return The view home which is the view into a user can log in
	 */
	@GetMapping("/Home")
	public String index()
	{
		return "Home";
	}
	
	
	/**This request manages the view after login into the application
	 * 
	 * @param acountOfUser This parameter is obtain from the method post in the view 
	 * and corresponds to the user's account in the session 	 
	 * @param passwordOfUser This parameter is obtain from the method post in the view 
	 * and corresponds to the user's password in the session
	 * @return The next view that depends on validation of the sent parameters
	 */
	@PostMapping("/Home/LogIn/Menu")
	public String logInUser(@RequestParam(name = "userAcount") String acountOfUser, 
							@RequestParam(name = "password") String passwordOfUser)
	{		
		Optional<AdministratorUser> UserInSesion = admUserRepositoryIn.findByPassword(passwordOfUser);
		if(UserInSesion.isPresent())
		{			
			return "Menu";
		}
		else
		{			
			return "Home";
		}
	}	
}
