package com.smartsamagri.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/recipes/findRecipes") // Disable CSRF protection for the /recipes/findRecipes endpoint
            )
            .authorizeHttpRequests(authorizeHttpRequests ->
                authorizeHttpRequests
                    .requestMatchers( "/health","/users/signin","/users/signup").permitAll() // Allow access to /login and /health without authentication
                    .requestMatchers("/users/**").authenticated()
                    .anyRequest().permitAll() // Require authentication for all other requests
            )
            .formLogin(formLogin -> formLogin.defaultSuccessUrl("/")) // Use default login page
            .logout(logout -> logout.logoutSuccessUrl("/")); // Use default logout

        return http.build();
    }
}
