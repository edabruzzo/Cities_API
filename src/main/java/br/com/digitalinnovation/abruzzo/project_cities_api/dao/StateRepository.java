package br.com.digitalinnovation.abruzzo.project_cities_api.dao;

import br.com.digitalinnovation.abruzzo.project_cities_api.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {}
