package co.edu.unbosque.ciclo3back.securityConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	
	@Autowired
	private UserDetailsService customUserDetailsService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	return NoOpPasswordEncoder.getInstance();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth)
	throws Exception
	{
		auth
		.userDetailsService(customUserDetailsService)
		.passwordEncoder(passwordEncoder());
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception 
	{		
		http		
			.authorizeRequests()								
				.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/Home/LogIn/Menu")
				.permitAll()
				.and()			
			.logout()
				.permitAll();								
	}	
}
