package TallerMecanico.JWT;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "k7Hm2pX9vL4nQ8wR1yT6uI3oE5sA0jC2dF7gB4hK9mN";
    //24 Horas
    private static final long EXPIRATION_TIME = 86400000;

    //genera la firma "Key"
    private Key ObetenerKeyInciar(){
        byte[] bitesCrudos;
        bitesCrudos = Decoders.BASE64.decode(SECRET_KEY);
        Key key = Keys.hmacShaKeyFor(bitesCrudos);
        return key;
    }

    public String generarToken(String correo, String rol) {

        Date fecha = new Date();
        Date fechaCreacion = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
        Key key = ObetenerKeyInciar();

        return Jwts.builder()
                .setSubject(correo)
                .setIssuedAt(fecha)
                .claim("rol",rol )
                .setExpiration(fechaCreacion)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extraerRol(String token){

        return extraerClaims(token).get("rol").toString();
    }

    public Claims extraerClaims(String token){

        Key key = ObetenerKeyInciar();
        Claims claims;


        return claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String obtenerCorreo(String token){
        String correo = extraerClaims(token).getSubject();
        return correo;
    }

    public Boolean verificarToken(String token){

        boolean vigente = true;

        if (extraerClaims(token).getExpiration().before(new Date())) {return false;}
        return vigente;
    }


    public Boolean valido(String token, String correo){

        boolean correoValidado = verificarToken(correo);
        boolean correoComparar = !obtenerCorreo(token).equals(correo);

        return correoComparar && correoValidado;
    }

}