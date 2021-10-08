package co.edu.unbosque.ciclo3back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.edu.unbosque.ciclo3back.JPAdataAccess.AdmUserRepository;
import co.edu.unbosque.ciclo3back.JPAdataAccess.ClientRepository;
import co.edu.unbosque.ciclo3back.JPAdataAccess.ProductRepository;
import co.edu.unbosque.ciclo3back.JPAdataAccess.SupplierRepository;

@Controller
public class ReportsServlet 
{
	@Autowired
	private AdmUserRepository admUserRepository;
	
	@Autowired
	private ClientRepository clientRepository;
		  	
	
	@PostMapping("/Home/LogIn/Menu/Module/Reports")
	public String testReportsServlet(@RequestParam(name="kindOfReport") String kindOfReport,
										Model model)
	{
		switch(kindOfReport)
		{
			case "Listado de usuarios": model.addAttribute("listOfUsers", admUserRepository.findAll());
										return "Users/Report";
				
			case "Listado de clientes": model.addAttribute("listOfclients", clientRepository.findAll());
										return "Clients/Report";
					
			//case "Ventas por cliente":  
				//return "Sellings/Report";
		}
		return "99999error";
	}
}
