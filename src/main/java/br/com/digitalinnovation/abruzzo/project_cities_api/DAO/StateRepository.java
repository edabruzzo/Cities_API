package br.com.digitalinnovation.abruzzo.project_cities_api.DAO;

import br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<Estado, Long> {}
