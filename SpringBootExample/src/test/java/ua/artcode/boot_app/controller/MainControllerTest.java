package ua.artcode.boot_app.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import ua.artcode.boot_app.dto.GeneralResponse;
import ua.artcode.boot_app.model.User;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MainControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testPostUser() throws Exception {
        ResponseEntity<GeneralResponse> responseEntity = restTemplate
                .postForEntity("http://localhost:" + port + "/app/" + "user", new User(2, "Kolia"),
                        GeneralResponse.class);

        GeneralResponse generalResponse = responseEntity.getBody();

        assertThat(responseEntity.getStatusCode(), is(HttpStatus.OK));
        assertThat(generalResponse.getMessage(), is("success"));
    }

}