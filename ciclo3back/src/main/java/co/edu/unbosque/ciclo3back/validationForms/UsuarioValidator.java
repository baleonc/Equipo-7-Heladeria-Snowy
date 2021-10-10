package co.edu.unbosque.ciclo3back.validationForms;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co.edu.unbosque.ciclo3back.JPAdataAccess.AdmUserRepository;
import co.edu.unbosque.ciclo3back.model.AdministratorUser;


@Component
public class UsuarioValidator implements Validator
{	
	@Autowired
	private AdmUserRepository admUserRepositoryIn;
	
	@Override
	public boolean supports(Class<?> clazz)
	{
		return AdministratorUser.class.isAssignableFrom(clazz);
	}
	@Override
	public void validate(Object target, Errors errors)
	{
		AdministratorUser user = (AdministratorUser) target;
		String usuario = user.getUsuario();
		String password = user.getPassword();
		
		Optional<AdministratorUser> userByUsuario = admUserRepositoryIn.findByUsuario(usuario);
		Optional<AdministratorUser> userByPassword = admUserRepositoryIn.findByPassword(password);
		if(userByUsuario.isEmpty())
		{
			errors.rejectValue("usuario", "usuario.incorrect", "Incorrect user");		
		}
		if(userByPassword.isEmpty())
		{
			errors.rejectValue("password", "password.incorrect", "Incorrect password");
		}
	}
}
