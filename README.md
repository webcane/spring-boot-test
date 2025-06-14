# spring-boot-test demo project

This test project is intended for the following purposes:
- To demonstrate how to test REST controllers without having a SpringBootApplication class in the main source code.
  This can be useful for projects that follow a hexagonal architecture and use Gradle multi-project builds, 
  where only one subproject contains the SpringBootApplication definition.
- To test REST controllers using various approaches:
    - SpringBootTest
        - Loading only the required classes (([DemoService](src/main/java/cane/brothers/demo/DemoService.java), [DemoController](src/main/java/cane/brothers/demo/DemoController.java))) directly into the application context. [DemoControllerSpringBootTest](src/test/java/cane/brothers/demo/springboot/DemoControllerSpringBootTest.java)
        - Loading the application context via a configuration file [DemoConfig](src/main/java/cane/brothers/demo/DemoConfig.java). [DemoControllerSpringBootTest](src/test/java/cane/brothers/demo/springboot/DemoControllerSpringBootTest.java)
        - Test controllers using TestRestTemplate. [DemoControllerRestClientSpringBootTest](src/test/java/cane/brothers/demo/springboot/DemoControllerRestClientSpringBootTest.java)
        - Replacing beans in the application context using @TestConfiguration. [DemoControllerTestConfigSpringBootTest](src/test/java/cane/brothers/demo/springboot/DemoControllerTestConfigSpringBootTest.java)
    - WebMvcTest
        - Using WebApplicationContext to configure mockMvc. [DemoControllerWebMvcTest](src/test/java/cane/brothers/demo/webmvc/DemoControllerWebMvcTest.java)
        - Using `@AutoConfigureMockMvc`. [DemoControllerAutoconfigureMockWebMvcTest](src/test/java/cane/brothers/demo/webmvc/DemoControllerAutoconfigureMockWebMvcTest.java)
        - Using MockMvcTester.  [DemoControllerAutoconfigureMockWebMvcTest](src/test/java/cane/brothers/demo/webmvc/DemoControllerWebMvcTesterTest.java)
    - MockMvc - without using Spring context
        - Using `@InjectMocks` and `@Mock`. [DemoControllerMockMvcTest](src/test/java/cane/brothers/demo/mockmvc/DemoControllerMockMvcTest.java)
        - Manually creating objects. [DemoControllerPureMockMvcTest](src/test/java/cane/brothers/demo/mockmvc/DemoControllerPureMockMvcTest.java)