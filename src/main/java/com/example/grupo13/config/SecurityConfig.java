package com.example.grupo13.config;

import static org.springframework.security.web.util.matcher.AntPathRequestMatcher.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth
				.requestMatchers("/", "/home", "/register", "/events").permitAll()
				.requestMatchers("/profile", "/events/**").authenticated()
				.requestMatchers("/events/nuevo", "/events/guardar", "/events/eliminar/**").hasRole("ADMIN")
				.anyRequest().denyAll())
				.formLogin(form -> form
						.loginPage("/login")
						.defaultSuccessUrl("/profile", true)
						.permitAll())
				.logout(logout -> logout
						.logoutRequestMatcher(antMatcher("/logout"))
						.logoutSuccessUrl("/")
						.permitAll());
		return http.build();
	}


	@Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        UserDetails admin = User.builder()
        .username("admin@example.com")
        .password(passwordEncoder().encode("admin123"))
        .roles("ADMIN")
        .build();

        UserDetails user = User.builder()
        .username("usuario@example.com")
        .password(passwordEncoder().encode("user123"))
        .roles("USER")
        .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
}
