package pe.sermaluc.register.contract.request;


import lombok.Data;

import javax.validation.constraints.Email;
import java.util.List;

@Data
public class RequestUserRegister {

    private String name;
    @Email(message = "El correo no tiene el formato")
    private String email;
    private String password;
    List<PhoneRegister> phones;

    @Data
    public static class PhoneRegister {
        private String number;
        private String cityCode;
        private String countryCode;

        public PhoneRegister(String number, String number1, String number2) {
        }
    }
}
