package com.bcp.test.tech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class BcpTechTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(BcpTechTestApplication.class, args);
    }

}
