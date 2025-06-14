package cane.brothers.demo.mockmvc;

import cane.brothers.demo.DemoController;
import cane.brothers.demo.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * works without Spring context at all
 */
class DemoControllerPureMockMvcTest {

    private MockMvc mockMvc;

    @BeforeEach
    public void setMockMvc() {
        var demoSvc = new DemoService();
        var demoCmd = new DemoController(demoSvc);
        mockMvc = MockMvcBuilders.standaloneSetup(demoCmd).build();
    }

    @Test
    void test_greeting() throws Exception {
        // when/then
        mockMvc.perform(get("/api/hello?name=Test"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Test!"));
    }
}