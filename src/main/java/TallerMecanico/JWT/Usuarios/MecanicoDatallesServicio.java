package TallerMecanico.JWT.Usuarios;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MecanicoDatallesServicio implements UserDetailsService {

    TallerMecanico.repository.MecanicoRepository mecanicoRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        TallerMecanico.entity.MecanicoEntity nutriologas = mecanicoRepository.findByCorreo(correo).orElseThrow(() -> new UsernameNotFoundException("No se encontro el correo: "+correo));

        //objeto user -implementaición
        return User.builder()
                .username(nutriologas.getCorreo())
                .password(nutriologas.getPasswordHash())
                .roles("MECANICO")
                .build();
    }
}
