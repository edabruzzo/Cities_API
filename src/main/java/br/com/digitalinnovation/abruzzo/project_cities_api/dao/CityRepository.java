package br.com.digitalinnovation.abruzzo.project_cities_api.dao;

import br.com.digitalinnovation.abruzzo.project_cities_api.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author emmanuel
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    @Query(value = "select ((select lat_lon from cidade where id = :idCidade1) <@> (select lat_lon from cidade where id = :idCidade2)) as distance;",nativeQuery = true)
    Double calculaDistanciaEntreCidades_ByPostgresExtension_EarthDistance(Long idCidade1, Long idCidade2);

    @Query(value = "select earth_distance(ll_to_earth(:x1,:y1), ll_to_earth(:x2,:y2)) as distance;", nativeQuery = true)
    Double calculaDistanciaEntreCidades_ByPostgresExtension_Cube(double x1, double y1, double x2, double y2);

    @Query(value = "select distinct c2.id, c2.nome, (c1.lat_lon <@> c2.lat_lon) as distancia\n" +
            "from public.cidade c1 \n" +
            "\tinner join public.cidade c2\n" +
            "\t\ton (c1.lat_lon <@> c2.lat_lon) < :raioDistancia\n" +
            "where c1.nome ilike :nomeCidadeFrom ;", nativeQuery = true)
    List<Object> retornaListaCidades_RaioDistancia_ByPoint(String nomeCidadeFrom, double raioDistancia);

    // Método DAO usando NativeNamedQuery declarada na Classe de Entidade
    List<City> findCitiesByName(String nomeCidade1, String nomeCidade2);
}
