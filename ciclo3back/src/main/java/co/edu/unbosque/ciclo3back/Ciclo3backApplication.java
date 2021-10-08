package co.edu.unbosque.ciclo3back;

import org.slf4j.LoggerFactory;

import org.slf4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ModelAttribute;

import co.edu.unbosque.ciclo3back.JPAdataAccess.AdmUserRepository;
import co.edu.unbosque.ciclo3back.JPAdataAccess.ClientRepository;
import co.edu.unbosque.ciclo3back.model.AdministratorUser;
import co.edu.unbosque.ciclo3back.model.Client;

@SpringBootApplication
public class Ciclo3backApplication 
{
	
	public static final Logger log = LoggerFactory.getLogger(Ciclo3backApplication.class);

	public static void main(String[] args) 
	{
		SpringApplication.run(Ciclo3backApplication.class);		
	}
	
	//Hola
	
	@Bean
	public CommandLineRunner demo(ClientRepository ClientRepositoryIn)
	{
		return (args) ->
		{
			//Save some usuarios
			/*repository.save(new Usuario(1,"@DobleH", "Doble h", "password", "FirstUser"));
			repository.save(new Usuario(2, "@DobleJ", "Doble j", "passwordj", "SecondUser"));*/
						
			
			log.info("All clients");
			log.info("--------------------");
			for(Client client: ClientRepositoryIn.findAll())
			{
				log.info(client.toString());
			}
			log.info("");
			
			//Using the method that extends RepositoryCrud for "usuario" repository
			/*log.info("Using the method findByCedulaUsuario()");
			log.info("---------------------");
			Usuario aUsuario = UsuarioRepositoryIn.findByCedulaUsuario("3154339545");
			log.info(aUsuario.toString());*/
			
		};
	}
}
