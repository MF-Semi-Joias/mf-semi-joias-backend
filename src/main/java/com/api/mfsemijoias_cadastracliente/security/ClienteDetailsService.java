package com.api.mfsemijoias_cadastracliente.security;

    import com.api.mfsemijoias_cadastracliente.domain.model.Cliente;
    import com.api.mfsemijoias_cadastracliente.ports.in.ClienteService;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.core.userdetails.UsernameNotFoundException;
    import org.springframework.stereotype.Service;

    @Service
    public class ClienteDetailsService implements UserDetailsService {

        private final ClienteService clienteService;

        public ClienteDetailsService(ClienteService clienteService) {
            this.clienteService = clienteService;
        }

        @Override
        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
            Cliente cliente = clienteService.buscarClientePorUsuario(username);
            if (cliente == null) {
                throw new UsernameNotFoundException("Usuário não encontrado: " + username);
            }
            return User.builder()
                    .username(cliente.getUsuario())
                    .password(cliente.getSenha())
                    .roles("USER") // Defina os papéis do usuário
                    .build();
        }
    }