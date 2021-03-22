package com.digitalinnovation.livecoding.repository;

import com.digitalinnovation.livecoding.document.Films;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface FilmsRepository extends CrudRepository<Films, String>{
}
