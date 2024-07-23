package in.prachi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean 
	public InMemoryUserDetailsManager configureUsers() {
		UserDetails prachiUser = User.withDefaultPasswordEncoder()
		.username("prachi")
		.password("abc@123")
		.authorities("ADMIN")
		.build();
		
		UserDetails johnUser = User.withDefaultPasswordEncoder()
		.username("john")
		.password("1234fr")
		.authorities("USER")
		.build();
		//initializing the bean with the two user objects
		return new InMemoryUserDetailsManager(prachiUser, johnUser);
	}
@Bean
/*
 *this annotation is used to represent our method return type as a
 spring bean whatever the method is returning it 
 will be represented as a spring bean*/
public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
	http.authorizeHttpRequests((request)-> request
			
			.requestMatchers("/contact","/about","/swagger-ui.html").permitAll()
			.anyRequest().authenticated()
			).formLogin();
	return http.build();
}
	
}
