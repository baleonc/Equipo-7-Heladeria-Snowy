package co.edu.unbosque.ciclo3back.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unbosque.ciclo3back.JPAdataAccess.AdmUserRepository;
import co.edu.unbosque.ciclo3back.model.AdministratorUser;
import co.edu.unbosque.ciclo3back.model.Client;
import co.edu.unbosque.ciclo3back.validationForms.UsuarioValidator;

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
	
	@Autowired
	private UsuarioValidator usuarioValidator; 
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
	 * @return The view home which is the view a user can log in to
	 */
	@GetMapping("/Home")
	public String index(Model model)
	{		
		model.addAttribute("admUserInSession", new AdministratorUser());
		boolean passwordValidated = true;
		boolean userValidated = true;
		model.addAttribute("passwordValidated", passwordValidated);
		model.addAttribute("userValidated", userValidated);
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
	public String logInUser(@Valid @ModelAttribute("admUserInSession") AdministratorUser admUserInSession, 
								BindingResult result)
	{			
		usuarioValidator.validate(admUserInSession, result);
		if(result.hasErrors())
		{
			return "Home";
		}
		else
		{
			return "Menu";
		}
	}	
}
