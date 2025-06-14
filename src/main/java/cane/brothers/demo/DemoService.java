package cane.brothers.demo;

import org.springframework.stereotype.Service;

@Service
public class DemoService {
    public String sayHello(String name) {
        return "Hello, %s!".formatted(name);
    }
}
