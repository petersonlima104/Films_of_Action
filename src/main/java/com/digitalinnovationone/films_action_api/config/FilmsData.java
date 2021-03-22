package com.digitalinnovation.livecoding.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovation.livecoding.constants.HeroesConstant.ENDPOINT_DYNAMO;
import static com.digitalinnovation.livecoding.constants.HeroesConstant.REGION_DYNAMO;

public class FilmsData {
  public static void main(String[] args) throws Exception {

    AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
      .build();
    DynamoDB dynamoDB = new DynamoDB(client);

    Table table = dynamoDB.getTable("Films_Api_Table");

    Item film = new Item()
      .withPrimaryKey("id", "1")
      .withString("name", "Com as Proprias Mãos")
      .withString("Ano", "2004")
      .withNumber("films", 1);

    Item film2 = new Item()
      .withPrimaryKey("id", "2")
      .withString("name", "Velozes e Furiosos")
      .withString("Ano", "2001 - 2021")
      .withNumber("films", 9);

    Item film3 = new Item()
      .withPrimaryKey("id", "3")
      .withString("name", "Carga Explosiva")
      .withString("Ano", "202")
      .withNumber("films", 3);

    Item film4 = new Item()
            .withPrimaryKey("id", "3")
            .withString("name", "Red - Aposentados e Perigosos")
            .withString("Ano", "2010")
            .withNumber("films", 2);

    PutItemOutcome outcome1 = table.putItem(film);
    PutItemOutcome outcome2 = table.putItem(film2);
    PutItemOutcome outcome3 = table.putItem(film3);
    PutItemOutcome outcome4 = table.putItem(film4);

  }

}

