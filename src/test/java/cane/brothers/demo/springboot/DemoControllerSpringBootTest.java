package cane.brothers.demo.springboot;

import cane.brothers.demo.DemoController;
import cane.brothers.demo.DemoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

//@SpringBootTest(classes = {DemoConfig.class})
@SpringBootTest(classes = {DemoService.class, DemoController.class})
class DemoControllerSpringBootTest {

    @Autowired
    private DemoController web;

    @Test
    void test_greeting() {
        var greeting = this.web.greeting("Test");

        assertThat(greeting.getBody())
            .isEqualTo("Hello, Test!");
    }
}