package com.example.meditatii;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.example.meditatii"})
public class MeditatiiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MeditatiiApplication.class, args);
    }

}
