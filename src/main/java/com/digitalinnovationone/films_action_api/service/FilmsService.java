package com.digitalinnovation.livecoding.service;

import com.digitalinnovation.livecoding.document.Films;
import com.digitalinnovation.livecoding.repository.FilmsRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class FilmsService {
  private final FilmsRepository filmsRepository;

  public FilmsService(FilmsRepository filmsRepository) {
    this.filmsRepository = filmsRepository;
  }

  public Flux<Films> findAll(){

    return Flux.fromIterable(this.filmsRepository.findAll());
  }

  public  Mono<Films> findByIdHero(String id){

    return  Mono.justOrEmpty(this.filmsRepository.findById(id));
  }


  public Mono<Films> save(Films films){
    return  Mono.justOrEmpty(this.filmsRepository.save(films));
  }


  public Mono<Boolean> deletebyIDFilm(String id) {
    filmsRepository.deleteById(id);
    return Mono.just(true);

  }

}

