package techbrain.think.insight;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "My API", version = "v1"))
public class TechBrainApp extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(TechBrainApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder
                      application) {
        return application.sources(TechBrainApp.class);
    }
}
