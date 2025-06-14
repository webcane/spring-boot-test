package cane.brothers.demo.webmvc;

import cane.brothers.demo.DemoController;
import cane.brothers.demo.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * test will work only if @SpringBootApplication or @SpringBootConfiguration is available
 */
@WebMvcTest(DemoController.class)
@AutoConfigureMockMvc
class DemoControllerAutoconfigureMockWebMvcTest {

    @MockitoBean
    private DemoService demoSvc;

    @Test
    void test_greeting(@Autowired MockMvc mockMvc) throws Exception {
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