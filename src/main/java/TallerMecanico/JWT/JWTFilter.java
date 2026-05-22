package TallerMecanico.JWT;

import TallerMecanico.JWT.Usuarios.EmpleadoDetallesServicio;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JWTFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final TallerMecanico.JWT.Usuarios.MecanicoDatallesServicio mecanicoDatallesServicio;
    private final TallerMecanico.JWT.Usuarios.ClienteDetallesServicio clienteDetallesServicio;
    private final EmpleadoDetallesServicio empleadoDetallesServicio;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        UserDetails userDetails = null; //almacena el usuario temporalmente

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {

            String jwt = token.substring(7);

             Boolean vigente = jwtUtil.verificarToken(jwt);

             if (vigente) {
                 String correo = jwtUtil.obtenerCorreo(jwt);
                 String rol = jwtUtil.extraerRol(jwt);

                 switch (rol){
                     case "MECANICO": userDetails = mecanicoDatallesServicio.loadUserByUsername(correo); break;
                     case "EMPLEADO": userDetails = empleadoDetallesServicio.loadUserByUsername(correo); break;
                     case "CLIENTE": userDetails = clienteDetallesServicio.loadUserByUsername(correo); break;
                     default: filterChain.doFilter(request, response);
                 }

                Boolean valido =  jwtUtil.valido(jwt, correo);

                 if (valido) {

                     //pase de acceso con: usuario, credenciales = null, permisos
                     UsernamePasswordAuthenticationToken autenticado = new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());

                     //entrega de acceso a spring
                     SecurityContextHolder.getContext().setAuthentication(autenticado);
                     filterChain.doFilter(request, response);
                 }
             }
        }
        else filterChain.doFilter(request, response);
    }
}