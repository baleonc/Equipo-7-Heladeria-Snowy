package co.edu.unbosque.ciclo3back.controller;

import java.io.IOException;
import java.util.Optional;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import co.edu.unbosque.ciclo3back.JPAdataAccess.AdmUserRepository;
import co.edu.unbosque.ciclo3back.JPAdataAccess.ClientRepository;
import co.edu.unbosque.ciclo3back.JPAdataAccess.ProductRepository;
import co.edu.unbosque.ciclo3back.JPAdataAccess.SupplierRepository;
import co.edu.unbosque.ciclo3back.model.AdministratorUser;
import co.edu.unbosque.ciclo3back.model.Client;
import co.edu.unbosque.ciclo3back.model.Product;
import co.edu.unbosque.ciclo3back.model.Supplier;


/**
 * 
 * @author Brayan Leon
 * @version 4 oct 2021
 */


@Controller
public class CrudServlet 
{
	@Autowired
	private AdmUserRepository admUserRepository;
	
	@Autowired
	private ClientRepository clientRepository;
		  
	@Autowired
	private SupplierRepository supplierRepository;
	
	@Autowired
	private ProductRepository productRepository; 
	
	
	/**This method manages the view after to had chosen a module that offers a CRUD option
	 * 
	 * @param operationIn The operation CRUD that the logged in user chose
	 * @param model The model of the Spring application
	 * @param module The module chosen by the user
	 * @return The first view to perform an operation CRUD that depends on the chosen module 
	 */
	@GetMapping("/Home/LogIn/Menu/Module/{module}/OptionCRUD")
	public String CRUDFirst(@RequestParam(name="operation") String operationIn, Model model,
										@PathVariable String module)
	{
		model.addAttribute("module", module);		
		switch(module)
		{
			case "Users":model.addAttribute("instruccion", "Introduzca cedula de usuario");						 
						 switch(operationIn)
						 {
							case "Guardar": model.addAttribute("operationCrud", "Save");
											model.addAttribute("OperationCrudEs", "Guardar");
											model.addAttribute("administratorUser", new AdministratorUser());
											model.addAttribute("typeOfObjectEs", "usuario");
											return module + "/" + "Save";
											
							case "Modificar": model.addAttribute("operationCrud", "Modify");
											  model.addAttribute("OperationCrudEs", "Modificar");											  
										  	  return "Templates2/IdOfModelObject";						  	
											  
							case "Borrar": model.addAttribute("operationCrud", "Delete");
										   model.addAttribute("OperationCrudEs", "Borrar");
						  				   return "Templates2/IdOfModelObject";
							  
							case "Consultar": model.addAttribute("operationCrud", "Query");
											  model.addAttribute("OperationCrudEs", "Consultar");
					  						  return "Templates2/IdOfModelObject";
						}
						 
			case "Clients":model.addAttribute("instruccion", "Introduzca cedula de cliente");						 
							 switch(operationIn)
							 {
								case "Guardar": model.addAttribute("operationCrud", "Save");
												model.addAttribute("OperationCrudEs", "Guardar");
												model.addAttribute("client", new Client());
												model.addAttribute("typeOfObjectEs", "cliente");
												return module + "/" + "Save";
												
								case "Modificar": model.addAttribute("operationCrud", "Modify");
												  model.addAttribute("OperationCrudEs", "Modificar");											  
											  	  return "Templates2/IdOfModelObject";						  	
												  
								case "Borrar": model.addAttribute("operationCrud", "Delete");
											   model.addAttribute("OperationCrudEs", "Borrar");
							  				   return "Templates2/IdOfModelObject";
								  
								case "Consultar": model.addAttribute("operationCrud", "Query");
												  model.addAttribute("OperationCrudEs", "Consultar");
						  						  return "Templates2/IdOfModelObject";						  						  								
							}
							 
			case "Suppliers":model.addAttribute("instruccion", "Introduzca nit de proveedor");
							 switch(operationIn)
							 {
								case "Guardar": model.addAttribute("operationCrud", "Save");
												model.addAttribute("OperationCrudEs", "Guardar");
												model.addAttribute("supplier", new Supplier());
												model.addAttribute("typeOfObjectEs", "proveedor");
												return module + "/" + "Save";
												
								case "Modificar": model.addAttribute("operationCrud", "Modify");
												  model.addAttribute("OperationCrudEs", "Modificar");											  
											  	  return "Templates2/IdOfModelObject";						  	
												  
								case "Borrar": model.addAttribute("operationCrud", "Delete");
											   model.addAttribute("OperationCrudEs", "Borrar");
							  				   return "Templates2/IdOfModelObject";
								  
								case "Consultar": model.addAttribute("operationCrud", "Query");
												  model.addAttribute("OperationCrudEs", "Consultar");
						  						  return "Templates2/IdOfModelObject";
							}
							 
			case "Ventas": return module + "/" + "Save";					
						
		}		
		return "99999error";
	}
	
	
	/**This method manages the second view to perform a CRUD action. Depends on chosen CRUD action, 
	 * second view will be a confirmation message, an information view or a new form. 
	 * @param module The module chosen by the user
	 * @param actionCRUD The CRUD action chosen by the user
	 * @param administratorUser Recovers the model attribute generated by the previous view with attached
	 * data attributes binded by Thymeleaf. This kind of objects are only used when is chosen save option in
	 * this controller.
	 * @param client
	 * @param dataToCrud
	 * @param model
	 * @return
	 */
	@PostMapping("/Home/LogIn/Menu/Module/{module}/OptionCRUD/{actionCRUD}")
	public String CRUDSecond(@PathVariable String module,								
							@PathVariable String actionCRUD,										
							@ModelAttribute AdministratorUser administratorUser,
							@ModelAttribute Client client,
							@ModelAttribute Supplier supplier,
							@RequestParam String dataToCrud,
							Model model)
	{
		try
		{
			switch(module)
			{
				case "Users":switch(actionCRUD)
							 {
								case "Save": admUserRepository.save(administratorUser);								
											 return "ConfirmationTestWindow";
											 
								case "Modify":  Optional<AdministratorUser> userToModify;
												userToModify = admUserRepository.findByCedulaUsuario(Long.parseLong(dataToCrud));
												if(userToModify.isPresent())
												{
												   AdministratorUser userToModifyIn = userToModify.get();   											   											  
												   model.addAttribute("userToModify", userToModifyIn);
												   model.addAttribute("idOfObjectToModify", String.valueOf(userToModifyIn.getCedulaUsuario()));
												   model.addAttribute("typeOfObjectEs", "usuario");
												   return module + "/" + "Modify";
												}
											    else
											    {
												   return "Templates2/NoEncontrado";
											    }
																							  	
												  
								case "Delete": Optional<AdministratorUser> userToDelete;
											   userToDelete = admUserRepository.findByCedulaUsuario(Long.parseLong(dataToCrud));
											   if(userToDelete.isPresent())
											   {
												   admUserRepository.delete(userToDelete.get());
												   return "ConfirmationTestWindow";
											   }
											   else
											   {
												   return "Templates2/NoEncontrado";
											   }							  	  				
								  
								case "Query":  Optional<AdministratorUser> userToQuery;
											   userToQuery = admUserRepository.findByCedulaUsuario(Long.parseLong(dataToCrud));
											   if(userToQuery.isPresent())
											   {											   
												   model.addAttribute("userToQuery", userToQuery.get());
												   return module + "/" + "Query";
											   }
											   else
											   {
												   return "Templates2/NoEncontrado";
											   }				  	  							
							}
				case "Clients":switch(actionCRUD)
								 {
								 	case "Save": clientRepository.save(client);
									 			 return "ConfirmationTestWindow";
								 	
								 	case "Modify":  Optional<Client> clientToModify;
								 					clientToModify = clientRepository.findByCedulaCliente(Long.parseLong(dataToCrud));
													if(clientToModify.isPresent())
													{
													   Client clientToModifyIn = clientToModify.get();
													   model.addAttribute("clientToModify", clientToModifyIn);
													   model.addAttribute("idOfObjectToModify", String.valueOf(clientToModifyIn.getCedulaCliente()));
													   model.addAttribute("typeOfObjectEs", "cliente");
													   return module + "/" + "Modify";
													}
												    else
												    {
													   return "Templates2/NoEncontrado";
												    }
													  
									case "Delete": Optional<Client> clientToDelete;
												   clientToDelete = clientRepository.findByCedulaCliente(Long.parseLong(dataToCrud));
												   if(clientToDelete.isPresent())
												   {
													   clientRepository.delete(clientToDelete.get());
													   return "ConfirmationTestWindow";
												   }
												   else
												   {
													   return "Templates2/NoEncontrado";
												   }
									  
									case "Query":  Optional<Client> clientToQuery;
												   clientToQuery = clientRepository.findByCedulaCliente(Long.parseLong(dataToCrud));
												   if(clientToQuery .isPresent())
												   {
													   model.addAttribute("clientToQuery", clientToQuery.get());
													   model.addAttribute("typeOfObjectEs", "cliente");
													   return module + "/" + "Query";
												   }
												   else
												   {
													   return "Templates2/NoEncontrado";
												   }
								}
				
				case "Suppliers":switch(actionCRUD)
								 {
								 	case "Save": supplierRepository.save(supplier);
									 			 return "ConfirmationTestWindow";
								 	
								 	case "Modify":  Optional<Supplier> supplierToModify;
								 					supplierToModify = supplierRepository.findByNitProveedor(Long.parseLong(dataToCrud));
													if(supplierToModify.isPresent())
													{
													   Supplier supplierToModifyIn = supplierToModify.get();
													   model.addAttribute("supplierToModify", supplierToModifyIn);
													   model.addAttribute("idOfObjectToModify", String.valueOf(supplierToModifyIn.getNitProveedor()));
													   model.addAttribute("typeOfObjectEs", "proveedor");
													   return module + "/" + "Modify";
													}
												    else
												    {
													   return "Templates2/NoEncontrado";
												    }
													  
									case "Delete": Optional<Supplier> supplierToDelete;
												   supplierToDelete = supplierRepository.findByNitProveedor(Long.parseLong(dataToCrud));
												   if(supplierToDelete.isPresent())
												   {
													   supplierRepository.delete(supplierToDelete.get());
													   return "ConfirmationTestWindow";
												   }
												   else
												   {
													   return "Templates2/NoEncontrado";
												   }
									  
									case "Query":  Optional<Supplier> supplierToQuery;
												   supplierToQuery = supplierRepository.findByNitProveedor(Long.parseLong(dataToCrud));
												   if(supplierToQuery .isPresent())
												   {
													   model.addAttribute("supplierToQuery", supplierToQuery.get());
													   model.addAttribute("typeOfObjectEs", "proveedor");
													   return module + "/" + "Query";
												   }
												   else
												   {
													   return "Templates2/NoEncontrado";
												   }
								}
								//Implement the rest of modules here
											 
			}
		}		
		catch(NumberFormatException e)
		{
			return "Templates2/NoEncontrado";
		}
		return "999999error";
	}
	
		
	/**The following methods deal with modify module which require an additional step
	 * 
	 * @param module The module chosen by the user
	 * @param userToModify  Recovers the model attribute generated by the previous view with attached
	 * data attributes binded by Thymeleaf depending on the module chosen.
	 * @param clientToModify
	 * @return
	 */
	@PostMapping("/Home/LogIn/Menu/Module/{module}/OptionCRUD/Modify/{idOfObjectToModify}")
	public String UpdateThirdStepForUsers(@PathVariable String module,
											@ModelAttribute AdministratorUser userToModify,
											@ModelAttribute Client clientToModify,
											@ModelAttribute Supplier supplierToModify)
											
								
	{	
		switch(module)
		{
			case "Users": admUserRepository.save(userToModify);
							return "ConfirmationTestWindow";
							
			case "Clients": clientRepository.save(clientToModify);
							return "ConfirmationTestWindow";
										
			case "Suppliers": supplierRepository.save(supplierToModify);
							return "ConfirmationTestWindow";										
		}
		return "9999error";
	}
	
	//Deals with uploading of products
	@PostMapping("/Home/LogIn/Menu/Module/Products")
	public String uploadsProducts(@RequestParam(name="Products") MultipartFile file)
	{
		try
		{			
			String[] data = new String(file.getBytes(), java.nio.charset.StandardCharsets.UTF_8).split("\n");
						
			Product newProduct = new Product();
			
			for(int i = 0; i < data.length; i++) 
			{				
				StringTokenizer st = new StringTokenizer(data[i], ",");
                newProduct.setCodigoProducto(Integer.parseInt(st.nextToken()));
                newProduct.setIvaCompra(Double.parseDouble(st.nextToken()));
                newProduct.setNitProveedor(Long.parseLong(st.nextToken()));
                newProduct.setNombreProducto(st.nextToken());
                newProduct.setPrecioCompra(Double.parseDouble(st.nextToken()));
                newProduct.setPrecioVenta(Double.parseDouble(st.nextToken()));
                
                productRepository.save(newProduct);
            }							
		}
		catch(IOException e)
		{
			return "redirect: /Home/LogIn/Menu/Module";
		}
		
		return "ConfirmationTestWindow";
	}
}
