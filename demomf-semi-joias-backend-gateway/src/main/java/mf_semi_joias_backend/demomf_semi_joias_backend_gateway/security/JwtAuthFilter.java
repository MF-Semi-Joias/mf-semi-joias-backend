package mf_semi_joias_backend.demomf_semi_joias_backend_gateway.security;

    import org.springframework.cloud.gateway.filter.GlobalFilter;
    import org.springframework.core.Ordered;
    import org.springframework.cloud.gateway.filter.GatewayFilterChain;
    import org.springframework.http.HttpStatus;
    import org.springframework.stereotype.Component;
    import org.springframework.web.server.ServerWebExchange;
    import reactor.core.publisher.Mono;

    @Component
    public class JwtAuthFilter implements GlobalFilter, Ordered {

        @Override
        public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
            String path = exchange.getRequest().getPath().toString();
            if (path.startsWith("/auth")) {
                return chain.filter(exchange); // Libera rotas públicas
            }
            String authHeader = exchange.getRequest().getHeaders().getFirst("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
                return exchange.getResponse().setComplete();
            }
            String token = authHeader.substring(7);
            // Valide o token aqui
            return chain.filter(exchange);
        }

        @Override
        public int getOrder() {
            return -1;
        }
    }