//package com.codecool.solarwatch.user.controller;
//
//import com.codecool.solarwatch.security.config.JwtService;
//import com.codecool.solarwatch.user.model.UserRegistrationDTO;
//import com.codecool.solarwatch.user.service.UserService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.InjectMocks;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.context.TestPropertySource;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
//
//@WebMvcTest(RegistrationController.class)
//@TestPropertySource(locations = "classpath:application-test.properties")
//class RegistrationControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private UserService userService;
//
//    @MockBean
//    private JwtService jwtService;
//    @InjectMocks
//    private RegistrationController registrationController;
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    public void testRegistrationForm() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/register"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("registration-form"));
//    }
//
//    @Test
//    public void testRegistrationSubmission() throws Exception {
//        UserRegistrationDTO userRegistrationDTO =
//                new UserRegistrationDTO("Iza", "Bon", "test@test.pl", "test");
//
//        mockMvc.perform(MockMvcRequestBuilders.post("/register")
//                        .flashAttr("userRegistrationDto", userRegistrationDTO))
//                .andExpect(MockMvcResultMatchers.status().is3xxRedirection())
//                .andExpect(MockMvcResultMatchers.redirectedUrl("/confirmation"));
//
//        verify(userService, times(1)).register(ArgumentMatchers.argThat(argument ->
//                argument.firstName().equals("Iza") && argument.lastName().equals("Bon")
//                        && argument.email().equals("test@test.pl")&&
//                        argument.password().equals("test")));
//
//    }
//    @Test
//    public void testRegistrationConfirmation() throws Exception {
//        mockMvc.perform(MockMvcRequestBuilders.get("/confirmation"))
//                .andExpect(MockMvcResultMatchers.status().isOk())
//                .andExpect(MockMvcResultMatchers.view().name("registration-confirmation"));
//    }
//
//
//}