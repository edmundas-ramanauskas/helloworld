package com.ibm.test.hello;

import com.ibm.test.GreetingApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
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
    private static final byte[] KITTY_RESPONSE = "KITTY".getBytes();

    @Mock
    private KittyService kittyService;
    @Mock
    private HelloService helloService;

    @InjectMocks
    private HelloController helloController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
    }

    @Test
    public void testHelloWorld() throws Exception {
        when(helloService.sayHello(anyString())).thenReturn(new HelloModel("Hello World !"));
        this.mockMvc.perform(get("/helloworld").accept(MediaType.parseMediaType(CONTENT_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath(JSON_PATH).value("Hello World !"));
    }

    @Test
    public void testHello() throws Exception {
        when(helloService.sayHello(anyString())).thenReturn(new HelloModel("Hello World !"));
        this.mockMvc.perform(post("/hello").accept(MediaType.parseMediaType(CONTENT_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath(JSON_PATH).value("Hello World !"));
    }

    @Test
    public void testHelloWithName() throws Exception {
        when(helloService.sayHello(anyString())).thenReturn(new HelloModel("Hello Developer !"));
        this.mockMvc.perform(post("/hello?name=Developer").accept(MediaType.parseMediaType(CONTENT_TYPE)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(CONTENT_TYPE))
                .andExpect(jsonPath(JSON_PATH).value("Hello Developer !"));
    }

    @Test
    public void testHelloKitty() throws Exception {
        when(kittyService.getKitty()).thenReturn(KITTY_RESPONSE);
        this.mockMvc.perform(get("/hellokitty").accept(MediaType.IMAGE_JPEG))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.IMAGE_JPEG))
                .andExpect(content().bytes(KITTY_RESPONSE));
    }
}
