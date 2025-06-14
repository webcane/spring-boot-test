package cane.brothers.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final DemoService demoService;

    @GetMapping("/api/hello")
    public ResponseEntity<String> greeting(@RequestParam(defaultValue = "World") String name) {
        return ResponseEntity.ok(demoService.sayHello(name));
    }
}
