package com.anysinsa;

import com.amazonaws.xray.spring.aop.XRayEnabled;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@XRayEnabled
@SpringBootApplication
public class BrandApplication {

    public static void main(String[] args) {
        SpringApplication.run(BrandApplication.class, args);
    }
}
