package TallerMecanico.JWT.Usuarios;

import TallerMecanico.entity.ClienteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteDetallesServicio implements UserDetailsService {

    private final TallerMecanico.repository.ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        ClienteEntity paciente = clienteRepository.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("Cliente no encontrado con correo: " + correo));

        //objeto user -implementaición
        return User.builder()
                .username(paciente.getCorreo())
                .password(paciente.getPasswordHash())
                .roles("CLIENTE")
                .build();
    }
}
