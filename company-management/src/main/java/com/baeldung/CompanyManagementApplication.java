package com.baeldung;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
@Import(CompanyManagementConfiguration.class)
public class CompanyManagementApplication {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(CompanyManagementApplication.class, args);
    }


}