package com.technicaltest.shoppingcart.config;

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
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/products").authenticated()  // Requires authentication
                                .requestMatchers("/api/orders/**").authenticated()  // Requires authentication
                                .requestMatchers("/api/payments/**").authenticated() // Requires authentication
                                .anyRequest().authenticated()  // Requires authentication for other request
                )
                .httpBasic(customizer -> {});

        return http.build();
    }
}
