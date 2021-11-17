/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.model;

// https://stackoverflow.com/questions/31440496/hibernate-spatial-5-geometrytype
//import com.vividsolutions.jts.geom.Point;


import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.springframework.data.geo.Point;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author emmanuel
 */
@Entity
@Table(name = "cidade", catalog = "cities", schema = "public")
@TypeDefs(value = {@TypeDef(name = "point", typeClass = PointType.class)})
@NamedQueries({@NamedQuery(name = "City.findCitiesByName",
              query = "SELECT c FROM City c WHERE c.nome in (:nomeCidade1, :nomeCidade2) ")
})
public class City implements Serializable {

    public City() {
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "uf")
    private Integer uf;

    @Column(name = "ibge")
    private Integer ibge;

    // 1st
    @Column(name = "lat_lon")
    private String geolocation;

    // 2nd
    @Type(type = "point")
    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Point location;


    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name="cod_tom")
    private int cod_tom;


    public City(Long id, String nome, Integer uf, Integer ibge, String geolocation, Point location) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.ibge = ibge;
        this.geolocation = geolocation;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getUf() {
        return uf;
    }

    public void setUf(Integer uf) {
        this.uf = uf;
    }

    public Integer getIbge() {
        return ibge;
    }

    public void setIbge(Integer ibge) {
        this.ibge = ibge;
    }

    public String getGeolocation() {
        return geolocation;
    }

    public void setGeolocation(String geolocation) {
        this.geolocation = geolocation;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public int getCod_tom() {
        return cod_tom;
    }

    public void setCod_tom(int cod_tom) {
        this.cod_tom = cod_tom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cod_tom == city.cod_tom && Objects.equals(id, city.id) && Objects.equals(nome, city.nome) && Objects.equals(uf, city.uf) && Objects.equals(ibge, city.ibge) && Objects.equals(geolocation, city.geolocation) && Objects.equals(location, city.location) && Objects.equals(latitude, city.latitude) && Objects.equals(longitude, city.longitude);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, uf, ibge, geolocation, location, latitude, longitude, cod_tom);
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", uf=" + uf +
                ", ibge=" + ibge +
                ", geolocation='" + geolocation + '\'' +
                ", location=" + location +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", cod_tom=" + cod_tom +
                '}';
    }
}