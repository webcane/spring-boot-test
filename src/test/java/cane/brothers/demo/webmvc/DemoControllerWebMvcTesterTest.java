package cane.brothers.demo.webmvc;

import cane.brothers.demo.DemoController;
import cane.brothers.demo.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

/**
 * test will work only if @SpringBootApplication or @SpringBootConfiguration is available
 */
@WebMvcTest(DemoController.class)
@AutoConfigureMockMvc
class DemoControllerWebMvcTesterTest {

    @MockitoBean
    private DemoService demoSvc;


    // If AssertJ is on the classpath, you can use MockMvcTester
    @Test
    void testWithMockMvcTester(@Autowired MockMvcTester mvc) {
        // given
        when(demoSvc.sayHello("Test"))
                .thenReturn("Hello, Test!");

        // when/then
        assertThat(mvc.get().uri("/api/hello?name=Test"))
                .hasStatusOk()
                .hasBodyTextEqualTo("Hello, Test!");
    }
}