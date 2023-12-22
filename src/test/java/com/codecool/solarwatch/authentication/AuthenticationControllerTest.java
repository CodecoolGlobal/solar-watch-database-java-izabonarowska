package com.codecool.solarwatch.authentication;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = AuthenticationController.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application.properties")
public class AuthenticationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private AuthenticationService authenticationService;

    @MockBean
    private AuthenticationController authenticationController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testRegistrationSubmission() throws Exception {
        RegisterRequest registerRequest = new RegisterRequest("test@test.pl", "test");
       mockMvc.perform(MockMvcRequestBuilders.post("/register")
                        .flashAttr("registerRequest", registerRequest))
                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/confirmation"));

        verify(authenticationService, times(1)).register(ArgumentMatchers.argThat(argument ->
                        argument.getEmail().equals("test@test.pl")&&
                        argument.getPassword().equals("test")));

    }
}