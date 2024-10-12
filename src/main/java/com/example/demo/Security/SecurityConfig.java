package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/floristeria/login", "/public/**").permitAll() // Permitir acceso a /floristeria/login
                .anyRequest().authenticated()
            )
            .formLogin((form) -> form
                .loginPage("/floristeria/login")
                .defaultSuccessUrl("/flores/listar", true) // Redirigir a /flores/listar después de un inicio de sesión exitoso
                .permitAll()
            )
            .logout((logout) -> logout.permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.builder()
            .username("user")
            .password("{noop}admin")
            .roles("USER")
            .build();

            UserDetails administradoUserDetails = User.builder()
                .username("admin")
                .password("{noop}admin") 
                .roles("ADMIN")
                .build();
                

        return new InMemoryUserDetailsManager(user, administradoUserDetails);
    }
}
