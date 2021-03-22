package com.digitalinnovation.livecoding;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;

@SpringBootApplication
@EnableDynamoDBRepositories
public class FilmsApiApplication {

  public static void main(String[] args) {

    SpringApplication.run(FilmsApiApplication.class, args);
    System.out.println("Filmes de Ação com webflux");
  }

}

