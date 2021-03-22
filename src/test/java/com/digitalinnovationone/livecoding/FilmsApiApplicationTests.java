package com.digitalinnovation.livecoding;

import org.springframework.boot.test.context.SpringBootTest;

import org.junit.Test;
import com.digitalinnovation.livecoding.repository.FilmsRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.digitalinnovation.livecoding.constants.FilmsConstant.FILMS_ENDPOINT_LOCAL;


@RunWith(SpringRunner.class)
@DirtiesContext
@AutoConfigureWebTestClient
@SpringBootTest
public class FilmsApiApplicationTests {

  @Autowired
  WebTestClient webTestClient;

  @Autowired
  FilmsRepository filmsRepository;


  @Test
  public void getOneFilmById(){

    webTestClient.get().uri(FILMS_ENDPOINT_LOCAL.concat("/{id}"),"10")
      .exchange()
      .expectStatus().isOk()
      .expectBody();


  }

  @Test
  public void getOneFilmnotFound(){

    webTestClient.get().uri(FILMS_ENDPOINT_LOCAL.concat("/{id}"),"10")
      .exchange()
      .expectStatus().isNotFound();

  }


  @Test
  public void deleteFilm(){

    webTestClient.delete().uri(FILMS_ENDPOINT_LOCAL.concat("/{id}"),"1")
      .accept(MediaType.APPLICATION_JSON)
      .exchange()
      .expectStatus().isNotFound()
      .expectBody(Void.class);

  }

}


