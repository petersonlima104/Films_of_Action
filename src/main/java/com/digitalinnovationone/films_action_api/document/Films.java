package com.digitalinnovation.livecoding.document;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import org.springframework.data.annotation.Id;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
@DynamoDBTable(tableName ="Films_Api_Table")


public class Films {
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAno() {
    return ano;
  }

  public void setAno(String ano) {
    this.ano = ano;
  }

  public int getFilms() {
    return films;
  }

  public void setFilms(int films) {
    this.films = films;
  }

  @Id
  @DynamoDBHashKey (attributeName = "id")
  private String id;

  @DynamoDBAttribute (attributeName = "name")
  private String name;

  @DynamoDBAttribute (attributeName = "ano")
  private String ano;

  @DynamoDBAttribute (attributeName = "films")
  private int films;


  public Films(String id, String name, String ano, int films) {
    this.id = id;
    this.name = name;
    this.ano = ano;
    this.films = films;
  }

}

