package pe.sermaluc.register.contract.request;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestUserRegister {

    @NotNull
    @NotBlank
    private String name;
    @NotNull
    @NotBlank
    @NotEmpty
    @Email(message = "El correo no tiene el formato")
    private String email;
    @NotNull
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
