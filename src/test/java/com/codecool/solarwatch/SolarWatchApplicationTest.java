//package com.codecool.solarwatch;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
//
//import com.codecool.solarwatch.user.controller.LoginController;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.test.web.server.LocalServerPort;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//
//@ExtendWith(SpringExtension.class)
//@SpringBootTest(webEnvironment = RANDOM_PORT)
//class SolarWatchApplicationTest {
//    @Autowired
//    private LoginController loginController;
//    @Autowired
//    private TestRestTemplate testRestTemplate;
//    @LocalServerPort
//    private int port;
//
//
//    @Test
//    void contextLoads() throws Exception {
//        assertThat(loginController).isNotNull();
//    }
//
//    @Test
//    public void testRestEndpoint() {
//        String url = "http://localhost:" + port + "/login-form";
//        String response = testRestTemplate.getForObject(url, String.class);
//        assertNotNull(response);
//    }
//
//}