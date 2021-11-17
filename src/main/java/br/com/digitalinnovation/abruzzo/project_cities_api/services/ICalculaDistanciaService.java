package br.com.digitalinnovation.abruzzo.project_cities_api.services;

import br.com.digitalinnovation.abruzzo.project_cities_api.model.City;

public interface ICalculaDistanciaService {

    Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(Long idCidade1, Long idCidade2);
    Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(String nomeCidade1, String nomeCidade2);
    Double calculaDistanciaEntreCidades_ByPostgresExtension_Cube(double x1, double y1, double x2, double y2);
    Object retornaListaCidades_RaioDistancia_ByPoint(String nomeCidadeFrom, double raioDistancia);
    Double calculaDistanciaEntreCidadesUsandoMatematicaPura(Long nomeCidade1, Long nomeCidade2, EarthRadius unit);
    Double calculaDistanciaEntreCidadesUsandoMatematicaPura(String nomeCidade1, String nomeCidade2, EarthRadius unit);
    Double calcular(final double lat1, final double lon1, final double lat2, final double lng2, final EarthRadius earthRadius);
}