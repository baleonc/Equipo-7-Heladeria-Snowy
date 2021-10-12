package co.edu.unbosque.ciclo3back.securityConfig;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.unbosque.ciclo3back.JPAdataAccess.AdmUserRepository;
import co.edu.unbosque.ciclo3back.model.AdministratorUser;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService
{
	@Autowired
	private AdmUserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName)
	throws UsernameNotFoundException 
	{
		Optional<AdministratorUser> user = userRepository.findByUsuario(userName);
		if(user.isEmpty())
		{
			throw new UsernameNotFoundException("Not found user"); 
		}
		 
		return new org.springframework.security.core.userdetails.User(
		user.get().getUsuario(),
		user.get().getPassword(),
		Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
	}
}
