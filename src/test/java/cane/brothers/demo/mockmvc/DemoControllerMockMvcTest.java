package cane.brothers.demo.mockmvc;

import cane.brothers.demo.DemoController;
import cane.brothers.demo.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Works without Spring context.
 * Use for clean unit tests
 */
class DemoControllerMockMvcTest {

    private MockMvc mockMvc;
    @InjectMocks
    private DemoController demoCtrl;
    @Mock
    private DemoService demoSvc;

    @BeforeEach
    public void setMockMvc() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(demoCtrl)
                .build();
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
    }
}