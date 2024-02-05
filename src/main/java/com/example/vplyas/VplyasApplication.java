package com.example.vplyas;

import com.example.vplyas.config.API.APIConfig;
import com.example.vplyas.config.API.StorageProperties;
import com.example.vplyas.service.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class VplyasApplication {

  public static void main(String[] args) {
    APIConfig.loadEnv();
    SpringApplication.run(VplyasApplication.class, args);
  }
  @Bean
  CommandLineRunner init(StorageService storageService) {
    return (args) -> storageService.init();
  }
}
