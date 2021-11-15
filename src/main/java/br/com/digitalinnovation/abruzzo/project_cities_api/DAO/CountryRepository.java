/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.DAO;

import br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author emmanuel
 */
@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {}

