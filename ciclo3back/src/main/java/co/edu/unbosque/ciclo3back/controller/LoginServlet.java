package co.edu.unbosque.ciclo3back.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**This controller manages login of an user and the first view of the application
 * 
 * @author Brayan Leon
 * @version 3 OCT 2021
 */
@Controller
public class LoginServlet 
{					
	/**This request manages the authentication of a user by using WebSecurity 
	 * configuration for Spring Applications. 
	 * 
	 * @return
	 */
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}	
}
