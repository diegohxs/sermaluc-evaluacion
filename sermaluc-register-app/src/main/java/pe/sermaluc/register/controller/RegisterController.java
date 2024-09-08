package pe.sermaluc.register.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.sermaluc.register.contract.request.RequestUserRegister;
import pe.sermaluc.register.contract.response.ResponseUserRegister;
import pe.sermaluc.register.services.RegisterService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@Slf4j
public class RegisterController {

    private static String NULL = null;

    private final RegisterService registerService;
    @Operation(summary = "register", description = "register new user")
    @ApiResponses(value={@ApiResponse(responseCode = "201",description = "Successful",content ={
            @Content(mediaType = "application/json", schema =
            @Schema(implementation = ResponseUserRegister.class))
    })
    })
    @PostMapping("/register")
    public ResponseEntity<ResponseUserRegister> postRegisterUser(@Valid @RequestBody RequestUserRegister requestUserRegister) throws Exception {
        ResponseUserRegister response = registerService.postUserRegister(requestUserRegister);
        return ResponseEntity.status(response.getMessage() != NULL ?
                        HttpStatus.FORBIDDEN : HttpStatus.CREATED)
                .body(response);
    }
}
