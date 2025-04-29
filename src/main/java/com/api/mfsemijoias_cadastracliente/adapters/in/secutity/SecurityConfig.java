package com.api.mfsemijoias_cadastracliente.adapters.in.secutity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()) // Desabilita CSRF
                .authorizeHttpRequests(auth -> {
                    auth.requestMatchers("/clientes/**").authenticated(); // Protege os endpoints de clientes
                    auth.anyRequest().permitAll(); // Permite acesso público a outros endpoints
                })
                .httpBasic(httpbasic -> {}); // Habilita autenticação HTTP Basic

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Configura o encoder de senhas
    }
}