package pe.sermaluc.register.services.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import pe.sermaluc.register.contract.request.RequestUserRegister;
import pe.sermaluc.register.contract.response.ResponseUserRegister;
import pe.sermaluc.register.repository.RegisterRepository;
import pe.sermaluc.register.repository.entity.Phone;
import pe.sermaluc.register.repository.entity.User;
import pe.sermaluc.register.services.RegisterService;
import pe.sermaluc.register.util.UtilService;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class RegisterServiceImpl implements RegisterService {

    private final RegisterRepository registerRepository;
    private final UtilService utilService;

    public ResponseUserRegister postUserRegister(RequestUserRegister requestUserRegister) throws Exception {


        try {
            String validationCase = validationCase(requestUserRegister);
            if (!validationCase.equalsIgnoreCase("")) {
                return ResponseUserRegister.builder().message(validationCase).build();
            }
            User newUser = User.builder()
                    .email(requestUserRegister.getEmail())
                    .name(requestUserRegister.getName())
                    .customerRegister(UUID.randomUUID().toString())
                    .password(requestUserRegister.getPassword())
                    .phones(requestUserRegister.getPhones().stream()
                            .map(phone -> new Phone(phone.getNumber(), phone.getCityCode(), phone.getCountryCode()))
                            .collect(Collectors.toList()))
                    .build();

            newUser.setToken(utilService.generateToken(newUser.getName()));
            User responseUser = registerRepository.save(newUser);

            return ResponseUserRegister.builder()
                    .created(responseUser.getCreated())
                    .id(responseUser.getCustomerRegister())
                    .isActive(responseUser.isActive())
                    .lastLogin(responseUser.getLastLogin())
                    .modified(responseUser.getModified())
                    .token(responseUser.getToken())
                    .build();
        } catch (Exception e) {
            log.error("Error {}", e.getCause());
            throw new Exception(e);
        }
    }

    public String validationCase(RequestUserRegister requestUserRegister) {
        Optional<User> userExist = registerRepository.findByEmail(requestUserRegister.getEmail());
        if (userExist.isPresent()) {
            return "El correo ya se encuentra registrado";
        } else {
            return utilService.validRegexPassword(requestUserRegister.getPassword()).equals(Boolean.FALSE) ? "El password no cumple con el formato" : "";
        }
    }


}
