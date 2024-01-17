package com.example.vplyas;

import com.example.vplyas.config.API.APIConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VplyasApplication {

  public static void main(String[] args) {
    APIConfig.loadEnv();
    SpringApplication.run(VplyasApplication.class, args);
  }
}
