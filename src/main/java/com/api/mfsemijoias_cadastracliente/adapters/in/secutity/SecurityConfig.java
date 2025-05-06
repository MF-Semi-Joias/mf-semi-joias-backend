package com.api.mfsemijoias_cadastracliente.adapters.in.secutity;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final PrimeiroUsuarioFiltro primeiroUsuarioFiltro;

    public SecurityConfig(PrimeiroUsuarioFiltro primeiroUsuarioFiltro) {
        this.primeiroUsuarioFiltro = primeiroUsuarioFiltro;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/clientes/**").access((authentication, context) -> {
                            HttpServletRequest request = context.getRequest();
                            Boolean primeiroUsuario = (Boolean) request.getAttribute("primeiroUsuario");
                            Authentication authObj = authentication.get();
                            boolean isAuthorized = (primeiroUsuario != null && primeiroUsuario) ||
                                                   (authObj != null && authObj.isAuthenticated());
                            return new AuthorizationDecision(isAuthorized);
                        })
                        .anyRequest().authenticated()
                )
                .addFilterBefore(primeiroUsuarioFiltro, UsernamePasswordAuthenticationFilter.class)
                .httpBasic(httpBasic -> {});

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}