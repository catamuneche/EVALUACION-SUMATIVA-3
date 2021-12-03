package com.nttdata3.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService usd;
	
	@Override
 	protected void configure(HttpSecurity http) throws Exception {
 		http.authorizeRequests()
 		.antMatchers("/login","/registro","/usuario/registrar","/usuario/registro","/","/usuario/login", "usuario/entrar")// /css/**, js/**,
 		.permitAll()
// 		.anyRequest().authenticated()
 		//.hasRole("USER")
 		.and()
 		.formLogin()
	 		.loginPage("/login") 
		        .loginProcessingUrl("/usuario/login")
		        .defaultSuccessUrl("/home")
		        .failureUrl("/access_denied")
 			.permitAll()
 			.usernameParameter("email").passwordParameter("password")
 		.and()
 		.logout().permitAll();
 	
 	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usd).passwordEncoder(bCryptPasswordEncoder());
	}
	
}

