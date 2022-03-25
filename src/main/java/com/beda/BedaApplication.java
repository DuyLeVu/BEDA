package com.beda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BedaApplication {

    public static void main(String[] args) {
        try {
            SpringApplication.run(BedaApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
