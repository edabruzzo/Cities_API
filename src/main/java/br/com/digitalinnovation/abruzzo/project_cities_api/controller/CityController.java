package br.com.digitalinnovation.abruzzo.project_cities_api.controller;

import br.com.digitalinnovation.abruzzo.project_cities_api.dao.CityRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.model.Cidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author emmanuel
 */

@RestController
@RequestMapping({"/cities"})
public class CityController {

    @Autowired
    private CityRepository repository;

    /*
    private CityRepository repository;
    public CityController(CityRepository cityRepository) {
        this.repository = cityRepository;
    }
     */

    @GetMapping
    public Page<Cidade> findAll(Pageable pageable) {
        return (Page<Cidade>) this.repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity findCidadeById(@PathVariable Long id) {
        Optional<Cidade> optional = this.repository.findById(id);
        if (optional.isPresent()) return ResponseEntity.ok().body(optional.get());
        else return (ResponseEntity) ResponseEntity.notFound().build();
    }


}
