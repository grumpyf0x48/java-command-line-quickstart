package org.grumpyf0x48.application.name;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Application.class)
            .logStartupInfo(false)
            .bannerMode(Banner.Mode.OFF)
            .web(WebApplicationType.NONE)
            .run(args);
        int exitCode = SpringApplication.exit(applicationContext);
        System.exit(exitCode);
    }
}
