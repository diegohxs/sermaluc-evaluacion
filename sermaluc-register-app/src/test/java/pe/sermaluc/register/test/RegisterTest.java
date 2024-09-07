package pe.sermaluc.register.test;


import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import pe.sermaluc.register.RegisterApplicationMain;
import pe.sermaluc.register.controller.RegisterController;
import pe.sermaluc.register.services.RegisterService;

import java.nio.file.Files;
import java.nio.file.Paths;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = RegisterApplicationMain.class)
@AutoConfigureMockMvc
public class RegisterTest {
    @Autowired
    protected MockMvc mvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.standaloneSetup(RegisterController.class).build();
    }


    @Test
    public void registerPostUserCreated() throws Exception {


        mvc.perform(MockMvcRequestBuilders
                        .post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(prepareDataToRegisterController("bodyRegister")))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }


    @Test
    public void registerPostUserForbidden() throws Exception {

        mvc.perform(MockMvcRequestBuilders
                        .post("/user/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(String.valueOf(prepareDataToRegisterController("bodyForbiddenRegister")))
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    private String prepareDataToRegisterController(String jsonBody) {
        String jsonRequest = null;
        try {
            jsonRequest = new String(Files.readAllBytes(Paths.get(getClass().getResource(
                    "/jsonsForTest/" + jsonBody + ".json").toURI())));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonRequest;
    }
}

