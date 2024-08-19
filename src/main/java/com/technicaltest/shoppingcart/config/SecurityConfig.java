package com.technicaltest.shoppingcart.config;

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
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/api/products").hasAnyRole("USER", "ADMIN")  // Only users with the USER rol can access
                                .requestMatchers("/api/orders/**").hasRole("ADMIN")  // Only users with the ADMIN rol can access
                                .requestMatchers("/api/payments/**").hasAnyRole("USER", "ADMIN") // Both roles can access
                                .anyRequest().authenticated()  // Requires authentication for other request
                )
                .httpBasic(customizer -> {});

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
        UserDetails user = User.builder()
                .username("shoppingUser")
                .password(passwordEncoder.encode("Sh0ppingUs3rS3cur3!"))
                .roles("USER")
                .build();

        UserDetails admin = User.builder()
                .username("shoppingAdmin")
                .password(passwordEncoder.encode("Sh0ppingC@rtS3cur3!"))
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
