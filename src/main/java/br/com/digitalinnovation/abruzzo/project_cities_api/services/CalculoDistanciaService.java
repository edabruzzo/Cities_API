package br.com.digitalinnovation.abruzzo.project_cities_api.services;

import br.com.digitalinnovation.abruzzo.project_cities_api.dao.CityRepository;
import br.com.digitalinnovation.abruzzo.project_cities_api.model.City;
import br.com.digitalinnovation.abruzzo.project_cities_api.util.StringLocationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.*;

@Service
public class CalculoDistanciaService implements ICalculaDistanciaService {

    Logger logger = LoggerFactory.getLogger(CalculoDistanciaService.class);

    @Autowired
    private CityRepository repository;

    @Override
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(Long idCidade1, Long idCidade2) {
        this.logger.info("calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance({}, {}, {})", idCidade1, idCidade2);
        return repository.calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(idCidade1, idCidade2);
    }

    @Override
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(String nomeCidade1, String nomeCidade2) {
        this.logger.info("calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance({}, {}, {})", nomeCidade1, nomeCidade2);
        return repository.calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(nomeCidade1, nomeCidade2);
    }


    @Override
    public Double calculaDistanciaEntreCidades_ByPostgresExtension_Cube(double x1, double y1, double x2, double y2) {
        this.logger.info("calculaDistanciaEntreCidades_ByPostgresExtension_Cube({}, {}, {}, {})", x1, y1, x2, y2);
        return repository.calculaDistanciaEntreCidades_ByPostgresExtension_Cube(x1, y1, x2, y2);
    }

    @Override
    public List<Object> retornaListaCidades_RaioDistancia_ByPoint(String nomeCidadeFrom, double raioDistancia) {
        this.logger.info("retornaListaCidades_RaioDistancia_ByPoint({}, {})", nomeCidadeFrom, raioDistancia);
        return repository.retornaListaCidades_RaioDistancia_ByPoint(nomeCidadeFrom, raioDistancia);
    }

    @Override
    public Double calculaDistanciaEntreCidadesUsandoMatematicaPura(Long idCidade1, Long idCidade2, EarthRadius unit) {
        this.logger.info("calculaDistanciaEntreCidadesUsandoMatematicaPura({}, {}, {})", idCidade1, idCidade2, unit);
        EarthRadius unidadeMedida = unit == null ? EarthRadius.KILOMETERS : unit;
        final List<City> cities = this.repository.findAllById((Arrays.asList(idCidade1, idCidade2)));
        final Double[] location1 = StringLocationUtils.transform(cities.get(0).getGeolocation());
        final Double[] location2 = StringLocationUtils.transform(cities.get(1).getGeolocation());
        return calcular(location1[0], location1[1], location2[0], location2[1], unidadeMedida);
    }

    @Override
    public Double calculaDistanciaEntreCidadesUsandoMatematicaPura(String nomeCidade1, String nomeCidade2, EarthRadius unit) {
        this.logger.info("calculaDistanciaEntreCidadesUsandoMatematicaPura({}, {}, {})", nomeCidade1, nomeCidade2, unit);
        EarthRadius unidadeMedida = unit == null ? EarthRadius.KILOMETERS : unit;
        final List<City> cities = this.repository.findCitiesByName(nomeCidade1, nomeCidade2);
        final Double[] location1 = StringLocationUtils.transform(cities.get(0).getGeolocation());
        final Double[] location2 = StringLocationUtils.transform(cities.get(1).getGeolocation());
        return calcular(location1[0], location1[1], location2[0], location2[1], unidadeMedida);
    }

    public Double calcular(final double lat1, final double lon1, final double lat2, final double lng2, final EarthRadius earthRadius) {
        double lat = toRadians(lat2 - lat1);
        double lon = toRadians(lng2 - lon1);
        double a = sin(lat / 2) * sin(lat / 2) + cos(toRadians(lat1)) * cos(toRadians(lat2)) * sin(lon / 2) * sin(lon / 2);
        double c = 2 * atan2(sqrt(a), sqrt(1 - a));
        return earthRadius.getValue() * c;
    }

}
