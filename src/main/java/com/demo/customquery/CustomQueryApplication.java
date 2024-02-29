package com.demo.customquery;

import com.demo.customquery.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomQueryApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CustomQueryApplication.class, args);
    }

    @Autowired
    private PolicyService policyService;

    @Override
    public void run(String... args) throws Exception {
        policyService.test();
    }
}
