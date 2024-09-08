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
                .setId(UUID.randomUUID().toString())
                .setSubject(name)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600000))
                .signWith(SignatureAlgorithm.HS256, configPropertiesService.getJwtSecret().getBytes())
                .compact();
    }

    public Boolean validRegexPassword(String password) {
            Pattern passwordRegexp = Pattern.compile(configPropertiesService.getPasswordRegexp());
            return passwordRegexp.matcher(password).matches() ? Boolean.TRUE : Boolean.FALSE;
    }
}
