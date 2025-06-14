package cane.brothers.demo.springboot;

import cane.brothers.demo.DemoController;
import cane.brothers.demo.DemoService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Use to manually control bean replacement
 */
@SpringBootTest
@Import(DemoControllerTestConfigSpringBootTest.MockConfig.class)
class DemoControllerTestConfigSpringBootTest {

    @TestConfiguration
    static class MockConfig {
        @Bean
        public DemoService demoSvc() {
            return Mockito.mock(DemoService.class);
        }
    }

    @Autowired
    private DemoController web;

    @Test
    void test_greeting() {
        var greeting = this.web.greeting("Test");

        assertThat(greeting.getBody())
            .isEqualTo("Hello, Test!");
    }
}