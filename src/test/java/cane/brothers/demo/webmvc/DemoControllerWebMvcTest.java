package cane.brothers.demo.webmvc;

import cane.brothers.demo.DemoController;
import cane.brothers.demo.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * If you want to focus only on the web layer and not start a complete ApplicationContext,
 * consider using @WebMvcTest instead.
 * Test will work only if @SpringBootApplication or @SpringBootConfiguration is available
 */
@WebMvcTest(DemoController.class)
class DemoControllerWebMvcTest {

    @Autowired
    private WebApplicationContext context;

    @MockitoBean
    private DemoService demoSvc;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
    }

    @Test
    void test_greeting() throws Exception {
        // given
        when(demoSvc.sayHello("Test"))
                .thenReturn("Hello, Test!");

        // when/then
        mockMvc.perform(get("/api/hello?name=Test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Test!"));

//        verify(demoSvc).sayHello(any(User.class));
    }
}