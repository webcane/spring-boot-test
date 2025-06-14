package cane.brothers.demo;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@SpringBootConfiguration
@ComponentScan("cane.brothers.demo")
@ConfigurationPropertiesScan
public class DemoConfig {
}
