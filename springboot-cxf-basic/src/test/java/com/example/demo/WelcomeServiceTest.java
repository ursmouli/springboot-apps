package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.cxf.jaxrs.client.WebClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;

@SpringBootTest(classes = SpringbootCxfBasicApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class WelcomeServiceTest {

	@LocalServerPort
    private int port;
	
	@Test
    public void testHelloRequest() throws Exception {
        WebClient wc = WebClient.create("http://localhost:" + port + "/myapp/api");
        wc.accept("text/plain");
        
        wc.path("welcome").path("Name");
        String greeting = wc.get(String.class);
        assertEquals("Welcome Name to CXF restful webserice!!! Username!!!", greeting);
	}
}
