package com.api.mfsemijoias_cadastracliente.adapters.in.secutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilita CSRF usando o novo padrão
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/clientes/**").permitAll(); // Permite acesso público aos endpoints de clientes
                auth.anyRequest().permitAll(); // Permite acesso público a qualquer outro endpoint
            });

        return http.build();
    }
}