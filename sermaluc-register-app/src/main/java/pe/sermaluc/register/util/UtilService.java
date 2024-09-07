package pe.sermaluc.register.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pe.sermaluc.register.config.ConfigPropertiesService;

import java.util.Date;
import java.util.UUID;
import java.util.regex.Pattern;

@Component
@RequiredArgsConstructor
@Slf4j
public class UtilService {

    private final ConfigPropertiesService configPropertiesService;

    public String generateToken(String name) {
        return Jwts.builder()
                .setId(UUID.randomUUID().toString())  // Generar ID único
                .setSubject(name)  // Establecer el subject (usuario, por ejemplo)
                .setIssuedAt(new Date())  // Fecha de emisión
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))  // 1 hora de validez
                .signWith(SignatureAlgorithm.HS256, configPropertiesService.getJwtSecret().getBytes())  // Algoritmo HS256 y clave secreta
                .compact();
    }

    public Boolean validRegexPassword(String password) {
        try {
            Pattern passwordRegexp = Pattern.compile(configPropertiesService.getPasswordRegexp());
            return passwordRegexp.matcher(password).matches() ? Boolean.TRUE : Boolean.FALSE;
        }catch (Exception e) {
            throw e;
        }
    }
}
