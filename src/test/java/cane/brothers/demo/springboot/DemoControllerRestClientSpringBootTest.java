package cane.brothers.demo.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoControllerRestClientSpringBootTest {

    @Test
    void test_greeting(@Autowired TestRestTemplate restTemplate) {

        String greeting = restTemplate.getForObject("/api/hello?name=Test", String.class);

        assertThat(greeting)
            .isEqualTo("Hello, Test!");
    }
}