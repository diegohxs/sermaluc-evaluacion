package pe.sermaluc.register.config;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Data
public class ConfigPropertiesService {

    @Value("${user.validation.regex.password}")
    private String passwordRegexp;

    @Value("${app.jwtSecret}")
    private String jwtSecret;
}
