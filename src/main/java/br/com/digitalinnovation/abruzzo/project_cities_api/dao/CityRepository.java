package br.com.digitalinnovation.abruzzo.project_cities_api.dao;

import br.com.digitalinnovation.abruzzo.project_cities_api.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author emmanuel
 */
@Repository
public interface CityRepository extends JpaRepository<Cidade,Long> { }
