package pe.sermaluc.register.contract.request;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class RequestUserRegister {

    @NotBlank(message = "name is mandatory")
    private String name;
    @NotBlank(message = "email is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.cl$", message = "The email must follow the format aaaaaaa@dominio.cl")
    //Regex generico para validar correos correctos
    // @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$"")
    @Email(message = "Email is not in the correct format")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;
    List<PhoneRegister> phones;

    @Data
    @AllArgsConstructor
    public static class PhoneRegister {
        private String number;
        private String cityCode;
        private String countryCode;

    }
}
