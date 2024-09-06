package pe.sermaluc.register.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.sermaluc.register.contract.request.RequestUserRegister;
import pe.sermaluc.register.contract.response.ResponseUserRegister;
import pe.sermaluc.register.services.RegisterService;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

    private static String NULL = null;

    private final RegisterService registerService;

    @PostMapping("/user")
    public ResponseEntity<?> postRegisterUser(@RequestBody RequestUserRegister requestUserRegister) throws Exception {
        ResponseUserRegister response = registerService.postUserRegister(requestUserRegister);
        return ResponseEntity.status(response.getMessage() != NULL ?
                        HttpStatus.FORBIDDEN : HttpStatus.CREATED)
                .body(response);
    }
}
