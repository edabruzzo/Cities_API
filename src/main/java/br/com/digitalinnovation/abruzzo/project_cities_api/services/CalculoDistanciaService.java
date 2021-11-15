package br.com.digitalinnovation.abruzzo.project_cities_api.services;

import br.com.digitalinnovation.abruzzo.project_cities_api.dao.CityRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculoDistanciaService implements ICalculaDistanciaService{

    //Logger logger = LoggerFactory.getLogger(CalculoDistanciaService.class);
    @Autowired private CityRepository repository;

    @Override
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(Long idCidade1, Long idCidade2) {
        return repository.calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(idCidade1,idCidade2);
    }

    @Override
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_Cube(double x1, double y1, double x2, double y2) {
        return repository.calculaDistanciaEntreCidades_ByPostgresExtension_Cube(x1,y1,x2,y2);
    }
}
