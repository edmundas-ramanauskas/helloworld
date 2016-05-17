package com.ibm.test.hello;

import com.ibm.test.GreetingApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by edmundas on 16.5.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = GreetingApplication.class)
@WebAppConfiguration
public class HelloControllerTest {

    private static final String CONTENT_TYPE = "application/json;charset=UTF-8";
    private static final String JSON_PATH = "$.message";

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        this.mockMvc.perform(get("/helloworld").accept(MediaType.parseMediaType(CONTENT_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath(JSON_PATH).value("Hello World !"));
    }

    @Test
    public void testHello() throws Exception {
        this.mockMvc.perform(post("/hello").accept(MediaType.parseMediaType(CONTENT_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath(JSON_PATH).value("Hello World !"));
    }

    @Test
    public void testHelloWithName() throws Exception {
        this.mockMvc.perform(post("/hello?name=Developer").accept(MediaType.parseMediaType(CONTENT_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath(JSON_PATH).value("Hello Developer !"));
    }
}
