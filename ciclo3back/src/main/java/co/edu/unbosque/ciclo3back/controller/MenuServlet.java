package co.edu.unbosque.ciclo3back.controller;


import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuServlet 
{		
	
	/**Request implemented to return to the main menu
	 * 
	 * @return
	 */
	@GetMapping("/Home/LogIn/Menu")
	public String toMenu()
	{
		return "Menu";
	}
	
	
	/**The controller manages requests to pass to a module
	 * 
	 * @param moduleIn The module chosen by the user gotten from the view by get method
	 * @param model The bean model of the Spring application
	 * @return A ModelAndView object of the Spring application to pass to the next view depending on
	 * the option chosen by the user
	 */	
	@GetMapping("/Home/LogIn/Menu/Module")	
	public ModelAndView getModuleInterestingIn(@RequestParam(name="module") String moduleIn)
	{
		String module;
		String viewToReturn;
		
		switch(moduleIn)
		{
			case "Usuarios": module = "Users"; 
							 viewToReturn = "Templates2/CrudOptions";
							 break;
							 
			case "Clientes": module = "Clients"; 
							 viewToReturn = "Templates2/CrudOptions";
							 break;
							
			case "Proveedores": module = "Suppliers";
							    viewToReturn = "Templates2/CrudOptions";
							    break;
							    
			case "Productos": module = "Products";
		    				  viewToReturn = module + "/" + "UploadFileWithProducts";
		    				  break;		    
								
			case "Ventas": module = "Sellings";
						   viewToReturn = "Sellings";
						   break;
						   
			case "Reportes": module = "Reports";
							 viewToReturn = "Reports/ReportOptions";
							 break;
							 
			default:module = "99999error";
					viewToReturn = "99999error";
		}
		ModelAndView modelAndView = new ModelAndView(viewToReturn);
		modelAndView.addObject("module", module);		
		return modelAndView;
	}	
}
