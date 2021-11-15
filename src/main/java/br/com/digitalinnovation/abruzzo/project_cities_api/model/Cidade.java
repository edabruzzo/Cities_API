/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.digitalinnovation.abruzzo.project_cities_api.model;

// https://stackoverflow.com/questions/31440496/hibernate-spatial-5-geometrytype
//import com.vividsolutions.jts.geom.Point;


import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.locationtech.jts.geom.Geometry;



import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author emmanuel
 */
@Entity
@Table(name = "cidade", catalog = "cities", schema = "public")
@NamedQueries({
    @NamedQuery(name = "Cidade.findAll", query = "SELECT c FROM Cidade c"),
    @NamedQuery(name = "Cidade.findById", query = "SELECT c FROM Cidade c WHERE c.id = :id"),
    @NamedQuery(name = "Cidade.findByNome", query = "SELECT c FROM Cidade c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cidade.findByUf", query = "SELECT c FROM Cidade c WHERE c.uf = :uf"),
    @NamedQuery(name = "Cidade.findByIbge", query = "SELECT c FROM Cidade c WHERE c.ibge = :ibge"),
    @NamedQuery(name = "Cidade.findByLatitude", query = "SELECT c FROM Cidade c WHERE c.latitude = :latitude"),
    @NamedQuery(name = "Cidade.findByLongitude", query = "SELECT c FROM Cidade c WHERE c.longitude = :longitude"),
    @NamedQuery(name = "Cidade.findByCodTom", query = "SELECT c FROM Cidade c WHERE c.codTom = :codTom")})
public class Cidade implements Serializable {

    public Cidade() {
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

    @Column(name = "lat_lon", updatable = false, insertable = false)
    private Geometry location;


    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "latitude")
    private Double latitude;
    
    @Column(name = "longitude")
    private Double longitude;
    
    @Column(name = "cod_tom")
    private Short codTom;


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

    public Geometry getLocation() {
        return location;
    }

    public void setLocation(Geometry location) {
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

    public Short getCodTom() {
        return codTom;
    }

    public void setCodTom(Short codTom) {
        this.codTom = codTom;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return Objects.equals(id, cidade.id) && Objects.equals(nome, cidade.nome) && Objects.equals(uf, cidade.uf) && Objects.equals(ibge, cidade.ibge) && Objects.equals(location, cidade.location) && Objects.equals(latitude, cidade.latitude) && Objects.equals(longitude, cidade.longitude) && Objects.equals(codTom, cidade.codTom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, uf, ibge, location, latitude, longitude, codTom);
    }


    @Override
    public String toString() {
        return "Cidade{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", uf=" + uf +
                ", ibge=" + ibge +
                ", location=" + location +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", codTom=" + codTom +
                '}';
    }

    public Cidade(Long id, String nome, Integer uf, Integer ibge, Geometry location, Double latitude, Double longitude, Short codTom) {
        this.id = id;
        this.nome = nome;
        this.uf = uf;
        this.ibge = ibge;
        this.location = location;
        this.latitude = latitude;
        this.longitude = longitude;
        this.codTom = codTom;
    }
}
