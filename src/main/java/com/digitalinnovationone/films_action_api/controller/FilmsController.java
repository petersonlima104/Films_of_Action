package com.digitalinnovation.livecoding.controller;

import com.digitalinnovation.livecoding.document.Films;
import com.digitalinnovation.livecoding.repository.FilmsRepository;
import com.digitalinnovation.livecoding.service.FilmsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.digitalinnovation.livecoding.constants.FilmsConstant.FILMS_ENDPOINT_LOCAL;


@RestController
@Slf4j

public class FilmsController {
  FilmsService filmsService;

  FilmsRepository filmsRepository;

  private static final org.slf4j.Logger log =
    org.slf4j.LoggerFactory.getLogger(FilmsController.class);

  public FilmsController(FilmsService filmsService, FilmsRepository filmsRepository) {
    this.filmsService = filmsService;
    this.filmsRepository = filmsRepository;
  }

  @GetMapping(FILMS_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.OK)
  public Flux<Films> getAllItems() {
    log.info("requesting the list off all films");
    return filmsService.findAll();

  }


  @GetMapping(FILMS_ENDPOINT_LOCAL + "/{id}")
  public Mono<ResponseEntity<Films>> findByIdFilm(@PathVariable String id) {
    log.info("Requesting the film with id {}", id);
    return filmsService.findByIdHero(id)
      .map((item) -> new ResponseEntity<>(item, HttpStatus.OK))
      .defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(FILMS_ENDPOINT_LOCAL)
  @ResponseStatus(HttpStatus.CREATED)
  public Mono<Films> createFilm(@RequestBody Films films) {
    log.info("A new film was Created");
    return filmsService.save(films);

  }

  @DeleteMapping(FILMS_ENDPOINT_LOCAL + "/{id}")
  @ResponseStatus(code = HttpStatus.NOT_FOUND)
  public Mono<HttpStatus> deletebyIDFilm(@PathVariable String id) {
    filmsService.deletebyIDFilm(id);
    log.info("Deleting the film with id {}", id);
    return Mono.just(HttpStatus.NOT_FOUND);
  }
}
