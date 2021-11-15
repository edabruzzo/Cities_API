/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.DAO;

import br.com.digitalinnovation.abruzzo.project_cities_api.MODEL.Country;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 * @author emmanuel
 */
@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {}

